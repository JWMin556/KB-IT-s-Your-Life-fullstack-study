import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueDevTools()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    proxy: {
      //   요청 url 중에 api라는 것으로 시작하는 요청이라면, target과 통신하라
      //   rewrite함수: path라는 기존 경로를 replace를 통해 정규표현식을 통해 /api로 시작하면 빈문자열로 바꾸라는 것이다
      //   예시: /api/todos라면... /todos로 요청하라는 것이다.
      //     정규 표현식:
      //       /   / 이 아냉 정규 표현식
      //       ^\을 통해 ^\뒤에 있는 녀석으로 시작하는가?

      '/api': {
        target: 'http://localhost:3000',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, ''),
      },
    },
  },
});
