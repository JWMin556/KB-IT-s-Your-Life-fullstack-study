<template>
  <div class="div-container">
    <router-view />
  </div>
</template>

<script setup>
import axios from 'axios';
import { computed, provide, reactive } from 'vue';

const states = reactive({ studyList: [] });

const fetchStudyList = async () => {
  try {
    const response = await axios.get('/api/studies');
    console.log('실행결과: ', response);
    states.studyList = response.data;
  } catch (error) {
    console.log('에러뜸ㅋ', error);
  }
};

const fetchStudyOne = async (id) => {
  try {
    const response = await axios.get(`/api/studies?id=${id}`);
    console.log('하나 가져온 결과: ', response);
    return response.data;
  } catch (error) {
    console.log('하나 가져오는 오는데 또 에러뜸', error);
    return;
  }
};

provide(
  'studyList',
  computed(() => states.studyList)
);

provide('fetchStudyOne', fetchStudyOne);

fetchStudyList();
</script>

<style scoped>
.div-container {
  display: flex;
  width: 65rem;
  flex-direction: column;
  margin-left: 10rem;
}
</style>
