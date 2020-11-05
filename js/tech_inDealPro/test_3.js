function revBySep(str, sep) {
    return str.split(sep).?().join(sep)
}

let str = "I want to become a JavaScript Ninja!"

console.log(revBySep(str, ""))  //  !ajniN tpircSavaJ a emoceb ot tnaw I
console.log(revBySep(str, " ")) //  Ninja! JavaScript a become to want I