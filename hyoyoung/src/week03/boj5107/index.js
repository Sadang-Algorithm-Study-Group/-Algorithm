const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let num = 0;
let count = 0;

while (input.length) {
    let graph = new Map();
    let inputs = [];
    let nC = Number(input.shift());

    if (Number(nC) && !isNaN(nC)) {
        inputs = inputArr(nC);
        num++;
        for (let array of inputs) {
            graph.set(array[0], []);
        }
        for (let array of inputs) {
            graph.get(array[0]).push(array[1]);
            graph.get(array[1]).push(array[0]);
        }

        var visitied = new Set();

        function bfs(start) {
            let queue = [start];
            while (queue.length > 0) {
                let current = queue.shift();
                for (let next of graph.get(current)) {
                    if (visitied.has(next)) continue;
                    visitied.add(next);
                    queue.push(next);
                }
            }
        }
        for (let i of inputs) {
            let name = i[0];
            if (!visitied.has(name)) {
                bfs(name);
                count++;
            }
        }
        console.log(`${num} ${count}`);
        count = 0;
    }
}

function inputArr(nC) {
    let inputs = [];
    for (let i = 0; i < nC; i++) {
        let readLine = input.shift().split(' ');
        inputs.push(readLine);
    }
    return inputs;
}
