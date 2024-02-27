const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
    let resultBuilder = "";
    let word = "";
    let inTag = false;

    for (let i = 0; i < line.length; i++) {
        if (line.charAt(i) === '<') {
            // 태그 시작
            inTag = true;

            resultBuilder += word.split("").reverse().join("");
            word = "";
            resultBuilder += s.charAt(i);
        } else if (line.charAt(i) === '>') {
            // 태그 끝
            inTag = false;

            resultBuilder += line.charAt(i);
        } else if (inTag) {
            // 태그 안의 문자열
            resultBuilder += line.charAt(i);
        } else if (line.charAt(i) === ' ') {
            // 단어 뒤집기
            resultBuilder += word.split("").reverse().join("") + ' ';
            word = "";
        } else {
            // 단어 구성
            word += line.charAt(i);
        }
    }

    // 마지막 단어 처리
    resultBuilder += word.split("").reverse().join("");
    console.log(resultBuilder);
});