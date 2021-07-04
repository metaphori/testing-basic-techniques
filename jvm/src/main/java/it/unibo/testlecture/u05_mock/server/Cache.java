package it.unibo.testlecture.u05_mock.server;

public interface Cache<Key,Value> {
    Boolean cached(Key key);
    Value get(Key key);
    void put(Key key, Value value);
}
