const p1 = { name: 'john', age: 20 };
// p1 = { name: 'susan', age: 20 };  // 이러면 오류가 난다.
p1.name = 'susan';

// 참고로 타입에러가 발생하면 그 아래의 코드는 실행되지 않음
console.log(p1);
