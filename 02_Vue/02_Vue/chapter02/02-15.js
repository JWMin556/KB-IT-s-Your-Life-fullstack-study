let obj = { result: 0 };

obj.add = function (x, y) {
  // 화살표 함수는 함수가 선언될 때 this가 정의된다.
  //   add 함수 내에 있으므로 this는 그대로 obj가 된다
  const inner = () => {
    this.result = x + y;
  };
  inner();
};

obj.add(3, 4);

console.log(obj);

// 중요한 것은 일반함수는 호출시, 화살표함수는 선언시 this가 정해진다는 것이다.
