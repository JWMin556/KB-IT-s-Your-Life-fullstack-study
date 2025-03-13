const fs = require('fs').promises;

const benchFilePath = './practice/logs/bench.txt';
const squatFilePath = './practice/logs/squat.txt';
const deadliftFilePath = './practice/logs/deadlift.txt';

const readRecord = async (filePath) => {
    try {
        const data = await fs.readFile(filePath, 'utf-8');
        return data
        .split('\n')
        .filter((line) => line.trim() !== '')
        .map((line) => {
            const [name, weight] = line.split(':').map((str) => str.trim());
            return {name, weight: parseInt(weight, 10)};
        });
    } catch (err) {
        if (err.code === 'ENOENT') {
            console.log('운동 기록 파일이 없습니다!');
            process.exit(1);
        } else {
            throw err;
        }
    }
};

const getTotalWeight = async (memberName) => {
    const benchRecords = await readRecord(benchFilePath);
    const squatRecords = await readRecord(squatFilePath);
    const deadliftRecords = await readRecord(deadliftFilePath);

    const bench = benchRecords.find((record) => record.name === memberName)?.weight || 0;
    const squat = squatRecords.find((record) => record.name === memberName)?.weight || 0;
    const deadlift = deadliftRecords.find((record) => record.name === memberName)?.weight || 0;

    const total = bench + squat + deadlift;

    if (bench === 0 && squat === 0 && deadlift === 0) {
        console.log(`${memberName} 회원님의 기록이 없습니다!`);
    } else if (total >= 500) {
        console.log(`${memberName} 회원님! 3대 500 돌파! 강력한 힘의 소유자!`);
    } else if (total >= 200) {
        console.log(`${memberName} 회원님, 3대 200은 넘으셨네요. 꾸준히 파이팅!`);
    } else {
        console.log(`${memberName} 회원님, 아직 3대 200은 부족해요. 힘내세요!`);
    }
};

// 테스트 실행 (이름을 바꿔가면서 실행 가능)
const members = ['이승기', '김종국', '유재석', '박보검', '이병헌', '정우성'];

const runAnalysis = async () => {
    for (const member of members) {
        await getTotalWeight(member);
    }
};

runAnalysis();
