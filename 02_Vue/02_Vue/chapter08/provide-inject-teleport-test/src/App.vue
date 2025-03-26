<template>
  <div>
    <h2>최신 인기곡</h2>
    <SongList :songs="songs" />
    <br />
    <br />
    <button @click="changeModal">Teleport를 이용한 Modal 기능</button>
    <!-- id가 modal인 영역을 찾아서 isModal값에 의해 보여주기 -->
    <teleport to="#modal">
      <Modal v-if="isModal" />
    </teleport>
  </div>
</template>

<script>
import { computed } from 'vue';
import SongList from './components/SongList.vue';
import Modal from './components/Modal.vue';

export default {
  name: 'App',
  components: { SongList, Modal },
  data() {
    return {
      songs: [
        { id: 1, title: 'Blueming', done: true },
        { id: 2, title: 'Dynamite', done: true },
        { id: 3, title: 'Lovesick Girls', done: false },
        { id: 4, title: '마리아(Maria)', done: false },
      ],
      isModal: false,
    };
  },
  methods: {
    changeModal() {
      this.isModal = true;
      setTimeout(() => {
        this.isModal = false; //2초후 모달 사라짐
      }, 2000);
    },
  },

  // provide는 하위 요소 어디든 주입받을 수 있도록 상위요소에서 제공한다
  provide() {
    return {
      icons: {
        checked: 'far fa-check-circle',
        unchecked: 'far fa-circle',
      },
      // songs 배열 중 done이 true인 곡의 길이 계산
      doneCount: computed(() => {
        return this.songs.filter((s) => s.done === true).length;
      }),
    };
  },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css');
</style>
