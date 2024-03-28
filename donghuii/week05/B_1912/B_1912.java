package P2024_01;

import java.util.*;

public class B_1912 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(sc.nextInt());
                }
            }
        };

        int currentSum = 0, maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            currentSum += arr.get(i);

            if(currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        System.out.println(maxSum);

        sc.close();
    }
}
