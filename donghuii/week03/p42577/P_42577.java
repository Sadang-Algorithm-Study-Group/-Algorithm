package P2024_01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class P_42577 {
    public static void main(String[] args) {
        String[] phone = {"119", "97674223", "1195524421"};
        String[] phone1 = {"123","456","789"};
        boolean result = true;
        Arrays.sort(phone);
        for (int i = 0; i < phone.length - 1; i++) {
            if(phone[i + 1].startsWith(phone[i])) {
                result = false;
                break;
            }
        }
        System.out.println(result);
        Arrays.sort(phone1);
        System.out.println(
                IntStream.range(0, phone1.length - 1)
                        .noneMatch(i -> phone1[i + 1].startsWith(phone1[i]))
        );
    }
}
