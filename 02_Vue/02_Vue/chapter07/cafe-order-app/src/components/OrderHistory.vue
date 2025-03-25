<template>
  <div class="mb-4">
    <div v-for="(order, index) in orders" :key="index">
      <div class="card mb-3 shadow-sm">
        <div class="card-body">
          <h5 class="card-title">주문 내역</h5>
          <p class="card-text"><strong>⏰ 시간:</strong> {{ order.time }}</p>
          <p class="card-text"><strong>음료:</strong> {{ order.drinkName }}</p>
          <p class="card-text"><strong>사이즈:</strong> {{ order.size }}</p>
          <p class="card-text">
            <strong>추가샷:</strong> {{ order.extraShot }}
          </p>
          <p class="card-text"><strong>얼음 양:</strong> {{ order.ice }}</p>
          <p class="card-text"><strong>금액:</strong> {{ order.price }}</p>
        </div>
      </div>
      <hr class="my-2" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderHistory',
  props: {
    orders: {
      type: Array, // 배열로 지정
      required: true,
    },
  },
};
</script>
