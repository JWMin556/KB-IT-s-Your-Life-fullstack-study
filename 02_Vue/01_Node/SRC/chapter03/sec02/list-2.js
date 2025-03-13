const fs = require('fs');
// readdir: 현재 폴더에 있는 파일들 목록 보여주기 (비동기)
fs.readdir('./', (err, files) => {
  // 예외가 발생할 경우 출력해주고 리턴
  if (err) {
    console.error(err);
    return;
  }
  console.log(files);
});
