

const always = n => {
    const ret = n => n
    return ret(n)
}

///////////////

function a(n) {
    function r(n) {
        return n;
    }
    return r(n)
}

/////////////



const five = a(5)
console.log(five);
