package week07.boj1758;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        long answer = 0;

        Arrays.setAll(array, i -> scanner.nextInt());
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            long tip = array[i] - i;

            if (tip > 0) {
                answer += tip;
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}