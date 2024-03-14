package P2024_01;

import java.util.*;

public class B_11652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(sc.nextInt());
                }
            }
        };
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxValue = Collections.max(map.values());

        List<Integer> keys = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == maxValue) {
                keys.add(entry.getKey());
            }
        }

        System.out.println(Collections.min(keys));
        sc.close();
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            map.put(x, map.getOrDefault(x, 0) + 1);
//        }
//        Optional<Integer> maxValue = map.values()
//                .stream().max(Integer::compareTo);
//
//        List<Integer> keys = new ArrayList<>() {
//            {
//                if(maxValue.isPresent()) {
//                    for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                        if(entry.getValue().equals(maxValue.get())) {
//                            add(entry.getKey());
//                        }
//                    }
//                }
//            }
//        };
//        System.out.println(keys.stream().min(Integer::compareTo).get());
//        map.forEach((key, value) -> {
//            if(value.equals(
//                    map.values()
//                            .stream()
//                            .max(Integer::compareTo).get()
//            )) {
//                System.out.println(key);
//            }
//        });
//        sc.close();
    }
}
