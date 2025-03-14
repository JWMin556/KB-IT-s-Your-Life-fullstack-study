class Item {
  constructor(name, type, stock, alreadyWarned = false) {
    this.name = name;
    this.type = type;
    this.stock = stock;
    this.alreadyWarned = alreadyWarned;
  }

  printAddedInfo() {
    console.log(`[추가] ${this.type} - ${this.name} (재고: ${this.stock}개)`);
  }

  checkWarning() {
    if (this.stock < 5 && !this.alreadyWarned) {
      this.alreadyWarned = true;
      console.log(
        `[자동 경고] ${this.name}: 재고가 ${this.stock}개 미만입니다!`
      );
    }
  }
}

class InventoryManager {
  constructor() {
    this.items = [];
  }

  addItem(item) {
    this.items.push(item);
    item.printAddedInfo();
  }

  updateStock(itemName, count) {
    const item = this.items.find((i) => i.name === itemName); // 아이템을 찾기
    if (!item) {
      console.log('[업데이트 오류] 아이템을 찾을 수 없습니다.');
      return;
    }

    if (count < 0) {
      console.log('[업데이트 오류] 재고는 0 이상이어야 합니다.');
    } else {
      item.stock = count; // 재고 업데이트
      item.alreadyWarned = false; // 재고 업데이트 후 경고를 리셋
      if (count < 5 && !item.alreadyWarned) {
        console.log(`[재고 부족 경고] ${item.name}: 재고가 5개 미만입니다!`);
      } else {
        console.log(`[업데이트] ${item.name} 재고: ${item.stock}개`);
      }
    }
  }

  checkStock() {
    // 5초 후에 검사 종료 메시지를 출력
    const timeout = setTimeout(() => {
      console.log('[재고 검사 종료]');
    }, 5000);

    // 1초마다 재고 상태를 검사
    const interval = setInterval(() => {
      // 배열에 있는 모든 아이템에 대해 checkWarning() 호출
      this.items.forEach((item) => item.checkWarning());
    }, 1000);

    // 5초 후에 검사 종료
    setTimeout(() => {
      clearInterval(interval); // 5초 후에 검사를 종료합니다.
    }, 5000);
  }
}

// 🐾 시스템 사용 예시
const inventory = new InventoryManager();

// 아이템 등록
const item1 = new Item('고급 고양이 사료', '사료', 10);
inventory.addItem(item1);

// 재고 업데이트
inventory.updateStock('고급 고양이 사료', 4); // 5개 미만 → 경고 발생
inventory.updateStock('고급 고양이 사료', -1); // 음수 입력 → 오류 발생

// 재고 상태 검사 시작 (5초 후 종료)
inventory.checkStock();
