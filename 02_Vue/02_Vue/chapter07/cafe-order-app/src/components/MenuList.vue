<script>
export default {
  name: 'MenuList',
  props: ['menu'],
};
</script>

<template>
  <div class="col-md-3 mb-3">
    <button
      @click="$emit('chooseMenu', menu)"
      class="btn btn-outline-primary w-100"
    >
      <h5>{{ menu.name }} ({{ menu.price }}원)</h5>
    </button>
  </div>
</template>

<style scoped>
/* 버튼 내부 텍스트 스타일 추가 */
button h5 {
  font-size: 1.25rem;
  margin-bottom: 0.5rem;
}

button p {
  font-size: 1rem;
  color: #555;
}
</style>
