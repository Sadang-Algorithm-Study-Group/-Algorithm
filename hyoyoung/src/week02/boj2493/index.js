const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

input.shift()
input = input[0].split(' ').map(Number)


// 시간초과...이중for문을 써서 그런 것 같다..
function solution(input){
    let queue =Array.from({length:input.length},()=>0);
    for(let i=input.length-1; i>=0; i--){
        for(let j = i-1; j>=0; j--){
            console.log(input[i],input[j])
            if(input[j]>input[i]){
                queue[i]=j+1;
                break
            }
        }
    }
    console.log(queue.join(' '))
}

solution(input)
