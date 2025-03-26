<template>
  <ul>
    <!-- songs를 App.vue에서 받아와서 하나씩 song이란 props로 SongListItem에 전달 -->
    <SongListItem v-for="s in songs" :key="s.id" :song="s" />
  </ul>
  <!-- computed된 값이므로 데이터 변경시 바로 전달 -->
  <div>체크된 곡 수 : {{ doneCount }}</div>
</template>

<script>
import SongListItem from './SongListItem.vue';
export default {
  name: 'SongList',
  components: {
    SongListItem,
  },
  props: ['songs'],
  inject: ['doneCount'],
};
</script>
