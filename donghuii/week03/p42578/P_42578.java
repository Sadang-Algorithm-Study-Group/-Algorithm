package P2024_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class P_42578 {
    public static void main(String[] args) {
        String[][] cloth1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        String[][] cloth2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        SolutionCloth so = new SolutionCloth();
        System.out.println(so.solution(cloth1));
    }
}
class SolutionCloth {
    public int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>() {
            {
                for(String[] cloth : clothes) {
                    putIfAbsent(cloth[1], new ArrayList<>());
                    get(cloth[1]).add(cloth[0]);
                }
            }
        };
        System.out.println(map);

        int result = 1;
        System.out.println(map.keySet());
        for(String key : map.keySet()) {
            result *= (map.get(key).size() + 1);
        }

        return result - 1;//적어도 하나 이상의 의상을 선택해야 하는 조건 때문에 -1 해준다.
    }
}