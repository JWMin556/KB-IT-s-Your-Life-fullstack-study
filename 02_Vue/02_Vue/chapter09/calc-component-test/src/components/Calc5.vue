<template>
  <div>
    x : <input type="text" v-model.number="x" />
    <br />
    결과 : {{ result }}
  </div>
</template>

<script>
import { ref, watch } from 'vue';

export default {
  name: 'Calc5',
  setup() {
    const x = ref(0);
    const result = ref(0);

    // 안에서 watch 함수를 선언
    // watch(감시하려는 데이터, 처리 함수)
    // 여기서 받아온 데이터들은 모두 .value처리가 되어있기에 current, old를 .value없이 사용할 수 있는 것이다
    watch(x, (current, old) => {
      // x를 감시할 것이다
      // 보면 알 수 있듯이 current와 old는 .value로 하지 않는다
      console.log(`${old} -> ${current}`);
      result.value = current * 2;
    });
    return { x, result };
  },
};
</script>
