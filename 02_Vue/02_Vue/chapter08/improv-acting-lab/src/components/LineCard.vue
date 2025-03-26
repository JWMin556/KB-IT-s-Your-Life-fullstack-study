<template>
  <div class="line-card-container">
    <p class="line-text">"{{ currentLine }}"</p>
    <p v-if="currentLineSource" class="line-source">
      출처: {{ currentLineSource }}
    </p>
    <button @click="handleClick" class="random-button">랜덤 대사 뽑기</button>
    <p class="daily-quote">오늘의 즉흥 대사입니다.</p>
    <slot name="tip" class="tip-slot"></slot>
    <slot name="image" class="image-slot"></slot>
    <slot
      name="lineLength"
      :tooLong="computeLength"
      class="line-length-slot"
    ></slot>
  </div>
</template>

<script>
export default {
  name: 'LineCard',
  data() {
    return {
      isClicked: false,
      currentLine: '아직 대사가 없습니다. 버튼을 눌러주세요!',
      currentLineSource: '',
    };
  },
  computed: {
    computeLength() {
      console.log('지금 대사의 길이: ', this.currentLine.length);
      return this.currentLine.length >= 50 ? true : false;
    },
  },
  methods: {
    handleClick() {
      const randomIndex = Math.floor(Math.random() * this.lines.length);
      this.currentLine = this.lines[randomIndex].line;
      this.currentLineSource = this.lines[randomIndex].source;
    },
  },
  inject: ['lines'],
};
</script>

<style scoped>
.line-card-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #ffffff;
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  margin-top: 30px;
  max-width: 500px;
  width: 100%;
  text-align: center;
}

.line-text {
  font-size: 1.25rem;
  color: #333;
  margin-bottom: 15px;
}

.line-source {
  font-size: 1rem;
  color: #777;
  margin-bottom: 20px;
}

.random-button {
  background-color: #3956a7;
  color: white;
  padding: 10px 20px;
  font-size: 1rem;
  border: none;
  border-radius: 12px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.daily-quote {
  font-size: 1.1rem;
  color: #666;
  margin-top: 15px;
  margin-bottom: 15px;
}

.image-slot {
  margin-top: 20px;
}

.line-length-slot {
  margin-top: 15px;
  font-size: 1rem;
  color: #007acc;
  font-weight: bold;
}
</style>
