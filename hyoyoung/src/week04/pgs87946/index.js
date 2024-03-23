//**피로도 */
function solution(k, dungeons) {
    var answer = -1;
    let n = dungeons.length;
    let ch = Array.from({ length: n }, () => 0);
    function dfs(s, t) {
        answer = Math.max(t, answer);

        for (let i = 0; i < n; i++) {
            if (!ch[i] && dungeons[i][0] <= s) {
                ch[i] = 1;
                dfs(s - dungeons[i][1], t + 1);
                ch[i] = 0;
            }
        }
    }
    dfs(k, 0);
    return answer;
}

console.log(80, [
    [80, 20],
    [50, 40],
    [30, 10],
]);
