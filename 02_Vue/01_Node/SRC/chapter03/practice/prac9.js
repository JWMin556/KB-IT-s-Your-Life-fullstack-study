const fs = require('fs').promises;
const memberFilePath = './practice/logs/memberRoutine.txt';
const routineFilePath = './practice/logs/routine.txt';

const upperRoute = ['벤치프레스 3세트', '어깨프레스 3세트', '팔굽혀펴기 50개'];
const downRoute = ['스쿼트 5세트', '런지 3세트', '레그프레스 4세트'];

const recommendExercise = (part) => {
    const exercises = part === '상체' ? upperRoute : downRoute;
    return exercises[Math.floor(Math.random() * exercises.length)];
};

const recommend = async () => {
    try {
        // 회원 루틴 파일 확인
        const memberData = await fs.readFile(memberFilePath, 'utf-8');
        const members = memberData.split('\n').filter((line) => line.trim() !== '');

        // 이미 추천된 회원 목록 가져오기
        let recommendedMembers = new Set();
        try {
            const routineData = await fs.readFile(routineFilePath, 'utf-8');
            routineData.split('\n').forEach((line) => {
                const match = line.match(/^(.+?) \(/);
                if (match) recommendedMembers.add(match[1]); // 회원 이름만 저장
            });
        } catch (err) {
            if (err.code !== 'ENOENT') throw err; // 파일이 없으면 무시
        }

        for (const entry of members) {
            const [name, part] = entry.split(': ').map((str) => str.trim());

            console.log(`운동 루틴 추천 중... (${name})`);

            if (recommendedMembers.has(name)) {
                console.log(`${name} 회원님은 이미 추천을 받으셨습니다!`);
                continue; // 추천 제외하고 다음 회원 검사
            }

            const exercise = recommendExercise(part);
            console.log(`${name} 회원님, 오늘의 ${part} 추천 루틴은 '${exercise}'입니다! 화이팅!`);
            // 1초 후 비동기적으로 처리
            await new Promise((resolve) => {
                setTimeout(async () => {
                    const log = `${name} (${part}): ${exercise}\n`;
                    await fs.appendFile(routineFilePath, log);
                    console.log(`${name} 회원님의 추천 루틴이 기록되었습니다!`);
                    resolve();
                }, 1000);
            });

            recommendedMembers.add(name); // 추천된 회원 추가
        }
    } catch (err) {
        console.error('오류 발생:', err.message);
    }
};

recommend();
