import fs from 'fs/promises';

export class EducationManager {
    constructor() {
        this.programs = [];
    }

    registerProgram(program) {
        this.programs.push(program);
        console.log(`[등록 완료] 교육 과정: ${program.title}`);
    }

    // 일반 함수로 이수 처리 (this 바인딩 확인)
    completeProgramWithFunction(title) {
        this.programs.forEach(function (program) {
            if (program.title === title) {
                program.isCompleted = true;
                console.log(`[이수 완료 - 일반 함수] ${program.title}`);
            }
        });
    }

    // 화살표 함수로 이수 처리 (this 바인딩 확인)
    completeProgramWithArrowFunction(title) {
        this.programs.forEach((program) => {
            if (program.title === title) {
                program.isCompleted = true;
                console.log(`[이수 완료 - 화살표 함수] ${program.title}`);
            }
        });
    }

    // 파일 저장 (비동기 처리)
    async saveToFile() {
        try {
            await fs.writeFile(
                './02_Vue/02_Vue/chapter02/practice/education/education_records.json',
                JSON.stringify(this.programs, null, 2)
            );
            console.log('[파일 저장 완료] 교육 기록이 파일로 저장되었습니다.');
        } catch (error) {
            console.error('❌ 파일 저장 중 오류 발생:', error);
        }
    }
}
