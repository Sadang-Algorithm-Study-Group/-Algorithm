package week03.pgs42577;

import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        return Arrays.stream(phoneBook)
                .sorted()
                .flatMap(a -> Arrays.stream(phoneBook).filter(b -> !a.equals(b) && b.startsWith(a)))
                .toList()
                .isEmpty();
    }
}