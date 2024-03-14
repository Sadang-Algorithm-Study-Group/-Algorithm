const fs = require('fs');
const [ , ...numbers ] = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(num => BigInt(num));

console.log(
        numbers.reduce((countMap, num) => countMap.set(num, (countMap.get(num) || 0) + 1), new Map())
            .entries()
            .reduce((minKey, entry) => minKey[1] !== entry[1] ? (entry[1] - minKey[1] > 0 ? entry : minKey) : (minKey[0] - entry[0] > 0 ? entry : minKey), [0, 0])[0]
);

