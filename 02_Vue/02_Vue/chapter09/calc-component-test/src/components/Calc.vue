<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>

<script>
import { ref } from 'vue'; // vue에서 자주 사용됨

export default {
  name: 'Calc',
  setup() {
    const x = ref(10); //ref를 통해 초기값을 부여해야 proxy화 가능
    const y = ref(20);
    return { x, y }; // setup함수에서 리턴하는 변수들을 탬플릿에서 쓸 수 있다. 마치 data()처럼
  },
};
</script>
