CREATE TABLE menu_list
(
    MENU_ID     VARCHAR(255) NOT NULL COMMENT '菜单ID',
    MENU_NAME   VARCHAR(255) NOT NULL COMMENT '菜单名称',
    IS_DEFAULT  INT(1)       NOT NULL DEFAULT 0 COMMENT '默认菜单项(不允许删除)',
    URL         VARCHAR(255) COMMENT '菜单链接',
    PARENT_ID   VARCHAR(255) NOT NULL DEFAULT '0' COMMENT '父级菜单ID(0为无父级)',
    TYPE        VARCHAR(20)  NOT NULL DEFAULT 'Operation' COMMENT '菜单类型(Admin: 管理员菜单, Operation: 运营人员菜单)',
    ORDER_BY    INT(10)      NOT NULL DEFAULT 0 COMMENT '',
    CREATE_TIME DATETIME     NOT NULL COMMENT '创建时间',
    UPDATE_TIME DATETIME     NOT NULL COMMENT '更新时间',
    STATUS      INT(1)       NOT NULL COMMENT '状态(1:启用,0:禁用,-1:删除)',
    PRIMARY KEY (MENU_ID)
);
INSERT INTO menu_list (MENU_ID, MENU_NAME, IS_DEFAULT, URL, PARENT_ID, TYPE, ORDER_BY, CREATE_TIME, UPDATE_TIME, STATUS)
VALUES ('1', '系统设置', 1, '', '0', 'Admin', '1000', NOW(), NOW(), 1);
INSERT INTO menu_list (MENU_ID, MENU_NAME, IS_DEFAULT, URL, PARENT_ID, TYPE, ORDER_BY, CREATE_TIME, UPDATE_TIME, STATUS)
VALUES ('2', '菜单管理', 1, 'Menu', '1', 'Admin', '1', NOW(), NOW(), 1);
