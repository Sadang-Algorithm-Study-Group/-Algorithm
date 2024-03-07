function solution(priorities, location) {
    var queue = priorities.map((priority, index) => ({index, priority}));
    var answer = 1;

    while (queue.length > 0) {
        let current = queue.shift();

        if (isContainsHigherPriority(queue, current.priority)) queue.push(current);
        else if (current.index === location) break;
        else answer++;
    }
    return answer;
}

function isContainsHigherPriority(queue, currentPriority) {
    for (let i = 0; i < queue.length; i++) {
        if (queue[i].priority > currentPriority) {
            return true;
        }
    }
    return false;
}