fs = require('fs');
if (fs.existsSync('./sec04/test2/test3/test4')) {
  console.log('folder already exists');
} else {
  // recursive 옵션을 토앻 중간 경로의 폴더까지 생성 가능
  fs.mkdir('./sec04/test2/test3/test4', { recursive: true }, (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('folder created');
  });
}
