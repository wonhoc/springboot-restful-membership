--Member Table 생성하기 
CREATE TABLE Member
(
	userid VARCHAR(20),
	passwd VARCHAR(20) NOT NULL,
	name VARCHAR(20) NOT NULL,
	age TINYINT NOT NULL,
	gender CHAR(1) NOT NULL,
	city VARCHAR(30) NOT NULL,
	CONSTRAINT member_userid_pk PRIMARY KEY(userid),
	CONSTRAINT member_age_ck CHECK(age BETWEEN 20 AND 65),
	CONSTRAINT member_gender_ck CHECK(gender IN ('1', '0')),
	CONSTRAINT member_city_ck CHECK(city IN('서울', '부산', '대전', '광주', '대구'))
);


--Member Insert Stored Procedure
DELIMITER //
CREATE PROCEDURE test.member_insert_sp(
	IN t_userid VARCHAR(20),
	IN t_passwd VARCHAR(20),
	IN t_name VARCHAR(20),
	IN t_age TINYINT,
	IN t_gender CHAR(1),
	IN t_city VARCHAR(30)
)
BEGIN
	INSERT INTO Member(userid, passwd, name, age, gender, city)
	VALUES(t_userid, t_passwd, t_name, t_age, t_gender, t_city);
	COMMIT;
END //
DELIMITER ;


--Member Select One Stored Procedure
DELIMITER //
CREATE PROCEDURE test.member_select_sp(
	IN t_userid    VARCHAR(20)
)
BEGIN
	SELECT * FROM Member
	WHERE userid = t_userid;
END //
DELIMITER ;


--Member Select All Stored Procedure
DELIMITER //
CREATE PROCEDURE test.member_select_all_sp()
BEGIN
	SELECT * FROM Member
	ORDER BY userid ASC;
END //
DELIMITER ;


--Member Update Stored Procedure
DELIMITER //
CREATE PROCEDURE test.member_update_sp(
	IN t_age   TINYINT,
	IN t_gender  CHAR(1),
	IN t_city   VARCHAR(30),
	IN t_userid    VARCHAR(20)
)
BEGIN
	UPDATE Member SET age = t_age, gender = t_gender, city = t_city
	WHERE userid = t_userid;
	COMMIT;
END //
DELIMITER ;


--Member Delete Stored Procedure
DELIMITER //
CREATE PROCEDURE test.member_delete_sp(
	IN t_userid    VARCHAR(20)
)
BEGIN
	DELETE FROM Member
	WHERE userid = t_userid;
	COMMIT;
END //
DELIMITER ;