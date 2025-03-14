let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  // add의 this를 inner의 this에 지정하는 것이다.
  inner = inner.bind(this); //bind를 넣어주면 영구적으로 this값이 지정된다.
  inner();
};

obj.add(3, 4);

console.log(obj);
