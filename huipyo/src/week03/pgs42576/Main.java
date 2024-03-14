package week03.pgs42576;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                new String[] {"leo", "kiki", "eden"},
                new String[] {"eden", "kiki"}
        )); // leo
        System.out.println(new Solution().solution(
                new String[] {"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[] {"josipa", "filipa", "marina", "nikola"}
        )); // vinko
        System.out.println(new Solution().solution(
                new String[] {"mislav", "stanko", "mislav", "ana"},
                new String[] {"stanko", "ana", "mislav"}
        )); // mislav
    }
}
