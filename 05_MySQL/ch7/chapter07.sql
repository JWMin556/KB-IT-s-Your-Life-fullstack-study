USE sqldb;
SELECT * 
FROM buytbl 
	INNER JOIN usertbl 
      ON buytbl.userID = usertbl.userID
WHERE usertbl.userID = 'JYP'
ORDER BY buytbl.userID;

SELECT * 
FROM buytbl 
	RIGHT OUTER JOIN usertbl 
      ON buytbl.userID = usertbl.userID
ORDER BY buytbl.userID;

-- 구매 이력이 없는 사용자만 출력
SELECT * 
FROM buytbl b
	RIGHT OUTER JOIN usertbl u
      ON b.userID = u.userID
WHERE ifnull(b.userID, TRUE)
ORDER BY b.userID;

SELECT buytbl.userID as 'userID', name, prodName, addr, concat(mobile1, mobile2) as '연락처'
FROM buytbl 
	RIGHT OUTER JOIN usertbl 
      ON buytbl.userID = usertbl.userID
WHERE buytbl.userID is not null
ORDER BY buytbl.userID;

select * from usertbl where mobile1 is not null AND mobile2 is not null;
select * from usertbl where mobile1 is null AND mobile2 is null;

