// 구조 분해 할당, 객체를 쪼개서 받아온다.
const { user1, user2 } = require('./users-1');
const hello = require('./hello');

hello(user1);
hello(user2);
