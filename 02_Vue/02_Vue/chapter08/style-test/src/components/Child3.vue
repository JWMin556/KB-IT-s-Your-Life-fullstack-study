<template>
  <div :class="$style.child">
    <h2>Child3</h2>
  </div>
</template>
<script>
export default {
  name: 'Child3',
  created() {
    //돔 연결 안되고 막 컴포넌트만 만들어진 상태
    console.log(this.$style);
  },
};
</script>
<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
