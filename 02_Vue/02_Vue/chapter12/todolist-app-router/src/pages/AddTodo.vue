<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <!-- 보면 유사한 형태가 반복되므로 이들은 컴포넌트화 하는게 더 좋다 -->
      <div class="form-group">
        <label htmlFor="todo">할일 :</label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명 :</label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추 가
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취 소
        </button>
      </div>
    </div>
  </div>
</template>
<script setup>
// import { inject, reactive } from 'vue';
// import { useRouter } from 'vue-router';
// const router = useRouter();
// const { addTodo } = inject('actions');
// const todoItem = reactive({ todo: '', desc: '' });

// // 다른 페이지에서는 inject로 얻은 함수를 직접사용했으나, 여기서는 별도로 함수를 만들고 그 안에서 addTodo를 사용한다

// const addTodoHandler = () => {
//   let { todo } = todoItem;
//   if (!todo || todo.trim() === '') {
//     // 필수항목을 체크한다.
//     alert('할일은 반드시 입력해야 합니다');
//     return;
//   }
//   addTodo({ ...todoItem }, () => {
//     // 왜 addTodo(todoItem)으로 안했을까? 그것은 ...을 통해 객체의 복사를 사용했기 때문이다.
//     // todoItem은 reactice로 선언되었기에 proxy데이터가 포함된 객체이다. [{} , {}, ... proxy]
//     // 그렇기에 순수한 데이터 객체로 만들고 그 녀석만 add하기 위해서 ...todoItem을 사용한다.

//     router.push('/todos'); //이 녀석은 콜백이다. 콜백으로 페이지 이동한다
//     // addTodo가 이제는 비동기 호출이기에 async, await 때문에 비동기호출임을 감안해서 콜백함수를 넣어줘야 하는 것이다.
//   });
// };

import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';
const router = useRouter();
const { addTodo } = inject('actions');
const todoItem = reactive({ todo: '', desc: '' });
const addTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다');
    return;
  }
  addTodo({ ...todoItem });
  router.push('/todos');
};
</script>

<style scoped></style>
