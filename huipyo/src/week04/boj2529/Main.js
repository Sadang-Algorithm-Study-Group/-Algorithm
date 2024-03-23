const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function mapToString(array, func) {
    return array.map(func);
}

function isCorrect(list, inequalities) {
    for (let i = 1; i < list.length; i++) {
        if (isWrong(list[i - 1], list[i], inequalities[i - 1])) return false;
    }
    return true;
}

function isLessThan(inequality) {
    return inequality === "<";
}

function isWrong(first, second, inequality) {
    return isLessThan(inequality) ? first > second : first < second;
}

rl.on("line", (line) => {
    let k = parseInt(line);
    let stack = [];
    let sortedSet = new Set();

    rl.on("line", (line) => {
        let inequalities = line.split(" ");
        function run() {
            for (let i = 0; i < 10; i++) {
                if (stack.includes(i)) continue;
                stack.push(i);
                if (stack.length <= k) run();
                else if (isCorrect(stack, inequalities)) sortedSet.add(stack.join(""));
                stack.pop();
            }
        }

        run();
        const sortedArray = Array.from(sortedSet).sort();
        console.log(sortedArray[sortedArray.length - 1]);
        console.log(sortedArray[0]);
        rl.close();
    });
});
