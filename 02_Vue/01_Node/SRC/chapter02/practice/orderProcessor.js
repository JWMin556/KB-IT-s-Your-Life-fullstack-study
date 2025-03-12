// export const processOrder = (object) => {
//   for (let key in object) {
//     const grillTime = new Promise((resolve, reject) => {
//       setTimeout(() => {
//         resolve(`✅ ${key} ${object[key]} 주문 처리 완료!`);
//       }, 1000);
//     });

//     grillTime
//       .then((result) => {
//         console.log(result);
//       })
//       .catch((err) => {
//         console.error(err);
//       });
//   }
// };

export const processOrder = async (object) => {
  for (let key in object) {
    try {
      const grillTime = await new Promise((resolve, reject) => {
        setTimeout(() => {
          resolve(`✅ ${key} ${object[key]} 주문 처리 완료!`);
        }, 1000);
      });
      console.log(grillTime);
    } catch (error) {
      console.error(error);
    }
  }
  console.log('🍽️ 모든 주문 처리 완료! 식사 시작!');
};
