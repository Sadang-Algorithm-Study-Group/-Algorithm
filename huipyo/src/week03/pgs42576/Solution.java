package week03.pgs42576;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, List<String>> map = initMap(participant);

        for (String c : completion) {
            if (map.containsKey(c)) {
                map.get(c).remove(map.get(c).size() - 1);
            }
        }
        for (String key : map.keySet()) {
            if (!map.get(key).isEmpty()) return key;
        }
        return "";
    }

    private Map<String, List<String>> initMap(String[] participant) {
        return Arrays.stream(participant).collect(Collectors.groupingBy(s -> s));
    }
}