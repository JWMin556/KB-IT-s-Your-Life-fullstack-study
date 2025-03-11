function outer() {
  var outvalue = 5678;
  function inner() {
    var invalue = 1234;
    console.log('outvalue: ', outvalue); // 내부함수에서 외부함수의 변수 사용가능
  }
  inner();
  console.log('invalue: ', invalue); // 외부함수에서는 내부 함수의 변수 사용불가
}
