#优惠券表
create table coupon (
          id int(11) not null auto_increment,
          code varchar(128) not null default '' COMMENT '优惠券码',
          title varchar(30) not null default '' COMMENT '优惠券标题',
          pic_url varchar(255) not null default '' COMMENT '图片',
          achive_amount int(11) not null default 0 COMMENT '达到多少金额',
          reduce_amount int(11) not null default 0 COMMENT'减多少金额',
          stock int(11) not null default 0 COMMENT '库存',
          status int(11) not null default 0 COMMENT '状态 0为可用 1为不可用 ',
          create_time dateTime default null COMMENT '创建时间',
          update_time dateTime default null COMMENT '跟新时间',
          create_user varchar(20)  not null default '' COMMENT '创建用户',
          update_user varchar(20) not null default '' COMMENT '更新用户',
          PRIMARY KEY(`id`)
)engine=innoDB auto_increment=0  default charset=utf8  COMMENT '优惠券定义表';

