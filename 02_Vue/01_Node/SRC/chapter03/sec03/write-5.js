fs = require('fs');
// appendFile은 비동기로 기존파일 내용에 새로운 내용 추가
// flag옵션을 a준 것과 동일
fs.appendFile('./sec03/text-2.txt', '\n\n 새로운 내용 추가', (err) => {
  if (err) {
    console.log(err);
  }
  console.log('appending to file');
});
