const fs = require('fs');
const filePath = './practice/logs/reservations.txt';

const reservation = async (name, type) => {
  if (fs.existsSync(filePath)) {
    try {
      console.log('예약 처리 중...');
      const data = fs.readFileSync(filePath, 'utf-8');

      if (data.includes(name)) {
        console.log(`${name} 회원님은 이미 예약되어 있습니다.`);
      } else {
        const content = `\n${name}: ${type}`;
        fs.appendFile(filePath, content, (err) => {
          if (err) {
            console.log(err);
          } else {
            console.log(`${name} 회원님의 ${type} 예약이 완료되었습니다!`);
            console.log('예약 기록이 파일에 저장되었습니다.');
          }
        });
      }
    } catch (err) {
      console.log(err);
    }
  } else {
    console.log('예약 기록 파일이 없습니다.');
  }
};

reservation('이승기', '스파링');
