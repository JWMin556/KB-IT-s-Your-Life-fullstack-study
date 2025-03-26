// main.css가 전역 css로 여기에 선언
import { createApp } from 'vue';
import App from './App.vue';

// Bootstrap 불러오기
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

createApp(App).mount('#app');
