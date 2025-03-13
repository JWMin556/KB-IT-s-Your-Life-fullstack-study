const fs = require('fs');
if (!fs.existsSync('./sec03/text-2.txt')) {
  // 파일이없다면
  console.log('file does not exist');
} else {
  // 파일이있다면
  fs.unlink('./sec03/text-2.txt', (err) => {
    if (err) {
      return console.error(err);
    }
    console.log('file deleted');
  });
}
