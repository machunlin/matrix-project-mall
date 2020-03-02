CREATE TABLE user_cart
(
    ID          VARCHAR(255) NOT NULL COMMENT '购物车ID',
    USER_ID     VARCHAR(255) NOT NULL COMMENT '用户ID',
    GOODS_ID    VARCHAR(255) NOT NULL COMMENT '商品ID',
    GOODS_COUNT INT(10)      NOT NULL COMMENT '商品数量',
    CREATE_TIME DATETIME     NOT NULL COMMENT '创建时间',
    UPDATE_TIME DATETIME     NOT NULL COMMENT '更新时间',
    STATUS      INT(1)       NOT NULL COMMENT '状态(1:上架,-1:删除)',
    PRIMARY KEY (ID)
);