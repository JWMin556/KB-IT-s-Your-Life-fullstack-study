<template>
  <nav class="navbar navbar-expand-md navbar-light bg-light shadow-sm">
    <div class="container">
      <ul class="navbar-nav mx-auto d-flex justify-content-center">
        <li class="nav-item">
          <RouterLink
            class="nav-link"
            :to="{ name: 'home' }"
            active-class="text-primary"
            >홈</RouterLink
          >
        </li>
        <li class="nav-item">
          <RouterLink
            class="nav-link"
            :to="{ name: 'products' }"
            active-class="text-primary"
            >상품목록</RouterLink
          >
        </li>
        <li class="nav-item">
          <RouterLink
            class="nav-link"
            :to="{ name: 'cart' }"
            active-class="text-primary"
            >장바구니</RouterLink
          >
        </li>
      </ul>
    </div>
  </nav>
</template>

<script setup>
import { RouterLink } from 'vue-router';
</script>
