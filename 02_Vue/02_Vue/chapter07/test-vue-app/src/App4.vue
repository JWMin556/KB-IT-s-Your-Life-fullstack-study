<template>
  <div>
    <!-- 자식에서 보낸 이벤트 명을 @에 주고 그 후에 이 vue파일에서 사용하는 함수와 연결한다 -->
    <!-- <InputName @nameChanged="nameChangedHandler" /> -->
    <InputName2 @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터: {{ parentName }}</h3>
  </div>
</template>
<script>
import InputName from './components/InputName.vue';
import InputName2 from './components/InputName2.vue';
export default {
  name: 'App',
  components: { InputName, InputName2 }, // 이 components에 등록해야 한다.
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    nameChangedHandler(e) {
      this.parentName = e.name; //아까 객체인 {name}으로 넘겨주었기에 여기서도 객체로 받기위한 event를 사용
    },
  },
};
</script>
