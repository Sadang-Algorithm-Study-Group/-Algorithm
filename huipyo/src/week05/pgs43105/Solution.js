/**
 *  정수 삼각형
 *  https://school.programmers.co.kr/learn/courses/30/lessons/43105
 *  [ 효율성 ]
 *  채점 결과
 *  정확성: 64.3
 *  효율성: 35.7
 *  합계: 100.0 / 100.0
 */

function solution(triangle) {
    for (var i = triangle.length - 2; i >= 0; i--) {
        for (var j = 0; j < triangle[i].length; j++) {
            triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
        }
    }
    return triangle[0][0];
}