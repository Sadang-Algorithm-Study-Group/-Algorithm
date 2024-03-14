package P2024_01;

import java.util.*;

public class P_42576 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        HashSet<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4));
        Iterator iterator = set.iterator();
        System.out.println(set);
//        for(int it : set) {
//            System.out.println(iterator.next());
//        }

        Solution42576 so = new Solution42576();
        String result = so.solution1(participant, completion);
        System.out.println(result);

    }
}

class Solution42576 {
    public String solution(String[] participant, String[] completion) {
        List<String> dupli = new ArrayList<>(){
            {
                for (String str : participant) {
                    add(str);
                }
            }
        };
        for (String str : completion) {
            dupli.remove(str);
        }
        return dupli.get(0);
    }
    public String solution1(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
            System.out.println(map);
        }
        for(String player : completion) {
            map.put(player, map.get(player) - 1);
            if(map.get(player) == 0) {
                map.remove(player);
            }
        }
        return map.keySet().iterator().next();
    }
}