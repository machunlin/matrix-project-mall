CREATE TABLE country
(
    CODE INT(10)     NOT NULL COMMENT '国家ID',
    NAME VARCHAR(20) NOT NULL COMMENT '国家名称',
    PRIMARY KEY (CODE)
);
INSERT INTO country (CODE, NAME)
VALUES (10, '中国');

CREATE TABLE province
(
    CODE INT(10)     NOT NULL COMMENT '省份ID',
    NAME VARCHAR(20) NOT NULL COMMENT '省份名称',
    PRIMARY KEY (CODE)
);
INSERT INTO province (CODE, NAME)
VALUES (1001, '江苏');

CREATE TABLE city
(
    CODE INT(10)     NOT NULL COMMENT '城市ID',
    NAME VARCHAR(20) NOT NULL COMMENT '城市名称',
    PRIMARY KEY (CODE)
);
INSERT INTO city (CODE, NAME)
VALUES (100101, '苏州');