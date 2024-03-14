function solution(clothes) {
    var answer = 1;
    let hash = new Map();
    for (let [x, y] of clothes) {
        if (hash.has(y)) {
            hash.set(y, hash.get(y) + 1);
        } else hash.set(y, 1);
    }
    for (let [x, y] of hash) {
        answer *= y + 1;
    }
    return answer - 1;
}
