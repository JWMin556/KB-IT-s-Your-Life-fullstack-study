<template>
    <div class="product-list">
        <ProductItem v-for="product in products" :key="product.id" :product="product" />
        <ProductAddButton @click="addProduct" />
    </div>
</template>

<script setup>
import {defineProps} from 'vue';
import ProductItem from './ProductItem.vue';
import ProductAddButton from './ProductAddButton.vue';

defineProps({
    products: Array, // 제품 목록 배열
});

const addProduct = () => {
    alert('상품 추가 기능이 구현될 예정입니다!');
};
</script>

<style scoped>
.product-list {
    border: 1px solid #ddd;
    padding: 10px;
    border-radius: 5px;
    background: #fff;
}
</style>
