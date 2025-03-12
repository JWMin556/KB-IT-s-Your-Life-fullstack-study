let getTriangle = (base, height) => (base * height) / 2;
let getCircle = (radius) => radius * radius * Math.PI;

let getObject = (x) => ({
  // 이렇게 화살표함수로 object를 리턴시에는 함수의 본체로 {}가 인식되기에 함수본체부분을 ()로 한번 더 감싼다
  a: 5,
  b: 4,
});

console.log('삼각형의 면적:' + getTriangle(5, 2));
console.log('원의 면적:' + getCircle(5));
