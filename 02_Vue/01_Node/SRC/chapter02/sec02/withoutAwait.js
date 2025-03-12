// fetch는 Promise객체를 리턴한다
fetch('https://jsonplaceholder.typicode.com/users')
  .then((response) => response.json()) //얘도 json으로 바꾸기는 하지만, Promise형태이다
  .then((data) => console.log(data))
  .catch((err) => console.log(err));
