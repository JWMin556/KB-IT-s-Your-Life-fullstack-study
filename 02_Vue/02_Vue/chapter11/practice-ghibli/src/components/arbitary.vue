<template>
  <div class="container py-5">
    <div class="text-center mb-4">
      <h2 class="fw-bold">💸 지갑 입금 / 출금 애니메이션</h2>
    </div>

    <div class="wallet-wrapper d-flex justify-content-center mb-4">
      <div class="wallet" :class="{ open: isOpen }">
        <div class="cash-slot">
          <div
            v-for="(bill, index) in bills"
            :key="bill.id"
            class="bill"
            :class="[bill.type, { show: bill.show }]"
          ></div>
        </div>
      </div>
    </div>

    <div class="row justify-content-center mb-3">
      <div class="col-md-3">
        <label class="form-label">만원:</label>
        <input
          type="number"
          class="form-control"
          v-model.number="tenInput"
          min="0"
        />
      </div>
      <div class="col-md-3">
        <label class="form-label">천원:</label>
        <input
          type="number"
          class="form-control"
          v-model.number="oneInput"
          min="0"
        />
      </div>
    </div>

    <div class="d-flex justify-content-center gap-3">
      <button class="btn btn-success px-4" @click="deposit">입금</button>
      <button class="btn btn-danger px-4" @click="withdraw">출금</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const isOpen = ref(false);
const bills = ref([]);

const tenInput = ref(0);
const oneInput = ref(0);

const deposit = () => {
  isOpen.value = true;
  const newBills = [];
  let delay = 0;

  setTimeout(() => {
    for (let i = 0; i < tenInput.value; i++) {
      const id = Date.now() + Math.random();
      newBills.push({ id, type: 'ten', show: false });
      setTimeout(() => {
        bills.value.push({ id, type: 'ten', show: true });
      }, delay);
      delay += 100;
    }

    for (let i = 0; i < oneInput.value; i++) {
      const id = Date.now() + Math.random();
      newBills.push({ id, type: 'one', show: false });
      setTimeout(() => {
        bills.value.push({ id, type: 'one', show: true });
      }, delay);
      delay += 100;
    }
  }, 300);
};

const withdraw = () => {
  isOpen.value = true;
  setTimeout(() => {
    removeBills('ten', tenInput.value);
    setTimeout(() => {
      removeBills('one', oneInput.value);
    }, tenInput.value * 100);
  }, 300);
};

const removeBills = (type, count) => {
  let removed = 0;
  for (let i = 0; i < bills.value.length && removed < count; i++) {
    if (bills.value[i].type === type) {
      const id = bills.value[i].id;
      const index = bills.value.findIndex((b) => b.id === id);
      if (index !== -1) {
        const bill = bills.value[index];
        bill.show = false;
        setTimeout(() => bills.value.splice(index, 1), 400);
        removed++;
      }
    }
  }
};
</script>

<style scoped>
.wallet-wrapper {
  perspective: 1000px;
}

.wallet {
  width: 300px;
  height: 0;
  background: #7b4b2a;
  border-radius: 16px;
  position: relative;
  overflow: hidden;
  transition: height 0.5s ease;
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.4);
}

.wallet.open {
  height: 220px;
}

.cash-slot {
  position: absolute;
  bottom: 10px;
  width: 100%;
  display: flex;
  flex-direction: column-reverse;
  align-items: center;
  justify-content: flex-end;
}

.bill {
  width: 140px;
  height: 60px;
  background-size: cover;
  background-position: center;
  transform: translateY(-200px);
  opacity: 0;
  transition: transform 0.4s ease, opacity 0.4s ease;
  border-radius: 6px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
  margin-top: -30px;
}

.bill.show {
  transform: translateY(0);
  opacity: 1;
}

.bill.ten {
  background-image: url('https://i.namu.wiki/i/Y9X3H_PKS4MvmAd6k8IingwY_q_1PtLJtBXqSSKEmoQb55IPA1VkoQi9_65Po2tOwVyHOisXjPosRZG4uzdY2A.webp');
}

.bill.one {
  background-image: url('https://i.namu.wiki/i/iGdUeTXCru6yZny0sJ7rCG7gGN8kxQgU2_nMBMokI7DhBBk2brKvmjV2bEYn-ch2mg4ybpUA9KukPsr8Ub7ZPQ.webp');
}
</style>
