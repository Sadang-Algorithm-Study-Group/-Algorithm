package week02.boj26042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제: 식당 입구 대기 줄
 */

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int maxQueueSize = 0;
            int minStudentNum = n;

            for (int i = 0; i < n; i++) {
                String[] input = reader.readLine().split(" ");
                String command = input[0];

                // 유형 1
                if (command.equals("1")) {
                    int studentNum = Integer.parseInt(input[1]);
                    queue.offer(studentNum);

                    // 기존 최대 대기 인원보다 queue 사이즈가 크면
                    if (maxQueueSize < queue.size()) {
                        maxQueueSize = queue.size();
                        minStudentNum = studentNum;
                    }

                    // 같으면
                    if (maxQueueSize == queue.size()) {
                        minStudentNum = Math.min(minStudentNum, studentNum);
                    }
                } else { // 유형2
                    queue.poll();
                }
            }

            // 최대 대기 인원, 최소 학생 번호 출력
            System.out.printf("%d %d", maxQueueSize, minStudentNum);
        }
    }
}
