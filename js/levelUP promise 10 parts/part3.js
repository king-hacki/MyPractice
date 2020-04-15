
const prom = new Promise((res, rej) => {
    res('1');
    rej('error');
    res('2');
  })
    .then(res => {
        console.log('then: ', res);
        throw new Error('test error')
    })

    .catch(err => {
        console.log('catch: ', err);
    });

//  Output only 1, because rej('error') don't hit. After run res('1') it goes on .then
//  and don't go on catch. But if we put rej above res it will run .catch().
//  Okay, one more. If in .then thre is error .catch will be called (e.g. above)

// then:  1
// part3.js:13 catch:  Error: test error

//  The resolve or reject only execute once even there is a resolve call after the reject.  //  It won't execute.