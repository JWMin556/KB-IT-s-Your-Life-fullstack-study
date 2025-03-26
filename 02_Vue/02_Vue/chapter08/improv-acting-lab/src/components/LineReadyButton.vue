<template>
  <div class="button-container">
    <button @click="handleClick" class="ready-button">대사 준비 완료</button>
    <p class="click-count">버튼을 누른 횟수: {{ clickCount }}회</p>
    <div class="slot-container">
      <slot>여기에 서윤이의 코멘트가 들어갑니다.</slot>
    </div>
  </div>
</template>

<script>
export default {
  name: 'LineReadyButton',
  data() {
    return {
      clickCount: 0,
    };
  },
  methods: {
    handleClick() {
      this.clickCount += 1;
      this.$emit('ready', `대사 준비 완료! (총 ${this.clickCount}회 눌림)`);
    },
  },
};
</script>

<style scoped>
.button-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.ready-button {
  background-color: #ff7675;
  color: white;
  padding: 10px 20px;
  font-size: 1rem;
  border: none;
  border-radius: 12px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.ready-button:hover {
  background-color: #d63031;
}

.click-count {
  font-size: 1rem;
  color: #333;
  margin-top: 10px;
}

.slot-container {
  background-color: #f1f2f6;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  padding: 14px;
  margin-top: 20px;
  max-width: 400px;
  width: 100%;
  text-align: center;
  color: #666;
  font-size: 1rem;
}
</style>
