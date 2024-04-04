package P2024_01;

import java.util.Arrays;
import java.util.Scanner;

public class B_2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();
        int[][] result = new int[k][4];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = sc.nextInt() - 1;
            }
        }

        for (int[] arr : result) {
            long sum = 0;
            for (int i = arr[0]; i <= arr[2]; i++) {
                for (int j = arr[1]; j <= arr[3]; j++) {
                    sum += nums[i][j];
                }
            }
            System.out.println(sum);
        }
        sc.close();
    }
}
