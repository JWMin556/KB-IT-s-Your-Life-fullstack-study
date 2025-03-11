var add = function (a, b) {
  return a + b;
};

// 변수처럼 함수도 전달이 가능함
var plus = add;
console.log('2 + 3 =', plus(2, 3));
