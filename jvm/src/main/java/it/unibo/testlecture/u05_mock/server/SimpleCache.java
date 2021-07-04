package it.unibo.testlecture.u05_mock.server;

import java.util.HashMap;

public class SimpleCache<Key,Value> implements Cache<Key,Value> {
    private HashMap<Key,Value> map;

    public SimpleCache(){
        map = new HashMap<>();
    }

    @Override
    public Boolean cached(Key key) {
        return map.containsKey(key);
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public void put(Key key, Value value) {
        map.put(key, value);
    }
}
