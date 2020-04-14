package org.step.fifth.data;

import java.util.List;

public class StatisticCollector {

    public static void main(String[] args) {
        StreamStatistic streamStatistic = new StreamStatistic();

        long defaultFirst = System.nanoTime();
        List<Long> longListByDefaultOperator = streamStatistic.getLongListByDefaultOperator();
        long defaultSecond = System.nanoTime();

        long streamFirst = System.nanoTime();
        List<Long> longListByStream = streamStatistic.getLongListByStream();
        long streamSecond = System.nanoTime();

        System.out.println("Default " + (defaultSecond - defaultFirst));
        System.out.println("Stream " + (streamSecond - streamFirst));
    }
}
