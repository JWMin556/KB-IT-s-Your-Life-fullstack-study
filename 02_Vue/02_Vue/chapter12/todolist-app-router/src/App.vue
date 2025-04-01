<template>
    <div class="container">
        <Header />
        <router-view />
        <Loading v-if="states.isLoading" />
    </div>
</template>
<script setup>
import {reactive, computed, provide} from 'vue';
import Header from '@/components/Header.vue';
import Loading from '@/components/Loading.vue';

import axios from 'axios';
const BASEURI = '/api/todos';
const states = reactive({todoList: []});
// const states = reactive({
//     todoList: [
//         {id: 1, todo: 'ES6학습', desc: '설명1', done: false},
//         {id: 2, todo: 'React학습', desc: '설명2', done: false},
//         {id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true},
//         {id: 4, todo: '야구경기 관람', desc: '설명4', done: false},
//     ],
// });

//TodoList목록을조회합니다.
const fetchTodoList = async () => {
    states.isLoading = true;
    try {
        const response = await axios.get(BASEURI);
        if (response.status === 200) {
            states.todoList = response.data;
        } else {
            alert('데이터조회실패');
        }
    } catch (error) {
        alert('에러발생:' + error);
    }
    states.isLoading = false;
};

// const addTodo = ({todo, desc}) => {
//     states.todoList.push({id: new Date().getTime(), todo, desc, done: false});
// };

// 새로운 TodoItem을 추가합니다.
const addTodo = async ({todo, desc}, successCallback) => {
    states.isLoading = true;
    try {
        const payload = {todo, desc};
        const response = await axios.post(BASEURI, payload);
        if (response.status === 201) {
            states.todoList.push({...response.data, done: false});
            successCallback();
        } else {
            alert('Todo 추가 실패');
        }
    } catch (error) {
        alert('에러발생 :' + error);
    }
    states.isLoading = false;
};

// const updateTodo = ({id, todo, desc, done}) => {
//     let index = states.todoList.findIndex((todo) => todo.id === id);
//     states.todoList[index] = {...states.todoList[index], todo, desc, done};
// };

// 기존 TodoItem을 변경합니다.
const updateTodo = async ({id, todo, desc, done}, successCallback) => {
    states.isLoading = true;
    try {
        const payload = {id, todo, desc, done};
        const response = await axios.put(BASEURI + `/${id}`, payload);
        if (response.status === 200) {
            let index = states.todoList.findIndex((todo) => todo.id === id);
            states.todoList[index] = payload;
            successCallback();
        } else {
            alert('Todo 변경 실패');
        }
    } catch (error) {
        alert('에러발생 :' + error);
    }
    states.isLoading = false;
};

// const deleteTodo = (id) => {
//     let index = states.todoList.findIndex((todo) => todo.id === id);
//     states.todoList.splice(index, 1);
// };

//기존 TodoItem을 삭제합니다.
const deleteTodo = async (id) => {
    states.isLoading = true;
    try {
        const response = await axios.delete(BASEURI + `/${id}`);
        console.log(response.status, response.data);
        if (response.status === 200) {
            let index = states.todoList.findIndex((todo) => todo.id === id);
            states.todoList.splice(index, 1);
        } else {
            alert('Todo 삭제 실패');
        }
    } catch (error) {
        alert('에러발생 :' + error);
    }
    states.isLoading = false;
};

// const toggleDone = (id) => {
//     let index = states.todoList.findIndex((todo) => todo.id === id);
//     states.todoList[index].done = !states.todoList[index].done;
// };

//기존 TodoItem의 완료여부(done) 값을 토글합니다.
const toggleDone = async (id) => {
    states.isLoading = true;
    try {
        let todo = states.todoList.find((todo) => todo.id === id);
        let payload = {...todo, done: !todo.done};
        const response = await axios.put(BASEURI + `/${id}`, payload);
        if (response.status === 200) {
            todo.done = payload.done;
        } else {
            alert('Todo 완료 변경 실패');
        }
    } catch (error) {
        alert('에러발생 :' + error);
    }
    states.isLoading = false;
};

provide(
    'todoList',
    computed(() => states.todoList)
);
provide('actions', {addTodo, deleteTodo, toggleDone, updateTodo, fetchTodoList});

fetchTodoList();
</script>

<style scoped></style>
