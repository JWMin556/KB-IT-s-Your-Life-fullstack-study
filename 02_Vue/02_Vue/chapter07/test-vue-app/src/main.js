import { createApp } from 'vue';
import App4 from './App4.vue';
// 전역 컴포넌트 등록 방법
// 모든 곳에서 등록되기에 파일이 커질 수 있다는 단점 -> 비권장
// import CheckboxItem from './components/CheckboxItem.vue';
// createApp(App).component('CheckboxItem', CheckboxItem).mount('#app');
createApp(App4).mount('#app');
