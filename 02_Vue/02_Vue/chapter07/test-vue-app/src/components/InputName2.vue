<template>
  <div style="border: solid 1px gray; padding: 5px">
    이름: <input type="text" v-model="name" />
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
    <!-- emit은 자식이 부모에게 이벤트 전달시 사용한다 -->
  </div>
</template>

<script>
export default {
  name: 'InputName2',
  // emits: [ 'nameChanged1'],  // nameChanged1 이외의 이벤트 발생시 경고 출력
  emits: {
    //객체로 판단하는 방법이다. 조건이 맞지 않으면 경고창 출력
    namedChanged: (e) => {
      return e.name && typeof e.name === 'string' && e.name.trim().length >= 3
        ? true
        : false;
    },
  },

  data() {
    return { name: '' };
  },
};
</script>
