package week03.pgs42578;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>() {
            {
                for (String[] clothe : clothes) {
                    computeIfAbsent(clothe[1], s -> new ArrayList<>()).add(clothe[0]);
                }
            }
        };
        List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(map.entrySet());
        Set<Map.Entry<String, List<String>>> set = new HashSet<>();
        AtomicInteger answer = new AtomicInteger(0);
        Consumer<Integer> combination = new Consumer<>() {
            @Override
            public void accept(Integer start) {
                for (int i = start; i < map.size(); i++) {
                    Map.Entry<String, List<String>> entry = entryList.get(i);

                    if (set.contains(entry)) continue;
                    set.add(entry);
                    answer.addAndGet(getCumulativeProduct(set));
                    if (set.size() < map.size()) accept(i);
                    set.remove(entry);
                }
            }
        };

        combination.accept(0);
        return answer.get();
    }

    private int getCumulativeProduct(Set<Map.Entry<String, List<String>>> entrySet) {
        int acc = 1;

        for (Map.Entry<String, List<String>> entry : entrySet) {
            acc *= entry.getValue().size();
        }
        return acc;
    }
}