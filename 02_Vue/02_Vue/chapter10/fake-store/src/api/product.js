import axios from 'axios';

const BASE = '/api/products'; // Vite 프록시를 통해 fakestoreapi와 통신

export const get = async (target = '', params = {}) => {
    try {
        const response = await axios.get(`${BASE}/${target}`, {params});
        return response.data;
    } catch (error) {
        console.error('GET 요청 실패:', error);
        throw error;
    }
};

export const post = async (target = '', product) => {
    try {
        const response = await axios.post(`${BASE}/${target}`, product);
        return response.data;
    } catch (error) {
        console.error('POST 요청 실패:', error);
        throw error;
    }
};

export const put = async (target = '', product) => {
    try {
        const response = await axios.put(`${BASE}/${target}`, product);
        return response.data;
    } catch (error) {
        console.error('PUT 요청 실패:', error);
        throw error;
    }
};

export const remove = async (target = '', params = {}) => {
    try {
        const response = await axios.delete(`${BASE}/${target}`, {params});
        return response.data;
    } catch (error) {
        console.error('DELETE 요청 실패:', error);
        throw error;
    }
};
