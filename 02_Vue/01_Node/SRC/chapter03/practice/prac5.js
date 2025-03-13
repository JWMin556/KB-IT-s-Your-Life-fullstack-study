const exercises = async () => {
  try {
    const runStretching = await new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('스트레칭 완료');
      }, 1000);
    });
    const runTreadmill = await new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('러닝머신 완료');
      }, 500);
    });
    const runProtein = await new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('단백질 보충 완료');
      }, 500);
    });
    console.log(runStretching);
    console.log(runTreadmill);
    console.log(runProtein);
    console.log('운동 기록 처리 종료');
  } catch (err) {
    console.log(err);
  }
};

console.log('운동 기록 처리 시작');
exercises();
