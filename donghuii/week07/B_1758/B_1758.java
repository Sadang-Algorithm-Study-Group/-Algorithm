package P2024_01;

import java.util.Arrays;
import java.util.Scanner;

public class B_1758 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] people = new Integer[n];
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }
        Arrays.sort(people, (a, b) -> b - a);
        long max = 0;
        for (int i = 0; i < n; i++) {
            max += Math.max(people[i] - i, 0);
        }

        System.out.println(max);
        sc.close();
    }
}
