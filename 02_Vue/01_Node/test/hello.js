const c = require('ansi-colors');

function hello(name) {
  console.log(c.green(name) + '님 안녕');
}

hello('민중원');
