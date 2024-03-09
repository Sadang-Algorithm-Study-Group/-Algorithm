const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
    let n = parseInt(line);
    var deque = [];
    var list = [];

    for (let i = 0; i < n; i++) {
        deque.push([parseInt(line), i + 1]);
    }

    function biConsumer(integer, runnable) {
        for (let i = 0; i < integer; i++) {
            runnable();
        }
    };

    while (deque.length > 0) {
        let outed = deque.shift();

        list.push(String(outed[1]));
        if (deque.length === 0) break;
        if (outed[0] > 0) {
            biConsumer(outed[0] - 1, () => deque.push(deque.shift()));
        } else {
            biConsumer(-outed[0], () => deque.unshift(deque.pop()));
        }
    }
    console.log(list.join(' '));
    rl.close();
});