<template>
  <h1>🎥 지브리 영화 리스트</h1>
  <h2>{{ movieInfo[0].title }} ({{ movieInfo[0].year }})</h2>
  <p>감독: {{ movieInfo[0].director }}</p>
  <p>줄거리: {{ movieInfo[0].description }}</p>
  <img
    :src="movieInfo[0].poster"
    :alt="movieInfo[0].title"
    v-if="movieInfo[0].poster"
  />
</template>
<script setup>
import axios from 'axios';
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

const currentRounte = useRoute();
const id = currentRounte.params.id;

const movieInfo = ref([
  { title: '', year: '', director: '', description: '', poster: '' },
]);

const requestGetApi = async () => {
  const url = `http://localhost:3000/movies?id=${id}`;
  try {
    const response = await axios.get(url);
    console.log('dddd', response);
    movieInfo.value = response.data;
  } catch (error) {
    console.log('에러 뜸 ㅋ', error);
  }
};

onMounted(() => {
  requestGetApi();
});
</script>
