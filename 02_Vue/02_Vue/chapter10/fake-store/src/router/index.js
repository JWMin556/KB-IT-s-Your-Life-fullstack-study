import {createRouter, createWebHistory} from 'vue-router';
import HomePage from '@/pages/HomePage.vue';
import ElectronicsPage from '@/pages/ElectronicsPage.vue';
import JeweleryPage from '@/pages/JeweleryPage.vue';
import MensClothingPage from '@/pages/MensClothingPage.vue';
import WomensClothingPage from '@/pages/WomensClothingPage.vue';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomePage,
        },
        {
            path: '/electronics',
            name: 'electronics',
            component: ElectronicsPage,
        },
        {
            path: '/jewelery',
            name: 'jewelery',
            component: JeweleryPage,
        },
        {
            path: '/mensclothing',
            name: "men's clothing",
            component: MensClothingPage,
        },
        {
            path: '/womenclothing',
            name: "women's clothing",
            component: WomensClothingPage,
        },
    ],
});

export default router;
