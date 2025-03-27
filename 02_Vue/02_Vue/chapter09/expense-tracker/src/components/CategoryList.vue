<template>
  <li class="expense-item">
    <div>
      <span class="category-name">{{ category }}</span
      >:&nbsp
      <span class="category-total">{{ formatPrice(total) }} 원</span>
    </div>
  </li>
</template>

<script setup>
const props = defineProps({
  category: { type: String, required: true },
  total: { type: Number, required: true },
  formatPrice: { type: Function, required: true },
});
</script>

<style scoped>
.expense-item {
  display: flex;
  justify-content: space-between;
  background-color: #c11d1d;
  border-radius: 8px;
  padding: 12px;
  margin: 10px 0;
  display: flex;
  align-items: center;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
}
.category-name {
  font-size: 18px;
  font-weight: bold;
  color: #f0f0f0;
}
.category-total {
  font-size: 18px;
  color: lightgreen;
}
</style>
