//**카펫 */
function solution(brown, yellow) {
    let n = brown + yellow;
    let answer;
    let harf = parseInt(n / 2);
    for (let i = 1; i < harf; i++) {
        for (let j = 1; j < harf; j++) {
            if (i * j === n && i >= j) {
                if (!dfs(i, j)) continue;
                else return dfs(i, j);
            }
        }
    }
    function dfs(x, y) {
        let arr = Array.from({ length: y }, () => Array(x).fill(0));
        let count = 0;
        let bcount = 0;
        for (let i = 0; i < y; i++) {
            for (let j = 0; j < x; j++) {
                if (bcount > brown) return;
                if (i === 0 || j === 0 || i === y - 1 || j === x - 1) {
                    arr[i][j] = 'b';
                    bcount++;
                }
            }
        }

        for (let i = 0; i < y; i++) {
            for (let j = 0; j < x; j++) {
                if (count > yellow) return;
                if (arr[i][j] === 0) {
                    count++;
                }
            }
        }
        if (count === yellow) return [x, y];
        else return;
    }
    return answer;
}
