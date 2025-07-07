export default [
  {
    path: '/gallery/list',
    name: 'gallery/list',
    component: () => import('../pages/gallery/GalleryListPage.vue'),
  },
  {
    path: '/travel/detail/:no',
    name: 'travel/detail',
    component: () => import('../pages/travel/TravelDetailPage.vue'),
  },
];
