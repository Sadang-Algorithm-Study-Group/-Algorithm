/**
 *  뒤집기 3
 *  https://www.acmicpc.net/problem/1464
 *  메모리 초과
 */

package week02.boj1464;

import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        SortedSet<String> sortedSet = new TreeSet<>();
        BiConsumer<Integer, String> consumer = new BiConsumer<>() {
            @Override
            public void accept(Integer integer, String string) {
                for (int i = integer; i <= s.length(); i++) {
                    String reversedSubstring = new StringBuilder(string.substring(0, i))
                            .reverse()
                            .append(string.substring(i))
                            .toString();

                    if (sortedSet.contains(reversedSubstring)) continue;
                    sortedSet.add(string);
                    sortedSet.add(reversedSubstring);
                    accept(integer + 1, string);
                    accept(integer + 1, reversedSubstring);
                }
            }
        };

        consumer.accept(2, s);
        System.out.println(sortedSet.first());
        scanner.close();
    }
}