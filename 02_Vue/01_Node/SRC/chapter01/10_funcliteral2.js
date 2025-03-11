// 함수 선언식만 위로 호이스틱 된다.
console.log('2+3 = ', add1(2, 3));
console.log('2+3 = ', add2(4, 5)); //즉, 얘는 안됨

// 함수 선언식
function add1(a, b) {
  return a + b;
}

// 함수 표현식
var add2 = function (a, b) {
  return a + b;
};
