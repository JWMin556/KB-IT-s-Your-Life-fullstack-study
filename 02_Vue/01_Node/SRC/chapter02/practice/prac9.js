import {menu} from './menu.js';
import {filterMenuByPrice} from './menuFilter.js';

const showAffordableMenu = async () => {
    const item = await filterMenuByPrice(menu, 18000);
    console.log('✅ 선택 가능한 메뉴:');
    for (let {name, price} of item) {
        console.log(`${name}: ${price}원`);
    }
};
showAffordableMenu();
