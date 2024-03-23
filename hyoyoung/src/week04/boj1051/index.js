//**숫자정사각형 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');
let [n, m] = input.shift().split(' ');
let graph = Array.from({ length: +n }, () => Array(+m).fill(0));
let check = Array.from({ length: +n }, () => Array(+m).fill(0));
for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        graph[i][j] = input[i][j];
    }
}
function dfs(v, x, y, num) {
    if (v === 3) {
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (check[i][j] === 0 && num === graph[i][j]) {
                check[i][j] = 1;
                dfs(v + 1, graph[i][j]);
                check[i][j] = 0;
            }
        }
    }
}

for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
        if (check[i][j] === 0) {
            check[i][j] = 1;
            dfs(0, i, j, graph[i][j]);
            check[i][j] = 0;
        }
    }
}
console.log(solution(graph));
