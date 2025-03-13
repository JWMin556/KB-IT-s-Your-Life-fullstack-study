const fs = require('fs');
const filePath = './practice/logs/diet.txt';

const diet = async (name, cal) => {
  if (fs.existsSync(filePath)) {
    try {
      console.log(
        `식단 기록 중... (오늘도 건강한 한 끼!)\n${name} 회원님, 오늘도 건강한 한 끼 감사합니다!`
      );

      const recordDiet = await new Promise((resolve) => {
        if (cal >= 500) {
          setTimeout(() => {
            const content = `\n${name}: ${cal}kcal, 조금 과했어요! 내일은 가볍게 가볼까요?\n${name}회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!`;
            fs.appendFile(filePath, content, (err) => {
              if (err) {
                console.log(err);
              }
              resolve(
                `${name} 회원님, 오늘 뭐 드셨어요? 칼로리 폭탄인가요?!\n식단 기록이 맛있게 저장되었습니다!`
              );
            });
          }, 1000);
        } else {
          setTimeout(() => {
            const content = `\n${name}: ${cal}kcal, 괜찮아요 아직 여유 있어요!`;
            fs.appendFile(filePath, content, (err) => {
              if (err) {
                console.log(err);
              }
              resolve(`식단 기록이 맛있게 저장되었습니다!`);
            });
          }, 1000);
        }
      });
      console.log(recordDiet);
    } catch (err) {
      console.log(err);
    }
  } else {
    console.log('식단 기록 파일이 어디로 갔죠?!');
  }
};

diet('이승기', 1000);
