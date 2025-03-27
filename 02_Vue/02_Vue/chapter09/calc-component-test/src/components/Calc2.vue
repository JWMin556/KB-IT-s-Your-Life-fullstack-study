<template>
  <div>
    X : <input type="text" v-model.number="x" />
    <br />
    Y : <input type="text" v-model.number="y" />
    <br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'Calc2',
  setup() {
    // setup호출 되었을 때, 모두 클로저에 저장됨
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);

    // 이렇게 setup 내부에서 정의할 수 있다.
    // vue2에서는 methods에서 했었고 화살표 함수를 쓰면 안되었지만, 여기서는 화살표함수 써도 됨!
    const calcAdd = () => {
      result.value = x.value + y.value;
      // 주의는 result = x + y 이런식으로 하면 ㅈ됨
    };

    return { x, y, result, calcAdd }; // 이렇게 내보내면서 탬플릿에서 사용할 수 있는 것이다.
  },
};
</script>
