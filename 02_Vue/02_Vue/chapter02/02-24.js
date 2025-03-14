let obj = { name: '홍길동', age: 20 };
const proxy = new Proxy(obj, {
  // 값을 가지고 올 때 처리
  get: function (target, key) {
    console.log('## get ' + key);

    if (!target[key]) {
      throw new Error(`존재하지 않는 속성 (${key})입니다.`);
    }
    return target[key];
  },

  // 값을 설정할 때는 set처리
  set: function (target, key, value) {
    console.log('## set ' + key);
    if (!target[key]) {
      throw new Error(`존재하지 않는 속성 (${key})입니다.`);
    }
    target[key] = value;
    return true;
  },
});

// 값을 가져오므로 get 호출
console.log(proxy.name);
proxy.name = '나미';
proxy.age = 21;
console.log(proxy);
