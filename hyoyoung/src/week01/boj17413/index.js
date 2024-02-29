
// const fs = require('fs');
// const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
// let input = fs.readFileSync(filePath).toString().trim().split('\r\n');


function solution(str){
    let str1 =''
    let stack =[]
    for(let x of str){
        if(x==='>'){
            for(let i=0;i<stack.length; i++){
                str1+=stack[i]
            }
            str1+=x

            while(stack.pop()!=="<");
        }else{

            if(x==='<'&& stack.length){
                str1+=stack.join('').split(' ').map(x=>x.split('').reverse().join('')).join(' ')
                stack=[]
            }
            stack.push(x)
        }
    }
    str1+= stack.join('').split(' ').map(x=>x.split('').reverse().join('')).join(' ')
    return str1
}

let str ='<int><max>7463847412<long long><max>7085774586302733229' 
console.log(solution(str))
// console.log(solution(input[0]))