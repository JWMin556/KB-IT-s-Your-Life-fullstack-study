function outer() {
  var value = 1234;
}
outer();
console.log('value = ' + value);
// 함수 내부에 있는 value는 함수 안에서만 사용할 수 있다
