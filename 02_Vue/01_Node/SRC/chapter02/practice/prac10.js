import {calculateDiscount as discount} from './discount.js';

let price = 15000;
let quantity = 5;
let afterCalcu = discount(price, quantity);

console.log(`✅ 최종 결제 금액: ${afterCalcu}원`);
