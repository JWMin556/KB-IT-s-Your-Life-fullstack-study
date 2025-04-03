import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import StudyList from '@/components/StudyList.vue';
import StudyDetail from '@/components/StudyDetail.vue';
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/studies',
      name: 'studies',
      component: StudyList,
    },
    {
      path: '/studies/:id',
      name: 'studies/id',
      component: StudyDetail,
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue'),
    // },
  ],
});

export default router;
