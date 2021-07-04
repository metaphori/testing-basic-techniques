package it.unibo.testlecture.u05_mock.server;

import java.util.function.Function;

public class BasicServerWithCache extends BasicServer {
    private final Cache<Request, Response> cache;
    private final Function<Request, Boolean> cacheable;

    public BasicServerWithCache(Cache<Request,Response> cache,
                                Function<Request, Boolean> cacheable,
                                Function<Request, Response> logic){
        super(logic);
        this.cache = cache;
        this.cacheable = cacheable;
    }

    @Override
    public Response serve(Request r) {
        if(!cacheable.apply(r)) return super.serve(r);
        if(cache.cached(r)) return cache.get(r);

        Response result = super.serve(r);
        cache.put(r, result);
        return result;
    }
}
