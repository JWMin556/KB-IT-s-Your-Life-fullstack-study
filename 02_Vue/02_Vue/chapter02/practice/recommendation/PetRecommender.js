import fs from 'fs/promises';

class PetRecommender {
    constructor() {
        this.recommendations = [];
    }

    recommendPet(customer) {
        let pet = '기본 추천 없음';

        if (customer.lifestyle === '활동적' && customer.housing === '단독주택') {
            pet = '골든 리트리버';
        } else if (customer.lifestyle === '조용한' && customer.housing === '아파트') {
            pet = '고양이';
        } else if (customer.lifestyle === '활동적' && customer.housing === '아파트') {
            pet = '푸들';
        } else if (customer.lifestyle === '조용한' && customer.housing === '단독주택') {
            pet = '페르시안 고양이';
        }

        this.recommendations.push({name: customer.name, recommendedPet: pet});
    }

    async saveToFile() {
        try {
            await fs.writeFile(
                './02_Vue/02_Vue/chapter02/practice/recommendation/pet_recommendations.json',
                JSON.stringify(this.recommendations, null, 2)
            );
            console.log('✅ 추천 결과가 저장되었습니다.');
        } catch (err) {
            console.error('❌ 파일 저장 중 오류 발생:', err);
        }
    }
}
export {PetRecommender};
