create table users
(
    username varchar(50)  not null
        primary key,
    password varchar(500) not null,
    enabled  tinyint(1)   not null
);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint uc_auth_username
        unique (username, authority),
    constraint fk_authorities_users
        foreign key (username) references users (username)
);

CREATE TABLE `customer`
(
    `id`       int          NOT NULL AUTO_INCREMENT,
    `email`    varchar(45)  NOT NULL,
    `password` varchar(200) NOT NULL,
    `role`     varchar(45)  NOT NULL,
    PRIMARY KEY (`id`)
);

