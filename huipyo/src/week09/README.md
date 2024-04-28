# ** [ 4월 27일 기록 ] **
- 인원: 3명 (3명 온라인)
- 장소: 게더타운
- 시간: 13:00 - 15:30

# ** [ To - DO ] **
- 과제: DFS, BFS
    - BOJ url: https://www.acmicpc.net/problemset?sort=ac_desc&algo=7
               https://www.acmicpc.net/problemset?sort=ac_desc&algo=11
               https://www.acmicpc.net/problemset?sort=ac_desc&algo=126
               https://www.acmicpc.net/problemset?sort=ac_desc&algo=127
    - Programmers url: https://school.programmers.co.kr/learn/courses/30/parts/12421

# ** [ 진행 사항 ] **
1. 과제 코드 리뷰
    - 구명보트

2. 공부한 것 세미발표로 스터디원들과 공유하기
    - 발표자: 희표
    - 발표내용: 투 포인터

3. 알고리즘 문제 풀이
    - 문제를 읽고 각자 1명씩 풀수 있는 예상시간을 베팅 후 평균낸 시간을 내어 주어진 시간안에 문제 풀기
    - 귀여운 라이언(40분)
    - 배열 합치기(30분)
    - 동전 1(라이브 코딩)

4. 기타 건의사항
    - 동전 1은 DP로 분류됨
    - 어린이날 연휴로 인해 한주 쉬어가기로 함, 5월 2일, 4일은 쉬는날
    - 5월 9일, 11일 부터 스터디 다시 시작
    - 과제로 풀 문제는 미리 올려주기

# ** [ 발표 내용 ] **
투 포인터(Two Pointer)
--------------------------------------------------

* 배열이나 리스트에서 ‘두 개의 포인터’를 사용하여 ‘특정 조건을 만족하는 부분 구간’을 효율적으로 탐색하는 알고리즘

### 투 포인터 예제 그림
![스크린샷 2024-04-27 240427](https://github.com/Sadang-Algorithm-Study-Group/Algorithm/blob/huipyo/huipyo/src/week09/image.jpg)

### 투 포인터 수행 단계
1. 배열 또는 리스트의 시작 위치에 첫 번쨰 포인터와 두 번째 포인터를 설정 
2. 두 포인터 사이의 구간을 조사하고 조건을 확인한다. 
3. 조건을 만족할 경우, 알고리즘 종료 
4. 조건을 만족하지 않을 경우, 첫 번째 또는 두 번째 포인터를 이동
5. 다시 2번 단계로 돌아가 반복

--------------------------------------------------
투 포인터 종류

* 고정 길이 슬라이딩 윈도우:
  ![스크린샷 2024-04-27 240427](https://github.com/Sadang-Algorithm-Study-Group/Algorithm/blob/huipyo/huipyo/src/week09/img.gif)
    * 고정된 길이의 윈도우를 사용하여 배열이나 리스트를 탐색 
    * 윈도우 크기를 일정하게 유지하면서 왼쪽 포인터와 오른쪽 포인터를 이동시키며 필요한 계산을 수행 
    * 부분 배열의 합이나 평균을 계산하는 등의 문제에 사용될 수 있다.
* 가변 길이 슬라이딩 윈도우:
    * 가변 길이의 윈도우를 사용해서 배열이나 리스트를 탐색 
    * 최소 길이 부분 배열이나 최대 길이 부분 배열을 찾는 등의 문제에 사용될 수 있다.

### 투 포인터 이동 원칙
- sum과 count는 1로 초기화한 상태
- sum > N : sum = sum - start_index; start_index++
- sum < N : end_index++; sum = sum + end_index;
- sum == N : end_index++; sum = sum + end_index; count++;

## 슈도코드 작성해보기(백준 2018)

<aside>
➕ N 변수 저장
사용 변수 초기화(count = 1 , start_index = 1, end_index = 1, sum = 1)
while (end_index ≠ N) {
if (sum == N) count증가, end_index증가, sum값 변경
else if (sum > N) sum 값 변경, start_index 증가
else if (sum < N) end_index증가, sum값 변경
}

count출력

</aside>

### 구현코드
```java
import java.util.Scanner;

public class TowPointerP2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int sum = 1;
        int start_index = 1;
        int end_index = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum = sum + end_index;
            } else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
```