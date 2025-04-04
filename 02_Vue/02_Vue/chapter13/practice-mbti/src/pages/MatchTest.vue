<template>
  <div class="container mt-5">
    <div class="card p-4">
      <h3 class="text-center mb-4">MBTI 궁합 테스트</h3>
      <div class="mb-3">
        <label for="myMBTI" class="form-label">나의 MBTI</label>
        <select id="myMBTI" v-model="myMBTI" class="form-select">
          <option value="" disabled>MBTI 선택</option>
          <option v-for="mbti in mbtiList" :key="mbti" :value="mbti">
            {{ mbti }}
          </option>
        </select>
      </div>

      <div class="mb-3">
        <label for="friendMBTI" class="form-label">친구의 MBTI</label>
        <select id="friendMBTI" v-model="friendMBTI" class="form-select">
          <option value="" disabled>MBTI 선택</option>
          <option v-for="mbti in mbtiList" :key="mbti" :value="mbti">
            {{ mbti }}
          </option>
        </select>
      </div>

      <button @click="calculateMBTI" class="btn btn-primary">궁합 계산</button>

      <div
        v-if="compatibility !== null"
        class="mt-4 text-center bg-success text-white p-4 rounded"
      >
        <h4>{{ myMBTI }} ❤️ {{ friendMBTI }}</h4>
        <p class="fs-4">
          <strong>{{ result }}</strong>
        </p>
        <p class="fs-5">
          궁합률: <strong>{{ compatibility }}%</strong>
        </p>
      </div>

      <button
        v-if="compatibility !== null"
        @click="saveData"
        class="btn btn-success mt-3"
      >
        결과 저장
      </button>
    </div>
  </div>
</template>
<script setup>
import { useMatchStore } from '@/stores/matchStore.js';
import { ref } from 'vue';
const myMBTI = ref('');
const friendMBTI = ref('');
const result = ref('');
const compatibility = ref(null);

const matchStore = useMatchStore();
const { mbtiList, fetchMatchData, getCompatibility } = matchStore;

const calculateMBTI = async () => {
  // 데이터를 먼저 가져오기
  await fetchMatchData();

  //mbti가 유효한지 테스트
  if (myMBTI.value && friendMBTI.value) {
    // 궁합 계산
    const compatibilityResult = getCompatibility(
      myMBTI.value,
      friendMBTI.value
    );
    // console.log('compatibilityResult: ', compatibilityResult);
    result.value = compatibilityResult.result;
    compatibility.value = compatibilityResult.compatibility;
  } else {
    result.value = 'MBTI 값을 선택해 주세요.';
    compatibility.value = null;
  }
};
</script>
<style scoped>
.container {
  max-width: 600px;
  margin-top: 50px;
}

.card {
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

button {
  font-size: 1.2rem;
  padding: 12px;
}

h4 {
  color: #333;
  font-weight: bold;
}

p {
  font-weight: bold;
}
</style>
