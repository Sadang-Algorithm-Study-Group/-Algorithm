/**
 *  단어 뒤집기 2
 *  https://www.acmicpc.net/problem/17413
 *  [ 효율성 ]
 *  - 메모리: 22544KB
 *  - 시간 : 396ms
 */

package week01.boj17413;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder resultBuilder = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                // 태그 시작
                inTag = true;

                resultBuilder.append(word.reverse());
                word.setLength(0);
                resultBuilder.append(s.charAt(i));
            } else if (s.charAt(i) == '>') {
                // 태그 끝
                inTag = false;

                resultBuilder.append(s.charAt(i));
            } else if (inTag) {
                // 태그 안의 문자열
                resultBuilder.append(s.charAt(i));
            } else if (s.charAt(i) == ' ') {
                // 단어 뒤집기
                resultBuilder.append(word.reverse()).append(' ');
                word.setLength(0);
            } else {
                // 단어 구성
                word.append(s.charAt(i));
            }
        }

        // 마지막 단어 처리
        resultBuilder.append(word.reverse());
        System.out.println(resultBuilder);
    }
}