// ES모듈 시스템의 내보내기 방식이다 (export default버젼)
// 기본 내보내기 방식은 파일당 하나만 가능
const goodbye = (name) => {
  console.log(`${name}님 잘가`);
};

export default goodbye;
