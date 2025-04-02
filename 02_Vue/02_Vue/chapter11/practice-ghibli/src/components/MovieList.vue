<template>
  <h1>🎥 지브리 영화 리스트</h1>
  <ul>
    <li v-for="movie in movieList" :key="movie.id">
      <router-link
        style="color: yellow"
        :to="{ name: 'movies/id', params: { id: movie.id } }"
        >🎥{{ movie.title }} - {{ movie.director }}</router-link
      >
    </li>
  </ul>
</template>

<script setup>
import { inject } from 'vue';
import { RouterLink } from 'vue-router';

const movieList = inject('movieList');
</script>
