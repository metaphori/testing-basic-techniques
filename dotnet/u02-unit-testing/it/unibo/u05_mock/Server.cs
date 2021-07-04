using System;
using System.Collections.Generic;

namespace it.unibo.testlecture.u05_mock {

    public struct Request {
        private readonly String body;

        public Request(String body){
            this.body = body;
        }

        public String getBody() {
            return body;
        }
    }

    public struct Response {
        private readonly String body;

        public Response(String body){
            this.body = body;
        }

        public String getBody() {
            return body;
        }

        public static Response of(String body){
            return new Response(body);
        }
    }

    public interface Server {
        public Response serve(Request r);
    }

    public class BasicServer : Server {
        private readonly Func<Request, Response> logic;

        public BasicServer(Func<Request, Response> logic){
            this.logic = logic;
        }

        public virtual Response serve(Request r) {
            return logic(r);
        }
    }
                                        
public class BasicServerWithCache : BasicServer {
        private readonly Cache<Request, Response> cache;
        private readonly Func<Request, Boolean> cacheable;

        public BasicServerWithCache(Cache<Request,Response> cache,
                                    Func<Request, Boolean> cacheable,
                                    Func<Request, Response> logic) : base(logic) {
            this.cache = cache;
            this.cacheable = cacheable;
        }

        public override Response serve(Request r) {
            if(!cacheable(r)) return base.serve(r);
            if(cache.cached(r)) return cache.get(r);

            Response result = base.serve(r);
            cache.put(r, result);
            return result;
        }
    }

    public interface Cache<Key,Value> {
        Boolean cached(Key key);
        Value get(Key key);
        void put(Key key, Value value);
    }

    public class SimpleCache<Key,Value> : Cache<Key,Value> {
        private IDictionary<Key,Value> dict;

        public SimpleCache(){
            dict = new Dictionary<Key,Value>();
        }

        public Boolean cached(Key key) {
            return dict.ContainsKey(key);
        }

        public Value get(Key key) {
            return dict[key];
        }

        public void put(Key key, Value value) {
            dict[key] = value;
        }
    }


}