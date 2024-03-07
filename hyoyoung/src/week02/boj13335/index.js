// pgs42583과 같은 문제 다시 풀어보기~

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
let input = fs.readFileSync(filePath).toString().trim().split('\r\n');

let [N,M,S] = input.shift().split(' ').map(Number) 
input = input.shift().split(' ').map(Number) 

// 메모리 : 9620KB 시간:176ms
function solution(N,M,S,input){
    let bridge = Array.from({length:M},()=>0)
    let time =0; 
    let bridge_weight = 0;
    bridge_weight+=input[0];
    bridge.shift()
    bridge.push(input.shift())
    time+=1
    while(bridge_weight){
        console.log(bridge,time,bridge_weight)
        time +=1;

        bridge_weight-=bridge.shift();

        if(bridge_weight+input[0]<=S){
            bridge_weight+=input[0];
            bridge.push(input.shift())
        }else bridge.push(0)
    }
    console.log(time)
}

 solution(N,M,S,input) 