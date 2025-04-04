// counter.js는 샘플 store이다.
import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0);
  const doubleCount = computed(() => count.value * 2);
  function increment() {
    count.value++;
  }

  return { count, doubleCount, increment }; // 다른 컴포넌트에서 이 세 가지를 사용할 수 있다. 다만, count를 저렇게 직접 내보내면 위험
});
