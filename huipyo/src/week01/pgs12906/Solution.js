function solution(arr) {
    let filterArray = array => {
        var list = [array[0]];

        for (let i = 1; i < array.length; i++) {
            if (list[list.length - 1] != array[i])
                list.push(array[i]);
        }
        return list;
    };
    return arr.length === 0 ? arr : filterArray(arr);
}