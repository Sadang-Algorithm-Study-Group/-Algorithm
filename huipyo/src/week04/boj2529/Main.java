/**
 *  부등호
 *  https://www.acmicpc.net/problem/2529
 *  [ 효율성 ]
 *  - 메모리: 271484KB
 *  - 시간 : 2028ms
 */

package week04.boj2529;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String[] inequalities = new String[k];
        LinkedList<Integer> stack = new LinkedList<>();
        SortedSet<String> sortedSet = new TreeSet<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if (stack.contains(i)) continue;
                    stack.push(i);
                    if (stack.size() <= k) run();
                    else if (isCorrect(stack, inequalities)) sortedSet.add(String.join("", mapToString(stack.toArray(), String::valueOf)));
                    stack.pop();
                }
            }
        };

        Arrays.setAll(inequalities, s -> scanner.next());
        runnable.run();
        System.out.println(sortedSet.last());
        System.out.println(sortedSet.first());
        scanner.close();
    }

    private static <T> String[] mapToString(T[] array, Function<T, String> function) {
        String[] result = new String[array.length];

        Arrays.setAll(result, i -> function.apply(array[i]));
        return result;
    }

    private static boolean isCorrect(List<Integer> list, String[] inequalities) {
        for (int i = 1; i < list.size(); i++) {
            if (isWrong(list.get(i - 1), list.get(i), inequalities[i - 1])) return false;
        }
        return true;
    }

    private static boolean isLessThan(String inequality) {
        return inequality.equals("<");
    }

    private static boolean isWrong(int first, int second, String inequality) {
        return isLessThan(inequality) ? first > second : first < second;
    }
}