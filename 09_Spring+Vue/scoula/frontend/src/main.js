import './assets/main.css';
import 'bootstrap/dist/css/bootstrap.css'; // 모든 컴포넌트에서 적용되는 전역
import 'vue-awesome-paginate/dist/style.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia'; // 상태관리 라이브러리
import { VueAwesomePaginate } from 'vue-awesome-paginate';

import App from './App.vue';
import router from './router';

import { useKakao } from 'vue3-kakao-maps';
const rest_api_key = import.meta.env.VITE_KAKAO_REST_API_KEY;
useKakao(rest_api_key, ['services']);

const app = createApp(App);
app.use(VueAwesomePaginate);
app.use(createPinia());
app.use(router);

app.mount('#app');
