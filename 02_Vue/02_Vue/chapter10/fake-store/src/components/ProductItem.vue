<template>
    <div class="product-item">
        <img :src="product.image" alt="Product Image" class="product-image" />
        <RouterLink :to="`/product/${product.id}`" class="product-title">
            {{ product.title }}
        </RouterLink>
    </div>
</template>

<script setup>
import {defineProps} from 'vue';

defineProps({
    product: Object, // 개별 제품 정보
});
</script>

<style scoped>
.product-item {
    display: flex;
    align-items: center;
    gap: 10px;
    padding: 10px;
    border-bottom: 1px solid #ddd;
}

.product-image {
    width: 50px;
    height: 50px;
    object-fit: cover;
}

.product-title {
    color: #007bff;
    text-decoration: none;
    font-weight: bold;
}

.product-title:hover {
    text-decoration: underline;
}
</style>
