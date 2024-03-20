function solution(numbers) {
    var stack = [];
    let primeNumbers = new Set();
    let numberList = numbers.split("");
    function getNumbers() {
        for (let i = 0; i < numberList.length; i++) {
            stack.push(i);
            if (stack.length !== 0) {
                let n = parseInt([...new Set(stack)].map(index => numberList[index]).join(""));
                if (isPrimeNumber(n)) primeNumbers.add(n);
                if (stack.length - 1 < numberList.length - 1) getNumbers();
            }
            stack.pop();
        }
    }

    getNumbers();
    return primeNumbers.size;
}

function isPrimeNumber(n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 === 0 || n % 3 === 0) return false;
    let i = 5;

    while (i * i <= n) {
        if (n % i === 0 || n % (i + 2) === 0) return false;
        i += 6;
    }
    return true;
}
