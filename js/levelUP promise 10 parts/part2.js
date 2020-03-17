
const prom = new Promise((res, rej) => {
    setTimeout(() => {
        res("success")
    }, 1000)
})

const prom2 = prom.then(() => {
    // rej("error")     compile error
    throw new Error("error")
});

console.log('prom', prom);  
console.log('prom2', prom2);  


setTimeout(() => {
    console.log("prom", prom);
    console.log("prom2", prom2);
}, 2000)

// promise has three different states:
// 1) pending
// 2) fulfilled
// 3) rejected
// Once the status updated, pending->fulfilled or pending->rejected,
// it can be changed again. The prom1 is different from prom2 and both of them 
// return new Promise status.