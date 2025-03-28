<template>
  <div className="mt-5">
    <img :src="member.photo" class="img" />
    <h4 class="mt-2">{{ member.name }}({{ member.role }})</h4>
    <p>{{ member.desc }}</p>
    <!-- 외부 사이트와 연결이기에 a태그를 사용한 것이다 -->
    <!-- 그리고 그 정보가 있는 경우에만 링크를 생성한다 -->
    <a
      v-if="member.insta && member.insta !== ''"
      class="fa fa-instagram m-1"
      :href="member.insta"
    ></a>
    <a
      v-if="member.facebook && member.facebook !== ''"
      class="fa fa-facebook m-1"
      :href="member.facebook"
    ></a>
    <a
      v-if="member.youtube && member.youtube !== ''"
      class="fa fa-youtube m-1"
      :href="member.youtube"
    ></a>
    <br /><br />
    <router-link :to="{ name: 'members' }">멤버 목록으로</router-link>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';
import members from '@/members.json';

export default {
  name: 'MemberInfo',
  setup() {
    const currentRoute = useRoute();
    // 경로 내의 데이터는 문자열이기 때문에 파싱이 필요
    const id = parseInt(currentRoute.params.id, 10);
    // 경로에 있는 아이디와 일치하는 데이터를 json에서 찾는다.
    const member = members.find((m) => m.id === id);

    return { member };
  },
};
</script>
