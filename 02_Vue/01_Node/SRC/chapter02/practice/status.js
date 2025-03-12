export let orderStatus = {
  samgyeopsal: '주문 대기',
  galbi: '주문 대기',
};

export const updateStatus = async (menu, status) => {
  try {
    const start = await new Promise((resolve, reject) => {
      setTimeout(() => {
        orderStatus[menu] = status;
        resolve(`🔄 ${menu} 상태가 '${status}'로 변경되었습니다.`);
      }, 1000);
    });
    console.log(start);
  } catch (err) {
    console.error(err);
  }
};
