<template>
  <div>
    X : <input type="text" v-model.number="state.x" />
    <br />
    Y : <input type="text" v-model.number="state.y" />
    <br />
    <div>결과 : {{ result }}</div>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';

export default {
  name: 'Calc4',
  setup() {
    const state = reactive({ x: 10, y: 20 });
    // computed 내부 함수로 들어옴
    const result = computed(() => {
      // x와 y가 수정되었을 때 자연스럽게 다시 계산된다.
      return state.x + state.y;
    });
    // 다른 계산된 속성이 필요하면
    // const reuslt2 = computed(() => {
    // }) 이렇게 하면 됨
    return { state, result };
  },
};
</script>
