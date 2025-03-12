// 여러 개 묶어서 내보내기

const hi = (name) => {
  console.log(`${name}아 반갑다`);
};

const goodbye = (name) => {
  console.log(`${name}아 잘가`);
};

// 여러개를 내보낼 때는 객체로 묶어서 내보낸다.
export { hi, goodbye };
