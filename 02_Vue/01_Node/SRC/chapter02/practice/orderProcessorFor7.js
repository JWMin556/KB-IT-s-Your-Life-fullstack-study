export const calculateTotal = (arr) => {
  let object = {};
  for (let i = 0; i < arr.length; i++) {
    if (object[arr[i].menu] === undefined) {
      object[arr[i].menu] = arr[i].quantity;
    } else {
      object[arr[i].menu] += arr[i].quantity;
    }
  }
  return object;
};

export const isTopMenu = (arr, menu) => {
  let sorted = Object.entries(arr).sort((a, b) => b[1] - a[1]);
  let sortedMenu = [];
  for (let element of sorted) {
    sortedMenu.push(element[0]);
  }
  return sortedMenu[0] === menu ? true : false;
};

export const processOrder = async (order) => {
  for (let [key, value] of Object.entries(order)) {
    try {
      const startOrder = await new Promise((resolve, reject) => {
        if (value >= 3) {
          setTimeout(() => {
            resolve(`✅  ${key} ${value}인분 주문 완료!`);
          }, 1000);
        } else {
          reject(`❌ ${key} ${value}인분은 주문 최소 수량 미달입니다.`);
        }
      });
      console.log(startOrder);
    } catch (err) {
      console.error(err);
    }
  }
};
