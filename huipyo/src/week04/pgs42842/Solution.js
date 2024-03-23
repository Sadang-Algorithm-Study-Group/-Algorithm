function solution(brown, yellow) {
    var answer = [0, 0];
    var total = brown + yellow;

    for (let width = 3; width < (total / 2); width++) {
        for (let height = 3; height < (total / 2); height++) {
            if (width * height == total && width >= height && yellow == (width - 2) * (height - 2)) {
                answer[0] = width;
                answer[1] = height;
                return answer;
            }
        }
    }
    return answer;
}