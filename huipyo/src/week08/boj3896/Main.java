/**
 *  소수 사이 수열
 *  https://www.acmicpc.net/problem/3896
 *  [ 효율성 ]
 *  - 메모리: 105248KB
 *  - 시간 : 1192ms
 */

package week08.boj3896;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            BigInteger k = scanner.nextBigInteger();

            System.out.println(k.nextProbablePrime().subtract(getPreviousPrime(k)));
        }
        scanner.close();
    }

    private static BigInteger getPreviousPrime(BigInteger bigInteger) {
        if (bigInteger.isProbablePrime(10)) return bigInteger.nextProbablePrime();
        while (!bigInteger.isProbablePrime(10)) {
            bigInteger = bigInteger.subtract(BigInteger.ONE);
        }
        return bigInteger;
    }
}
