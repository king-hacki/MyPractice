function foo(time, str, ?) {
    setTimeout(() => {
        callback(str + "work")
    })
}

foo(1000, "test", message => {console.log(message)})    //  testwork