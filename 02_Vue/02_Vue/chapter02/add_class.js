// ES6부터 클래스 개념이 도입되었다. 그러나 이 내부는 사실 프로토타입 기반 함수로 이루어져 있다.
class User {
  constructor(first, last) {
    // 이 안에 클래스 내부의 변수들이 생성된다.
    this.firstName = first;
    this.lastName = last;
  }

  getFullName() {
    return `${this.firstName} ${this.lastName}`;
  }
}

const jw = new User('joungwon', 'min');
