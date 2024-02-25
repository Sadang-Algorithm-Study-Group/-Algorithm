package week01.pgs12906;

import javax.script.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 자바스크립트 호출부
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Solution");

        try {
            scriptEngine.eval(
                    Files.newBufferedReader(
                            Paths.get("\\Users\\honghuipyo\\Documents\\Algorithm\\huipyo\\src\\week01\\pgs12906\\Solution.js"),
                            StandardCharsets.UTF_8
                    )
            );
            Invocable invocable = (Invocable) scriptEngine;
            Object[] arg = new Object[1];
            arg[0] = new int[] {1, 1, 3, 3, 0, 1, 1};

            System.out.println(invocable.invokeFunction("solution", arg));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 자바 호출부
        System.out.println(Arrays.toString(
                new Solution().solution(new int[] {1, 1, 3, 3, 0, 1, 1})
        )); // Answer: [1,3,0,1]
        System.out.println(Arrays.toString(
                new Solution().solution(new int[] {4, 4, 4, 3, 3})
        )); // Answer: [4,3]
    }
}
