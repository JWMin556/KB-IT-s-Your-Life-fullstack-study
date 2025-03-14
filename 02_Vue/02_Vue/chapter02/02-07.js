let arr = [10, 20, 30, 40];
// 4개 중 앞의 세 개의 값만 구조 분해 할당 가능.
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);

let p1 = { name: '홍길동', age: 20, gender: 'M' };
// :뒤에 원하는 이름으로 변경이 가능하다.
let { name: n, age: a, gender } = p1;
// 키값에 접근하면 value값이 나온다.
console.log(n, a, gender);
