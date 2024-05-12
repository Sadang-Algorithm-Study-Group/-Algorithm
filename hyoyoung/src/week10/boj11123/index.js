const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

const T = Number(input[0]);

function arrMake(K, H, W) {
    let arr = [];
    let move = [
        [0, 1],
        [1, 0],
        [0, -1],
        [-1, 0],
    ];
    let count = 0;
    for (let i = K + 1; i <= K + H; i++) {
        arr.push(input[i].split(''));
    }

    function island(x, y) {
        for (let m = 0; m < 4; m++) {
            let [nx, ny] = [x + move[m][0], y + move[m][1]];
            if (nx >= 0 && nx < H && ny >= 0 && ny < W && arr[nx][ny] === '#') {
                arr[nx][ny] = '.';
                island(nx, ny);
            }
        }
    }

    for (let i = 0; i < H; i++) {
        for (let j = 0; j < W; j++) {
            if (arr[i][j] === '#') {
                count++;
                arr[i][j] = '.';
                island(i, j);
            }
        }
    }

    console.log(count);
}

for (let i = 1; i < input.length; i++) {
    if (!isNaN(input[i].split(' ')[0])) {
        arrMake(i, Number(input[i].split(' ')[0]), Number(input[i].split(' ')[1]));
    }
}
