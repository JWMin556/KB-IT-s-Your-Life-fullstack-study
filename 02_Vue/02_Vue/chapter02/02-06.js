function foodReport(name, age, ...favoriteFoods) {
  console.log(name + ', ' + age);
  console.log(favoriteFoods);
}

// 지정된 매개변수 이외의 값들을 배열로 넘겨준다.
foodReport('이몽룡', 20, '짜장면', '냉면', '불고기');
foodReport('홍길동', 16, '초밥');
