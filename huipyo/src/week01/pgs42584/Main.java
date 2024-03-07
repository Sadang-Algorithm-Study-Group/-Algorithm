package week01.pgs42584;

import week01.pgs12906.Solution;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // 자바스크립트 호출부
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        try {
            // 호출할 자바스크립트 파일의 경로를 지정합니다.
            String scriptPath = "C:\\Users\\HPHong\\IntelliJIDEAProjects\\Algorithm\\huipyo\\src\\week01\\pgs42584\\Solution.js";

            // 자바스크립트 파일을 읽어옵니다.
            FileReader reader = new FileReader(scriptPath);

            // 자바스크립트 함수의 매개변수를 생성합니다.
            Object[] jsArgs1 = new Object[1];
            jsArgs1[0] = new int[] {1, 2, 3, 2, 3};

            // Nashorn 엔진을 사용하여 자바스크립트 파일을 실행합니다.
            engine.eval(reader);

            // 자바스크립트 파일에서 호출 가능한 객체를 생성합니다.
            Invocable invocable = (Invocable) engine;

            // 자바스크립트 함수 호출
            Object result1 = invocable.invokeFunction("solution", jsArgs1);

            // 호출 결과를 출력합니다.
            System.out.println(result1.toString());

            // 파일 읽기를 종료합니다.
            reader.close();
        } catch (IOException | ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        // 자바 호출부
        System.out.println(Arrays.toString(
                new Solution().solution(new int[] {1, 2, 3, 2, 3})
        )); // Answer: [4, 3, 1, 1, 0]
    }
}

