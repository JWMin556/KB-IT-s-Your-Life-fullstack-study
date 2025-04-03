<template>
  <div class="MainContainer">
    <button @click="showModal = true">🎬 영화 추가하기</button>
    <router-view />
    <AddMovieModal
      :visible="showModal"
      @movie-added="fetchMovies"
      @close="showModal = false"
    />
    <!-- <arbitary /> -->
  </div>
</template>

<script setup>
import axios from 'axios';
import { onMounted, provide, ref } from 'vue';
import AddMovieModal from './components/AddMovieModal.vue';
// import arbitary from './components/arbitary.vue';
const movieList = ref([]); // 반응형 변수로 선언
const showModal = ref(false);

const fetchMovies = async () => {
  try {
    const response = await axios.get('http://localhost:3000/movies');
    movieList.value = response.data;
  } catch (error) {
    console.error('영화 목록 불러오기 오류:', error);
  }
};

onMounted(fetchMovies);
provide('movieList', movieList);
</script>

<style scoped>
.MainContainer {
  background-color: black;
  color: white;
  padding: 20px;
}
button {
  background: yellow;
  border: none;
  padding: 10px 15px;
  cursor: pointer;
  margin-bottom: 20px;
}
</style>
