
//  Promise executes synchronously, promise.then executes asynchronously

const prom = new Promise((res, rej) => {
  console.log('first');
  res();
  console.log('second');
});

prom.then(() => {
  console.log('third');
});

prom.then(() => {
  console.log("fifth")
})

console.log('fourth');
console.log('sixth');

// first
// second
// fourth
// sixth
// third
// fifth

//    ok let's try somethink like next

const prom2 = new Promise ((res, rej) => {
  console.log("prom2 : 1")
  res()
  console.log("prom2 : 2")
})
  .then (() => {
    console.log("prom2 : 3")
  }) 

console.log("prom2 : 4")

//  here above we hava the same shit like on the top

// because : Promise executes synchronously, promise.then executes asynchronously