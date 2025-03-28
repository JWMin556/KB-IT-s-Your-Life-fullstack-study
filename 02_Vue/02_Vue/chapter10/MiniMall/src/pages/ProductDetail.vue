<template>
  <div class="card card-body">
    <h2>{{ product.name }}</h2>
    <div>
      <img :src="product.image" :alt="product.name" class="card-img-top" />
      <br />
      <p>{{ product.price }}원</p>
      <button type="button" class="btn btn-primary">장바구니 담기</button>
    </div>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import products from '@/data/products.json';
const currentRoute = useRoute();
const product = products.find(
  (item) => item.id === parseInt(currentRoute.params.id)
);
</script>
