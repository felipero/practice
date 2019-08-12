'use strict';

function vowelsAndConsonants(s) {
    let vowels = [];
    let consonants = [];
    for (let char of s) {
        if (["a", "e", "i", "o", "u"].includes(char)) {
            vowels.push(char);
            console.log(char);
        } else {
            consonants.push(char);
        }
    }
    for (let cons of consonants) {
        console.log(cons);
    }
}


function main() {
    const s = "javascriptloops";

    vowelsAndConsonants(s);
}

main();