const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\n');

let num = 0;
let count = 0;

while (input.length > 0) {
    let graph = new Map();
    let inputs = [];
    let nC = Number(input.shift());

    if (!isNaN(nC) && nC > 0) {
        for (let i = 0; i < nC; i++) {
            let readLine = input.shift().split(' ');
            let personA = readLine[0];
            let personB = readLine[1];

            if (!graph.has(personA)) {
                graph.set(personA, []);
            }
            if (!graph.has(personB)) {
                graph.set(personB, []);
            }

            graph.get(personA).push(personB);
            graph.get(personB).push(personA);
        }

        var visited = new Set();

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

        for (let [person] of graph) {
            if (!visited.has(person)) {
                bfs(person);
                count++;
            }
        }

        console.log(`${++num} ${count}`);
        count = 0;
    }
}
