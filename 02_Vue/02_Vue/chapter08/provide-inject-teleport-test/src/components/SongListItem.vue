<template>
  <li>
    <!-- 체크 여부에 따라 이모지 얼굴 변경 -->
    <i :class="song.done ? icons.checked : icons.unchecked"></i>
    {{ song.title }}
  </li>
</template>

<script>
export default {
  name: 'SongListItem',
  inject: ['icons'], // App.vue에서 provide한 속성 주입받기
  props: ['song'], // 하지만 props는 언제나 부모에게만 받을 수 있다. 즉, SongList에서
};
</script>
