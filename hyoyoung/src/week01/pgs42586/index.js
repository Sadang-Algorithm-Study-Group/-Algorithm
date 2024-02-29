function solution(progresses, speeds) {
    var answer = [0]; //먼저 0을 안넣어주면 처음에 null값이 들어감
    let arr=progresses.map((val,idx)=>{return Math.ceil((100-val)/speeds[idx])})
    let x=arr[0]
    let count=1
    // 원소가 x보다 크면 x는 y 값이 된다. 그리고 그 전의 값을 넣어준다.
    // 원소가 x보다 작으면 count를 높여준다.
    // for(let i=1; i<arr.length; i++){
    //     if(arr[i]>x){
    //         x = Math.max(x,arr[i])
    //         answer.push(count)
    //         count=0
    //     }
    //     count++
    // }
    // answer.push(count)
    
    for(let i=0, j=0; i<arr.length; i++){
        if(arr[i]<=x){ //arr이 원소가 작거나 같다면
            answer[j] +=1;
        }else{//크다면
            answer[++j]=1;
            x= arr[i]
        }
    }
    return answer;
}