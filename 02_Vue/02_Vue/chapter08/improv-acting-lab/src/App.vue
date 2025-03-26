<template>
  <div class="app-container">
    <h1>improv-acting-lab 🎭</h1>
    <LineReadyButton @ready="handleReady">
      🎭 오늘도 넌 멋질 거야! 자신 있게 무대에 올라가!
    </LineReadyButton>

    <!-- <LineCard v-if="isReadyClicked">
      <template v-slot:tip>TIP: 표정 풍부하게, 발음 또박또박!!</template>
      <template v-slot:image>
        <br />
        <img
          src="https://farm9.static.flickr.com/8147/7531728992_91cbf990f1.jpg"
          alt="사일런트 힐"
        />
      </template>
      <template v-slot:lineLength="p1">
        <br />
        <span v-if="p1.tooLong" style="color: blue; text-decoration: underline">
          대사가 너무 길어요! 천천히 연기해봐여!
        </span>
      </template>
    </LineCard> -->
    <button @click="handleQuiz" class="quiz-button">📝 퀴즈 시작하기</button>
    <LineQuizCard
      v-if="isQuizClicked"
      :quiz="currentQuiz"
      :key="currentQuiz.famousLine"
      @next="nextQuiz"
    >
      <template v-slot:quizTitle>
        {{ currentQuiz.famousLine }}
      </template>
      <template v-slot:quizHint> 힌트: 모두 유명 드라마 속 대사에요! </template>
      <template v-slot:quizOptionList>
        <button
          v-for="(option, index) in currentQuiz.options"
          :key="index"
          class="option-button"
          @click="checkAnswer(index)"
        >
          {{ option }}
        </button>
      </template>
      <template v-slot:quizResult>
        <p v-if="resultMessage">{{ resultMessage }}</p>
      </template>
    </LineQuizCard>
  </div>
</template>

<script>
import LineReadyButton from './components/LineReadyButton.vue';
import LineCard from './components/LineCard.vue';
import LineQuizCard from './components/LineQuizCard.vue';
export default {
  name: 'App',
  components: { LineReadyButton, LineCard, LineQuizCard },
  data() {
    return {
      isReadyClicked: false,
      isQuizClicked: false,
      quizData: [
        {
          famousLine: '한 사람만을 사랑하며 살 거야.',
          options: {
            first: '태양의 후예',
            second: '도깨비',
            third: '응답하라 1988',
            fourth: '비밀의 숲',
          },
          answer: 'first',
        },
        {
          famousLine: '그냥 내가 괜찮다고 말하면 되는 거야?',
          options: {
            first: '김비서가 왜 그럴까',
            second: '사랑의 불시착',
            third: '그냥 사랑하는 사이',
            fourth: '무브 투 헤븐',
          },
          answer: 'second',
        },
        {
          famousLine: '오늘도 너를 사랑해.',
          options: {
            first: '별에서 온 그대',
            second: '호텔 델루나',
            third: '사랑의 불시착',
            fourth: '시그널',
          },
          answer: 'first',
        },
        {
          famousLine: '내가 좋아하는 사람이 나를 좋아하는 게 이상하잖아.',
          options: {
            first: '이태원 클라쓰',
            second: '마이 디스타지',
            third: '응답하라 1988',
            fourth: '도깨비',
          },
          answer: 'third',
        },
        {
          famousLine: '너를 떠날 수 없다고.',
          options: {
            first: '미스터 션샤인',
            second: '비밀의 숲',
            third: '로맨스는 별책부록',
            fourth: '청춘기록',
          },
          answer: 'first',
        },
        {
          famousLine: '내 인생에 어떤 의미가 있을까?',
          options: {
            first: '시그널',
            second: '비밀의 숲',
            third: '밥 잘 사주는 예쁜 누나',
            fourth: '빈센조',
          },
          answer: 'second',
        },
        {
          famousLine: '다시 돌아갈 수 있을까?',
          options: {
            first: '알함브라 궁전의 추억',
            second: '미스터 션샤인',
            third: '응답하라 1988',
            fourth: '도깨비',
          },
          answer: 'first',
        },
        {
          famousLine: '내가 선택한 길이야.',
          options: {
            first: '청춘기록',
            second: '이태원 클라쓰',
            third: '마이 디스타지',
            fourth: '비밀의 숲',
          },
          answer: 'second',
        },
        {
          famousLine: '사랑을 믿어도 될까요?',
          options: {
            first: '사랑의 불시착',
            second: '도깨비',
            third: '호텔 델루나',
            fourth: '이태원 클라쓰',
          },
          answer: 'third',
        },
        {
          famousLine: '우리가 다시 만날 수 있을까?',
          options: {
            first: '별에서 온 그대',
            second: '시그널',
            third: '비밀의 숲',
            fourth: '청춘기록',
          },
          answer: 'first',
        },
      ],
      currentQuizIndex: 0,
      resultMessage: '',
      userAnswer: null,
    };
  },
  // provide() {
  //   return {
  //     lines: [
  //       {
  //         line: '조금은 친절해도 되잖아. 다들 니들처럼 익숙한 게 아니니까.',
  //         source: '청춘시대',
  //       },
  //       {
  //         line: '너와 함께한 시간 모두 눈부셨다. 날이 좋아서 날이 좋지 않아서 날이 적당해서 모든 날이 좋았다.',
  //         source: '도깨비',
  //       },
  //       {
  //         line: '당신이 좋은 이유? 그저 그 사람이라서. 바로 너라서.',
  //         source: '응답하라 1997',
  //       },
  //       {
  //         line: '인생에서 시련 오는 거, 진짜와 가짜를 한 번씩 걸러내라고 하나님이 주신 기회가 아닌가 싶다.',
  //         source: '별에서 온 그대',
  //       },
  //       {
  //         line: '잊지 말자. 나는 어머니의 자부심이다. 모자라고 부족한 자식이 아니다.',
  //         source: '미생',
  //       },
  //     ],
  //   };
  // },
  computed: {
    currentQuiz() {
      return this.quizData[this.currentQuizIndex];
    },
  },
  methods: {
    handleReady(message) {
      this.isReadyClicked = true;
      console.log('대사 준비 완료!');
    },
    handleQuiz() {
      this.isQuizClicked = true;
    },
    checkAnswer(index) {
      this.userAnswer = index;
      if (index === this.currentQuiz.answer) {
        this.resultMessage = '정답입니다!';
      } else {
        this.resultMessage = '오답이에요 ㅠ';
      }
    },
    nextQuiz() {
      this.currentQuizIndex++;
      if (this.currentQuizIndex >= this.quizData.length) {
        this.currentQuizIndex = 0; // 퀴즈가 끝나면 처음으로 돌아감
      }
      this.resultMessage = '';
      this.userAnswer = null;
    },
  },
};
</script>

<style scoped>
.app-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px;
}
h1 {
  font-size: 2.5rem;
  margin-bottom: 20px;
  color: #333;
}
.quiz-button {
  margin-top: 15px;
  background-color: #ca8025;
  color: white;
  padding: 10px 20px;
  font-size: 1rem;
  border: none;
  border-radius: 12px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.quiz-button:hover {
  background-color: #853535;
}

.option-button {
  margin: 5px;
  background-color: #25aeca;
  color: white;
  padding: 10px 20px;
  font-size: 1rem;
  border: none;
  border-radius: 12px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.correct {
  background-color: green;
  color: white;
}
.wrong {
  background-color: red;
  color: white;
}
</style>
