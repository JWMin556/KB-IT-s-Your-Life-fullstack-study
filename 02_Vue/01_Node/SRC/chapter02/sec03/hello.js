const hello = (name) => {
  console.log(`${name}님, 안녕하세요?`);
};
module.exports = hello; // commmonJS 내보내기

//혹은 아래처럼 해도 된다. 그러면 함수선언과 동시에 내보낼 수 있음
// exports.hello = (name) => {
//   console.log(`${name}님, 안녕하세요?`);
// };
