<template>
  <div>
    x : <input type="text" v-model.number="state.x" />
    <br />
    결과 : {{ state.result }}
  </div>
</template>

<script>
import { reactive, watch } from 'vue';

export default {
  name: 'Calc6',
  setup() {
    const state = reactive({ x: 0, result: 0 });
    // 반응형 데이터는 watch에 직접 넣으면 반응형 동작이 안됨
    // 무조건 getter 함수를 통해서 추적해야 함
    watch(
      () => state.x,
      (current, old) => {
        console.log(`${old} -> ${current}`);
        state.result = current * 2;
      }
    );
    return { state };
  },
};
</script>
