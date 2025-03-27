<template>
  <li class="expense-item">
    <div>
      <span class="product-name">{{ labeledName(product.name) }}</span
      >: &nbsp
      <span class="product-price">{{ formatPrice(product.price) }}원</span>
    </div>
    <span @click="deleteItem(index)" style="cursor: pointer"
      ><i class="fa-solid fa-circle-xmark"></i
    ></span>
  </li>
</template>

<script setup>
const props = defineProps({
  index: { type: Number, required: true },
  product: { type: Object, required: true },
  formatPrice: { type: Function, required: true },
});

const emit = defineEmits(['delete-item']);
const deleteItem = (index) => {
  emit('deleteItem', index);
};

const labeledName = (name) => {
  if (name.includes('커피')) {
    return `☕ ${name}`;
  } else if (name.includes('정장')) {
    return `🧺 ${name}`;
  } else {
    return `🍖 ${name}`;
  }
};
</script>

<style scoped>
.expense-item {
  display: flex;
  justify-content: space-between;
  background-color: #333;
  border-radius: 8px;
  padding: 12px;
  margin: 10px 0;
  display: flex;
  align-items: center;
  box-shadow: 0 0 8px rgba(0, 0, 0, 0.2);
}
.product-name {
  font-size: 18px;
  font-weight: bold;
  color: #f0f0f0;
}
.product-price {
  font-size: 18px;
  color: lightgreen;
}
</style>
