package P2024_01;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class P_43105 {

    private static List<List<Integer>> result = new ArrayList<>();
    private static int maxValue = 0;

    public static void main(String[] args) {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        };

        for (int i = 0; i < triangle.length; i++) {
            result.add(new ArrayList<>());
        }

        nodeSum(triangle, 0, 0, 0);
        System.out.println(result.get(triangle.length -1).stream().max(Integer::compareTo).get());
    }
    private static void nodeSum(int[][] triangle, int level, int index, int sum) {
        if (level >= triangle.length || index >= triangle[level].length) {
            return;
        }

        sum += triangle[level][index];

        result.get(level).add(sum);

        nodeSum(triangle, level + 1, index, sum);
        nodeSum(triangle, level + 1, index + 1, sum);
    }
}
