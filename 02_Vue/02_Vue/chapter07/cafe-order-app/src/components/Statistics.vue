<template>
    <div class="stats-container">
        <h3>📊 주문 통계</h3>
        <p><strong>총 주문 횟수:</strong> {{ totalOrders }}회</p>
        <p><strong>총 매출:</strong> {{ totalRevenue.toLocaleString() }}원</p>
        <p><strong>가장 인기 있는 음료:</strong> {{ mostPopularDrink }}</p>
        <p><strong>가장 많이 선택된 사이즈:</strong> {{ mostPopularSize }}</p>
        <p><strong>추가 샷 비율:</strong> {{ extraShotPercentage }}%</p>
    </div>
</template>

<script>
export default {
    props: {
        orders: {
            type: Array,
            required: true,
        },
    },
    computed: {
        totalOrders() {
            return this.orders.length;
        },
        totalRevenue() {
            return this.orders.reduce((sum, order) => sum + order.price, 0);
        },
        mostPopularDrink() {
            if (this.orders.length === 0) return '없음';
            const drinkCounts = this.orders.reduce((acc, order) => {
                acc[order.drinkName] = (acc[order.drinkName] || 0) + 1;
                return acc;
            }, {});
            const maxDrink = Object.keys(drinkCounts).reduce((a, b) => (drinkCounts[a] > drinkCounts[b] ? a : b));
            return `${maxDrink} (${drinkCounts[maxDrink]}회)`;
        },
        mostPopularSize() {
            if (this.orders.length === 0) return '없음';
            const sizeCounts = this.orders.reduce((acc, order) => {
                acc[order.size] = (acc[order.size] || 0) + 1;
                return acc;
            }, {});
            return Object.keys(sizeCounts).reduce((a, b) => (sizeCounts[a] > sizeCounts[b] ? a : b));
        },
        extraShotPercentage() {
            if (this.orders.length === 0) return 0;
            const extraShotCount = this.orders.filter((order) => order.extraShot).length;
            return ((extraShotCount / this.orders.length) * 100).toFixed(0);
        },
    },
};
</script>

<style scoped>
.stats-container {
    background-color: #eaf7e4;
    border: 1px solid #c3e6cb;
    padding: 15px;
    border-radius: 8px;
    margin-top: 15px;
}
</style>
