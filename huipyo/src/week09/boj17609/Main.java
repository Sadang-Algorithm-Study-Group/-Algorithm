/**
 *  회문
 *  https://www.acmicpc.net/problem/17609
 *  [ 효율성 ]
 *  - 메모리: 54240KB
 *  - 시간 : 776ms
 */

package week09.boj17609;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            StringBuilder s = new StringBuilder(scanner.next());

            if (s.toString().contentEquals(s.reverse())) {
                System.out.println(0);
                continue;
            }
            for (int j = 0; j < s.length() / 2; j++) {
                if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
                    String substring = s.substring(j, s.length() - j);
                    String prefix = substring.substring(0, substring.length() - 1);
                    String suffix = substring.substring(1);
                    String prefixReversed = new StringBuilder(prefix).reverse().toString();
                    String suffixReversed = new StringBuilder(suffix).reverse().toString();

                    if (prefix.length() > 1 && prefix.equals(prefixReversed) || suffix.length() > 1 && suffix.equals(suffixReversed)) {
                        System.out.println(1);
                        break;
                    }
                    if (substring.length() % 2 == 0) {
                        StringBuilder ss = new StringBuilder(substring);

                        ss.deleteCharAt(ss.length() / 2);
                        if (ss.toString().contentEquals(ss.reverse())) {
                            System.out.println(1);
                            break;
                        }
                    }
                    System.out.println(2);
                    break;
                }
            }
        }
        scanner.close();
    }
}