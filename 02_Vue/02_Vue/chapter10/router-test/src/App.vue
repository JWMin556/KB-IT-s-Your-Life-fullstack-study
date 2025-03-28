<template>
  <div class="container">
    <Header />
    <router-view></router-view>
  </div>
</template>

<script>
import Header from '@/components/Header.vue';
import { provide } from 'vue';
import videos from '@/videos.json';
export default {
  name: 'App',
  components: { Header },
  setup() {
    //하위 컴포넌트에서 videos 배열 모두 사용할 수 있도록 provide
    provide('videos', videos);
  },
};
</script>
<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css');
.container {
  text-align: center;
  margin-top: 10px;
}
.fa {
  padding: 5px;
  width: 30px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}
.fa-facebook {
  background: #3b5998;
  color: white;
}
.fa-youtube {
  background: #bb0000;
  color: white;
}
.fa-instagram {
  background: #125688;
  color: white;
}
</style>
