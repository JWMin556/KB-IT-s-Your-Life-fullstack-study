const fs = require('fs');
const data = fs.readFileSync('./sec03/./example.txt', 'utf8');
// fs.writeFileSync 넣어준 내용으로 새로운 파일을 쓴다. 동기
fs.writeFileSync('./sec03/text-1.txt', data);
