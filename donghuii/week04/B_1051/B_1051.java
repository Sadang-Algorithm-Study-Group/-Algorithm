package P2024_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1051 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        List<String[]> list = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(sc.nextLine().split(""));
                }
            }
        };

        int result = 1;
        int maxSize = Math.min(n, m);

        donghuii:
        for (int size = maxSize; size > 1; size--) {
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    String topLeft = list.get(i)[j];
                    String topRight = list.get(i)[j + size - 1];
                    String bottomLeft = list.get(i + size - 1)[j];
                    String bottomRight = list.get(i + size - 1)[j + size - 1];
                    if (topLeft.equals(topRight) && topLeft.equals(bottomLeft) && topLeft.equals(bottomRight)) {
                        result = size * size;
                        break donghuii;
                    }
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}
