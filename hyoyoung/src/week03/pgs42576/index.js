function solution(participant, completion) {
    var answer = '';
    const hashfun = (arr) => {
        let hash = new Map();
        for (let x of arr) {
            if (hash.has(x)) {
                hash.set(x, hash.get(x) + 1);
            } else hash.set(x, 1);
        }
        return hash;
    };

    let hash1 = hashfun(participant);
    let hash2 = hashfun(completion);
    for (let [x, y] of hash1) {
        if (!hash2.has(x)) {
            answer = x;
        } else if (hash1.get(x) !== hash2.get(x)) {
            answer = x;
        }
    }
    return answer;
}
