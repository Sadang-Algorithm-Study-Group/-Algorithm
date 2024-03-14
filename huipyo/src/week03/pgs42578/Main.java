package week03.pgs42578;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][] {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        })); // 5
        System.out.println(new Solution().solution(new String[][] {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        })); // 3
    }
}
