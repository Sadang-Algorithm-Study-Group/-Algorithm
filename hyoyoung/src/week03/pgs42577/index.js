function solution(phone_book) {
    var answer = true;
    let hash = {};
    for (let number of phone_book) {
        hash[number] = true;
    }
    for (let number of phone_book) {
        for (let i = 1; i < number.length; i++) {
            let str = number.substring(0, i);

            if (hash[str]) return false;
        }
    }
    return true;
}
