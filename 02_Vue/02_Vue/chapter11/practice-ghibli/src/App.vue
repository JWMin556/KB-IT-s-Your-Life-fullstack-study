<template>
  <div class="MainContainer">
    <router-view />
  </div>
</template>

<script setup>
import axios from 'axios';
import { onMounted, provide, ref } from 'vue';

const movieList = ref([]); // 반응형 변수로 선언

const requestApi = async () => {
  const url = 'http://localhost:3000/movies';
  try {
    const response = await axios.get(url);
    console.log('응답: ', response);
    movieList.value = response.data;
  } catch (error) {
    console.log('에러발생: ', error);
  }
};

onMounted(() => {
  requestApi();
});

// 그 후 provide로 하위 컴포넌트에 데이터 제공
provide('movieList', movieList);
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.MainContainer {
  background-color: black;
  color: white;
}
</style>
