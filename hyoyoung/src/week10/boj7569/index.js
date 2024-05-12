const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [M, N, H] = input.shift().split(' ').map(Number);

let graph = [];

for (let i = 0; i < H; i++) {
    let path = [];
    for (let h = 0; h < N; h++) {
        path.push(input.shift().split(' ').map(Number));
    }
    graph.push(path);
}

let queue = [];
let move = [
    [-1, 0, 0],
    [1, 0, 0],
    [0, -1, 0],
    [0, 1, 0],
    [0, 0, 1],
    [0, 0, -1],
];

let visited = new Array(H).fill(null).map(() => new Array(N).fill(null).map(() => new Array(M).fill(false)));

for (let h = 0; h < H; h++) {
    for (let n = 0; n < N; n++) {
        for (let m = 0; m < M; m++) {
            if (graph[h][n][m] === 1) {
                queue.push([h, n, m, 0]);
                visited[h][n][m] = true;
            }
        }
    }
}
let count = 0;
while (queue.length > 0) {
    let [h, x, y, c] = queue.shift();
    count = Math.max(count, c);
    for (let k = 0; k < 6; k++) {
        let [nh, nx, ny] = [h + move[k][0], x + move[k][1], y + move[k][2]];
        if (
            nh >= 0 &&
            nh < H &&
            nx >= 0 &&
            nx < N &&
            ny >= 0 &&
            ny < M &&
            graph[nh][nx][ny] === 0 &&
            !visited[nh][nx][ny]
        ) {
            graph[nh][nx][ny] = 1;
            queue.push([nh, nx, ny, c + 1]);
            visited[nh][nx][nh] = true;
        }
    }
}
for (let h = 0; h < H; h++) {
    for (let n = 0; n < N; n++) {
        for (let m = 0; m < M; m++) {
            if (graph[h][n][m] === 0) {
                count = -1;
            }
        }
    }
}
console.log(count, graph);
