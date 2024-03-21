package P2024_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class B_2529 {
    static int k;
    static String[] check;
    static boolean[] visited = new boolean[10];
    static String minValue = String.valueOf(Long.MAX_VALUE);
    static String maxValue = String.valueOf(Long.MIN_VALUE);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        check = new String[k];
        for (int i = 0; i < k; i++) {
            check[i] = sc.next();
        }

        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            dfs(i, 0, "" + i);
            visited[i] = false;
        }

        System.out.println(maxValue);
        System.out.println(minValue);
        sc.close();
    }

    private static void dfs(int num, int depth, String value) {
        if (depth == k) {
            if (value.compareTo(minValue) < 0) minValue = value;
            if (value.compareTo(maxValue) > 0) maxValue = value;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                if ((check[depth].equals("<") && num < i) || (check[depth].equals(">") && num > i)) {
                    visited[i] = true;
                    dfs(i, depth + 1, value + i);
                    visited[i] = false;
                }
            }
        }
    }
}