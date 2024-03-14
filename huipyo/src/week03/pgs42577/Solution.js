function solution(phoneBook) {
    return phoneBook.sort()
        .flatMap(a => phoneBook.filter(b => a != b && b.startsWith(a)))
        .length == 0;
}