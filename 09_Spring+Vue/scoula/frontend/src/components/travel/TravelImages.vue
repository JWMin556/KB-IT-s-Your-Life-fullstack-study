<script setup></script>

<template>
  <div class="w-100 my-4">
    <img :src="activeImage" style="width: 100%; height: 400px" />
    <div class="d-flex">
      <div class="flex-fill" v-for="(image, ix) in images" :key="image.no">
        <img
          class="thumbnail"
          :src="image.url"
          style="width: 100%; height: 100px"
          @click="onClick(ix)"
        />
      </div>
    </div>
  </div>
</template>

<style scoped>
img {
  object-fit: cover;
}
.thumbnail {
  cursor: pointer;
}
.active {
  border: 1px solid red;
}
</style>
