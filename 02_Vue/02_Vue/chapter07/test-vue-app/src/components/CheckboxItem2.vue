<script>
export default {
  name: 'CheckboxItem',
  props: ['idol'], // 부모에서 객체를 통째로 넘겨줬기에 자식에서 객체 접근 필요
};
</script>

<template>
  <!-- <li><input type="checkbox" v-model="checked" />옵션1</li> -->

  <!-- 체크박스의 체크여부 = "부모한테서 받아온 불린값" -->
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>
