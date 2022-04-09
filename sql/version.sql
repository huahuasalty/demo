CREATE TABLE `ybs_version_info`
(
    `id`           bigint       NOT NULL AUTO_INCREMENT COMMENT '版本id',
    `version`      varchar(20)  NOT NULL COMMENT '版本号',
    `content`      varchar(500) NOT NULL COMMENT '版本内容',
    `channel_code` varchar(20)  NOT NULL COMMENT '渠道编码：ybgj：银保 bxj:保险家 lcjl:理财经理',
    `channel_name` varchar(20)  NOT NULL COMMENT '渠道名称',
    `create_by`    varchar(10)  NOT NULL COMMENT '创建人',
    `update_by`    varchar(10)           DEFAULT NULL COMMENT '修改人',
    `is_release`   int          NOT NULL DEFAULT '0' COMMENT '是否发布 0：否 1：是',
    `release_date` date                  DEFAULT NULL COMMENT '更新时间',
    `start_time`   datetime              DEFAULT NULL COMMENT '生效开始时间',
    `gmt_create`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`     int          NOT NULL DEFAULT '0' COMMENT '是否删除 0：否 1 是',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='版本消息记录表';

CREATE TABLE `ybs_version_record`
(
    `id`            bigint      NOT NULL AUTO_INCREMENT COMMENT 'id',
    `version_id`    bigint      NOT NULL COMMENT '版本号',
    `agent_code`    varchar(20)          DEFAULT NULL COMMENT '投顾编码',
    `agent_mobile`  varchar(11) NOT NULL COMMENT '投顾手机号',
    `agent_name`    varchar(10) NOT NULL COMMENT '投顾姓名',
    `employee_code` varchar(20)          DEFAULT NULL COMMENT '保险家代理人工号',
    `gmt_create`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `del_flag`      int         NOT NULL DEFAULT '0' COMMENT '是否删除 0：否 1 是',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COMMENT='版本消息已读记录表';


