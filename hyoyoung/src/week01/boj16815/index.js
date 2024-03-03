
function solution(num){
    let count =0
    let stack =[]
    for(let x of num){
        if(x==='*') {
            count = stack.length;
            break
        }
        if(x==='('){
                stack.push(x)
        }else if(x===')'){
                stack.pop()
                count++
        }
    }
    return count
}

let str = '(()*()))'
console.log(solution(str))