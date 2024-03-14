/**
 *  카드
 *  https://www.acmicpc.net/problem/11652
 *  [ 효율성 ]
 *  - 메모리: 127432KB
 *  - 시간 : 1132ms
 */

package week03.boj11652;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(
                LongStream.range(0, n)
                        .mapToObj(i -> scanner.nextLong())
                        .collect(Collectors.groupingBy(i -> i))
                        .entrySet()
                        .stream()
                        .min((o1, o2) -> Math.toIntExact(o1.getValue().size() != o2.getValue().size() ? o2.getValue().size() - o1.getValue().size() : Long.compare(o1.getKey(), o2.getKey())))
                        .orElse(new AbstractMap.SimpleEntry<>(0L, Collections.emptyList()))
                        .getKey()
        );
        scanner.close();
    }
}