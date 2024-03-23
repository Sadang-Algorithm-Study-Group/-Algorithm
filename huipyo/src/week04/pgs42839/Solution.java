package week04.pgs42839;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String numbers) {
        LinkedList<Integer> stack = new LinkedList<>();
        Set<Integer> primeNumbers = new HashSet<>();
        List<String> numberList = Arrays.asList(numbers.split(""));
        Runnable getNumbers = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberList.size(); i++) {
                    stack.push(i);
                    if (!stack.isEmpty()) {
                        int n = Integer.parseInt(stack.stream().distinct().map(numberList::get).collect(Collectors.joining()));

                        if (BigInteger.valueOf(n).isProbablePrime(10)) primeNumbers.add(n);
                        if (stack.size() - 1 < numberList.size() - 1) run();
                    }
                    stack.pop();
                }
            }
        };

        getNumbers.run();
        return primeNumbers.size();
    }
}