package P2024_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.function.Function;

public class B_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //버퍼리더가 더 빠르니까 써보기
        Function<String, Integer> function = Integer::parseInt;
        //함수형 인터페이스 써보기
        int n = function.apply(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = function.apply(br.readLine());
        }

        solution(n, arr);
    }
    private static void solution(int n, int[] arr) {
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[n];
        dp[0] = arr[0];

        if (n > 1) dp[1] = Math.max(arr[0] + arr[1], arr[1]);
        if (n > 2) dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);

        for (int index = 3; index < n; index++) {
            dp[index] = Math.max(
                    arr[index] + arr[index - 1] + dp[index - 3],
                    arr[index] + dp[index - 2]
            );
        }

        System.out.println(dp[n - 1]);
    }
}


//public class B_2579 {
//
//    static List<Integer> list;
//    static int answer = 0;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int start = sc.nextInt();
//
//        list = new ArrayList<>();
//        for (int i = 0; i < start; i++) {
//            list.add(sc.nextInt());
//        }
//
//        List<Integer> path = new ArrayList<>();
//        findPaths(start - 1, path);
//
//        System.out.println(answer);
//
//        sc.close();
//    }
//
//    public static void findPaths(int current, List<Integer> path) {
//        path.add(current);
//
//        if (current == 0) {
//            int sum = 0;
//            for (int value : path) {
//                sum += list.get(value);
//            }
//            answer = Math.max(sum, answer);
//            path.remove(path.size() - 1);
//            return;
//        }
//
//        for (int next = current - 1; next >= current - 2 && next >= 0; next--) {
//            if (path.size() < 2 || !(path.get(path.size() - 2) == next + 2 && path.get(path.size() - 1) == next + 1)) {
//                List<Integer> newPath = new ArrayList<>(path);
//                findPaths(next, newPath);
//            }
//        }
//
//        path.remove(path.size() - 1);
//    }
//}

