package week08.boj3896;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 문제: 소수 사이 수열
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(reader.readLine());

            for (int i = 0; i < t; i++) {
                BigInteger k = new BigInteger(reader.readLine());
                System.out.println(solution(k));
            }
        }
    }

    private static int solution(BigInteger k) {
        if (k.isProbablePrime(10)) {
            return 0;
        }

        BigInteger nextPrime = k.nextProbablePrime();

        for (int i = k.intValue(); 0 <= i; i--) {
            if (BigInteger.valueOf(i).isProbablePrime(10)) {
                return nextPrime.intValue() - i;
            }
        }

        return 0;
    }
}
