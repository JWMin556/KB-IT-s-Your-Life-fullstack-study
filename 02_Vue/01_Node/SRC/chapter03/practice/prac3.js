const fs = require('fs');
const filePath = './practice/logs/members.txt';

if (fs.existsSync(filePath)) {
  const content = '\n이승기: 체중 68kg, 벤치프레스 80kg';
  fs.appendFile(filePath, content, (err) => {
    if (err) {
      console.log(err);
    }
    console.log('회원 정보가 성공적으로 추가되었습니다.');
  });
} else {
  console.log('회원 정보 파일이 없습니다.');
}
