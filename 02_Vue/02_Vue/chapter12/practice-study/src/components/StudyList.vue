<template>
  <h1>📚 스터디 목록</h1>
  <div class="container mb-5">
    <label for="isToday">
      <input type="checkbox" id="isToday" v-model="isToday" />
      <span>모집 중만 보기</span>
    </label>

    <select id="sortOptions" v-model="selectedSortOption">
      <option value="dueDateAsc">마감일 임박순</option>
      <option value="createdAtDesc">최신 등록일 순</option>
      <option value="likesDesc">좋아요순</option>
    </select>
  </div>

  <div class="row">
    <div
      class="card-container"
      v-for="study in sortedStudyList"
      :key="study.id"
    >
      <div class="card mb-4">
        <div class="card-body">
          <router-link
            class="no-deco"
            :to="{ name: 'studies/id', params: { id: study.id } }"
          >
            <h3 class="card-title font-weight-bold">{{ study.title }}</h3>
            <p class="card-text">📎 카테고리: {{ study.category }}</p>
            <p class="card-text">📅 등록일: {{ study.createdAt }}</p>
            <p class="card-text">📅 마감일: {{ study.dueDate }}</p>
            <p class="card-text">❤️ 좋아요: {{ study.likes }}</p>
            <p class="card-text">
              <span class="badge bg-success">{{
                getDueDateText(study.dueDate)
              }}</span>
            </p>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, ref, computed } from 'vue';

// studyList를 부모 컴포넌트(App.vue)에서 주입
const studyList = inject('studyList');
const isToday = ref(false);
const selectedSortOption = ref('dueDateAsc');

// 현재 날짜를 가져오기 위한 helper 함수
const getCurrentDate = () => {
  const today = new Date();
  today.setHours(0, 0, 0, 0); // 오늘 자정으로 설정
  return today;
};

// "모집 중인 스터디만 보기" 필터링 로직
const filteredStudyList = computed(() => {
  if (!studyList.value) return []; // studyList가 아직 주입되지 않았을 때 처리
  const currentDate = getCurrentDate();

  return studyList.value.filter((study) => {
    const dueDate = new Date(study.dueDate);
    return !isToday.value || dueDate >= currentDate; // isToday가 true일 때만 마감일이 오늘 이후인 스터디만 포함
  });
});

const sortedStudyList = computed(() => {
  const filteredStudies = filteredStudyList.value;

  // 선택된 정렬 기준에 따라 정렬
  switch (selectedSortOption.value) {
    case 'dueDateAsc':
      return filteredStudies.sort(
        (a, b) => new Date(a.dueDate) - new Date(b.dueDate)
      ); // 마감일 임박순
    case 'createdAtDesc':
      return filteredStudies.sort(
        (a, b) => new Date(b.createdAt) - new Date(a.createdAt)
      ); // 최신 등록일 순
    case 'likesDesc':
      return filteredStudies.sort((a, b) => b.likes - a.likes); // 좋아요순
    default:
      return filteredStudies;
  }
});

const getDueDateText = (dueDate) => {
  const due = new Date(dueDate);
  const currentDate = new Date();

  // 남은 일수 계산
  const diffTime = due - currentDate;
  const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

  if (diffDays < 0) {
    return '마감됨';
  } else {
    return `D - ${diffDays}`;
  }
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: space-between;
}

.row {
  display: flex;
  flex-wrap: wrap;
  gap: 1rem; /* 카드들 간의 간격 */
}

.card-container {
  width: 48%; /* 한 줄에 두 개씩 나오도록 50%로 설정 */
}

.card {
  width: 100%; /* card가 부모의 100%를 차지하게 */
}

.no-deco {
  text-decoration: none; /* 밑줄 제거 */
  color: inherit; /* 링크의 색상을 부모 색상으로 설정 */
}

/* 카드 이미지의 크기 조정 (옵션) */
.card-img-top {
  height: 200px;
  object-fit: cover;
}

/* card-title을 굵게 설정 */
.font-weight-bold {
  font-weight: bold;
}
</style>
