const p1 = { name: 'min0', age: 20 };
// 객체는 참조형 변수이기에 참조형 변수의 const는 내부 필드의 value는 변경이 가능하다.
p1.age = 30;
console.log(p1);

p1 = { name: 'nami', age: 21 }; // 객체 자체를 변경 시 타입 에러가 난다.
