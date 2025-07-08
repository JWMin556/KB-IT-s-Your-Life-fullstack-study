<script setup>
import TravelHeader from '@/components/travel/TravelHeader.vue';
import TravelImages from '@/components/travel/TravelImages.vue';
import TravelMap from '@/components/travel/TravelMap.vue';
import { useRoute, useRouter } from 'vue-router';
import api from '@/api/travelApi';
import { ref } from 'vue';

const cr = useRoute();
const router = useRouter();
const no = cr.params.no;
const travel = ref({});

const back = () => {
  router.push({ name: 'travel/list', query: cr.query });
};

const load = async () => {
  travel.value = await api.get(no);
  // 마침표(.)를 기준으로 한 문장당 p태그를 붙인다.
  // 자바의 replace는 몽땅 다 바꾸지만, JS의 replace는 첫번째만 바꿔주도 두번째 것은 안바꿈
  let descriptions = travel.value.description.replace(
    /\. /gm,
    (t) => t + '<p/><p>'
  );
  travel.value.description = `<p>${descriptions}</p>`;
};

load();
</script>

<template>
  <TravelHeader :travel="travel" />
  <div class="content" v-html="travel.description"></div>
  <TravelImages :images="travel.images"></TravelImages>
  <div>
    <i class="fa-solid fa-square-phone-flip"></i> 전화번호: {{ travel.phone }}
  </div>
  <TravelMap :title="travel.title" :address="travel.address" />
  <div class="my-5">
    <button class="btn btn-primary me-2" @click="back">
      <i class="fa-solid fa-list"></i> 목록
    </button>
  </div>
</template>
