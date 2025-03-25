<script>
export default {
  name: 'Statistics',
  props: ['orders'],
  data() {
    return {
      totalCount: 0,
      totalPrice: 0,
      mostFavoriteMenu: '',
      mostFavoriteMenuCount: 0,
      mostChoosedSize: '',
      extraShotRatio: 0,
    };
  },
  watch: {
    orders: {
      handler(newOrders) {
        this.realTimeStatistics(newOrders); // 새로운 주문 배열을 전달
      },
      immediate: true, // 컴포넌트가 마운트될 때 즉시 실행
    },
  },
  methods: {
    realTimeStatistics(newOrders) {
      // 새로운 주문 배열을 사용하여 통계 계산
      this.totalCount = newOrders.length;
      let total = 0;
      const drinkCount = {}; // 음료 이름별 주문 횟수를 저장할 객체
      const sizeCount = {}; // 사이즈별 주문 횟수를 저장할 객체
      const extraShotCount = { total: 0, withExtraShot: 0 }; // 추가 샷 비율 계산을 위한 객체

      for (let order of newOrders) {
        total += order.price;

        // 음료별 주문 횟수 증가
        if (drinkCount[order.drinkName]) {
          drinkCount[order.drinkName]++;
        } else {
          drinkCount[order.drinkName] = 1;
        }

        // 사이즈별 주문 횟수 증가
        if (sizeCount[order.size]) {
          sizeCount[order.size]++;
        } else {
          sizeCount[order.size] = 1;
        }

        // 추가 샷 비율 계산을 위한 로직
        if (order.extraShot) {
          extraShotCount.withExtraShot++;
        }
        extraShotCount.total++;
      }

      this.totalPrice = total;

      // 가장 인기 있는 음료 계산 (빈 배열을 방지)
      this.mostFavoriteMenu =
        Object.keys(drinkCount).length > 0
          ? Object.keys(drinkCount).reduce((a, b) =>
              drinkCount[a] > drinkCount[b] ? a : b
            )
          : ''; // 빈 배열인 경우 기본값 ''
      this.mostFavoriteMenuCount = this.mostFavoriteMenu
        ? drinkCount[this.mostFavoriteMenu]
        : 0;

      // 가장 많이 선택된 사이즈 계산 (빈 배열을 방지)
      this.mostChoosedSize =
        Object.keys(sizeCount).length > 0
          ? Object.keys(sizeCount).reduce((a, b) =>
              sizeCount[a] > sizeCount[b] ? a : b
            )
          : ''; // 빈 배열인 경우 기본값 ''

      // 추가 샷 비율 계산
      if (extraShotCount.total > 0) {
        this.extraShotRatio = (
          (extraShotCount.withExtraShot / extraShotCount.total) *
          100
        ).toFixed(1);
      } else {
        this.extraShotRatio = 0; // 추가 샷이 없을 경우 비율 0으로 설정
      }
    },
  },
};
</script>
