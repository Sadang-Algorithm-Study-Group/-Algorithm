function solution(clothes) {
    let dictionary = initDictionary(clothes);
    let bodyParts = Object.keys(dictionary);
    var set = new Set();
    var answer = 0;
    function combination(start) {
        for (let i = start; i < bodyParts.length; i++) {
            let bodyPart = bodyParts[i];

            if (set.has(bodyPart)) continue;
            set.add(bodyPart);
            answer += Array.from(set).reduce((acc, part) => acc * dictionary[part].length, 1);
            if (set.size < bodyParts.length) combination(i);
            set.delete(bodyPart);
        }
    }

    combination(0);
    return answer;
}

function initDictionary(clothes) {
    const dictionary = {};

    for (let cloth of clothes) {
        let [item, category] = cloth;

        if (!dictionary[category]) {
            dictionary[category] = [];
        }
        dictionary[category].push(item);
    }
    return dictionary;
}