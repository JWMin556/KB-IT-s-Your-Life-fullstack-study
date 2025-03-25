<template>
  <div
    class="card"
    style="
      background-color: #fffaf0;
      border: 1px solid #d2b48c;
      padding: 20px;

      margin: auto;
    "
  >
    <h3 class="text-center">🧾 주문 내역서</h3>
    <p><strong>주문 시간:</strong> {{ currentDateTime }}</p>
    <hr />
    <p><strong>음료:</strong> {{ drink.name }}</p>
    <p><strong>사이즈:</strong> {{ optionData.size }}</p>
    <p><strong>추가 샷:</strong> {{ optionData.extraShot }}</p>
    <p><strong>얼음 양:</strong> {{ optionData.ice }}</p>
    <hr />
    <p><strong>결제 금액:</strong> {{ drink.price }}원</p>
    <button
      @click="$emit('place-order')"
      class="btn btn-outline-warning btn-block"
    >
      주문 확정하기
    </button>
  </div>
</template>

<script>
export default {
  name: 'OrderSummary',
  props: ['drink', 'optionData'],
  computed: {
    currentDateTime() {
      const now = new Date();
      const hours = now.getHours();
      const minutes = now.getMinutes().toString().padStart(2, '0');
      const seconds = now.getSeconds().toString().padStart(2, '0');
      const day = now.getDate().toString().padStart(2, '0');
      const month = (now.getMonth() + 1).toString().padStart(2, '0');
      const year = now.getFullYear();

      const ampm = hours >= 12 ? '오후' : '오전';
      const displayHour = hours % 12 || 12;

      return `${year}-${month}-${day} ${ampm} ${displayHour}:${minutes}:${seconds}`;
    },
  },
};
</script>

<style scoped>
/* 카드 내용의 텍스트 스타일 */
.card p {
  font-size: 1rem;
  margin: 8px 0;
}

.card button {
  margin-top: 20px;
}
</style>
