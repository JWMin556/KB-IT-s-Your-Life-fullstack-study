function displayA() {
  console.log('A');
}
function displayB() {
  // 2초 후에 B를 출력하라
  setTimeout(() => {
    console.log('B');
  }, 2000);
}
function displayC() {
  console.log('C');
}
displayA();
displayB();
displayC();
