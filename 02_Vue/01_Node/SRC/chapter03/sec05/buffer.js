const fs = require('fs');
fs.readFile('./sec05/example.txt', (err, data) => {
  if (err) return console.log(err);
  console.log(data); // 기본값은 이진 데이터 표시
  console.log('\n');
  console.log(data.toString()); // toString()을 사용해서 문자열로 변환
});
