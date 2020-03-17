
const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log('first')
      resolve('second')
    }, 1000)
  })
  
const start = Date.now()

promise.then((res) => {
    console.log(res, Date.now() - start, "third")
})

promise.then((res) => {
    console.log(res, Date.now() - start, "fourth")
})
  
  // first
  // second 1054 third
  // second 1054 fourth

//  Here we see that first .then and second execute in one time after resolve() in promise 

// A promise .then or .catch can be called multiple times,
// but here the Promise constructor is executed only once. 
// In other words, once the internal state of a promise changes 
// and a value is obtained, each subsequent call to .then or .catch 
// will directly get the value.