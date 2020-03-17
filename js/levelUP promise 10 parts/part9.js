
Promise
    .resolve()
    .then(
        function success(res) {
            throw new Error('Error after success');
        },
        function fail1(e) {
            console.error('fail1: ', e);
        }
    )
    .catch(function fail2(e) {
        console.error('fail2: ', e);
    });

//  .then can accept two parameters, the first is a function that handles success, 
//  and the second is a function that handles errors. .catch is a convenient way 
//  to write the second parameter of .then, but there is one thing to pay attention 
//  to in usage: .then the second error-handling function cannot catch the error 
//  thrown by the first successful function and subsequent ones 
//  .catch catches previous errors.