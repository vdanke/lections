package org.step.fifth.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStatistic {

    private List<Long> longList;

    public StreamStatistic() {
        longList = new ArrayList<>();
        for (int i = 0; i < 1_000_000_00; i++) {
            longList.add((long) i);
        }
    }

    List<Long> getLongListByDefaultOperator() {
        List<Long> longs = new ArrayList<>();

        for (Long l : longList) {
            if ((l % 250) == 0) {
                longs.add(l);
            }
        }
        return longs;
    }

    List<Long> getLongListByStream() {
        return longList.parallelStream()
                .unordered()
                .filter(l -> (l % 250) == 0)
                .collect(Collectors.toList());
    }
}
