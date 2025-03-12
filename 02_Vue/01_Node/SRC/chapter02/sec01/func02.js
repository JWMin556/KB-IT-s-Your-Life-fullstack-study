var getTriangle = function (base, height) {
  // 기명함수를 익명함수로 바꾼다.
  return (base * height) / 2;
};
console.log('삼각형의 면적:' + getTriangle(5, 2));
