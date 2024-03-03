package week01.boj3986;

import java.io.*;
import java.util.*;

/**
 * 문제: 좋은 단어
 */

public class Main {
    /**
     * 메모리: 25088kb
     * 시간: 280ms
     */

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine());
//        String[] words = new String[n];
//        for (int i = 0; i < n; i++) {
//            words[i] = reader.readLine();
//        }
//
//        System.out.println(solution(words));
//    }
//
//    public static int solution(String[] words) {
//        int count = 0;
//
//        for (String word : words) {
//            if (isGoodWord(word)) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private static boolean isGoodWord(String word) {
//        LinkedList<Character> stack = new LinkedList<>();
//
//        for (char c : word.toCharArray()) {
//            if (!stack.isEmpty() && stack.peek() == c) {
//                stack.pop();
//                continue;
//            }
//
//            stack.push(c);
//        }
//
//        return stack.isEmpty();
//    }

    /**
     * 메모리: 25828kb
     * 시간: 280ms
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> words = new ArrayList<>();

        // 단어 입력
        for (int i = 0; i < n; i++) {
            words.add(reader.readLine());
        }

        System.out.println(solution(words));
    }

    // 좋은 단어 count
    public static long solution(List<String> words) {
        return  words.stream()
                .filter(Main::isGoodWord)
                .count();
    }

    // 좋은 단어 인지 확인
    private static boolean isGoodWord(String word) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : word.toCharArray()) {
            // stack의 마지막 요소와 현재의 글자가 같다면 pop
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }
            stack.push(c); // stack이 비어 있거나, 현재 글자와 다르면 push
        }
        return stack.isEmpty();
    }
}
