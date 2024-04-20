//**숫자 카드 */

//**메모리 136908	시간 944 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let N = Number(input[0]);
let card = input[1].split(' ').map(Number);
let M = Number(input[2]);
let arr = input[3].split(' ').map(Number);

let answer = [];
card.sort((a, b) => a - b);

function binany_search(s, e, k) {
    if (s === e) {
        if (card[s] === k) return 1;
        else return 0;
    }
    let mid = Math.floor((s + e) / 2);
    if (card[mid] >= k) return binany_search(s, mid, k);
    else return binany_search(mid + 1, e, k);
}
for (let i = 0; i < arr.length; i++) {
    answer.push(binany_search(0, N - 1, arr[i]));
}

console.log(answer.join(' '));
