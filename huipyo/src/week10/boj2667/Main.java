package week10.boj2667;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] array = new char[n][];
        LinkedList<Integer> countList = new LinkedList<>();
        Consumer<int[]> dfs = new Consumer<>() {
            @Override
            public void accept(int[] pos) {
                for (int[] next : new int[][] {{pos[0] - 1, pos[1]}, {pos[0], pos[1] + 1}, {pos[0] + 1, pos[1]}, {pos[0], pos[1] - 1}}) {
                    if (next[0] > -1 && next[0] < array.length && next[1] > -1 && next[1] < array[0].length && array[next[0]][next[1]] == '1') {
                        array[next[0]][next[1]] = '2';
                        countList.push(countList.pop() + 1);
                        accept(next);
                    }
                }
            }
        };

        Arrays.setAll(array, i -> scanner.next().toCharArray());
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == '1') {
                    countList.push(0);
                    dfs.accept(new int[] {i, j});
                }
            }
        }
        countList.sort(Comparator.naturalOrder());
        System.out.println(countList.size());
        for (int count : countList) {
            System.out.println(count);
        }
        scanner.close();
    }
}
