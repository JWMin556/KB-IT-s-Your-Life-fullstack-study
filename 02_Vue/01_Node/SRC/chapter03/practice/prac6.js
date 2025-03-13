const fs = require('fs');
const filePath = './practice/logs/checkin.txt';

const attending = async (member) => {
  try {
    console.log('출석 중...');
    const data = fs.readFileSync(filePath, 'utf8');
    if (data.includes(member)) {
      console.log(`${member} 회원님은 이미 출석하셨습니다!`);
    } else {
      const attendStart = await new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve(`${member}: 출석 완료 (2025-03-14 10:30)`);
        }, 1000);
      });
      console.log(attendStart);

      if (fs.existsSync(filePath)) {
        const content = `\n${member}: 출석 완료 (2025-03-14 10:30)`;
        fs.appendFile(filePath, content, (err) => {
          if (err) {
            console.log(err);
          }
          console.log('출석 기록이 파일에 저장되었습니다!');
        });
      } else {
        console.log('출석 기록 파일이 없습니다!');
      }
    }
  } catch (err) {
    console.log(err);
  }
};

attending('이승기');
