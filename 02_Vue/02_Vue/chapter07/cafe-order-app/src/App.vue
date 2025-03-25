<template>
    <div class="container my-4">
        <h1 class="mb-4">카페 주문 앱</h1>

        <!-- 메뉴 선택 -->
        <h3 class="mb-3">메뉴 선택</h3>
        <div class="row">
            <MenuList
                @chooseMenu="chooseMenuHandler"
                v-for="menu in menus"
                :key="menu.name"
                :menu="menu"
                class="col-md-3 mb-3"
            />
        </div>

        <!-- 선택한 메뉴 표시 -->
        <div v-if="selectedMenu" class="alert alert-info">
            <h5>선택한 음료: {{ selectedMenu.name }}</h5>
        </div>

        <!-- DrinkOptions 컴포넌트 -->
        <DrinkOptions
            v-if="selectedMenu"
            :selectedDrink="selectedMenu"
            @options-changed="handleOptionsChanged"
            class="mt-4"
        />

        <!-- 현재 선택 옵션 -->
        <div v-if="isSelectedoption" class="alert alert-secondary mt-4">
            <h5 class="mb-3">현재 선택한 옵션</h5>
            <ul class="list-unstyled">
                <li><strong>사이즈:</strong> {{ selectedoption.size }}</li>
                <li>
                    <strong>추가샷:</strong>
                    {{ selectedoption.extraShot ? '예' : '아니오' }}
                </li>
                <li><strong>얼음 양:</strong> {{ selectedoption.ice }}</li>
            </ul>
        </div>

        <OrderSummary
            :drink="selectedMenu"
            :optionData="selectedoption"
            v-if="selectedMenu && isSelectedoption"
            @place-order="handlePlaceOrder"
        />

        <div class="bg-light p-3 rounded mt-3">
            <h3>📜 주문 내역</h3>
            <OrderHistory v-if="orderHistory.length !== 0" :orders="orderHistory" />
            <p v-else>주문 내역이 없습니다.</p>
        </div>

        <!-- 통계 보기/숨기기 버튼 -->
        <button v-if="orderHistory.length > 0" @click="showStats = !showStats" class="toggle-btn">
            {{ showStats ? '통계 숨기기' : '통계 보기' }}
        </button>

        <!-- Statistics 컴포넌트 -->
        <Statistics v-if="showStats" :orders="orderHistory" />
    </div>
</template>

<script>
import MenuList from './components/MenuList.vue';
import DrinkOptions from './components/DrinkOptions.vue';
import OrderSummary from './components/OrderSummary.vue';
import OrderHistory from './components/OrderHistory.vue';
import Statistics from './components/Statistics.vue';

export default {
    name: 'App',
    components: {
        MenuList,
        DrinkOptions,
        OrderSummary,
        OrderHistory,
        Statistics,
    },
    data() {
        return {
            selectedMenu: '',
            menus: [
                {name: '아메리카노', price: 4000},
                {name: '카페라떼', price: 4500},
                {name: '바닐라라떼', price: 4800},
                {name: '콜드브루', price: 5000},
            ],
            isSelectedoption: false,
            selectedoption: {
                size: '',
                extraShot: '',
                ice: '',
            },
            orderHistory: [],
            showStats: false, // 추가
        };
    },
    methods: {
        chooseMenuHandler(menu) {
            this.selectedMenu = menu;
        },
        handleOptionsChanged(options) {
            this.isSelectedoption = true;
            this.selectedoption.size = options.size;
            this.selectedoption.extraShot = options.extraShot;
            this.selectedoption.ice = options.ice;
        },
        handlePlaceOrder() {
            alert(`${this.selectedMenu.name} 주문이 완료되었습니다!`);
            const orderList = {
                time: new Date().toLocaleString(),
                drinkName: this.selectedMenu.name,
                size: this.selectedoption.size,
                extraShot: this.selectedoption.extraShot,
                ice: this.selectedoption.ice,
                price: this.selectedMenu.price,
            };
            this.orderHistory.unshift(orderList);
        },
    },
};
</script>

<style scoped>
.toggle-btn {
    background-color: #8fbc8f;
    color: white;
    padding: 10px 20px;
    border-radius: 6px;
    border: none;
    cursor: pointer;
    margin-top: 10px;
}

.toggle-btn:hover {
    background-color: #78a678;
}
</style>
