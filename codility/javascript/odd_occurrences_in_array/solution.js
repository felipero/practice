// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(A) {
        // write your code in JavaScript (Node.js 8.9.4)
        const counts = {};

        for (const num of A) {
                counts[num] = (counts[num] || 0) + 1;
        }

        const oddElem = Object.entries(counts).find(elem => elem[1] % 2 != 0);

        return Number.parseInt(oddElem);
}
