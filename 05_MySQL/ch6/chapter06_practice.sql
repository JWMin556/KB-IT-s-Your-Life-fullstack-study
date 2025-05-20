use speed_quiz;
CREATE TABLE quiz_words (
    id INT AUTO_INCREMENT PRIMARY KEY,
    word VARCHAR(100) NOT NULL,
    category VARCHAR(30) NOT NULL,
    difficulty INT NOT NULL CHECK (difficulty BETWEEN 1 AND 5),
    hint VARCHAR(255),
    created_at DATE NOT NULL
);

CREATE TABLE players (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nickname VARCHAR(50) NOT NULL UNIQUE,
    age INT NOT NULL,
    region VARCHAR(30) NOT NULL,
    joined_at DATE NOT NULL
);

CREATE TABLE quiz_logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_nickname VARCHAR(50) NOT NULL,
    word VARCHAR(100) NOT NULL,
    is_correct CHAR(1) NOT NULL CHECK (is_correct IN ('O', 'X')),
    time_taken INT NOT NULL,
    answered_at DATE NOT NULL
);

CREATE TABLE game_sessions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    player_id INT NOT NULL,
    mode VARCHAR(20) NOT NULL CHECK (mode IN ('개인전', '팀전')),
    total_score INT NOT NULL,
    played_at DATE NOT NULL,

    FOREIGN KEY (player_id) REFERENCES players(id)
);

CREATE TABLE reports (
    id INT AUTO_INCREMENT PRIMARY KEY,
    word VARCHAR(100) NOT NULL,
    reason VARCHAR(100) NOT NULL,
    reported_by VARCHAR(50) NOT NULL,
    reported_at DATE NOT NULL
);


INSERT INTO quiz_words (id, word, category, difficulty, hint, created_at) VALUES
(1, '피카츄', '캐릭터', 2, '노란색, 전기', '2025-05-10'),
(2, '라면', '음식', 1, '뜨거운 국물, 면발', '2025-05-12'),
(3, '된장찌개', '음식', 2, NULL, '2025-05-11'),
(4, '해리포터', '캐릭터', 5, '호그와트', '2025-05-12'),
(5, '붕어빵', '음식', 1, '겨울 간식', '2025-05-08'),
(6, '김연아', '연예인', 3, '피겨 여왕', '2025-05-11'),
(7, '손흥민', '연예인', 3, '축구 선수', '2025-05-10'),
(8, '아이스크림', '음식', 1, '차갑다', '2025-05-13');

INSERT INTO players (id, nickname, age, region, joined_at) VALUES
(1, '지우', 22, '서울', '2025-05-01'),
(2, '이슬이', 21, '부산', '2025-05-03'),
(3, '웅이', 23, '서울', '2025-05-05'),
(4, '태훈', 33, '제주', '2025-05-06'),
(5, '민지', 25, '부산', '2025-05-04');

INSERT INTO quiz_logs (id, player_nickname, word, is_correct, time_taken, answered_at) VALUES
(1, '지우', '피카츄', 'O', 4, '2025-05-12'),
(2, '이슬이', '라면', 'X', 6, '2025-05-12'),
(3, '웅이', '마라탕', 'O', 5, '2025-05-11'),
(4, '지우', '된장찌개', 'X', 3, '2025-05-11'),
(5, '민지', '붕어빵', 'O', 2, '2025-05-10'),
(6, '이슬이', '해리포터', 'O', 7, '2025-05-12'),
(7, '지우', '포켓몬빵', 'O', 4, '2025-05-13');

INSERT INTO game_sessions (id, player_id, mode, total_score, played_at) VALUES
(1, 1, '개인전', 85, '2025-05-10'),
(2, 2, '개인전', 92, '2025-05-11'),
(3, 3, '팀전', 88, '2025-05-11'),
(4, 4, '개인전', 77, '2025-05-12'),
(5, 1, '개인전', 99, '2025-05-13');

INSERT INTO reports (id, word, reason, reported_by, reported_at) VALUES
(1, '피카츄', '오타', '이슬이', '2025-05-10'),
(2, '피카츄', '오타', '지우', '2025-05-11'),
(3, '피카츄', '부적절함', '웅이', '2025-05-12'),
(4, '마라탕', '오타', '민지', '2025-05-11'),
(5, '포켓몬빵', '부적절함', '민지', '2025-05-13'),
(6, '김연아', '부적절함', 'test', '2025-05-13');


select * from quiz_words where category = '음식';
select word, difficulty from quiz_words where difficulty >= 3;
select * from quiz_words where hint is not null;
select * from quiz_words where word like '%빵%';
select nickname, age from players where age between 20 and 29;
select * from players where region = '부산';
select * from quiz_logs where is_correct = 'X';
select * from quiz_logs where time_taken <= 5;
select * from reports where reason = '오타';
select * from quiz_words where created_at = '2025-05-13';

select category, count(word) as 'word_count' from quiz_words group by category;
select category, avg(difficulty) as 'avg_diff' from quiz_words where difficulty >= 3 group by category;
select region, count(*) from players group by region having count(*) >= 2;
select avg(time_taken) as 'avg_time' from quiz_logs where is_correct = 'O';
select reason, count(*) as 'report_count' from reports group by reason;
select reported_at, count(*) as 'cnt' from reports group by reported_at having count(*) >= 2;
select category, max(difficulty) as 'max_diff' from quiz_words group by category;
select floor(age / 10) * 10 as 'age_group', avg(age) 'avg_age' from players group by floor(age / 10) * 10;
select answered_at, (count(case when is_correct = 'O' then 1 end) / count(*)) as 'accuracy' from quiz_logs group by answered_at;
select category, count(*) as 'count' from quiz_words group by category with rollup;

select word, difficulty from quiz_words order by difficulty desc limit 1;
select * from quiz_words order by created_at desc limit 5;
select * from players order by joined_at limit 1;
select * from quiz_words where difficulty > (select avg(difficulty) from quiz_words);
select * from game_sessions where total_score >= 90;
select * from reports where reported_at >= CURDATE() - INTERVAL 3 DAY order by reported_at desc;
select player_id, total_score from game_sessions order by total_score desc limit 1;
select * from players order by age desc limit 3;
select word, count(*) as 'cnt' from reports group by word limit 1;
select player_nickname from quiz_logs where is_correct = 'O' group by player_nickname;

insert into quiz_words values (null, '마라탕', '음식', 1, '혀가 얼얼한 맛', '2025-05-14');
select * from quiz_words;
update quiz_words set hint='힌트 없음' where hint is null;
select * from quiz_words;
-- game_sessions에서 player_id = 4 인 데이터 먼저 삭제
DELETE FROM game_sessions WHERE player_id = 4;
-- 그 다음 players에서 제주 거주자 삭제
DELETE FROM players WHERE region = '제주';
select * from players;

update quiz_words set difficulty = '4' where word = '마라탕';
select * from quiz_words;