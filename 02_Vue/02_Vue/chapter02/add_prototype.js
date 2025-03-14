// const yura = {
//   firstName: 'yura',
//   lastName: 'choi',
//   getFullName: function () {
//     return `${this.firstName} ${this.lastName}`;
//   },
// };

// // 일반함수에서 this는 호출한 객체가 된다. yura라는 객체에서 호출했기에...
// console.log(yura.getFullName());

//생성자 함수
function User(first, last) {
  this.firstName = first;
  this.lastName = last;
}

// 이렇게 프로토타입이라는 것으로 해당 함수를 참조하는 얘들은 모두 쓸 수 있게 한다.
User.prototype.getFullName = function () {
  return `${this.firstName} ${this.lastName}`;
};
// 다른 js의 주요 문법인 배열, 객체 등등 모두 이런 식으로 이루어져 있다.
// 즉, 프로토타입에 추가된 함수는 객체 전체가 공유한다.

const jw = new User('joungwon', 'min');
console.log(jw.getFullName());
