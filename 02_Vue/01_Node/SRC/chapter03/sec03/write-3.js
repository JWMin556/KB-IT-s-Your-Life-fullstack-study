const fs = require('fs');
fs.readFile('./sec03/example.txt', 'utf8', (err, data) => {
  if (err) {
    console.log(err);
  }
  // 에러가 없다면 읽어온 data를 쓰는 것이다
  fs.writeFile('./sec03/text-2.txt', data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log('text-2.txt is saved!');
  });
});
