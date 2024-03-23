# ** [ 3월 23일 기록 ] **
- 인원: 3명
- 장소: 원루프랩 사당점(6A회의실)
- 시간: 15:30 - 18:00

# ** [ To - DO ] **
- 과제: Dynamic Programming
    - BOJ url: https://www.acmicpc.net/problemset?sort=ac_desc&algo=25
    - Programmers url: https://school.programmers.co.kr/learn/courses/30/parts/12263

# ** [ 진행 사항 ] **
1. 과제 코드 리뷰
    - 백준 숫자 정사각형

2. 공부한 것 세미발표로 스터디원들과 공유하기
    - 발표자: 희표
    - 발표내용: 완전탐색과 순열

3. 알고리즘 문제 풀이
    - 완전탐색 3문제 풀이
    - 숫자 야구(40분)
    - 카펫(30분)
    - 리모컨(25분)

4. 기타 건의 사항
    - 알고리즘 문제 풀이 할때 어려운 문제를 선정해오니 시간내에 풀수 없고, 스터디 시간이 루즈해지는 경향이 있음
    - 2시간내에 풀수 있는 해당 주차 주제에 대해 확실히 짚고 갈수 있는 쉬운? 문제를 선정하면 좋겠습니다.

# ** [ 발표 내용 ] **
- 순열에서의 DFS

1, 2, 3, 4를 중복을 허용하여 모든 순열을 완전탐색으로 출력하면

``` Java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    for (int l = 0; l < list.size(); l++) {
                        count++;
                        System.out.println(list.get(i) + ", " + list.get(j) + ", " + list.get(k) + ", " + list.get(l));
                    }
                }
            }
        }
        System.out.println("count: " + count);
    }
}
```

실행 결과:
``` C
1, 1, 1, 1
1, 1, 1, 2
1, 1, 1, 3
1, 1, 1, 4
1, 1, 2, 1
1, 1, 2, 2
...
...
4, 4, 3, 1
4, 4, 3, 2
4, 4, 3, 3
4, 4, 3, 4
4, 4, 4, 1
4, 4, 4, 2
4, 4, 4, 3
4, 4, 4, 4
count: 256
```

1, 2, 3, 4를 중복없이 모든 순열을 출력하면

``` Java
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                for (int k = 0; k < list.size(); k++) {
                    if (i == k || j == k) continue;
                    for (int l = 0; l < list.size(); l++) {
                        if (i == l || j == l || k == l) continue;
                        count++;
                        System.out.println(list.get(i) + ", " + list.get(j) + ", " + list.get(k) + ", " + list.get(l));
                    }
                }
            }
        }
        System.out.println("count: " + count);
    }
}
```

실행 결과:
``` C
1, 2, 3, 4
1, 2, 4, 3
1, 3, 2, 4
1, 3, 4, 2
1, 4, 2, 3
1, 4, 3, 2
2, 1, 3, 4
2, 1, 4, 3
2, 3, 1, 4
2, 3, 4, 1
2, 4, 1, 3
2, 4, 3, 1
3, 1, 2, 4
3, 1, 4, 2
3, 2, 1, 4
3, 2, 4, 1
3, 4, 1, 2
3, 4, 2, 1
4, 1, 2, 3
4, 1, 3, 2
4, 2, 1, 3
4, 2, 3, 1
4, 3, 1, 2
4, 3, 2, 1
count: 24
```

1, 2, 3, 4 등 4가지의 숫자가 아닌 n개의 숫자의 순열을 구할경우 매번 n중 for문을 돌려야 하는가?

n개의 슷자를 중복을 허용하여 스택과 재귀함수를 이용하여 깊이우선 탐색으로 순열을 구하면 아래와 같다.

``` Java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stack<Integer> stack = new Stack<>();

        dfs(list, stack);
        System.out.println("count: " + count);
    }

    private static void dfs(List<Integer> list, Stack<Integer> stack) {
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
            if (stack.size() == list.size()) {
                count++;
                System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                dfs(list, stack);
            }
            stack.pop();
        }
    }
}
```

실행 결과:
``` C
1, 1, 1, 1
1, 1, 1, 2
1, 1, 1, 3
1, 1, 1, 4
1, 1, 2, 1
1, 1, 2, 2
...
...
4, 4, 3, 1
4, 4, 3, 2
4, 4, 3, 3
4, 4, 3, 4
4, 4, 4, 1
4, 4, 4, 2
4, 4, 4, 3
4, 4, 4, 4
count: 256
```

백트래킹이란? 원하는 해가 아닌것을 가지치기하며 되돌아가는 기법
즉 백트래킹을 이용하여 중복을 제거한 모든 순열을 출력하면

``` Java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stack<Integer> stack = new Stack<>();

        backTracking(list, stack);
        System.out.println("count: " + count);
    }

    private static void backTracking(List<Integer> list, Stack<Integer> stack) {
        for (int i = 0; i < list.size(); i++) {
            if (stack.contains(list.get(i))) continue;
            stack.push(list.get(i));
            if (stack.size() == list.size()) {
                count++;
                System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                backTracking(list, stack);
            }
            stack.pop();
        }
    }
}
```

실행 결과:
``` C
1, 2, 3, 4
1, 2, 4, 3
1, 3, 2, 4
1, 3, 4, 2
1, 4, 2, 3
1, 4, 3, 2
2, 1, 3, 4
2, 1, 4, 3
2, 3, 1, 4
2, 3, 4, 1
2, 4, 1, 3
2, 4, 3, 1
3, 1, 2, 4
3, 1, 4, 2
3, 2, 1, 4
3, 2, 4, 1
3, 4, 1, 2
3, 4, 2, 1
4, 1, 2, 3
4, 1, 3, 2
4, 2, 1, 3
4, 2, 3, 1
4, 3, 1, 2
4, 3, 2, 1
count: 24
```

즉 코드에서 dfs와의 차이는 if문의 여부로 확인할수 있음
아래 코드는 중복을 허용하되, 홀수개만 탐색하는 백트래킹 코드

``` Java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stack<Integer> stack = new Stack<>();

        backTracking(list, stack);
        System.out.println("count: " + count);
    }

    private static void backTracking(List<Integer> list, Stack<Integer> stack) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) continue;
            stack.push(list.get(i));
            if (stack.size() == list.size()) {
                count++;
                System.out.println(stack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            } else {
                backTracking(list, stack);
            }
            stack.pop();
        }
    }
}
```

실행 결과:
``` C
1, 1, 1, 1
1, 1, 1, 3
1, 1, 3, 1
1, 1, 3, 3
1, 3, 1, 1
1, 3, 1, 3
1, 3, 3, 1
1, 3, 3, 3
3, 1, 1, 1
3, 1, 1, 3
3, 1, 3, 1
3, 1, 3, 3
3, 3, 1, 1
3, 3, 1, 3
3, 3, 3, 1
3, 3, 3, 3
count: 16
```

- 그래프에서의 DFS

4개의 노드가 있고
아래와 같이 간선이 연결되있을때,
``` C
1: 2, 3, 4
2: 1, 4
3: 1, 4
4: 1, 2, 3
```

``` Java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> nodes = new HashMap<>() {
            {
                put(1, List.of(2, 3, 4));
                put(2, List.of(1, 4));
                put(3, List.of(1, 4));
                put(4, List.of(1, 2, 3));
            }
        };
        int start = 1;

        dfs(nodes, start, new Stack<>(), new HashSet<>(List.of(start)));
    }

    private static void dfs(Map<Integer, List<Integer>> edgeMap, int v, Stack<Integer> stack, Set<Integer> visited) {
        System.out.println(v); // 탐색순서
        for (int next : edgeMap.get(v)) {
            if (visited.contains(next)) continue;
            stack.push(next);
            visited.add(next);
            if (!stack.isEmpty()) {
                dfs(edgeMap, next, stack, visited);
            }
            stack.pop();
        }
    }
}
```

탐색순서는 아래와 같이 출력된다.
``` C
1
2
4
3
```