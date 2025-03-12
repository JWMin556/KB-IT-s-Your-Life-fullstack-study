import { ordersPrac7 } from './orderList.js';
import { calculateTotal, processOrder } from './orderProcessorFor7.js';

const orderObject = calculateTotal(ordersPrac7);
const processAllOrders = async () => {
  await processOrder(orderObject);
};
processAllOrders();
