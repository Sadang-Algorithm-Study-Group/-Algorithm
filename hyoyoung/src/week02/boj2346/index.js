const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let N = input.shift();

input = input.shift().split(' ').map(Number);

// 객체가 문제인듯 => 배열로 바꿔줌 => 3. 그래도 메모리 초과
let arr = input.map((v, i) => [v, i + 1]);
//     {
//     val: v,
//     cur: i + 1,
// }

let queue = [];

//고차함수 => 2. 그래도 메모리 초과^^
const cycle = (num, cycleFun) => {
    for (let i = 0; i < num; i++) {
        cycleFun();
    }
};

while (arr.length > 0) {
    let asc = arr.shift();
    let [A, B] = asc;
    queue.push(B);
    if (arr.length === 0) break;
    if (A > 0) {
        cycle(A - 1, () => arr.push(arr.shift()));
    } else {
        cycle(-A, () => arr.unshift(arr.pop()));
    }
    //1. 메모리 초과^^
    // if (A > 0) {
    //     for (let i = 0; i < A - 1; i++) {
    //         let element = arr.shift();
    //         if (!element) continue;
    //         arr.push(element);
    //     }
    // } else {
    //     for (let i = 0; i < Math.abs(A); i++) {
    //         let element = arr.pop();
    //         // if (!element) continue;
    //         arr.unshift(element);
    //     }
    // }
}

console.log(queue); //1 4 5 3 2 //3 2 1 -3 -1
