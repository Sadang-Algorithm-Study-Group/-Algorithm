package P2024_01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class B_2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] ropes = new Integer[n];

        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        Arrays.sort(ropes, (a, b) -> b - a);

        int max = 0;
        for (int i = 0; i < n; i++) {
            int current = ropes[i] * (i + 1);//현재 로프 포함한 무게
            if(current > max) {
                max = current;
            }
        }

        System.out.println(max);
        sc.close();
    }
}
