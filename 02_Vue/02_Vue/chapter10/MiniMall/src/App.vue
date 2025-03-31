<template>
    <div class="container">
        <header>
            <Header />
        </header>
        <RouterView />
    </div>
</template>

<script setup>
import {provide, reactive} from 'vue';
import Header from './components/Header.vue';
import {RouterView} from 'vue-router';

// 장바구니 상태 (reactive상태)
const cart = reactive([]);

// 장바구니에 상품 추가하는 함수
const addToCart = (product) => {
    cart.push(product);
};

// provide()로 전역 상태 및 함수 전달
provide('cart', cart);
provide('addToCart', addToCart);
</script>

<style scoped>
/* 부트스트랩 스타일을 사용하여 기본 스타일링 */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: Arial, Helvetica, sans-serif;
    background-color: #f8f9fa; /* 부트스트랩의 기본 배경색 */
}

/* .container 클래스를 부트스트랩의 클래스로 교체 */
.container {
    padding-top: 20px;
}

/* 헤더를 부트스트랩의 sticky-top 클래스를 사용하여 상단 고정 */
header {
    top: 0;
    z-index: 1000;
    background-color: white; /* 부트스트랩에 기본적으로 있는 배경색 */
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
}

/* RouterView를 부트스트랩 카드 컴포넌트를 이용하여 디자인 */
.router-view {
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    background-color: white;
    border-radius: 8px;
    padding: 20px;
    margin-top: 20px; /* 헤더 아래에 여백 추가 */
    box-sizing: border-box;
}
</style>
