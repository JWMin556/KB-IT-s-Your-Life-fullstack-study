<template>
  <div>
    <!-- 자식에서 변경이 될 때마다 name값이 searchName에 바로 반영 -->
    <InputName v-model:name="searchName" />
    <h3>검색어: {{ searchName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName.vue';
export default {
  name: 'App',
  components: { InputName },
  data() {
    return {
      searchName: 'John',
    };
  },
};
</script>
