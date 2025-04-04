import axios from 'axios';
import { defineStore } from 'pinia';
import { computed, reactive } from 'vue';

export const useMatchStore = defineStore('match', () => {
  const MATCHURL = 'http://localhost:3000/matches';
  const SavedResultsURL = 'http://localhost:3000/savedResults';
  const state = reactive({
    mbtiList: [
      'ISTJ',
      'ISFJ',
      'INFJ',
      'INTJ',
      'ISTP',
      'ISFP',
      'INFP',
      'INTP',
      'ESTP',
      'ESFP',
      'ENFP',
      'ENTP',
      'ESTJ',
      'ESFJ',
      'ENFJ',
      'ENTJ',
    ],
    matchData: [], // 데이터를 저장할 배열
  });

  const mbtiList = computed(() => state.mbtiList);

  const fetchMatchData = async () => {
    try {
      const response = await axios.get(MATCHURL);
      state.matchData = response.data; // API 응답으로 matchData 설정
    } catch (error) {
      console.log('에러: ', error);
    }
  };

  // myMBTI와 friendMBTI를 통해 결과를 찾는 액션
  const getCompatibility = (myMBTI, friendMBTI) => {
    const match = state.matchData.find(
      (item) => item.myMBTI === myMBTI && item.friendMBTI === friendMBTI
    );

    if (match) {
      return {
        result: match.result,
        compatibility: match.compatibility,
      };
    } else {
      return {
        result: '해당 MBTI 조합에 대한 결과가 없습니다.',
        compatibility: 0,
      };
    }
  };

  const postCompatibility = (myMBTI, friendMBTI, result, compatibility) => {};

  return { mbtiList, fetchMatchData, getCompatibility };
});
