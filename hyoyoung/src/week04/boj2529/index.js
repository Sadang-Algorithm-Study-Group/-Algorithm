//**부등호 */
// const fs = require('fs');
// const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
// let input = fs.readFileSync(filePath).toString().trim().split('\r\n');
// let k1 = input.shift();

// 1. 안풀림
// function solution(input) {
//     let arr = input.split(' ');
//     let ch = Array.from({ length: 10 }, () => 0);
//     let path = Array.from({ length: input.legnth + 1 }, () => 0);

//     function check(length, breck) {
//         for (let i = 0; i < length.length - 1; i++) {
//             if (breck[i] === '<' && length[i] > length[i + 1]) return false;
//             if (breck[i] === '>' && length[i] < length[i + 1]) return false;
//         }
//         return true;
//     }
//     let max = -1;
//     let min = Number.MAX_SAFE_INTEGER;
//     let answerMin = 0;
//     let answerMax = 0;
//     function dfs(v) {
//         if (v === arr.length + 1) {
//             if (check([...path], arr)) {
//                 let num = Number(path.join(''));
//                 if (num > max) {
//                     max = Math.max(num, max);
//                     answerMax = path.join('');
//                 }
//                 if (num < min) {
//                     min = Math.min(num, min);
//                     answerMin = path.join('');
//                 }
//                 // min = Math.min(num, min);
//                 // max = Math.max(num, max);
//             }
//         } else {
//             for (let i = 0; i < 10; i++) {
//                 if (ch[i] === 0) {
//                     ch[i] = 1;
//                     path[v] = i;
//                     dfs(v + 1);
//                     ch[i] = 0;
//                 }
//             }
//         }
//     }
//     dfs(0);

//     return answerMax + '\n' + answerMin;
// }

// console.log(solution('< >'));

//**2. 백트랙킹 */

//**메모리: 12836, 시간 :216  */
function solution(k, input) {
    let brenck = input.split(' ');
    let answer = [];
    function dfs(v, str) {
        if (v === k) {
            answer.push(str);
            return;
        } else {
            const last = str[str.length - 1];
            if (brenck[v] === '<') {
                for (let i = 0; i < 10; i++) {
                    if (!str.includes(`${i}`) && last < i) {
                        dfs(v + 1, str + `${i}`);
                    }
                }
            } else {
                for (let i = 0; i < 10; i++) {
                    if (!str.includes(`${i}`) && last > i) {
                        dfs(v + 1, str + `${i}`);
                    }
                }
            }
        }
    }

    for (let i = 0; i < 10; i++) {
        dfs(0, `${i}`);
    }
    return `${answer.pop()}\n${answer.shift()}`;
}

console.log(solution(k, input));
