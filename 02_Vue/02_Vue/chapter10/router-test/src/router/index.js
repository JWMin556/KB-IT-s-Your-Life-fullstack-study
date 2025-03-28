import { createRouter, createWebHistory } from 'vue-router';

import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import MemberInfo from '@/pages/MemberInfo.vue';
import VideoPlayer from '@/pages/VideoPlayer.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', name: 'home', component: Home },
    { path: '/about', name: 'about', component: About },
    { path: '/members', name: 'members', component: Members },
    {
      // 경로에 :이 붙으면 동적 파라미터 할당 가능
      path: '/members/:id',
      name: 'members/id',
      component: MemberInfo,
    },

    {
      // 하나의 라우트 내에서 또 다른 라우트를 부르는 구조
      path: '/songs',
      name: 'videos',
      component: Videos,
      children: [{ path: ':id', name: 'videos/id', component: VideoPlayer }],
    },
  ],
});

export default router;
