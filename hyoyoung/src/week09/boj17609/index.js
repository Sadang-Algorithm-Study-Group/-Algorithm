//** 회문 */

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let answer = '';

function twoPointer(str) {
    let left = 0;
    let right = str.length - 1;
    let check = true;
    let check2 = true;

    while (left < right) {
        if (str[left] === str[right]) {
            left++;
            right--;
        } else if (str[left] !== str[right]) {
            if (check === false) {
                // check2 = false;
                console.log(2);
                return;
            } else if (str[left + 1] === str[right]) {
                left++;
                check = false;
            } else if (str[left] === str[right - 1]) {
                right--;
                check = false;
            } else {
                // check2 = false;
                console.log(2);
                return;
            }
        }
    }
    if (check === false) {
        return console.log(1);
    } else return console.log(0);

    // if (check2 === false) {
    //     // answer += `2\n`;
    //     console.log(2);
    // } else if (check === false) {
    //     // answer += `1\n`;
    //     console.log(1);
    // } else {
    //     // answer += `0\n`;
    //     console.log(0);
    // }
}

for (let i = 1; i < input.length; i++) {
    twoPointer(input[i]);
}

// console.log(answer.trim());
