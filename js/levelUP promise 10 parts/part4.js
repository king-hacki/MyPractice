
Promise
    .resolve(1)
    .then(res => {
        console.log(res);           //  1
    return 2;
    })
    .catch(err => {                 //  this catch never invoke because in .then 
        console.log(err)            //  wich above there is no error          
    return 3;
    })
    .then(res => {
        console.log(res);           //  2
        throw new Error('test')
    return 4    //  never invoke  
    })
    .catch(err => {
        console.log(err)            //  error test
    return 5;
    })
    .then(res => {
        console.log(res)            //  5
        return rewritePromises()
    })
   
console.log('just test')

// just test will be first because .then and .catch are asynchronus
// 1
// 2
// error test
// 5

//  Promises can be chained. When referring to chained calls, 
//  we usually think of returning this, but Promises do not.
//  Each time a promise calls .then or .catch, a new promise will be returned, 
//  thus implementing chained calls.

//  we can rewrite this

const returnSmthWithTime = number => {
    return new Promise ((res, rej) => {
        setTimeout(() => {
            console.log(number)
            res();
        }, number)
    }) 
}

const returnSmth = number => {
    console.log(number)
}

//  Async/Await is more readable and easier to understand than Promise. 
//  Await can be only use within Async. Await basically wait for promise to finish 
//  and then run the code. For error handling, use try/catch.

async function rewritePromises() {  
    await returnSmthWithTime(3000)
    await returnSmthWithTime(2000)  
    returnSmthWithTime(1000)
}

//  3000
//  2000
//  1000

//  without await 

//  1000
//  2000
//  3000

