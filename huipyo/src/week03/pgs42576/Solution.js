function solution(participant, completion) {
    let map = initMap(participant);

    for (let c of completion) {
        if (map.has(c)) {
            map.get(c).pop();
            if (map.get(c).length === 0) {
                map.delete(c);
            }
        }
    }
    return [...map.entries()].filter((k, v) => v.length != 0)[0][0];
}

function initMap(participant) {
    let map = new Map();

    participant.forEach(p => {
        if (map.has(p)) map.get(p).push(p);
        else map.set(p, [p]);
    });
    return map;
}