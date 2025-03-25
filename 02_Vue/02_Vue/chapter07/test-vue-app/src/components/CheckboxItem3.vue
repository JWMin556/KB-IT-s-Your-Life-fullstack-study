<script>
export default {
  name: 'CheckboxItem3',
  props: {
    id: [Number, String], //id 값은 Number나 String 타입
    name: String, //name 값은 string 타입
    checked: {
      // checked 값은 bool값이고 필수값이 아니며 기본값은 false
      type: Boolean,
      required: false,
      default: false,
    },
  },
};
</script>

<template>
  <!-- <li><input type="checkbox" v-model="checked" />옵션1</li> -->

  <!-- 체크박스의 체크여부 = "부모한테서 받아온 불린값" -->
  <li><input type="checkbox" :checked="checked" />{{ id }} - {{ name }}</li>
</template>
