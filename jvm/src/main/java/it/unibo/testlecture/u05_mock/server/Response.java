package it.unibo.testlecture.u05_mock.server;

import java.util.Objects;

public class Response {
    private final String body;

    private Response(String body){
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public static Response of(String body){
        return new Response(body);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(body, response.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public String toString() {
        return "Response{" +
                "body='" + body + '\'' +
                '}';
    }
}
