<template>
  <div>
    X : <input type="text" v-model.number="state.x" />
    <br />
    Y : <input type="text" v-model.number="state.y" />
    <br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ state.result }}</div>
  </div>
</template>

<script>
import { reactive } from 'vue';

export default {
  name: 'Calc3',
  setup() {
    // reactive 덕에 state는 proxy가 되었다.
    const state = reactive({ x: 10, y: 20, result: 30 }); // x,y, result를 객체화 하여 초기화 하였다.

    const calcAdd = () => {
      state.result = state.x + state.y;
      // value없이 그냥 사용 (객체로 리턴했기에)
    };

    return { state, calcAdd };
  },
};
</script>
