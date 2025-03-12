import { list } from './object.js';
import { addOrder } from './orderManager.js';
import { grillMeat } from './grill.js';
import { processOrder } from './orderProcessor.js';
import { orderStatus, updateStatus } from './status.js';

//실습1번
// for (let key in list) {
//   if (key === '삼겹살') {
//     console.log(`삼겹살 주문 수량: ${list[key]}`);
//     break;
//   } else {
//     console.log('❌ 삼겹살 주문 내역이 없습니다.');
//     break;
//   }
// }

// 실습2번
// addOrder('등심', '10인분');
// console.log('✅ 현재 주문 내역: ');
// for (let key in list) {
//   console.log(`${key}: ${list[key]}`);
// }

//실습3번
// grillMeat('삼겹살');

//실습4번
// processOrder(list);

//실습5번
// const trackStatus = async () => {
//   for (let key in orderStatus) {
//     await updateStatus(key, '굽는 중');
//     await updateStatus(key, '완료');
//   }
//   console.log(`📋 최종 주문 상태: ${JSON.stringify(orderStatus, null, 2)}`);
// };
// trackStatus();

//실습6번
