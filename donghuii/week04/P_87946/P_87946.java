package P2024_01;

import java.util.*;
import java.util.stream.Collectors;

public class P_87946 {
    public static void main(String[] args) {
        int k = 80;
        Map<Integer, int[]> dungeons = new HashMap<>();
        dungeons.put(0, new int[]{80, 20});
        dungeons.put(1, new int[]{50, 40});
        dungeons.put(2, new int[]{30, 10});

        int result = 0;

        while (!dungeons.isEmpty()) {
            // 현재 k 값으로 진입 가능한 던전 찾기
            int finalK = k;
            Map<Integer, Integer> accessibleDungeons = dungeons.entrySet().stream()
                    .filter(entry -> finalK >= entry.getValue()[0])
                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue()[1]));

            if (accessibleDungeons.isEmpty()) {
                break; // 더 이상 진입할 수 있는 던전이 없음
            } else {
                // 가장 소모 키가 적은 던전 찾기
                int minKeyDungeon = accessibleDungeons.entrySet().stream()
                        .min(Map.Entry.comparingByValue())
                        .get().getKey();

                // k 업데이트 및 던전 제거
                k -= dungeons.get(minKeyDungeon)[1];
                dungeons.remove(minKeyDungeon);
                result++;
            }
            System.out.println("Remaining k: " + k);
        }

        System.out.println("Maximum dungeons: " + result);
//        int k = 80;
//        int[][] dungeons = {
//                {80, 20},
//                {50, 40},
//                {30, 10}
//        };
//        int result = 0;
//        while(true) {
//            int[] checking = new int[dungeons.length];
//            for (int i = 0; i < dungeons.length; i++) {
//                if (k <= dungeons[i][0]) {
//                    checking[i] = dungeons[i][1];
//                }
//            }
//            System.out.println(Arrays.toString(checking));
//            if (checking[0] == 0) {
//                break;
//            } else {
//                int min = Arrays.stream(checking).filter(i -> i != 0).min().getAsInt();
//                System.out.println(min);
//                k -= min;
//                result++;
//            }
//            System.out.println(k);
//
//        }
//
//        System.out.println(result);
//        int maxValue = map.get(Collections.max(map.keySet()));
//        k -= maxValue;
//        map.remove(Collections.max(map.keySet()));
//        System.out.println(map);
//        int minValue = Collections.min(map.values());

    }
}
