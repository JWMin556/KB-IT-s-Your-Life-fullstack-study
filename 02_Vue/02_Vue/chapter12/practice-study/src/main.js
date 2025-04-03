import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
// Bootstrap CSS
import 'bootstrap/dist/css/bootstrap.min.css';

// Bootstrap JS (필요한 경우)
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

const app = createApp(App);

app.use(router);

app.mount('#app');
