<template>
    <div v-if="visible" class="modal-overlay">
        <div class="modal-container">
            <span class="movie-icon">🎥</span>
            <input v-model="newMovie.title" placeholder="제목" />
            <input v-model="newMovie.year" placeholder="연도" />
            <input v-model="newMovie.director" placeholder="감독" />
            <textarea v-model="newMovie.description" placeholder="줄거리"></textarea>
            <input v-model="newMovie.poster" placeholder="포스터 이미지 URL" />

            <div class="button-group">
                <button @click="addMovie" class="submit-btn">등록</button>
                <button @click="$emit('close')" class="close-btn">닫기</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import {ref} from 'vue';
import axios from 'axios';

const props = defineProps({visible: Boolean});
const emit = defineEmits(['movie-added', 'close']);

const newMovie = ref({
    title: '',
    year: '',
    director: '',
    description: '',
    poster: '',
});

const addMovie = async () => {
    if (!newMovie.value.title || !newMovie.value.year || !newMovie.value.director) {
        alert('모든 필드를 입력해주세요!');
        return;
    }

    try {
        await axios.post('http://localhost:3000/movies', newMovie.value);
        emit('movie-added');
        emit('close');
        newMovie.value = {title: '', year: '', director: '', description: '', poster: ''};
    } catch (error) {
        console.error('영화 추가 오류:', error);
        alert('영화를 추가하는 중 오류가 발생했습니다.');
    }
};
</script>

<style scoped>
/* 모달 배경 */
.modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.7);
    display: flex;
    justify-content: center;
    align-items: center;
}

/* 모달 컨테이너 */
.modal-container {
    background: white;
    padding: 30px;
    border-radius: 10px;
    width: 400px;
    display: flex;
    flex-direction: column;
    gap: 10px;
    position: relative;
}

/* 영화 아이콘 */
.movie-icon {
    font-size: 30px;
    text-align: center;
    display: block;
    margin-bottom: 10px;
}

/* 입력 필드 */
input,
textarea {
    width: 100%;
    padding: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 16px;
}

/* 텍스트 입력 필드 */
textarea {
    resize: none;
    height: 60px;
}

/* 버튼 그룹 */
.button-group {
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
}

/* 등록 버튼 */
.submit-btn {
    background-color: yellow;
    color: black;
    font-size: 16px;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    flex: 1;
    margin-right: 5px;
}

/* 닫기 버튼 */
.close-btn {
    background-color: yellow;
    color: black;
    font-size: 16px;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    flex: 1;
    margin-left: 5px;
}
</style>
