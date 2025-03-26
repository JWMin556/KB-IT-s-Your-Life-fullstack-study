<template>
  <div>
    <Child1 />
    <Child2 />
    <Child3 />
  </div>
</template>

<script>
// 만약 scoped가 없다면 여기의 순서대로 화면에 스타일이 적용된다.
import Child3 from './components/Child3.vue';
import Child1 from './components/Child1.vue';
import Child2 from './components/Child2.vue';

export default {
  name: 'App',
  components: { Child1, Child2, Child3 },
};
</script>
