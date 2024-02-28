const readline = require("readline");
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("s", (s) => {
    var stack = [];

    for (let c of s) {
        switch (c) {
            case '(':
                stack.push(c);
                break;
            case ')':
                if (stack.length > 0 && stack[stack.length - 1] === '(') stack.pop();
                else stack.push(c);
                break;
            case '*':
                console.log(stack.length);
                break;
        }
    }
    rl.close();
});