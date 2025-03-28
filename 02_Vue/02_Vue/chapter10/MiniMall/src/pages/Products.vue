<template>
  <div class="myDiv">
    <h1>상품 목록</h1>
    <div class="row">
      <div class="col-md-4" v-for="product in products" :key="product.id">
        <div class="card mb-4">
          <img :src="product.image" :alt="product.name" class="card-img-top" />
          <div class="card-body">
            <h5 class="card-title">{{ product.name }}</h5>
            <p class="card-text">
              <strong>${{ product.price }}</strong>
            </p>
            <p class="text-success"></p>
            <RouterLink
              class="text-success"
              :to="{
                name: 'products/id',
                params: { id: product.id },
              }"
              >상세보기</RouterLink
            >
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import products from '@/data/products.json';
import { RouterLink } from 'vue-router';
</script>
<style scoped>
.myDiv {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
