import { list } from './object.js';

export const addOrder = (menu, quantity) => {
  list[menu] = quantity;
};
