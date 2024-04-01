package P2024_01;

import java.util.*;

public class B_1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Map<String, Integer>> list = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    Map<String, Integer> map = new HashMap<>();
                    map.put("R", sc.nextInt());
                    map.put("G", sc.nextInt());
                    map.put("B", sc.nextInt());
                    add(map);
                }
            }
        };
        System.out.println(list);
        for (int i = 1; i < n; i++) {
            Map<String, Integer> current = list.get(i);
            Map<String, Integer> previous = list.get(i - 1);

            current.put("R", current.get("R") + Math.min(previous.get("G"), previous.get("B")));
            current.put("G", current.get("G") + Math.min(previous.get("R"), previous.get("B")));
            current.put("B", current.get("B") + Math.min(previous.get("R"), previous.get("G")));
        }

        Map<String, Integer> lastHouse = list.get(n - 1);
        int minCost = Math.min(Math.min(lastHouse.get("R"), lastHouse.get("G")), lastHouse.get("B"));

        System.out.println(minCost);

        sc.close();
    }
}
