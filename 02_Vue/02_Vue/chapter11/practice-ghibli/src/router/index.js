import { createRouter, createWebHistory } from 'vue-router';
import MovieList from '@/components/MovieList.vue';
import MovieDetail from '@/components/MovieDetail.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: MovieList,
    },
    { path: '/movies/:id', name: 'movies/id', component: MovieDetail },
  ],
});

export default router;
