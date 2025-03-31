<template>
    <div class="card card-body flex-container">
        <h2>{{ product.name }}</h2>
        <div class="flex-container">
            <img :src="product.image" :alt="product.name" class="card-img-top" style="width: 300px" />
            <br />
            <p>가격: {{ product.price }}원</p>
        </div>
        <button type="button" class="btn btn-primary" @click="handleAddToCart">장바구니 담기</button>
    </div>
</template>

<script setup>
import {useRoute, useRouter} from 'vue-router';
import {inject} from 'vue';
import products from '@/data/products.json';

// 현재 라우트 정보 가져오기
const route = useRoute();
const router = useRouter();

// provide로부터 addToCart 함수 받아오기
const addToCart = inject('addToCart');

// 현재 상품 정보 가져오기
const product = products.find((item) => item.id === parseInt(route.params.id));

// 장바구니에 상품 추가 후 Cart 페이지로 이동
const handleAddToCart = () => {
    addToCart(product);
    router.push({name: 'cart'});
};
</script>

<style scoped>
.flex-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
</style>
