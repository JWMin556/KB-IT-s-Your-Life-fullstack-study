const order = (coffee, callback) => {
  console.log(`${coffee} 주문접수`);
  setTimeout(() => {
    // display함수 호출하는 타이밍에 아메리카노를 같이 넘겨줌
    callback(coffee);
  }, 3000);
};
const display = (result) => {
  console.log(`${result} 완료!`);
};
order('아메리카노', display);
