export const filterMenuByPrice = async (menu, maxPrice) => {
    try {
        // 비동기 대기 (예제용)
        await new Promise((resolve) => setTimeout(resolve, 1000));

        // maxPrice 이하의 메뉴 필터링
        const filteredMenu = menu.filter((item) => item.price <= maxPrice);

        return filteredMenu;
    } catch (err) {
        console.log(err);
    }
};
