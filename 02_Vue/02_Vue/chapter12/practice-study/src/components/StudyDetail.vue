<template>
  <h1>{{ studyInfo.title }}</h1>
  <p>{{ studyInfo.desc }}</p>
  <ul class="list-group">
    <li class="list-group-item">📅 마감일: {{ studyInfo.dueDate }}</li>
    <li class="list-group-item">📅 등록일: {{ studyInfo.createdAt }}</li>
    <li class="list-group-item">📎 카테고리: {{ studyInfo.category }}</li>
    <li class="list-group-item">👥 최대 인원: {{ studyInfo.max }}</li>
    <li class="list-group-item">❤️ 좋아요: {{ studyInfo.likes }}</li>
  </ul>

  <p class="card-text mt-3">
    <span class="badge bg-success">{{
      getDueDateText(studyInfo.dueDate)
    }}</span>
  </p>
  <router-link :to="{ name: 'studies' }"
    ><button class="btn btn-secondary">목록으로</button></router-link
  >
</template>

<script setup>
import { inject, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

const currentRoute = useRoute();
const id = currentRoute.params.id;
const fetchStudyOne = inject('fetchStudyOne');
const studyInfo = ref([
  {
    title: '',
    desc: '',
    category: '',
    dueDate: '',
    createdAt: '',
    likes: '',
    max: '',
  },
]);

const getDueDateText = (dueDate) => {
  const due = new Date(dueDate);
  const currentDate = new Date();

  //남은 일수 계산
  const diffTime = due - currentDate;
  const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

  if (diffDays < 0) {
    return '마감됨';
  } else {
    return `D - ${diffDays}`;
  }
};

onMounted(async () => {
  const result = await fetchStudyOne(id);
  studyInfo.value = result[0]; // 결과 배열에서 첫 번째 객체를 사용
});
</script>

<style scoped></style>
