package org.step.fourth.test;

import org.step.third.SystemStream;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GetPerformance {

    private Map<Integer, String> conMap = new ConcurrentHashMap<>();
    private Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());

    public GetPerformance() {
        for (int i = 0; i < 1000000; i++) {
            conMap.put(i, "");
            syncMap.put(i, "");
        }
    }

    public Map<Integer, String> getConMap() {
        return conMap;
    }

    public Map<Integer, String> getSyncMap() {
        return syncMap;
    }
}
