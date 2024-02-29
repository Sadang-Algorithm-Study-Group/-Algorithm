package week01.pgs12906;

import java.util.*;
import java.util.function.Function;

public class Solution {
    public int[] solution(int[] arr) {
        Function<int[], int[]> function = array -> {
            List<Integer> list = new ArrayList<>(Collections.singletonList(array[0]));

            for (int i = 1; i < array.length; i++) {
                if (list.get(list.size() - 1) != array[i])
                    list.add(array[i]);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        };
        return arr.length == 0 ? arr : function.apply(arr);
    }
}
