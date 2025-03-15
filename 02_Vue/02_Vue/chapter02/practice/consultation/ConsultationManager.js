class ConsultationManager {
    constructor() {
        this.items = [];
    }

    registerConsultation(item) {
        const phonePattern = /^010-\d{4}-\d{4}$/; // 010-0000-0000 형식 정규식
        if (!phonePattern.test(item.phoneNumber)) {
            console.log(`[상담 등록 오류] ${item.name}: 잘못된 전화번호 형식입니다.`);
            return;
        }

        const isDuplicate = this.items.some((existingItem) => existingItem.phoneNumber === item.phoneNumber);

        if (isDuplicate) {
            console.log(`[상담 등록 오류] ${item.name}: 이미 등록된 상담입니다.`);
            return;
        }
        this.items.push(item);
        console.log(`[상담 등록] ${item.name} - 선호 펫: ${item.pet}`);
        setTimeout(() => {
            console.log(`[저장 완료] ${item.name} 상담 기록 저장 완료!`);
        }, 1000);
    }

    autoEndConsultation() {
        setTimeout(() => {
            this.items = []; // 상담 기록 초기화
            console.log(`[상담 기록 저장 종료] 모든 상담 기록이 삭제되었습니다.`);
        }, 5000);
    }
}

export {ConsultationManager};
