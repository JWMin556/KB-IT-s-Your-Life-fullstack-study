// 일반 함수 버젼
const test1 = function (a, b) {
  return a + b;
};

// 화살표 함수 버젼
const test2 = (a, b) => {
  return a + b;
};

// 화살표 함수 리턴 생략 버젼
// 구현부가 한줄짜리 간단한 코드일 경우만 가능
const test3 = (a, b) => a + b;

console.log(test1(3, 4));
console.log(test2(3, 4));
console.log(test3(3, 4));
