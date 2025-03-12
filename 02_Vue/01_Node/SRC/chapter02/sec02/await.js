// await를 사용하는 함수에는 반드시 async를 상위에 붙인다
async function init() {
  try {
    //중요사실: await는 무조건 Promise형태로 반환된다
    const response = await fetch('https://jsonplaceholder.typicode.com/users');
    const users = await response.json();
    console.log(users);
  } catch (err) {
    console.error(err);
  }
}

init();
