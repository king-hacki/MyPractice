
process.nextTick(() => {
    console.log('1')
  })
  Promise.resolve()
    .then(() => {
      console.log('2')
    })
  setImmediate(() => {
    console.log('3')
  })

//    error what is process
//    Both process.nextTick and promise.then belong to microtask, 
//    while setImmediate belongs to macrotask, 
//    which is executed during the check phase of the event loop. 
//    A microtask is executed between each phase of the event loop (macrotask),
//    and the beginning of the event loop is executed once.