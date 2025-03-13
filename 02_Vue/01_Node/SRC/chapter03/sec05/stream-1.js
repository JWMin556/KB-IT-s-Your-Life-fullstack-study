const fs = require('fs');

// createdReadStream: ReadStream 생성
const rs = fs.createReadStream('./sec05/example.txt');
rs.on('data', (chunk) => {
  console.log('new chunk received:');
  console.log('chunk의 길이', chunk.length);
  console.log('chunck의 내용: ', chunk); //당연히 2진수로 출력됨
})
  .on('end', () => {
    // end: 데이터 읽기가 완료되었을 때, 발생하는 이벤트
    console.log('finished reading data');
  })
  .on('error', (err) => {
    console.error(`Error reading the file: ${err.message}`);
  });
