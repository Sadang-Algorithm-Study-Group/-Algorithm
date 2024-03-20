function solution(k, dungeons) {
    var answer = 0;
    var stack = [];
    function backtracking(sum) {
        for (let i = 0; i < dungeons.length; i++) {
            if (stack.includes(i) || sum < dungeons[i][0]) continue;
            stack.push(i);
            answer = Math.max(answer, stack.length);
            if (stack.length < dungeons.length) backtracking(sum - dungeons[i][1]);
            stack.pop();
        }
    }

    backtracking(k);
    return answer;
}