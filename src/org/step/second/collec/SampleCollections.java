package org.step.second.collec;

import org.step.second.data.UserData;
import org.step.second.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SampleCollections {

    private Deque<Integer> deque = new ArrayDeque<>();
    private Set<Integer> integerSet = new HashSet<>();
    private LinkedHashSet<User> userSet = new LinkedHashSet<>(10, 1.1f);
    private Map<Integer, String> integerStringMap = new HashMap<>();
    private NavigableMap<Integer, String> integerStringMapSecond = new TreeMap<>();
    private Map<Integer, String> weakHashMap = new WeakHashMap<>();
    private Map<Integer, String> concurrent = new ConcurrentHashMap<>();
    private Map<Integer, String> getIntegerStringMap = new LinkedHashMap<>(16, 1.1f, true);

    private SortedSet<Integer> sortedSetWithComparator = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer integer, Integer t1) {
            return 0;
        }
    });

    private SortedSet<User> userSortedSet = new TreeSet<>();

    public void setIntegerSet() {
        Map<NumberEnum, String> enumMap = new EnumMap<>(NumberEnum.class);
        enumMap.put(NumberEnum.FIRST, "first");

        String s = concurrent.get(1);

        String third = concurrent.put(3, "third");

        Map<Integer, String> integerStringMap = Collections.synchronizedMap(this.integerStringMap);

        Optional<User> any = userSet.stream().filter(user -> user.getId() > 1).findAny();
        userSortedSet.add(UserData.getUserList().get(0));
    }
}
