// 기본 매개변수는 무조건 뒤에서부터 사용
function addContact(
  name,
  mobile,
  home = '없음',
  address = '없음',
  email = '없음'
) {
  let str =
    `name=${name}, mobile=${mobile}, home=${home},` +
    ` address=${address}, email=${email}`;
  console.log(str);
}
// 값을 설정하지 않은 변수는 기본값으로 출력
addContact('홍길동', '010-222-3331');
addContact('이몽룡', '010-222-3331', '02-3422-9900', '서울시');
