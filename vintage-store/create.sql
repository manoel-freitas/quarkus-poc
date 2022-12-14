create sequence hibernate_sequence start 1 increment 1;
create table t_artists (id int8 not null, bio varchar(3000), createdDate timestamp, name varchar(100) not null, primary key (id));
create table t_book (isbn varchar(15), language varchar(20), nb_of_pages int4, publication_date date, id int8 not null, publisher_fk int8, primary key (id));
create table t_cd (genre varchar(100), music_company varchar(255), id int8 not null, primary key (id));
create table t_customers (id int8 not null, created_date timestamp not null, email varchar(255) not null, first_name varchar(50) not null, last_name varchar(50) not null, primary key (id));
create table t_item (id int8 not null, created_date timestamp not null, description varchar(300), price numeric(19, 2) not null, title varchar(100) not null, artist_fk int8, primary key (id));
create table t_order_line (id int8 not null, quantity int4, purchase_order_fk int8, primary key (id));
create table t_publishers (id int8 not null, createdDate timestamp, name varchar(255), primary key (id));
create table t_purchase_order (id int8 not null, date date, customer_fk int8, primary key (id));
create table t_tracks (id int8 not null, created_date timestamp not null, duration int8 not null, title varchar(255) not null, cd_fk int8, primary key (id));
alter table if exists t_book add constraint FKbyqjmrc5prskurt32aht7k1lf foreign key (publisher_fk) references t_publishers;
alter table if exists t_book add constraint FKk5o41nwsfg0t72nc8mp2ybp2a foreign key (id) references t_item;
alter table if exists t_cd add constraint FK2mvp6hjfhrf979oggcc4479eg foreign key (id) references t_item;
alter table if exists t_item add constraint FKtfvrtqwagsn0gxvw3hbx6fstf foreign key (artist_fk) references t_artists;
alter table if exists t_order_line add constraint FK7hdye6liwasjslykftafsu1jv foreign key (purchase_order_fk) references t_purchase_order;
alter table if exists t_purchase_order add constraint FKpivw1s8l9sxlwos0n89gwykcu foreign key (customer_fk) references t_customers;
alter table if exists t_tracks add constraint FKng2txu30a2hm3ifr834rjxnpl foreign key (cd_fk) references t_cd;
