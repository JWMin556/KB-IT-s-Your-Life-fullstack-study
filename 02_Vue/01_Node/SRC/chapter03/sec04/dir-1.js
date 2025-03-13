fs = require('fs');
if (fs.existsSync('./sec04/test')) {
  // 디렉터리가있다면
  console.log('folder already exists');
} else {
  // 디렉터리가없다면
  // mkdir: 해당 경로의 폴더를 비동기적으로 생성
  fs.mkdir('./sec04/test', (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('folder created');
  });
}
