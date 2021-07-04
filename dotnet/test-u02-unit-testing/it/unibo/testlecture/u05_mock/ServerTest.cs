using Xunit;
using System;
using System.Collections.Generic;
using Moq;

// dotnet add <project> package Moq
namespace it.unibo.testlecture.u05_mock
{
    // dotnet test --filter "FullyQualifiedName~ServerTest"
    public class ServerTest
    {
        [Fact]
        public void Test_Server_for_NonCacheables(){
            Server sut = new BasicServerWithCache(
                    null,   // DUMMY
                    req => false, // STUB
                    req => Response.of(req.getBody() + "bar") // FAKE OBJECT
            );

            Response r = sut.serve(new Request("foo"));

            Assert.Equal("foobar", r.getBody());
        }

        [Fact]
        public void Test_Server_Interaction_with_Cache_for_NonCacheables(){
            var cacheMock = new Mock<Cache<Request,Response>>();
            Server sut = new BasicServerWithCache(
                    cacheMock.Object, // MOCK
                    req => false, // STUB
                    req => Response.of(req.getBody() + "bar") // FAKE OBJECT
            );

            Response r = sut.serve(new Request("foo"));

            cacheMock.VerifyNoOtherCalls();
        }

            [Fact]
        public void Test_Server_Interaction_with_Cache_for_Cacheables(){
            Request request = new Request("foo");
            Response response = Response.of("foobar");
            var cacheMock = new Mock<Cache<Request,Response>>(MockBehavior.Strict);
            var callseq = new MockSequence();
            cacheMock.InSequence(callseq).Setup(c => c.cached(request)).Returns(false);
            cacheMock.InSequence(callseq).Setup(c => c.put(request, response));
            cacheMock.InSequence(callseq).Setup(c => c.cached(request)).Returns(true);
            cacheMock.InSequence(callseq).Setup(c => c.get(request)).Returns(response);

            Server sut = new BasicServerWithCache(
                    cacheMock.Object, // MOCK
                    req => true, // STUB
                    req => response // DUMMY
            );

            sut.serve(request);
            sut.serve(request);
        }
    }
}
