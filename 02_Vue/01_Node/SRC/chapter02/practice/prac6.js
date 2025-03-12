import { orders } from './orderList.js';
import {
  calculateTotal as total,
  isTopMenu as topMenu,
} from './orderProcessorFor6.js';

console.log(`✅ 총 주문 수량: ${JSON.stringify(total(orders), null)}`);
const answer = topMenu(total(orders), '목살') ? '네!' : '아니오!';
console.log(`🥩 목살이 가장 인기 메뉴인가요? ${answer}`);
