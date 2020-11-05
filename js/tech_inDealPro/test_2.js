function foo(a) {
    ? function (b) {
        ? function (c) {
            ? a * b * c
        }
    }
}

console.log(foo(5)(2)(7))   //  70
