let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  // 일반 함수이기 때문에 호출시 this가 결정
  // this => window
  inner();
};

obj.add(3, 4);

// obj객체는 변하지 않고 전역 객체가 변경된다.
console.log(obj); // { result: 0, add: [Function (anonymous)] } => 반영이 안됨
console.log(result);
