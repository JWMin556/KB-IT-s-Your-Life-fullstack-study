import fs from 'fs/promises';

export class PetAlbumManager {
    constructor() {
        this.album = [];
    }

    // 중복된 사진 등록 체크
    isDuplicatePhoto(photoPath) {
        return this.album.some((record) => record.type === 'Photo' && record.photoPath === photoPath);
    }

    // 중복된 성장 기록 체크
    isDuplicateGrowthRecord(recordDate, description) {
        return this.album.some(
            (record) =>
                record.type === 'Growth Record' &&
                record.recordDate === recordDate &&
                record.description === description
        );
    }

    // 사진 또는 성장 기록 추가
    async addRecord(record) {
        if (record.type === 'Photo') {
            if (this.isDuplicatePhoto(record.photoPath)) {
                console.log(`[등록 오류] ${record.name}: 중복된 사진입니다.`);
                return;
            }
        }

        if (record.type === 'Growth Record') {
            if (this.isDuplicateGrowthRecord(record.recordDate, record.description)) {
                console.log(`[등록 오류] ${record.name}: 중복된 성장 기록입니다.`);
                return;
            }
        }

        this.album.push(record);
        console.log(`[등록 완료] ${record.name}: ${record.type}가 등록되었습니다.`);

        await this.saveToFile();
    }

    // 파일 저장 (비동기 처리)
    async saveToFile() {
        try {
            await fs.writeFile(
                './02_Vue/02_Vue/chapter02/practice/petAlbum/pet_album.json',
                JSON.stringify(this.album, null, 2)
            );
            console.log('[파일 저장 완료] 앨범 기록이 파일로 저장되었습니다.');
        } catch (error) {
            console.error('❌ 파일 저장 중 오류 발생:', error);
        }
    }
}
