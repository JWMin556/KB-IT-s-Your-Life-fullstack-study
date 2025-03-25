<script>
import CheckboxItem3 from './components/CheckboxItem3.vue'; // 전역이든 지역이든 무조건 임포트 필요

export default {
  name: 'App',
  components: { CheckboxItem3 }, // 이 components에 등록해야 한다.
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
      <!-- :name과 :checked는 자식에게 전달할 props이다 -->
      <CheckboxItem3
        v-for="idol in idols"
        :key="idol.id"
        :name="idol.name"
        :checked="idol.checked"
        :id="idol.id"
      />
      <!-- 바로 이 녀석들이 컴포넌트로 등록한 사용자 정의 태그 -->
      <!-- <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
      <checkbox-item /> -->
    </ul>
  </div>
</template>
