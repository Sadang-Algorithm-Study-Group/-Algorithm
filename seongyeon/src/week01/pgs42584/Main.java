package week01.pgs42584;

/**
 * 문제: 주식가격
 */

public class Main {

    /**
     * 다시 이해한 문제 정리
     * 입력 [1, 2, 3, 2, 3] -> 출력 [4, 3, 1, 1, 0]
     * 이 케이스에서 유심히 봐야하는 점: 3 -> 2 로 갈 때 결과 값이 1다. 바로 감소했는데 결과 값이 0이 아니고 1이다.
     * 3 -> 2는 분명 감소를 뜻하지만, 3에서 2가 되는 그 사이에 흐른 시간이 1초기 때문에 결과가 1인 것이다. 즉, 그 1초간에는 가격이 떨어진 것이 아니므로..^^
     * 더 이해하기 쉬운 예로는 [4, 3, 2, 1] -> [1, 1, 1, 0] 이 있다.
     */

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int nextPrice = prices[j];
                count++;

                if (nextPrice < currentPrice) {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
