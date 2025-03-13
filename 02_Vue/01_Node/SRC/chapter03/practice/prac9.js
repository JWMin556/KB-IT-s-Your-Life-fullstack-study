const fs = require('fs');
const filePath = './practice/logs/memberRoutine.txt';

const upperRoute = ['벤치프레스 3세트', '어깨프레스 3세트', '팔굽혀펴기 50개'];
const downRoute = ['스쿼트 5세트', '런지 3세트', '레그프레스 4세트'];

const recommendExercise = (where) => {
  if (where === '상체') {
    const randomIndex = Math.floor(Math.random() * upperRoute.length);
    return upperRoute[randomIndex];
  } else if (where === '하체') {
    const randomIndex = Math.floor(Math.random() * downRoute.length);
    return downRoute[randomIndex];
  }
};

const recommend = async () => {
  if (fs.existsSync(filePath)) {
    try {
    } catch (err) {
      console.log(err);
    }
  } else {
    console.log('회원 루틴 파일이 없습니다!');
  }
};
