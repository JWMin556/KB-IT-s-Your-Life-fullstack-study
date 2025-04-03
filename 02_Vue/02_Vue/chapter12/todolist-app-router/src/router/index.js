import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import AddTodo from '@/pages/AddTodo.vue';
import EditTodo from '@/pages/EditTodo.vue';
import NotFound from '@/pages/NotFound.vue';
import TodoList from '@/pages/TodoList.vue';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/todos',
      name: 'todos',
      component: TodoList,
    },
    {
      path: '/todos/add',
      name: 'todos/add',
      component: AddTodo,
    },
    {
      path: '/todos/edit/:id',
      name: 'todos/edit/id',
      component: EditTodo,
    },
    {
      path: '/:pathMatch(.*)*', //위에서 매칭되지 않은 나머지
      name: 'NotFound',
      component: NotFound,
    },
  ],
});

export default router;
