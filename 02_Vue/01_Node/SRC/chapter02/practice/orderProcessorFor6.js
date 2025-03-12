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
