const fs = require('fs');
const filePath = './practice/logs/workout_log.txt';

try {
  if (fs.existsSync(filePath)) {
    console.log('이미 존재한다');
  } else {
    fs.mkdirSync('./practice/logs', { recursive: true });
    const content =
      '김종국 - 벤치프레스 100kg, 스쿼트 150kg\n유재석 - 덤벨 컬 20kg, 플랭크 2분';
    fs.writeFileSync(filePath, content);
    console.log('파일 생성 완료!');
  }
} catch (err) {
  console.error(err);
}

fs.readFile(filePath, 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
  } else {
    console.log('운동 기록 출력 완료!');
    console.log(data);
  }
});
