fs = require('fs');
fs.rm('./sec04/test2', { recursive: true }, (err) => {
  // recursive를 true로 설정함을 통해 폴더안에 있는 다른 폴더 및 파일까지 싹다 지울 수 있다.
  if (err) return console.error(err);
  console.log('folder deleted');
});
