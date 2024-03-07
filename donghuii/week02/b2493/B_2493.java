package P2024_01;

import java.io.*;
import java.util.*;

public class B_2493 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>() {
            {
                for (int i = 0; i < N; i++) {
                    offer(new AbstractMap.SimpleEntry<>(i, sc.nextInt()));
                }
            }
        };
        List<Integer> result = new ArrayList<>();
        result.add(0);
        Map.Entry<Integer, Integer> first = queue.poll();//1
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> current = queue.poll();//2
            if(first.getValue() >= current.getValue()) {
                result.add(current.getKey());
                first = current;
            } else {
                result.add(first.getKey());
                first = current;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
