let obj = { result: 0 };

obj.add = function (x, y) {
  this.result = x + y;
};

let add2 = obj.add;

console.log(add2 === obj.add); //true, 동일한 함수

add2(3, 4); //전역변수 result에 7이 할당됨. 불러준 객체가 없기에 최상위 레벨인 윈도우가 들어간다.
console.log(obj); // { result: 0 }
console.log(result); //7이 자동으로 생성됨 즉, window.result가 7이 되어버리는 것이다. 물론 node에서는 global.result
