#用户优惠券表
CREATE TABLE `t_user_coupon`(
 id int(11) NOT NULL AUTO_INCREMENT,
 user_coupon_code varchar(128) NOT NULL DEFAULT '' COMMENT '优惠券码',
 pic_url varchar(255) NOT NULL DEFAULT '' COMMENT '优惠券图',
 coupon_id int(11) NOT NULL DEFAULT 0 COMMENT 't_coupon表外键ID',
 user_id int(11) NOT NULL DEFAULT 0 COMMENT '所领取⽤户id',
 status int(1) NOT NULL DEFAULT 0 COMMENT '状态为0表示未使⽤，1为已使⽤',
 order_id int(11) NOT NULL DEFAULT 0 COMMENT '对应t_order表外键',
 create_time dateTime default null COMMENT '创建时间',
 update_time dateTime default null COMMENT '跟新时间',
 create_user varchar(20)  not null default '' COMMENT '创建用户',
 update_user varchar(20) not null default '' COMMENT '更新用户',
PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT '⽤户优惠
券';