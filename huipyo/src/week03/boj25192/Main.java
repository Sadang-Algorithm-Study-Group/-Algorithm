/**
 *  인사성 밝은 곰곰이
 *  https://www.acmicpc.net/problem/25192
 *  [ 효율성 ]
 *  - 메모리: 67672KB
 *  - 시간 : 768ms
 */

package week03.boj25192;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        int mapCount = 0;
        Map<String, Integer> map = new HashMap<>();

        Arrays.setAll(array, i -> scanner.next());
        for (String str : array) {
            if (str.equals("ENTER")) {
                mapCount += map.size();
                map.clear();
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        mapCount += map.size();
        System.out.println(mapCount);
        scanner.close();
    }
}
