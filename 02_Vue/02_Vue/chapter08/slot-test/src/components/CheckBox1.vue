<template>
  <div>
    <!-- change는 input값이 바뀔 때 발생한다 -->
    <!-- id와 checked는 부모에게서 받아온 props로 -->
    <!-- input이 변경될 때, check-changed라는 이벤트에 id와 현재 input 체크 여부를 담아서 부모에게 전송 -->
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 가장 최신의 checked를 보내주기 위해서 event.target.chekced를 해준 것 -->
    <!-- 체크 여부에 따라서 span의 스타일이 변경됨 -->
    <span
      v-if="checked === true"
      style="color: blue; text-decoration: underline"
    >
      <i>{{ label }}</i>
    </span>
    <span v-else style="color: gray">{{ label }}</span>
  </div>
</template>

<script>
export default {
  name: 'CheckBox1',
  props: ['id', 'checked', 'label'],
};
</script>
