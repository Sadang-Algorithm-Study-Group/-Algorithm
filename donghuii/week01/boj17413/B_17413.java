package P2024_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 인터페이스 써봤는데 너무 오래걸림 담부터 안쓸랜다.
 * 모던 자바 : 메모리 31188KB / 시간 536ms -> 확실히 가독성은 좋음
 * 일반 : 메모리 30576KB / 시간 532ms
 */
public class B_17413 {
    public static void main(String[] args) {
        Solution17413 solution = new Solution17413();
        List<String> list = solution.inputString();
        List<String> result = solution.transformArray(list);
        List<String> answer = solution.reverseInside(result);
        System.out.println(String.join("", answer));
    }
}
interface transform {
    List<String> inputString();
    List<String> transformArray(List<String> input);
    List<String> reverseInside(List<String> input);
}
class Solution17413 implements transform{
    @Override
    public List<String> inputString() {
        try (Scanner sc = new Scanner(System.in)) {
            return Arrays.stream(sc.nextLine().split("")).collect(Collectors.toList());
        }
    }
    @Override
    public List<String> reverseInside(List<String> input) {
        return input.stream()
                .map(str -> !str.startsWith("<") || !str.endsWith(">") ?
                        new StringBuilder(str).reverse().toString() : str)
                .collect(Collectors.toList());
    }
    @Override
    public List<String> transformArray(List<String> input) {
        List<String> result = new ArrayList<>();
        StringBuilder currentString = new StringBuilder();
        boolean insideBrackets = false;

        for (String element : input) {
            switch (element) {
                case "<":
                    current(result, currentString);
                    insideBrackets = true;
                    currentString.append(element);
                    break;
                case ">":
                    currentString.append(element);
                    current(result, currentString);
                    insideBrackets = false;
                    break;
                case " ":
                    if (!insideBrackets) {
                        current(result, currentString);
                        result.add(" ");
                    } else {
                        currentString.append(element);
                    }
                    break;
                default:
                    currentString.append(element);
                    break;
            }
        }
        current(result, currentString);
        return result;
    }
    private void current(List<String> result, StringBuilder currentString) {
        if (currentString.length() > 0) {
            result.add(currentString.toString());
            currentString.setLength(0);
        }
    }
}