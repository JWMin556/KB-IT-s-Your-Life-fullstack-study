export const grillMeat = (meat) => {
  const grillTime = new Promise((resolve) => {
    setTimeout(() => {
      resolve(`🔥 ${meat}가 다 구워졌습니다`);
    }, 2000);
  });
  grillTime
    .then((result) => {
      console.log(result);
      console.log('🍽️ 식사 시작!');
    })
    .catch((err) => console.log(err));
};
