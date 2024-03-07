const input = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

input.question('', (n) => {
    const list = input.question('', (list) => {
        list = list.trim().split(' ');
        var array = new Array(parseInt(n));

        for (let i = 1; i < parseInt(n); i++) {
            array[i] = findHighNumber(i, list, array);
        }
        console.log(array.join(' '));
        input.close();
    });
});

function findHighNumber(index, list, array) {
    let position = index - 1;

    while (position >= 0 && parseInt(list[index]) > parseInt(list[position])) {
        position = array[position] - 1;
    }
    return position + 1;
}