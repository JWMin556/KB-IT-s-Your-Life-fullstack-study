const fs = require('fs');

const rs = fs.createReadStream('./practice/logs/workout_log.txt', 'utf8');
const ws = fs.createWriteStream('./practice/logs/backup_log.txt', 'utf8');

rs.pipe(ws);
ws.on('finish', () => {
  console.log('백업이 완료되었습니다.');
});

rs.on('error', (err) => {
  console.log('백업 중 오류가 발생했습니다.', err);
});

ws.on('error', (err) => {
  console.log('백업 중 오류가 발생했습니다.', err);
});
