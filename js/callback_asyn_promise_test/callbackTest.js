/*
    перевод статьи Макса Одена — «Callback Hell».
    http://callbackhell.ru/

    Medium : https://medium.com/javascript-in-plain-english/google-javascript-technical-interview-question-callback-promise-await-async-74b8dda2e331
    Medium : https://medium.com/@stacycho/callback-promise-and-async-await-d9ac7ea2450a
*/


function printString(string, callback) {
    setTimeout(
      () => {
        console.log(string)
        callback()
      },
      1 * 1000 // 1s
     )
  }

  function printAll() {
    printString("A", () => {
      printString("B", () => {
        printString("C", () => {})
      })
    })
}
  

const printStringPromise = string => {
    return new Promise((resolve, reject) => {
        setTimeout (() => {
            console.log(string)
            resolve()
        }, 1000)
    })
} 
    
const testPromise = () => {
    printStringPromise("A")
        .then(() => {
            return printStringPromise("B")
        })
        .then(() => {
            return printStringPromise("C")
        })
}

async function testAsync(){
    await printStringPromise("A")
    await printStringPromise("B")
    await printStringPromise("C")
}

testPromise()
testAsync()
printAll()




