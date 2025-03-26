<template>
  <!-- name을 부모에게 받아오고 변경되었을 때, 부모에게 이벤트로 변경된 값 전송 -->
  <input
    type="text"
    :value="name"
    @input="$emit('update:name', $event.target.value)"
  />
</template>

<script>
export default {
  name: 'InputName',
  props: ['name'],
};
</script>
