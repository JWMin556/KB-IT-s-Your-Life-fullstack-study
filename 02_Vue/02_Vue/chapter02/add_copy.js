import _ from 'lodash';

const teacher = {
  name: 'yura',
  age: 20,
  emails: ['test@test.com'],
};

// const copyTeacher = teacher; // 주소값이 복사돼서 같이 변경됨

// 방법1: Object.assign을 이용해서 target 객체에 출처 객체를 복사할 수 있다.
// const copyTeacher = Object.assign({}, teacher);

//방법2: 전개 연산자를 이용해서 객체 생성
// const copyTeacher = { ...teacher };

//방법3: 깊은 복사까지 하기 위한 lodash 사용법
const copyTeacher = _.cloneDeep(teacher);

console.log(copyTeacher === teacher);

teacher.age = 21;
console.log(teacher);
console.log(copyTeacher);

teacher.emails.push('test2@gidjfi.com');
console.log(teacher.emails === copyTeacher.emails); //보면, teacher에만 추가했으나 copyTeacher에도 추가됨. 즉, 참조형 데이터까지 값을 복사해주진 못한다. -> 한계 발생
console.log(teacher);
console.log(copyTeacher);
