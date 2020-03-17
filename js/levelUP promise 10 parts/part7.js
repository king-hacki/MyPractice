
Promise
    .resolve()
    .then(() => {
        // return new Error('error');      // don't call .catch it will call .then
        return Promise.reject(new Error('error'))   //  now we go on .catch
    })
    .then(res => {
        console.log('then: ', res);
    })
    .catch(err => {
        console.log('catch: ', err);
    });

// Returning an error object in .then or .catch does not throw an error, 
// so it will not be caught by subsequent .catch


//  Things like this happend because returning any not-promise value 
//  will wrapped into promise object that's why
//  return new Error (‘error’) is equivalent to return Promise.resolve (new Error (‘error’)).
