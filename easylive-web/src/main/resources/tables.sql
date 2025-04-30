create table forums
(
    forum_id    int auto_increment
        primary key,
    forum_name  varchar(100)                        not null,
    description text                                null,
    created_at  timestamp default CURRENT_TIMESTAMP null,
    updated_at  timestamp default CURRENT_TIMESTAMP null comment '更新时间'
);

create table posts
(
    post_id    int auto_increment
        primary key,
    user_id    varchar(10)                          not null,
    forum_id   int                                  not null,
    title      varchar(200)                         not null,
    content    text                                 not null,
    is_essence tinyint(1) default 0                 null,
    is_sticky  tinyint(1) default 0                 null,
    created_at timestamp  default CURRENT_TIMESTAMP null,
    updated_at timestamp  default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    constraint posts_ibfk_2
        foreign key (forum_id) references forums (forum_id)
);

create table comments
(
    comment_id        int auto_increment
        primary key,
    user_id           varchar(10)                         not null,
    post_id           int                                 not null,
    parent_comment_id int                                 null,
    content           text                                not null,
    created_at        timestamp default CURRENT_TIMESTAMP null,
    last_change       timestamp default (now())           null comment '上一次修改时间',
    constraint comments_ibfk_2
        foreign key (post_id) references posts (post_id),
    constraint comments_ibfk_3
        foreign key (parent_comment_id) references comments (comment_id)
);

create index parent_comment_id
    on comments (parent_comment_id);

create index post_id
    on comments (post_id);

create index user_id
    on comments (user_id);

create index forum_id
    on posts (forum_id);

create index user_id
    on posts (user_id);

create table user_info
(
    user_id             varchar(10)       not null comment 'id'
        primary key,
    nick_name           varchar(20)       not null comment '昵称',
    email               varchar(150)      not null comment '邮箱',
    password            varchar(50)       not null comment '密码',
    sex                 tinyint default 2 null comment '0:女 1:男 2:未知',
    birthday            varchar(10)       null comment '出生日期',
    school              varchar(150)      null comment '学校',
    person_introduction varchar(200)      null comment '个人简介',
    join_time           datetime          not null comment '加入时间',
    last_login_time     datetime          null comment '最后登录时间',
    last_login_ip       varchar(15)       null comment '最后登录ip',
    status              tinyint           not null comment '0:禁用 1:正常',
    notice_info         varchar(300)      null comment '空间公告',
    total_coin_count    int               not null comment '硬币总数量',
    current_coin_count  int               not null comment '当前硬币数',
    theme               tinyint           not null comment '主题',
    avatar              text              null comment '头像url',
    constraint user_info_pk_2
        unique (email),
    constraint user_info_pk_3
        unique (nick_name)
)
    comment '用户信息';

create table users
(
    user_id    int auto_increment
        primary key,
    username   varchar(50)                                                      not null,
    password   varchar(255)                                                     not null,
    email      varchar(100)                                                     not null,
    user_role  enum ('admin', 'moderator', 'regular') default 'regular'         null,
    profile    text                                                             null,
    created_at timestamp                              default CURRENT_TIMESTAMP null,
    constraint email
        unique (email),
    constraint username
        unique (username)
);

create table notifications
(
    notification_id int auto_increment
        primary key,
    user_id         int                                  not null,
    message         text                                 not null,
    is_read         tinyint(1) default 0                 null,
    created_at      timestamp  default CURRENT_TIMESTAMP null,
    constraint notifications_ibfk_1
        foreign key (user_id) references users (user_id)
);

create index user_id
    on notifications (user_id);

create table private_messages
(
    message_id  int auto_increment
        primary key,
    sender_id   int                                 not null,
    receiver_id int                                 not null,
    post_id     int                                 null,
    content     text                                not null,
    created_at  timestamp default CURRENT_TIMESTAMP null,
    constraint private_messages_ibfk_1
        foreign key (sender_id) references users (user_id),
    constraint private_messages_ibfk_2
        foreign key (receiver_id) references users (user_id),
    constraint private_messages_ibfk_3
        foreign key (post_id) references posts (post_id)
);

create index post_id
    on private_messages (post_id);

create index receiver_id
    on private_messages (receiver_id);

create index sender_id
    on private_messages (sender_id);

create table reactions
(
    reaction_id   int auto_increment
        primary key,
    user_id       int                                 not null,
    post_id       int                                 null,
    comment_id    int                                 null,
    reaction_type enum ('like', 'dislike')            not null,
    created_at    timestamp default CURRENT_TIMESTAMP null,
    constraint reactions_ibfk_1
        foreign key (user_id) references users (user_id),
    constraint reactions_ibfk_2
        foreign key (post_id) references posts (post_id),
    constraint reactions_ibfk_3
        foreign key (comment_id) references comments (comment_id)
);

create index comment_id
    on reactions (comment_id);

create index post_id
    on reactions (post_id);

create index user_id
    on reactions (user_id);

create table reports
(
    report_id   int auto_increment
        primary key,
    reporter_id int                                                    not null,
    post_id     int                                                    null,
    comment_id  int                                                    null,
    reason      text                                                   not null,
    status      enum ('pending', 'resolved') default 'pending'         null,
    created_at  timestamp                    default CURRENT_TIMESTAMP null,
    constraint reports_ibfk_1
        foreign key (reporter_id) references users (user_id),
    constraint reports_ibfk_2
        foreign key (post_id) references posts (post_id),
    constraint reports_ibfk_3
        foreign key (comment_id) references comments (comment_id)
);

create index comment_id
    on reports (comment_id);

create index post_id
    on reports (post_id);

create index reporter_id
    on reports (reporter_id);

