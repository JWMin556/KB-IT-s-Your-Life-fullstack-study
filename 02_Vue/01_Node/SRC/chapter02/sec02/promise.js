let likePizza = true;
const pizza = new Promise((resolve, reject) => {
  // resolve는 성공시 호출하는 메소드이고 reject는 실패시 호출하는 메소드이다
  if (likePizza) {
    resolve('피자를 주문한다. '); //즉, value를 넘긴다.
  } else {
    reject('피자를 주문하지 않는다');
  }
});

//then으로 resolve 매개변수 받아오고 catch로 reject 매개변수 받아옴
pizza
  .then((result) => {
    console.log(result);
  })
  .catch((err) => {
    console.log(err);
  });
