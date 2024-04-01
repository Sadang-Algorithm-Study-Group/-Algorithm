package week05.boj1912;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int sum = 0;
        int answer = Integer.MIN_VALUE;

        Arrays.setAll(array, i -> scanner.nextInt());
        for (int number : array) {
            sum = Math.max(sum + number, number);
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
        scanner.close();
    }
}