package week06.pgs92344;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(
                new int[][] {
                        {5,5,5,5,5},
                        {5,5,5,5,5},
                        {5,5,5,5,5},
                        {5,5,5,5,5}},
                new int[][] {
                        {1,0,0,3,4,4},
                        {1,2,0,2,3,2},
                        {2,1,0,3,1,2},
                        {1,0,1,3,3,1}
                }
        )); // 10
        System.out.println(new Solution().solution(
                new int[][] {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                },
                new int[][] {
                        {1,1,1,2,2,4},
                        {1,0,0,1,1,2},
                        {2,2,0,2,0,100}
                }
        )); // 6
    }
}
