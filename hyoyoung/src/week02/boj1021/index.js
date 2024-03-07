const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let N = Number(input.shift().split(' ')[0])
input = input.shift().split(' ').map(Number)
// 메모리 : 9356KB, 시간:128ms

function solution(N,input){
    let answer =0;
    let Deque = Array.from({length:N},(_,i)=>i+1);
    while(input.length){
        if(Deque[0]===input[0]){
            input.shift();
            Deque.shift()
        }else{
            let leftCount = 0;
            let rightCount =0;
            let left = [...Deque];
            let right = [...Deque];
            while(left[0]!==input[0]){
                left.push(left.shift());
                leftCount++
            }
            while(right[0]!==input[0]){
                right.unshift(right.pop())
                rightCount++
            }
            if(leftCount>rightCount){
                Deque = right
            }else Deque=left
            answer+= Math.min(leftCount,rightCount)
        }

    }
    return answer
}
// let N = 10
// let input = [2,9,5];
console.log(solution(N,input))
