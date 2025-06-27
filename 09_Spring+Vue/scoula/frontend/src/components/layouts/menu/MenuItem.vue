<script setup>
// 부모에게 받는 존재
// defineProps를 통해 태그안에서 사용할 변수인 property를 가져올 수 있다.
const props = defineProps({
  menu: { Type: Object, required: true },
});
// 탬플릿에서는 바로 menu로 쓸 수 있고 외부의 자바스크립트에선느 props.menu로 사용가능
</script>

<template>
  <li class="nav-item">
    <router-link class="nav-link" :to="menu.url">
      <i :class="menu.icon"></i>
      {{ menu.title }}
    </router-link>
  </li>
</template>

<style></style>
