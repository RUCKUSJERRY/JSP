DROP SEQUENCE MYBOARDSEQ;
DROP TABLE MYBOARD;

CREATE SEQUENCE MYBOARDSEQ;

CREATE TABLE MYBOARD(

	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(100) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO MYBOARD
VALUES (MYBOARDSEQ.NEXTVAL, '관리자', '테스트 글 입니다.', '삭제하고 다시 만들었어요.', SYSDATE);

INSERT INTO MYBOARD
VALUES (MYBOARDSEQ.NEXTVAL, '이용준', '이용준 입니다.', '포문 테스트중입니다.', SYSDATE);

INSERT INTO MYBOARD
VALUES (MYBOARDSEQ.NEXTVAL, '홍길동', '홍길동 입니다.', '포문 테스트중입니다.', SYSDATE);

SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE
FROM MYBOARD
ORDER BY SEQ DESC;

SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE
FROM MYBOARD
WHERE SEQ = 1;

