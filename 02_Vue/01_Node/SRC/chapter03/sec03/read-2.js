const fs = require('fs');
const data = fs.readFileSync('./sec03/example.txt', 'utf-8'); // 인코딩 옵션으로 utf-8 형식으로 지정
console.log(data);
