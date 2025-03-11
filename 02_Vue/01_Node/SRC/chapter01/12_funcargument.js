var add = function (a, b) {
  return a + b;
};
var multi = function (a, b) {
  return a * b;
};

// 함수를 매개변수로 넘겨주며, 이것이 함수적 프로그래밍이다.
// 헤당되는 함수가 호출됨
function calc(a, b, f) {
  return f(a, b);
}

console.log('2 + 3 = ' + calc(2, 3, add));
console.log('2 * 3 = ' + calc(2, 3, multi));
