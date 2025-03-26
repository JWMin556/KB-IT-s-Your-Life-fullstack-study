<template>
  <div class="quiz-card">
    <h3>📝 즉홍 대사 출처 퀴즈</h3>
    <h5>Q. 이 대사는 어디에서 나온 걸까여?</h5>
    <slot name="quizTitle"></slot>
    <br />
    <slot name="quizHint"></slot>
    <br />
    <slot name="quizOptionList"></slot>
    <br />
    <slot name="quizResult"></slot>
    <button @click="$emit('next')">➡️ 다음 문제 풀기</button>
  </div>
</template>

<script>
export default {
  name: 'LineQuizCard',
};
</script>

<style scoped>
.quiz-card {
  background-color: #f5f5f5;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  text-align: center;
}
button {
  background-color: #27ae60;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: #2d9747;
}
</style>
