package week01.pgs42586;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // 자바스크립트 호출부
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        try {
            // 호출할 자바스크립트 파일의 경로를 지정합니다.
            String scriptPath = "C:\\Users\\HPHong\\IntelliJIDEAProjects\\Algorithm\\huipyo\\src\\week01\\pgs42586\\Solution.js";

            // 자바스크립트 파일을 읽어옵니다.
            FileReader reader = new FileReader(scriptPath);

            // 자바스크립트 함수의 매개변수를 생성합니다.
            Object[] jsArgs1 = new Object[2];
            jsArgs1[0] = new int[] {93, 30, 55};
            jsArgs1[1] = new int[] {1, 30, 5};
            Object[] jsArgs2 = new Object[2];
            jsArgs2[0] = new int[] {95, 90, 99, 99, 80, 99};
            jsArgs2[1] = new int[] {1, 1, 1, 1, 1, 1};

            // Nashorn 엔진을 사용하여 자바스크립트 파일을 실행합니다.
            engine.eval(reader);

            // 자바스크립트 파일에서 호출 가능한 객체를 생성합니다.
            Invocable invocable = (Invocable) engine;

            // 자바스크립트 함수 호출
            Object result1 = invocable.invokeFunction("solution", jsArgs1);
            Object result2 = invocable.invokeFunction("solution", jsArgs2);

            // 호출 결과를 출력합니다.
            System.out.println(result1.toString());
            System.out.println(result2.toString());

            // 파일 읽기를 종료합니다.
            reader.close();
        } catch (IOException | ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}