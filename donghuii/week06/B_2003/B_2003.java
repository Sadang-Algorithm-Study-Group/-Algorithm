package P2024_01;

import java.util.Arrays;
import java.util.Scanner;

public class B_2003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(nums));

        int count = 0;
        dong: for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == m) {
                    count++;
                    continue dong;
                } else if(sum > m) {
                    continue dong;
                }
            }
        }
        System.out.println(count);
        System.out.println(towPointer(nums, m));
        sc.close();
    }
    //투포인터로 풀어보기
    private static int towPointer(int[] nums, int m) {
        int count = 0;
        int start = 0, end = 0, sum = 0;

        while(true) {
            if(sum >= m) sum -= nums[start++];
            else if(end == nums.length) break;
            else sum += nums[end++];

            if(sum == m) count++;
        }

        return count;
    }
}
