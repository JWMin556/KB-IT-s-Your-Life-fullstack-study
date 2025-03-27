<template>
  <div class="app">
    <h1 style="color: greenyellow">💸 Simple Budget Diary</h1>
    <ExpenseForm @addProduct="handleAddProduct" />
    <p class="styledPara">🧾 지출 내역</p>
    <ul class="expense-list">
      <ExpenseList
        v-for="(product, index) in products"
        @deleteItem="handleDeleteItem"
        :key="index"
        :product="product"
        :index="index"
        :formatPrice="formatPrice"
      />
    </ul>
    <TotalDisplay :totalExpense="totalExpense" :formatPrice="formatPrice" />
    <CategoryDisplay :products="products" :formatPrice="formatPrice" />
  </div>
</template>

<script setup>
import { computed, ref } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseList from './components/ExpenseList.vue';
import CategoryDisplay from './components/CategoryDisplay.vue';

const products = ref([]);

const handleAddProduct = (product) => {
  products.value.push(product);
};

const handleDeleteItem = (id) => {
  products.value.splice(id, 1);
};

const formatPrice = (price) => {
  return price.toLocaleString();
};

// computed는 주로 반복되는 값의 계산을 캐싱해서 성능 최적화와 코드 간결성을 위해 사용됩니다.
// 특히 뷰의 상태가 변경될 때마다 해당 계산 결과를 자동으로 다시 계산하여 뷰를 갱신하는 데 유용합니다.
// computed는 값이 변하지 않으면 이전 계산값을 캐시해두기 때문에 불필요한 계산을 피할 수 있습니다.

const totalExpense = computed(() => {
  return products.value.reduce(
    (sum, product) => sum + Number(product.price),
    0
  );
});
</script>

<style scoped>
.app {
  background-color: #1e1e1e;
  color: #f0f0f0;
  padding: 30px;
  font-family: 'Segoe UI', sans-serif;
  max-width: 600px;
  margin: 50px auto;
  border-radius: 16px;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.3);
}
.styledPara {
  font-size: 30px;
  color: skyblue;
}
.expense-list {
  list-style: none; /* 기본 리스트 아이콘 없애기 */
  padding: 0;
  margin: 0;
}
</style>
