<script>
export default {
  // 객체를 하나 정의해서 외부로 내보내는 중이다.
  name: 'CheckboxItem', //이 컴포넌트의 이름이다.
  //   data() {
  //     return {
  //       checked: false,
  //     };
  //   },
  props: ['name', 'checked'], //부모 컴포넌트에게서 받아온 속성 배열
};
</script>

<template>
  <!-- <li><input type="checkbox" v-model="checked" />옵션1</li> -->

  <!-- 체크박스의 체크여부 = "부모한테서 받아온 불린값" -->
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>
