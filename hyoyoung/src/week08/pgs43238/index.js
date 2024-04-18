//**입국심사 */

function solution(n, times) {
    var answer = 0;
    let arr = Array.from({ length: times.length }, () => 0);
    for (let i = 0; i < arr.length; i++) {
        if (n >= times.length) {
            arr[i] = times[i];
            n--;
        }
    }
    answer++;
    while (n) {
        for (let i = 0; i < arr.length; i++) {
            arr[i]--;
            if (arr[i] === 0) {
                if (n === 1) {
                    let min = times[i];
                    for (let j = 0; j < arr.length; j++) {
                        if (times[j] - arr[j] < min) {
                            answer += times[j];
                            break;
                        }
                    }
                }
                n--;
                arr[i] = times[i];
            }
        }
        answer++;
    }
    return answer;
}
