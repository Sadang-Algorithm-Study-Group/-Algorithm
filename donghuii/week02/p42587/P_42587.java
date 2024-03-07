package P2024_01;

import java.util.*;
import java.util.stream.Collectors;

public class P_42587 {
    public static void main(String[] args) {
        List<Integer> priorities = List.of(1, 1, 9, 1, 1, 1);
        int location = 0;
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>() {
            {
                for (int i = 0; i < priorities.size(); i++) {
                    offer(new AbstractMap.SimpleEntry<>(i, priorities.get(i)));
                }
            }
        };
        System.out.println(queue);
        int result = 0;
        while(!queue.isEmpty()) {
            Map.Entry<Integer, Integer> current = queue.poll();
            boolean maxPriority = true;

            for(Map.Entry<Integer, Integer> entry : queue) {
                if(entry.getValue() > current.getValue()) {
                    maxPriority = false;
                    break;
                }
            }

            if (maxPriority) {
                result++;
                if(current.getKey() == location) {
                    break;
                }
            } else {
                queue.offer(current);
            }
        }

        System.out.println(result);

//        Comparator<Map.Entry<Integer, Integer>> myComparator = (entry1, entry2) -> {
//            int valueCompare = entry2.getValue().compareTo(entry1.getValue());
//            if (valueCompare != 0) {
//                return valueCompare;
//            } else {
//                return entry1.getKey().compareTo(entry2.getKey()) * -1;
//            }
//        };
//        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>() {
//            {
//                addAll(map.entrySet().stream()
//                        .sorted(myComparator)
//                        .collect(Collectors.toList()));
//            }
//        };
    }
}
