const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on("n", (n) => {
    let answer = 0;

    for (let i = 0; i < parseInt(n); i++) {
        rl.question('', (s) => {
            var stack = [];

            for (let ch of s) {
                if (stack.length !== 0 && stack[stack.length - 1] === ch) stack.pop();
                else stack.push(ch);
            }
            if (stack.length === 0) answer++;
            console.log(answer);
            rl.close();
        }
        });
    }
});