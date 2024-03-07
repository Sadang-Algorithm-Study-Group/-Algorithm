// priorities를 순회하여 객체를 만들어준다.
//list의 첫번째 요소가 만약 거기서 제일 큰 수라면 빼고 
// 만약 이때 이 값의 cur이 location과 같게 되면 answer 리턴 
// 아니라면 answer의 값을 올린다.
//아니라면 list 배열에 다시 넣어준다.

// function solution(priorities, location) {
//     let pri = priorities
//     var answer = 0;
//    let arr= Array.from({length:priorities.length},(v,i)=>(String.fromCharCode(i+65)))
//    let queue=[]
//    let [str,loc] = [arr[location],pri[location]]
    
//     while(pri.length){
//         let big =Math.max(...pri)
//         if(pri[0]===loc && arr[0]===str && pri[0]===big) return answer+1
//         if(pri[0]===big){
//             answer++
//             pri.shift();
//             arr.shift();
//         }else{
//             pri.push(pri.shift())
//             arr.push(arr.shift())
//         }
//     }
//     return answer;
// }

function solution(priorities, location) {
    var answer = 0;
    let list = priorities.map((v,i)=>({
        my:i===location,
        val : v
    }))
    while(true){
        let cur = list.splice(0,1)[0];
        if(list.some(t=>cur.val<t.val)){
            list.push(cur)
        }else{
            answer++
            if(cur.my) break
        }
    }
    return answer;
}

