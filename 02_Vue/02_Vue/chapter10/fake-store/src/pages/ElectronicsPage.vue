<template>
    <div class="electronics-page">
        <h2 style="margin-top: 50px"><i class="fa-solid fa-tv"></i> 가전</h2>
        <ProductList :products="products" @add-product="goToAddProduct" />
    </div>
</template>

<script setup>
import {ref, onMounted} from 'vue';
import {useRouter} from 'vue-router';
import ProductList from '@/components/ProductList.vue';
import {get} from '@/api/product.js';

const products = ref([]);

const fetchProducts = async () => {
    try {
        const data = await get('', {category: 'electronics'}); // 가전 카테고리 필터 적용
        products.value = data; // API 응답 데이터를 상태에 저장
    } catch (error) {
        console.error('상품 데이터를 불러오는 데 실패했습니다.', error);
    }
};

onMounted(fetchProducts);

const router = useRouter();

const goToAddProduct = () => {
    router.push({path: '/add-product', query: {category: 'electronics'}});
};
</script>

<style scoped>
.electronics-page {
    padding: 20px;
    background: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
h2 {
    color: #333;
    margin-bottom: 15px;
}
</style>
