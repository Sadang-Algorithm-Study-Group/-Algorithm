package week09.boj20922;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] array = new int[n];
        int answer = 0;

        Arrays.setAll(array, i -> scanner.nextInt());
        for (int left = 0; left < array.length - 1; left++) {
            answer = Math.max(answer, getLength(left, k, array));
        }
        System.out.println(answer);
        scanner.close();
    }

    private static int getLength(int start, int k, int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int right = start + 1; right < array.length; right++) {
            map.put(array[right], map.getOrDefault(array[right], 0) + 1);
            if (map.get(array[right]) > k) break;
            count++;
        }
        return count;
    }
}