const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let num = 0; // 테스트 케이스 번호
let count = 0; // 연결된 부분의 수

while (input.length > 0) {
    let graph = new Map(); // 그래프 초기화
    let nC = Number(input.shift()); // 사람의 수

    // 입력이 숫자이고 0보다 크면 실행
    if (Number(nC) && !isNaN(nC)) {
        // 그래프 구성
        for (let i = 0; i < nC; i++) {
            let readLine = input.shift().split(' ');
            let personA = readLine[0];
            let personB = readLine[1];
            // 그래프에 해당 사람이 없으면 추가
            if (!graph.has(readLine[0])) graph.set(readLine[0], []);
            if (!graph.has(personB)) graph.set(personB, []);
            console.log(graph);

            // 각 사람이 선행을 베풀면 다른 사람도 선행을 베풀어야 함
            graph.get(readLine[0]).push(personB);
            graph.get(personB).push(readLine[0]);
        }

        // 방문 여부를 나타내는 Set 초기화
        let visited = new Set();

        // BFS 알고리즘 구현
        function bfs(start) {
            let queue = [start];
            while (queue.length > 0) {
                let current = queue.shift();
                for (let next of graph.get(current)) {
                    if (visited.has(next)) continue;
                    visited.add(next);
                    queue.push(next);
                }
            }
        }

        // 그래프 순회하면서 연결된 부분의 수를 찾음
        for (let [person] of graph) {
            if (!visited.has(person)) {
                bfs(person);
                count++;
            }
        }

        // 결과 출력
        console.log(`${++num} ${count}`);
        count = 0; // 연결된 부분 수 초기화
    }
}
