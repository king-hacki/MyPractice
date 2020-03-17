

const promise = Promise.resolve()
    .then(() => {
        return promise
    })

promise
    .catch(console.error)


//  TypeError: Chaining cycle detected for promise #<Promise>
//  Promise.catch (async)

// The value returned by .then or .catch cannot be the promise itself, 
// otherwise, it will cause an infinite loop.