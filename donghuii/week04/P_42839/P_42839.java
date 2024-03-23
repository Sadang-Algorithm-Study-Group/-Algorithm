package P2024_01;

import java.util.*;

public class P_42839 {
    public static void main(String[] args) {
        String numbers = "011";
        Set<Integer> set = new HashSet<>();

        combinations("", numbers, set);
        int result = 0;
        for(int value : set) {
            if(isPrime(value)) {
                result++;
            }
        }

        System.out.println(result);
    }
    private static void combinations(String prefix, String remaining, Set<Integer> set) {
        if (!prefix.isEmpty()) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < remaining.length(); i++) {
            combinations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), set);
        }
    }
    private static boolean isPrime(int number) {
        if(number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
