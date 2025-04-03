<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 수정</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일:</label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
        <!-- 사용자 정의 v-model의 연결 -->
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명:</label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <label htmlFor="done">완료여부 : </label>&nbsp;
        <input type="checkbox" v-model="todoItem.done" />
      </div>
      <div class="form-group">
        <!-- 또한 이 버튼들에 disabled로 :class를 놓아서 필수조건을 미완료시 버튼을 비활성화 하는게 좋다 -->
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="updateTodoHandler"
        >
          수정
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취소
        </button>
      </div>
    </div>
  </div>
</template>
<script setup>
import { inject, reactive } from 'vue';
import { useRouter, useRoute } from 'vue-router';
const todoList = inject('todoList');
const { updateTodo } = inject('actions');
const router = useRouter();
const currentRoute = useRoute();
const matchedTodoItem = todoList.value.find(
  (item) => item.id === parseInt(currentRoute.params.id)
);
if (!matchedTodoItem) {
  router.push('/todos');
}
const todoItem = reactive({ ...matchedTodoItem });
const updateTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다');
    return;
  }
  updateTodo({ ...todoItem });
  router.push('/todos');
};

// import { inject, reactive } from 'vue';
// import { useRouter, useRoute } from 'vue-router';
// const todoList = inject('todoList');
// const { updateTodo } = inject('actions');
// const router = useRouter();
// const currentRoute = useRoute();
// const matchedTodoItem = todoList.value.find(
//   // find는 참조를 리턴 (못 찾으면 null리턴), findIndex는 그 index를 리턴 (못찾으면 -1)
//   (item) => item.id === currentRoute.params.id
// );
// if (!matchedTodoItem) {
//   router.push('/todos');
// }
// const todoItem = reactive({ ...matchedTodoItem });
// // 왜 또 ...으로 객체복사? 만약 복사를 안하고 원본 데이터를 그대로 넣으면 중간에 수정안하고 수정해버릴 때, 이미 변경이 완료된다. 저기에 v-model로 연결되었기에
// // 그래서 원본하고 관계성을 끊기위해서 복사본으로 만든 것이다.
// const updateTodoHandler = () => {
//   let { todo } = todoItem;
//   // 이러한 작업들을 유효성 검사라고 한다. 필수항목 체크
//   if (!todo || todo.trim() === '') {
//     alert('할일은반드시입력해야합니다');
//     return;
//   }
//   updateTodo({ ...todoItem }, () => {
//     router.push('/todos');
//   });
// };
</script>

<style scoped></style>
