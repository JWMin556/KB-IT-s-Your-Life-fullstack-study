<template>
  <div class="expense-form">
    <input
      class="input-field"
      type="text"
      placeholder="항목명 입력"
      v-model="productName"
    />
    <input
      class="input-field"
      type="number"
      placeholder="가격을 입력"
      v-model.number="productPrice"
    />
    <select class="input-field" v-model="productCategory">
      <option value="" disabled selected>카테고리 선택</option>
      <option value="food">식비</option>
      <option value="transport">교통</option>
      <option value="shopping">쇼핑</option>
    </select>
    <button class="add-button" @click="addProduct">추가</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const productName = ref('');
const productPrice = ref(0);
const productCategory = ref('');
const productObject = ref({
  name: productName.value,
  price: productPrice.value,
  category: productCategory.value,
});
const emit = defineEmits(['addProduct']);
const addProduct = () => {
  productObject.value = {
    name: productName.value,
    price: productPrice.value,
    category: productCategory.value,
  };
  emit('addProduct', productObject.value);
};
</script>

<style scoped>
.expense-form {
  display: flex;
  gap: 12px;
  /* margin: 0 auto; */
  padding: 20px 0;
}

.input-field {
  font-size: 16px;
  border: 1px solid #ccc;
  color: white;
  border-radius: 4px;
  outline: none;
  background-color: #1e1e1e;
  transition: border-color 0.3s ease;
}

.input-field:focus {
  border-color: #4d90fe;
}

.add-button {
  /* width: 70px; */
  font-size: 16px;
  color: #fff;
  background-color: #48edda;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.add-button:hover {
  background-color: #357ae8;
}

.add-button:focus {
  outline: none;
}
</style>
