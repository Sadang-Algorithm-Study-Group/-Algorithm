package week07.pgs42860;

public class Main {

    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }

    public static int solution(String name) {
        return dfs(name, 0, 0);
    }

    private static int dfs(String name, int sum, int index) {
        if (index == -1 || name.equals("A".repeat(name.length()))) {
            return sum;
        }

        if (name.charAt(index) != 'A') {
            sum += getCountByChar(name.charAt(index), sum);
            name = name.substring(0, index) + 'A' + name.substring(index + 1);
        }

        int nextIndex = findNextIndexOfNotA(index, name);
        int prevIndex = findPreviousIndexOfNotA(index, name);
        return Math.min(dfs(name, sum, nextIndex), dfs(name, sum, prevIndex));
    }

    private static int findNextIndexOfNotA(int index, String name) {
        for (int i = index + 1; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                return i;
            }
        }
        return -1;
    }

    private static int findPreviousIndexOfNotA(int index, String name) {
        for (int i = index; 0 <= i; i--) {
            if (name.charAt(i) != 'A') {
                return i;
            }
        }
        return -1;
    }


    private static int getCountByChar(char c, int sum) {
        if (c < 'M') {
            int sum1 = c - 'A';
            sum += sum1;
        } else {
            int sum1 = 'Z' - c + 1;
            sum += sum1;
        }
        return sum;
    }
}
