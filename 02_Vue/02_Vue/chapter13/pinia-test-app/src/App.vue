<!-- <template>
  {{ store.count }} / {{ store.doubleCount }} <br />
  {{ count }}
</template>

<script setup>
import { computed } from 'vue';
import { useCounterStore } from '@/stores/counter.js';
const store = useCounterStore();
// const { count, increment } = store; // 분해 할당을 통해 가능하다. 즉, const count = store.count와 같음. 그렇기에 그냥 숫자가 되어버린다. proxy가 아님. 반응성을 잃어버림. 그래서 computed로 또 받아야 한다는 것이다.
const { increment } = store;
const count = computed(() => store.count);
increment();
// 즉, 함수를 꺼낼때는 분해할당을 해도 문제없으나 일반 변수는 computed를 통해 할당하거나 store.count같이 store를 직접 써줘야 한다.
console.log(count);
</script> -->

<template>
  <div>
    <h2>TodoList 테스트(Composition API)</h2>
    <hr />
    할일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script setup>
import { useTodoListStore } from '@/stores/todoList.js';
import { ref, computed } from 'vue';

const todo = ref('');

const todoListStore = useTodoListStore();
// 필요한 값들만 객체 구조 분해로 스토어에서 꺼냄
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;
// 기본 타입은 계산된 속성이라면 다시 computed로 작성해야 함

const doneCount = computed(() => todoListStore.doneCount); // 기본 타입에 대해서는 계산된 속성을 다시 작성

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};
</script>
