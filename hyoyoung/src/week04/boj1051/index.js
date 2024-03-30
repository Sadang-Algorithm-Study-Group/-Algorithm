//**숫자정사각형 */
const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');
let [n, m] = input.shift().split(' ');
let graph = [];
for (let i = 0; i < n; i++) {
    graph.push([...input.shift()]);
}
let size = 1;

for (let s = 0; s < Math.min(n, m); s++) {
    for (let i = 0; i < graph.length - s; i++) {
        for (let j = 0; j < graph[i].length - s; j++) {
            let num = graph[i][j];
            if (num === graph[i][j + s] && num === graph[i + s][j] && num === graph[i + s][j + s]) {
                size = Math.max(size, s + 1);
            }
        }
    }
}

console.log(size * size);
