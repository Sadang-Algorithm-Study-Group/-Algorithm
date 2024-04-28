/**
 *  소수의 연속합
 *  https://www.acmicpc.net/problem/1644
 *  [ 효율성 ]
 *  - 메모리: 21264KB
 *  - 시간 : 720ms
 */

package week09.boj1644;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] primeNumbers = IntStream.rangeClosed(2, n).filter(Main::isPrime).toArray();
        int answer = isPrime(n) ? 1 : 0;

        for (int i = 0; i < primeNumbers.length - 1; i++) {
            int sum = primeNumbers[i];

            for (int j = i + 1; j < primeNumbers.length; j++) {
                if (sum < n) {
                    sum += primeNumbers[j];
                } else {
                    if (sum == n) answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
        scanner.close();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 6; i <= (int) Math.sqrt(n) + 1; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }
}
