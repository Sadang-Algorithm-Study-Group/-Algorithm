package week09.pgs42885;


import java.util.Arrays;

/**
 * 문제: 구명보트
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java
 */

class Solution {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int boatCount = 0;

        while (left <= right) {
            int weightSum = people[left] + people[right];

            if (weightSum <= limit) {
                left++;
            }

            right--;
            boatCount++;
        }

        return boatCount;
    }
}
