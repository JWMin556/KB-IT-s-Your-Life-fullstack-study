<template>
  <div>
    <!-- 배경 이미지 추가 -->
    <div class="HeaderBackground">
      <h1>Fake Store 연습</h1>
      <p>Vue3 연습 사이트</p>
    </div>

    <!-- 네비게이션 바 -->
    <nav class="navbar navbar-expand-md bg-primary navbar-dark">
      <span class="navbar-brand"
        ><RouterLink class="nav-link" to="/"
          ><i class="fa-solid fa-house"></i> Fake Store</RouterLink
        ></span
      >
      <button class="navbar-toggler" type="button" @click="changeIsNavShow">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div :class="navClass">
        <ul class="navbar-nav">
          <li class="nav-item">
            <RouterLink class="nav-link" to="/electronics"
              ><i class="fa-solid fa-tv"></i>가전</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/jewelery"
              ><i class="fa-solid fa-gem"></i>주얼리</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/mensclothing"
              ><i class="fa-solid fa-mars-stroke"></i>남성의류</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/womenclothing"
              ><i class="fa-solid fa-venus"></i>여성의류</RouterLink
            >
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';

export default {
  setup() {
    const state = reactive({ isNavShow: false });

    const navClass = computed(() =>
      state.isNavShow
        ? 'collapse navbar-collapse show'
        : 'collapse navbar-collapse'
    );

    const changeIsNavShow = () => {
      state.isNavShow = !state.isNavShow;
    };

    return { state, changeIsNavShow, navClass };
  },
};
</script>

<style scoped>
.HeaderBackground {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding-left: 30px;
  color: white;
  background-image: url('https://farm9.static.flickr.com/8147/7531728992_91cbf990f1.jpg');
  background-size: cover; /* 배경 이미지 크기 설정 */
  background-position: center; /* 배경 이미지 중앙 정렬 */
  height: 200px; /* 배경 이미지의 높이를 설정 */
  width: 100%; /* 배경 이미지 너비를 100%로 설정 */
}
</style>
