import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import Cart from '@/pages/Cart.vue';
import Products from '@/pages/Products.vue';
import ProductDetail from '@/pages/ProductDetail.vue';
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
    {
      path: '/products',
      name: 'products',
      component: Products,
    },
    {
      path: '/products/:id',
      name: 'products/id',
      component: ProductDetail,
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
