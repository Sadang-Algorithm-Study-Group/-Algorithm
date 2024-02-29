package P2024_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_42586 {
    public static void main(String[] args) {
        List<Integer> progresses = List.of(93, 30, 55);
        List<Integer> speeds = List.of(1, 30, 5);
        Solution42586 so = new Solution42586();
        System.out.println(so.solution(progresses, speeds));
    }
}
class Solution42586 {
    public List<Integer> solution(List<Integer> progresses, List<Integer> speeds) {
        List<Integer> result = new ArrayList<>();
        List<Integer> complete = new ArrayList<>();

        for (int i = 0; i < progresses.size(); i++) {
            int days = (int) Math.ceil((100.0 - progresses.get(i)) / speeds.get(i));
            complete.add(days);
        }
        int currentMaxDays = complete.get(0);
        int count = 1;

        for (int i = 1; i < complete.size(); i++) {
            if(complete.get(i)<=currentMaxDays) {
                count++;
            } else {
                result.add(count);
                currentMaxDays = complete.get(i);
                count = 1;
            }
        }
        result.add(count);
        return result;
    }
}