<script>
import CheckboxItem from './components/CheckboxItem.vue'; // 전역이든 지역이든 무조건 임포트 필요

export default {
  name: 'App',
  components: { CheckboxItem }, // 이 components에 등록해야 한다.
  data() {
    return {
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
        { id: 4, name: 'ITZY', checked: false },
      ],
    };
  },
};
</script>

<template>
  <div>
    <!-- <h2>App 컴포넌트</h2> -->
    <h2>관심있는 K-pop가수</h2>
    <hr />
    <ul>
      <!-- idol이라는 props 속성에 객체 하나를 통째로 넘김 -->
      <CheckboxItem v-for="idol in idols" :key="idol.id" :idol="idol" />
    </ul>
  </div>
</template>
