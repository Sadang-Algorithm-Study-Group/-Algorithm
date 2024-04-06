package week05.pgs12900;

class Solution {
    public int solution(int n) {
        int[] array = new int[n];
        array[0] = 1;

        if (n > 1) array[1] = 2;
        for (int i = 1; i < array.length - 1; i++) {
            array[i + 1] = (array[i] + array[i - 1]) % 1_000_000_007;
        }
        return array[array.length - 1];
    }
}