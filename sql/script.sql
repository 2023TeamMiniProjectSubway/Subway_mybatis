CREATE TABLE IF NOT EXISTS SUBWAY_MEMBER
(
  MEMBER_ID  VARCHAR(50) PRIMARY KEY COMMENT '회원아이디',
  MEMBER_PASSWORD VARCHAR(50) NOT NULL COMMENT '비밀번호',
  MEMBER_NAME VARCHAR(30) NOT NULL COMMENT '회원이름',
  EMAIL VARCHAR(50) COMMENT '이메일',
  PHONE VARCHAR(50) COMMENT '전화번호',
  point INT COMMENT '포인트'

) ENGINE=INNODB COMMENT '서브웨이회원';

CREATE TABLE IF NOT EXISTS SUBWAY_ORDER
(
 ORDER_CODE INT AUTO_INCREMENT PRIMARY KEY COMMENT '주문번호',
 MEMBER_ID VARCHAR(50) NOT NULL COMMENT '회원아이디',
 TOTAL_PRICE INT COMMENT '총 주문가격',
 FOREIGN KEY (MEMBER_ID) REFERENCES SUBWAY_MEMBER(MEMBER_ID)

) ENGINE=INNODB COMMENT '서브웨이주문';

CREATE TABLE IF NOT EXISTS ORDER_SANDWICH
(
 SANDWICH_CODE VARCHAR(50) PRIMARY KEY COMMENT '샌드위치코드',
 ORDER_CODE INT AUTO_INCREMENT NOT NULL COMMENT '주문번호',
 SANDWICH_NAME VARCHAR(30) NOT NULL COMMENT '샌드위치명',
 BREAD_NAME VARCHAR(30) NOT NULL COMMENT '빵 이름',
 SANDWICH_PRICE INT NOT NULL COMMENT '샌드위치가격',
 FOREIGN KEY (ORDER_CODE) REFERENCES SUBWAY_ORDER(ORDER_CODE)
 
) ENGINE=INNODB COMMENT '주문 샌드위치';

CREATE TABLE IF NOT EXISTS SANDWICH_OPTION
(
 SANDWICH_CODE VARCHAR(50) COMMENT '샌드위치코드',
 OPTION_CODE VARCHAR(50) PRIMARY KEY COMMENT '옵션코드',
 TOPPING VARCHAR(50) COMMENT '야채 및 토핑',
 FOREIGN KEY (SANDWICH_CODE) REFERENCES ORDER_SANDWICH(SANDWICH_CODE)

) ENGINE=INNODB COMMENT '주문+-샌드위치옵션';


INSERT INTO SUBWAY_MEMBER (MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, EMAIL, PHONE, POINT)
VALUES ('lja9207', '1234', '이진아', 'lja@subway.com', '010-1111-2222', 0);

INSERT INTO SUBWAY_MEMBER (MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, EMAIL, PHONE, POINT)
VALUES ('her97', '1111', '심민섭', 'sms@subway.com', '010-1234-5678',0);