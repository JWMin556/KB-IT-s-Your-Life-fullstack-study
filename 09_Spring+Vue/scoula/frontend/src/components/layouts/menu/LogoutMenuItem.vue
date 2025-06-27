<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();
// useRouter(): /router/index.js의 객체 의미
// useRoute(): 현재 라우트 항목을 의미
const logout = (e) => {
  router.push('/');
};
</script>

<template>
  <a href="#" class="nav-link" @click.prevent="logout">
    <!-- capturing: 부모가 먼저 처리하고 자식으로
    bubbling: 자식이 먼저 처리하고 부모로 -->
    <!-- stop은 bubbling을 막는 것이다. 즉, 자식만 처리하고 부모는 아무것도 하지 마 -->
    <!-- prevent는 디폴트 액션을 차단하는 것이다 -->
    <i class="fa-solid fa-right-from-bracket"></i>
    로그아웃
  </a>
</template>
