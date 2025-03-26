<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은?(첫번째:Slot사용(X))</h3>
    <!-- id, label, checked는 props, check-changed는 emit -->
    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @check-changed="CheckBoxChanged"
    >
    </CheckBox1>
  </div>
</template>
<script>
import CheckBox1 from './CheckBox1.vue';

export default {
  name: 'NoSlotTest',
  components: { CheckBox1 },
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' },
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      // 받아온 객체의 id를 items 배열에서 찾아서 일치하는 객체 반환
      let item = this.items.find((item) => item.id === e.id);
      // 찾은 객체의 checked를 받아온 값으로 변경
      item.checked = e.checked;
    },
  },
};
</script>
