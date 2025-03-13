const fs = require('fs').promises;

const processFile = async () => {
  try {
    // 1. 파일 생성
    await fs.writeFile('./sec03/example.txt', 'hello, node.js');
    console.log('파일이 생성됨');

    // 2. 파일 읽기
    const data = await fs.readFile('./sec03/example.txt', 'utf-8');
    console.log('파일 내용: ', data);

    // 3. 파일에 내용 추가
    await fs.appendFile('./sec03/example.txt', '\n추가된 내용');
    console.log('파일에 내용 추가');

    //4. 파일 삭제
    await fs.unlink('./sec03/example.txt');
    console.log('파일이 삭제됨');
  } catch (error) {
    console.log(error);
  }
};

processFile();
