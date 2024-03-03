function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    let bridge=Array.from({length:bridge_length},()=>0)
    let bridge_weight=0;

    bridge.shift();
    bridge_weight+=truck_weights[0]

    answer++
    bridge.push(truck_weights.shift())
    
    while(bridge_weight){
        answer++
        bridge_weight -= bridge.shift()
        // 도로에 트럭을 추가해도 되고 트럭이 남아있을때
        if(bridge_weight+truck_weights[0]<=weight ){
            bridge_weight+=truck_weights[0];
            bridge.push(truck_weights.shift())
        }else bridge.push(0)
    }
    return answer;
}


// console.log(solution(100,100,[10]))
console.log(solution(100,100,[10,10,10,10,10,10,10,10,10,10]))
// console.log(solution(2,10,[7,4,5,6]))


