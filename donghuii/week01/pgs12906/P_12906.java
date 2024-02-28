package P2024_01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

public class P_12906 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        Solution12906 so = new Solution12906();
        System.out.println(Arrays.toString(so.solution(arr)));
    }
}
class Solution12906 {
    public int[] solution(int[] arr) {
        return IntStream.range(0, arr.length)
                .filter(i -> i == 0 || arr[i] != arr[i - 1])
                .map(i -> arr[i])
                .toArray();
    }
}