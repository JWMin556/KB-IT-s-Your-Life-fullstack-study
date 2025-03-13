const fs = require('fs');
const rs = fs.createReadStream('./sec05/example.txt', 'utf8');
const ws = fs.createWriteStream('./sec05/writeMe.txt');

// pipe를 이용하면 여러 개의 스트림을 이어서 처리할 수 있다.
rs.pipe(ws);
