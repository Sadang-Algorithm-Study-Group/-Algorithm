/**
 *  CD
 *  https://www.acmicpc.net/problem/4158
 *  [ 효율성 ]
 *  - 메모리: 271800KB
 *  - 시간 : 1020ms
 */

package week08.boj4158;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String readln;

            while (!(readln = reader.readLine()).equals("0 0")) {
                int n = Integer.parseInt(readln.split(" ")[0]);
                int m = Integer.parseInt(readln.split(" ")[1]);

                System.out.println(getAnswer(reader, n, m));
            }
        }
    }

    private static int getAnswer(BufferedReader reader, int n, int m) throws IOException {
        int result = 0;
        long[] array = new long[n];

        Arrays.setAll(array, i -> {
            try {
                return Long.parseLong(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        for (int i = 0; i < m; i++) {
            if (Arrays.binarySearch(array, Long.parseLong(reader.readLine())) > -1) result++;
        }
        return result;
    }
}