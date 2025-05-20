CREATE DATABASE sejong_festival_2025;
use sejong_festival_2025;
-- 행사 정보 테이블
CREATE TABLE eventTbl (
    eventID INT PRIMARY KEY,
    eventName VARCHAR(100),
    eventDate DATE,
    location VARCHAR(100)
);

-- 아티스트 정보 테이블
CREATE TABLE artistTbl (
    artistID INT PRIMARY KEY,
    artistName VARCHAR(100),
    genre VARCHAR(50),
    debutYear INT
);

-- 공연 구역 정보 테이블
CREATE TABLE stageTbl (
    stageID INT PRIMARY KEY,
    stageName VARCHAR(100),
    capacity INT
);

-- 공연 스케줄 테이블
CREATE TABLE scheduleTbl (
    scheduleID INT PRIMARY KEY,
    eventID INT,
    artistID INT,
    stageID INT,
    performTime TIME,
    durationMin INT,
    FOREIGN KEY (eventID) REFERENCES eventTbl(eventID),
    FOREIGN KEY (artistID) REFERENCES artistTbl(artistID),
    FOREIGN KEY (stageID) REFERENCES stageTbl(stageID)
);

-- eventTbl 데이터
INSERT INTO eventTbl (eventID, eventName, eventDate, location) VALUES
(1, '세종대 대동제', '2025-05-14', '대운동장'),
(2, '세종대 대동제', '2025-05-15', '대운동장'),
(3, '세종대 대동제', '2025-05-16', '대운동장');

-- artistTbl 데이터
INSERT INTO artistTbl (artistID, artistName, genre, debutYear) VALUES
(1, '로시', 'R&B', 2017),
(2, '잔나비', '밴드', 2014),
(3, 'NMIXX', '아이돌', 2022),
(4, '스컬&하하', '레게', 2008),
(5, 'KISS OF LIFE', '아이돌', 2023),
(6, 'ZICO', '힙합', 2011),
(7, '나상현씨 밴드', '인디', 2015),
(8, 'Apink', '아이돌', 2011),
(9, 'HIGHLIGHT', '아이돌', 2009);

-- stageTbl 데이터
INSERT INTO stageTbl (stageID, stageName, capacity) VALUES
(1, '재학생존', 3000),
(2, '외부인존', 1000);

-- scheduleTbl 데이터
INSERT INTO scheduleTbl (scheduleID, eventID, artistID, stageID, performTime, durationMin) VALUES
(1, 1, 1, 1, '18:00:00', 30),
(2, 1, 2, 1, '19:00:00', 40),
(3, 1, 3, 1, '20:00:00', 35),
(4, 2, 4, 1, '18:00:00', 30),
(5, 2, 5, 1, '19:00:00', 30),
(6, 2, 6, 1, '20:00:00', 45),
(7, 3, 7, 1, '18:00:00', 30),
(8, 3, 8, 1, '19:00:00', 35),
(9, 3, 9, 1, '20:00:00', 40);

select artistName, genre from artistTbl;
select * from artistTbl where debutYear >= 2015;
select artistName from artistTbl where genre = '아이돌';
select * from scheduletbl where durationMin >= 40;
select * from stagetbl where capacity >= 2000;

select artistName, debutYear from artistTbl order by debutYear desc;
select scheduleID, durationMin, (durationMin + 5) as '예상종료시간(분)' from scheduletbl;
select scheduleID, concat_ws(' ', eventDate, performTime) as '공연일시' from eventtbl join scheduletbl on eventtbl.eventID = scheduletbl.eventID;
select artistName, genre from artistTbl order by genre, artistName;
select stageName, concat(capacity, '명 수용 가능') as '수용정보' from stagetbl;

select artistName, substring(artistName, 1, 3) as '약칭' from artisttbl;
select * from artisttbl where locate('밴드', artistName);
select artistName, lower(artistName) as '소문자표기' from artisttbl;
select stageName, substring(stageName, 1, 3) as '구역명' from stagetbl;
select trim(genre) '장르' from artisttbl group by genre;

select * from eventTbl where eventDate > current_date();
select scheduleID, eventDate, dayofweek(eventDate) as '요일' from eventtbl join scheduletbl on eventtbl.eventID = scheduletbl.eventID;
select scheduleID, performTime, addtime(performTime, '00:10:00') as '예상종료시각을 ' from scheduletbl;
select eventName, year(eventDate) '연도', month(eventDate) '월', day(eventDate) as '일' from eventtbl;
select eventDate, sum(debutYear)
  from scheduletbl 
    join artisttbl on scheduletbl.artistID = artisttbl.artistID
    join eventTbl on scheduletbl.eventID = eventTbl.eventID
  group by eventDate
  limit 1;
 
 
 select stageName, avg(capacity) as '평균수용인원' from stageTbl group by stageName;
 select count(*) as '아이돌_아티스트_수' from artisttbl where genre = '아이돌';
 select max(durationMin) as '최장공연', min(durationMin) as '최단공연', avg(durationMin) as '평균공연시간' from scheduletbl;
 select artistName, sum(durationMin) as '총공연시간' from scheduletbl join artisttbl on scheduletbl.artistID = artisttbl.artistID group by artisttbl.artistID, artisttbl.artistName;
 select avg(debutyear) as '밴드_평균데뷔연도' from artisttbl where genre = '밴드';
 
 
 select artistName, durationMin 
  from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
  where substring(eventDate, 6) = '05-14';
select artistName, eventDate, performTime 
  from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID;
 select eventDate, performTime 
  from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
  where artistName = 'HIGHLIGHT';
select eventDate, count(*) as '아티스트수' 
  from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
  group by eventDate;
  
select artistName
  from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
  where capacity >= 1000;
  
  
  

select genre, count(artistName) '아티스트수'
  from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
  group by genre
  having count(artistName) >= 2; 
select eventDate, avg(durationMin) '평균공연시간'
 from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
 group by eventDate
 having avg(durationMin) >= 35;
select stageName, sum(durationMin) as '총공연시간'
 from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
 group by stageName
 having sum(durationMin) >= 100;
select debutYear, avg(durationMin) as '평균공연시간'
 from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
 group by debutYear;
 select artistName, count(scheduleID) '공연횟수'
 from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
  group by artistName
  having count(scheduleID) >= 1;

 
 
 
select genre, count(scheduletbl.artistID) '아티스트수'
 from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
 group by genre
 order by count(scheduletbl.artistID) desc
 limit 1;

select eventDate, SUM(nameLength) as '이름총길이'
from (
	select eventtbl.eventDate, CHAR_LENGTH(artisttbl.artistName) as nameLength
	 from artisttbl
	   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
	   join eventtbl on scheduletbl.eventID = eventtbl.eventID
	   join stagetbl on stagetbl.stageID = scheduletbl.stageID
) as sub
group by eventDate
order by SUM(nameLength) desc
limit 2;
 
 
SELECT artistName
FROM (
    SELECT artisttbl.artistName, artisttbl.debutYear
      FROM artisttbl
        JOIN scheduletbl ON artisttbl.artistID = scheduletbl.artistID
		JOIN eventtbl ON scheduletbl.eventID = eventtbl.eventID
		JOIN stagetbl ON stagetbl.stageID = scheduletbl.stageID
      GROUP BY artisttbl.artistID, artisttbl.artistName, artisttbl.debutYear
      HAVING COUNT(eventtbl.eventID) = 1
) AS once_performer
ORDER BY debutYear ASC
LIMIT 1;


select eventDate, artistName, durationMin
 from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
 group by eventDate, artistName, durationMin
 order by durationMin desc
 limit 1;
 
 
select genre, sum(durationMin) as '총 공연시간'
 from artisttbl
   join scheduletbl on artisttbl.artistID = scheduletbl.artistID
   join eventtbl on scheduletbl.eventID = eventtbl.eventID
   join stagetbl on stagetbl.stageID = scheduletbl.stageID
 group by genre
 order by sum(durationMin) desc
 limit 1;