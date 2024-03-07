const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
    let [n, m] = line.trim().split(' ').map(Number);

    rl.once('line', (queueLine) => {
        var queue = queueLine.trim().split(' ').map(Number);
        var deque = Array.from({ length: n }, (_, i) => i + 1);
        var count = 0;

        while (queue.length > 0) {
            let target = queue.shift();
            let start = deque.indexOf(target);
            let end = deque.length - start;

            while (deque.length > 0 && target !== deque[0]) {
                count++;
                if (start < end) deque.push(deque.shift());
                else deque.unshift(deque.pop());
            }
            deque.shift();
        }
        console.log(count);
        rl.close();
    });
});