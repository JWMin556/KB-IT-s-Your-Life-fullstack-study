<script setup>
import MenuItem from './MenuItem.vue';
// 얘도 결국은 부모에게 받아야 하는 값
const props = defineProps({
  menus: { Type: Array, required: true },
});
</script>

<template>
  <ul class="navbar-nav">
    <MenuItem v-for="menu in menus" :menu="menu" />
    <!-- v-for에게 key속성을 주면 변경된 파트만 렌더링, 이번 상황에서는 동적으로 메뉴가 수정되는게 아니기에 key속성을 안줌 -->
  </ul>
</template>
