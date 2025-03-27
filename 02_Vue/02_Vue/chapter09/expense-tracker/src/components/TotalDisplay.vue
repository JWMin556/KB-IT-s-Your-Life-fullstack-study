<template>
  <div class="stylediv">🧮 총 지출: {{ formatPrice(totalExpense) }}원</div>
</template>

<script setup>
const props = defineProps({
  // script setup에서는 이렇게 객체로 타입설정이 필수이다.
  totalExpense: { type: Number, required: true },
  formatPrice: { type: Function, required: true },
});
</script>

<style scoped>
/* 재밌는 상식: 부모 컴포넌트의 style 중 동명의 클래스 스타일이 있으며 상속이 된다 */
.stylediv {
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 5px;
  background-color: rgb(238, 181, 181);
  font-size: 30px;
  color: rgb(32, 155, 30);
}
</style>
