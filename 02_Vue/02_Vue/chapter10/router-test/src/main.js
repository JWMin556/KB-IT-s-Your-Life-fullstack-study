// import './assets/main.css'

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import 'bootstrap/dist/css/bootstrap.css';
const app = createApp(App);

app.use(router); //라우터를 앱에 연결

app.mount('#app');
