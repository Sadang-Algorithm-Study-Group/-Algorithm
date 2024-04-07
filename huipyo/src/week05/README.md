# ** [ 3월 30일 기록 ] **
- 인원: 2명 (1명 온라인)
- 장소: 원루프랩 사당점(6A회의실)
- 시간: 15:30 - 18:00

# ** [ To - DO ] **
- 과제: Prefix Sum
    - BOJ url: https://www.acmicpc.net/problemset?sort=ac_desc&algo=139

# ** [ 진행 사항 ] **
1. 과제 코드 리뷰
    - 백준 계단 오르기
    - 백준 RGB거리
    - 프로그래머스 정수 삼각형
    - 백준 연속합

2. 공부한 것 세미발표로 스터디원들과 공유하기
    - 발표자: 희표
    - 발표내용: 동적계획법

3. 알고리즘 문제 풀이
    - 요번주는 과제 코드리뷰만 진행하고, 선정한 문제는 각자 풀어보는것으로 정했습니다.

4. 기타 건의 사항
    - 스터디 장소를 다른장소를 옮기는것을 검토 (강남 등)
    - 스터디 시간을 유동적으로 조절하는게 어떨지 논의

# ** [ 발표 내용 ] **
동적 계획법(Dynamic Programming, 다이나믹 프로그래밍)
--------------------------------------------------

* 하나의 큰 문제를 해결하기 위해서 큰 문제를 작은 문제로 나누어 해결한 후,  작은 문제로부터 계산된 결과값를 이용하여 전체문제를 해결하는 알고리즘

### 동적계획법을 사용하는 이유:
* 큰 문제를 풀다보면 중복되는 연산이 발생하게 된다.
* 이 중복연산을 제거하고 재활용하여 전체적인 코드의 수행 및 연산 효율을 증대시키기 위함이다.
* 한번 계산한 문제틑 다시 계산하지 않도록 하는 알고리즘

### 동적 계획법 원리,구현방식
1. 큰 문제를 작은 문제로 나눌 수 있어야한다.
2. 작은 문제들이 반복돼 나타나고 사용되며, 이 작은 문제들의 결과값은 항상 같아야한다.
3. 모든 작은 문제들은 한번만 계산해 DP 테이블에 저장하며 추후 재사용할 때는 이 DP 테이블을 이용한다.
* 메모이제이션(Memoization) 기법이라고 한다.
4. 톱-다운 방식 (top-down, 하향식) , 바텀-업 방식 (bottom-up, 상향식)  으로 구현할 수 있다.

* 메모이제이션(Memoization):
    * 프로그램 실행시, 중복되는 연산이 2번 수행되지 않도록 이전에 계산한 값을 저장하여 전체적인 연산실행속도를 빠르게 하는 기술
* 바텀-업 방식 (bottom-up, 상향식) :
    * 가장 최하위 문제의 답을 구한 후, 이를 이용하여 상위 문제를 풀어나가는 방식


--------------------------------------------------
동적 계획법 (Dynamic Programming) vs 분할 정복(Divide & Conquer)

* 하나의 큰 문제를 해결하기 위해, 작은 문제로 나누어 하위문제를 해결하고 다시 병합하여 상위문제의 답을 얻는 방식
* 동적계획법과 분할정복 의 차이점
    * 부분문제는 중복되어 상위문제 해결 시 재활용
    * 분할정복은 하향식 접근법을 사용하고 메모이제이션 기법을 사용하지 않는다

|      | 동적 계획법                      | 분할 정복          |
|------|-----------------------------|-------------------------|
| 공통점  | 문제를 잘게 쪼개서 가장 작은 단위로 분할     |
| 차이점  | 부분문제는 중복 O (상위 문제 해결 시 재활용) | 부분 문제는 서로 중복 X |
|      | 메모이제이션 사용 O                 | 메모이제이션 사용 X    |

-------------------------------------------------------
### 다이나믹 프로그래밍 문제 푸는 순서

1. 동적 계획법으로 풀 수 있는지 확인 (DP 로 풀 수 있는 문제?)
* 피보나치 수열
    * 작은 문제로 나눌 수 있음
    * 수얼의 값은 항상 같음

2. 점화식
* 이미 있는 공식이 있다면 해당 공식을 사용 (조합,순열)
* 전체문제와 부분문제간의 인과관계 파악이 필요

* 피보나치 수열 점화식 (점화식을 사용해 수열의 항이 이어지는 형태를 간결하게 표헌)
```
D[i] =  D[i-1] + D[i-2]

단 1,2 번째 피보나치수 = 1
```

3. 메모이제이션 원리 이해  
   메모이제이션은 부분문제를 풀었을때 이 문제를 DP 테이블에 저장해 놓고 다음에 같은 문제가 나왔을때 재계산하지않고 DP 테이블의 값을 이용하는 것을 말한다.


### 1. 피보나치 재귀
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci01 { //1. 피보나치 재귀

    // 재귀를 이용했으며, DP 적용 X
    private static int DFS(int n){
      if (n == 1 || n == 2){
          return 1;
      } else{
          return DFS(n-2) + DFS(n-1);
      }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
    
        for (int i=1;i<=N;i++){
          sb.append(DFS(i) + " ");
        }
        System.out.println(sb);
    }
}
```


### 2. 피보나치 재귀 (메모이제이션, top-down 방식 ,하향식)
* 큰 문제를 해결하기 위해 작은문제를 호출 → 탑다운 방식
* 주로 재귀함수 형태로 코드를 구현
* 이해하기 편함

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci02 { // 2. Top Down 방식 ,하향식 (메모이제이션)

  private static int[] fibo;
  
  private static int DFS(int n){

      // 종료 조건(1) : 기존에 계산한 적이 있는 부분의 문제는 재계산하지 않고 리턴
      if (fibo[n] > 0) {
          return fibo[n];
      }

      // 종료 조건(2) : 1 혹은 2일 때 1을 반환
      if (n == 1 || n == 2) {
          return fibo[n] = 1;
      } else{
          // 메모이제이션 : 구한 값을 바로 리턴하지 않고 DP 테이블에 저장한 후 리턴하도록 로직을 구현
          return fibo[n] = DFS(n-2) + DFS(n-1);
      }
  }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        fibo = new int[N+1];

        DFS(N);
  
        for (int i = 1; i <= N; i++){
          sb.append(fibo[i] + " ");
        }
        
        System.out.println(sb);
    }
}
```


### 3. 피보나치 (바텀-업 , 상향식 구현 방식)
* 가장 작은 부분 문제부터 문제를 해결하며 점점 큰 문제로 확장해 나가는 방식.
* 주로 반복문의 형태로 구현

```java
public class Fibonacci03 { // 3. 바텀-업 다이나믹 프로그래밍

  private static int[] d;

  public static void main(String[] args) throws IOException {


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  //  N 번째 피보나치 수를 계산

    // 첫 번째와 두 번째 피보나치 수는 1
    d[1] = 1;
    d[2] = 1;


    // 피보나치 함수(Fibonacci Function) 반복문으로 구현
    for (int i = 3; i <= N; i++) {
      d[i] = d[i - 1] + d[i - 2];
    }

    System.out.println(d[N]);
  }
}
```
### 결론
* 더 안전한 방식은 바텀-업이다.
* 톱-다운 방식은 재귀함수의 형태로 구현돼있기 때문에 재귀의 depth 가 깊어질수록 런타임에러가 발생할 수 있다.
