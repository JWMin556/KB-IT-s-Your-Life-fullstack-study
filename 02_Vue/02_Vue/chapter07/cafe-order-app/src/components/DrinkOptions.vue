<script>
export default {
  name: 'DrinkOptions',
  props: ['selectedDrink'],
  data() {
    return {
      size: '',
      extraShot: false, // true/false로 설정
      ice: '보통',
    };
  },
  watch: {
    size(newValue) {
      this.emitOptionsChanged();
    },
    extraShot(newValue) {
      this.emitOptionsChanged();
    },
    ice(newValue) {
      this.emitOptionsChanged();
    },
  },
  methods: {
    emitOptionsChanged() {
      this.$emit('options-changed', {
        size: this.size,
        extraShot: this.extraShot,
        ice: this.ice,
      });
    },
  },
};
</script>

<template>
  <div class="alert alert-info">
    <h3>{{ selectedDrink }} 옵션 선택</h3>

    <div class="form-group">
      <label>사이즈</label>
      <div class="form-check">
        <input
          type="radio"
          id="sizeSmall"
          class="form-check-input"
          v-model="size"
          value="Small"
        />
        <label class="form-check-label" for="sizeSmall">Small</label>
      </div>
      <div class="form-check">
        <input
          type="radio"
          id="sizeMedium"
          class="form-check-input"
          v-model="size"
          value="Medium"
        />
        <label class="form-check-label" for="sizeMedium">Medium</label>
      </div>
      <div class="form-check">
        <input
          type="radio"
          id="sizeLarge"
          class="form-check-input"
          v-model="size"
          value="Large"
        />
        <label class="form-check-label" for="sizeLarge">Large</label>
      </div>
    </div>

    <div class="form-group">
      <div class="form-check">
        <input
          type="checkbox"
          id="extraShot"
          class="form-check-input"
          v-model="extraShot"
        />
        <label class="form-check-label" for="extraShot">샷 추가</label>
      </div>
    </div>

    <div class="form-group">
      <label for="iceAmount">얼음 양</label>
      <select
        class="form-control"
        v-model="ice"
        id="iceAmount"
        name="ice-amount"
      >
        <option value="적게">적게</option>
        <option value="보통">보통</option>
        <option value="많이">많이</option>
      </select>
    </div>
  </div>
</template>

<style scoped>
/* 추가 스타일이 필요하면 여기에 작성하세요 */
</style>
