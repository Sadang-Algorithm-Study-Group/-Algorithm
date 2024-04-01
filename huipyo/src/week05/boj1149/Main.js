const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function readLine() {
    return new Promise(resolve => {
        rl.question('', input => {
            resolve(input);
        });
    });
}

(async function () {
    const readln = await readLine();
    const count = parseInt(readln);
    const result = Array.from({ length: count }, () => [0, 0, 0]).reduce((acc, _) => {
        const input = readLine();
        const values = input ? input.split(' ').map(Number) : null;
        return values ? values.map((element, offset) => {
            switch (offset) {
                case 0:
                    return Math.min(acc[1], acc[2]) + element;
                case 1:
                    return Math.min(acc[0], acc[2]) + element;
                case 2:
                    return Math.min(acc[0], acc[1]) + element;
                default:
                    return 0;
            }
        }) : acc;
    }, [0, 0, 0]).reduce((min, curr) => Math.min(min, curr));

    console.log(result);
    rl.close();
})();
