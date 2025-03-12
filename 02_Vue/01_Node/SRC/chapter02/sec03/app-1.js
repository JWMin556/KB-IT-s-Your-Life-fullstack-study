const user = require('./user'); // commonJS에서 받아오는 방식이다
const hello = require('./hello');

console.log(user);
console.log(hello);
hello(user);
