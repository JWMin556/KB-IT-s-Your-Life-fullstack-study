<template>
  <p class="styledPara">
    <i class="fa-solid fa-chart-column"></i> 카테고리별 지출 합계
  </p>
  <ul class="expense-list">
    <CategoryList
      v-for="(total, category) in categoryExpense"
      :key="category"
      :category="category"
      :total="total"
      :formatPrice="formatPrice"
    />
  </ul>
</template>

<script setup>
import { computed } from 'vue';
import CategoryList from './CategoryList.vue';

const props = defineProps({
  products: { type: Array, required: true },
  formatPrice: { type: Function, required: true },
});

// 카테고리 별 지출 합계
const categoryExpense = computed(() => {
  const categoryMap = props.products.reduce((acc, product) => {
    if (acc[product.category]) {
      acc[product.category] += Number(product.price);
    } else {
      acc[product.category] = Number(product.price);
    }
    return acc;
  }, {});

  return categoryMap;
});
</script>

<style scoped>
.styledPara {
  font-size: 30px;
  color: skyblue;
}
</style>
