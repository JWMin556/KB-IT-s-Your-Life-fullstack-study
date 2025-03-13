const fs = require('fs');
const path = require('path');
const filePath = './members/kim_jong_kook.txt';

// if (fs.existsSync(filePath)) {
//   console.log('이미 존재한다');
// } else {
//   fs.mkdirSync('./members', { recursive: true }, (err) => {
//     if (err) {
//       return console.error(err);
//     } else {
//       const contest = '김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg';
//       fs.writeFile(filePath, contest, (err) => {
//         if (err) {
//           console.error(err);
//         } else {
//           console.log('파일 생성 완료!');
//         }
//       });
//     }
//   });
// }

try {
  // 파일이 존재하는지 확인
  if (fs.existsSync(filePath)) {
    console.log('이미 존재한다');
  } else {
    // 디렉토리 생성 (동기)
    fs.mkdirSync('./members', { recursive: true });

    const content = '김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg';

    // 파일 작성 (동기)
    fs.writeFileSync(filePath, content);

    console.log('파일 생성 완료!');
  }
} catch (err) {
  console.error(err);
}

const fn = path.basename(filePath);
const dir = path.dirname(filePath);
const absolutePath = path.resolve(filePath);

// console.log(`파일 이름: ${fn}`);
// console.log(`파일 경로: ${dir}`);
// console.log(`절대 경로: ${absolutePath}`);

const parsedPath = path.parse(absolutePath);
const lastDir = path.basename(parsedPath.dir);
// console.log(parsedPath);

console.log(`디렉터리 경로: ${lastDir}`);
console.log(`파일 이름: ${parsedPath.base}`);
console.log(`파일 확장자: ${parsedPath.ext}`);
console.log(`파일 이름(확장자 제외): ${parsedPath.name}`);
