// const fs = require('fs');
// const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
// let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

// input.shift()
// input = input.map(x=>x)
//메모리:18984KB 시간:244ms
function solution(arr){

    let count = 0;
    for(let x of arr){
        if(!check(x)) count++
    }

    function check(x){
        let stack =[]
        for(let y of x){
            // stack의 마지막이 현 요소와 같거나 stack의 길이가 비어있지 않을때
            if(stack[stack.length-1]===y && stack.length !==0){ 
                //pop을 해준다.
                stack.pop()
            }else stack.push(y) // 현오소랑 같지 않으면 push를 해준다.

        }
        return stack.length;
        
    }

    return count
}

input = ['AAA','AA','BB']
console.log(solution(input))//2