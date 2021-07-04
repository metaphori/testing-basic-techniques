package it.unibo.testlecture.u05_mock.server;

import java.util.function.Function;

public class BasicServer implements Server {
    private final Function<Request, Response> logic;

    public BasicServer(Function<Request, Response> logic){
        this.logic = logic;
    }

    @Override
    public Response serve(Request r) {
        return logic.apply(r);
    }
}
