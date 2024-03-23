//**소수찾기 */

function solution(numbers) {
    var answer = 0;
    let ch = Array.from({ length: numbers.length }, () => 0);
    let set = new Set();
    function prime(num) {
        if (num < 2) return false;
        for (let i = 2; i < num; i++) {
            if (num % i === 0) return false;
        }
        return true;
    }
    function dfs(v, path) {
        if (v > 0 && !set.has(+path)) {
            set.add(+path);
            if (prime(+path)) {
                answer++;
            }
        }
        for (let i = 0; i < numbers.length; i++) {
            if (ch[i] === 0) {
                ch[i] = 1;
                dfs(v + 1, path + numbers[i]);
                ch[i] = 0;
            }
        }
    }
    dfs(0, '');
    return answer;
}

console.log(solution('17'));
// console.log(solution('011'));
