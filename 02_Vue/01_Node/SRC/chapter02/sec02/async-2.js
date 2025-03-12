function displayA() {
  console.log('A');
}
function displayB(callback) {
  setTimeout(() => {
    console.log('B');
    // 받아온 콜백함수를 언제 실행해줄지 결정, 비동기
    callback();
  }, 2000);
}
function displayC() {
  console.log('C');
}
displayA();
displayB(displayC);
