const fs = require('fs');
if (!fs.existsSync('./sec03/text-1.txt')) {
  // 파일이 없다면
  console.log('file does not exist');
} else {
  // 파일이 있다면
  fs.unlinkSync('./sec03/text-1.txt');
  console.log('file deleted');
}
