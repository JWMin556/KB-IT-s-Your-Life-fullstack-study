fs = require('fs');
if (fs.existsSync('./sec04/test')) {
  // 삭제할 디렉토리가 있다면

  //rmdir: 빈 폴더가 해당 경로에 있다면 삭제(비동기)
  fs.rmdir('./sec04/test', (err) => {
    if (err) return console.error(err);
    console.log('folder deleted');
  });
} else {
  // 삭제할디렉토리가없다면
  console.log('folder does not exist');
}
