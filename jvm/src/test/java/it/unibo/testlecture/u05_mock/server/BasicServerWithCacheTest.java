package it.unibo.testlecture.u05_mock.server;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BasicServerWithCacheTest {

    @Test
    public void Test_Server_for_NonCacheables(){
        Server sut = new BasicServerWithCache(
                null,   // DUMMY
                req -> false, // STUB
                req -> Response.of(req.getBody() + "bar") // FAKE OBJECT
        );

        Response r = sut.serve(new Request("foo"));

        assertEquals("foobar", r.getBody());
    }

    @Test
    public void Test_Server_Interaction_with_Cache_for_NonCacheables(){
        Cache<Request, Response> cacheMock = mock(Cache.class);
        Server sut = new BasicServerWithCache(
                cacheMock, // MOCK
                req -> false, // STUB
                req -> Response.of(req.getBody() + "bar") // FAKE OBJECT
        );

        Response r = sut.serve(new Request("foo"));

        verifyNoInteractions(cacheMock);
        // verify(cacheMock, never()).cached(any());
        // verify(cacheMock, never()).get(any());
        // verify(cacheMock, never()).put(any(), any());
    }

    @Test
    public void Test_Server_Interaction_with_Cache_for_Cacheables(){
        Request request = new Request("foo");
        Response response = Response.of("foobar");
        Cache<Request, Response> cacheMock = mock(Cache.class);
        when(cacheMock.cached(request)).thenReturn(false).thenReturn(true);
        when(cacheMock.get(request)).thenReturn(response);
        Server sut = new BasicServerWithCache(
                cacheMock, // MOCK
                req -> true, // STUB
                req -> null // DUMMY
        );

        Response r1 = sut.serve(request);
        Response r2 = sut.serve(request);

        assertEquals(null, r1);
        assertEquals(response, r2);
        InOrder inOrder = inOrder(cacheMock);
        inOrder.verify(cacheMock).cached(request);
        inOrder.verify(cacheMock).put(eq(request), any());
        inOrder.verify(cacheMock).cached(request);
        inOrder.verify(cacheMock).get(request);
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void Test_Server_Interaction_with_Cache_for_Cacheables_2(){
        Request request = new Request("foo");
        Response response = Response.of("foobar");
        Cache<Request, Response> cacheMock = mock(Cache.class);
        when(cacheMock.cached(request)).thenReturn(false).thenReturn(true);
        when(cacheMock.get(request)).thenReturn(response);
        Server sut = new BasicServerWithCache(
                cacheMock, // MOCK
                req -> true, // STUB
                req -> response // DUMMY
        );

        Response r1 = sut.serve(request);
        Response r2 = sut.serve(request);

        assertEquals(response, r1);
        assertEquals(response, r2);
        InOrder inOrder = inOrder(cacheMock);
        inOrder.verify(cacheMock).cached(request);
        inOrder.verify(cacheMock).put(eq(request), eq(response));
        inOrder.verify(cacheMock).cached(request);
        inOrder.verify(cacheMock).get(request);
        inOrder.verifyNoMoreInteractions();
    }


    @Test
    public void Test_Server_Interaction_with_Cache_for_Cacheables_via_Spy(){
        Request request = new Request("foo");
        Cache<Request, Response> cacheSpy = spy(SimpleCache.class);
        Server sut = new BasicServerWithCache(
                cacheSpy, // SPY
                req -> true, // STUB
                BasicServerWithCacheTest::responseFor // FAKE OBJECT
        );

        sut.serve(request);
        sut.serve(request);

        InOrder inOrder = inOrder(cacheSpy);
        inOrder.verify(cacheSpy).cached(request);
        inOrder.verify(cacheSpy).put(request, responseFor(request));
        inOrder.verify(cacheSpy).cached(request);
        inOrder.verify(cacheSpy).get(request);
        inOrder.verifyNoMoreInteractions();
    }

    @Test
    public void Test_Server_With_Cache_For_Cached_Objects(){
        Request request = new Request("foo");
        Response expectedResponse = Response.of("bar");
        Cache<Request, Response> cacheStub = mock(Cache.class);
        when(cacheStub.cached(request)).thenReturn(true);
        when(cacheStub.get(request)).thenReturn(expectedResponse);
        Server sut = new BasicServerWithCache(
                cacheStub,   // STUB
                req -> true, // STUB
                req -> Response.of(req.getBody() + " anew") // FAKE OBJECT
        );

        Response r = sut.serve(request);

        assertEquals(expectedResponse, r, "We expect the cached response and not the computed response.");
    }

    private static Response responseFor(Request r){
        return Response.of(r.getBody() + "bar");
    }
}
