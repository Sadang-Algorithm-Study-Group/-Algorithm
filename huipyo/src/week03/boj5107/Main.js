/**
 *  마니또 (페어프로그래밍 효영/희표)
 *  https://www.acmicpc.net/problem/5107
 *  [ 효율성 ]
 *  - 메모리: 9412KB
 *  - 시간 : 116ms
 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');
let num = 0;

while (input.length) {
    let graph = {};
    let nC = Number(input.shift());

    if (nC === 0) break;
    num++;
    for (let i = 0; i < nC; i++) {
        let [first, second] = input.shift().split(' ');

        if (!graph[first]) graph[first] = [];
        if (!graph[second]) graph[second] = [];
        graph[first].push(second);
        graph[second].push(first);
    }
    let count = 0;

    // 방문 여부를 나타내는 Set 초기화
    let visited = new Set();

    // BFS 알고리즘 구현
    function bfs(start) {
        let queue = [start];

        while (queue.length > 0) {
            let current = queue.shift();

            for (let next of graph[current]) {
                if (visited.has(next)) continue;
                visited.add(next);
                queue.push(next);
            }
        }
    }

    for (let node in graph) {
        if (!visited.has(node)) {
            bfs(node);
            count++;
        }
    }
    console.log(`${num} ${count}`);
}