<template>
    <div class="cart-container">
        <h1><i class="fa-solid fa-cart-shopping"></i> 장바구니</h1>

        <ul v-if="cart.length > 0" class="cart-list">
            <li v-for="(item, index) in cart" :key="index" class="cart-item">
                <img :src="item.image" :alt="item.name" class="cart-item-img" />
                <div class="cart-item-info">
                    <h2 class="cart-item-name">{{ item.name }}</h2>
                    <p class="cart-item-price">{{ item.price.toLocaleString() }}원</p>
                </div>
            </li>
        </ul>

        <p v-else class="empty-message">장바구니가 비어 있습니다.</p>

        <h3 v-if="cart.length > 0" class="cart-total">총합: {{ totalPrice.toLocaleString() }}원</h3>
    </div>
</template>

<script setup>
import {computed, inject} from 'vue';

// provide로부터 장바구니 배열 가져오기
const cart = inject('cart');

// 총합 계산 (computed 사용)
const totalPrice = computed(() => {
    return cart.reduce((sum, item) => sum + item.price, 0);
});
</script>

<style scoped>
.cart-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    padding: 5rem;
    max-width: 600px;
    margin: 0 auto;
}

.cart-list {
    width: 100%;
    padding: 0;
}

.cart-item {
    display: flex;
    align-items: center;
    background: #fff;
    padding: 10px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
}

.cart-item-img {
    width: 60px;
    height: 60px;
    border-radius: 8px;
    object-fit: cover;
    margin-right: 15px;
}

.cart-item-info {
    display: flex;
    flex-direction: column;
}

.cart-item-name {
    font-size: 16px;
    font-weight: bold;
    margin: 0;
}

.cart-item-price {
    font-size: 14px;
    color: #555;
    margin-top: 5px;
}

.cart-total {
    margin-top: 15px;
    font-size: 18px;
    font-weight: bold;
}

.empty-message {
    color: #888;
    font-size: 16px;
}
</style>
