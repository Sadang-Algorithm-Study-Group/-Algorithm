package week05.boj2579;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = initArray(count, scanner);
        LinkedList<Integer> stack = new LinkedList<>();
        AtomicInteger answer = new AtomicInteger(0);
        Runnable backtracking = new Runnable() {
            @Override
            public void run() {
                for (int i : new int[] {1, 2}) {
                    if (i == 1 && !stack.isEmpty() && stack.peek() == 1) continue;
                    stack.push(i);
                    if (isSumEqualsCount(stack, count)) {
                        var sum = array[0];
                        var jSum = 0;

                        for (int j : stack) {
                            jSum += j;
                            sum += array[jSum];
                            answer.set(Math.max(answer.get(), sum));
                        }
                    }
                    if (stack.size() < count) {
                        run();
                    }
                    stack.pop();
                }
            }
        };

        backtracking.run();
        System.out.println(answer.get());
        scanner.close();
    }

    private static int sum(List<Integer> list) {
        int result = 0;

        for (int e : list) {
            result += e;
        }
        return result;
    }

    private static boolean isSumEqualsCount(List<Integer> list, int count) {
        int sum = sum(list);
        return sum == count - 1 || sum == count;
    }

    private static int[] initArray(int count, Scanner scanner) {
        int[] array = new int[count + 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
