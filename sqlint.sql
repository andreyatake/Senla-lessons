
create database  webapp;
use webapp;

-- -----------------------------------------------------
-- Table `webapp`.`address`
-- -----------------------------------------------------
CREATE TABLE  `address` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(50) ,
  `country` VARCHAR(50) ,
  `post_index` INT(20) ,
  `region` VARCHAR(50) ,
  `street` VARCHAR(50) ,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`author`
-- -----------------------------------------------------
CREATE TABLE `author` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) ,
  `surname` VARCHAR(50),
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`book`
-- -----------------------------------------------------
CREATE TABLE `book` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `book_cost` INT(11) ,
  `book_description` VARCHAR(600) ,
  `book_name` VARCHAR(50),
  `book_status` SMALLINT(6),
  `genre` INT ,
  `author` INT(20),
  PRIMARY KEY (`id`))
;

-- ----------------------------------------------------
-- Table `webapp`.`shop_contact`
-- -----------------------------------------------------
CREATE TABLE  `shop_contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `filial_status` SMALLINT(6),
  `address` INT ,
  `shop_data` INT ,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`shop_phone`
-- -----------------------------------------------------
CREATE TABLE  `shop_phone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone` INT(20) NULL DEFAULT NULL,
  `shop_contact` INT ,
  `phone_type` SMALLINT(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `webapp`.`shop_data`
-- -----------------------------------------------------
CREATE TABLE `shop_data` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `shop_name` VARCHAR(255) ,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `webapp`.`user`
-- -----------------------------------------------------
CREATE TABLE `user` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_active` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`user_data`
-- -----------------------------------------------------
CREATE TABLE `user_data` (
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) ,
  `name` VARCHAR(255) ,
  `surname` VARCHAR(255),
  `phone` BIGINT,
  `role` SMALLINT(6)  DEFAULT 0,
  `patronymic` VARCHAR(255) ,
  `address` INT ,
  `user_id` INT,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `webapp`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `feedback` VARCHAR(255) NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `book` INT(11) NULL DEFAULT NULL,
  `user_data` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));





-- -----------------------------------------------------
-- Table `webapp`.`user_data_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_data_book` (
  `user_data_id` INT NOT NULL,
  `favorites_id` INT NOT NULL,
  PRIMARY KEY (`user_data_id`, `favorites_id`));


-- -----------------------------------------------------
-- Table `webapp`.`user_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `creation_date` DATETIME NOT NULL,
  `order_cost` INT(11) ,
  `order_status` SMALLINT(6),
  `user_data` INT,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `webapp`.`user_order_book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user_order_book` (
  `user_order_id` INT NOT NULL,
  `listOrderBooks_id` INT NOT NULL,
  PRIMARY KEY (`user_order_id`, `listOrderBooks_id`));




ALTER TABLE `book` ADD CONSTRAINT `FK2E3AE9701F8CE8` FOREIGN KEY (`author`) REFERENCES `webapp`.`author` (`id`);
ALTER TABLE `shop_contact` ADD CONSTRAINT `FK80C54FD758132856` FOREIGN KEY (`address`) REFERENCES  `webapp`.`address` (`id`);
ALTER TABLE `shop_contact` ADD CONSTRAINT `FK80C54FD758132857` FOREIGN KEY (`shop_data`) REFERENCES  `webapp`.`shop_data` (`id`);
ALTER TABLE `shop_phone` ADD CONSTRAINT `FK80C54FD758132858` FOREIGN KEY (`shop_contact`) REFERENCES  `webapp`.`shop_contact` (`id`);


ALTER TABLE `user_data` ADD CONSTRAINT `FK1435639E3D43702C` FOREIGN KEY (`user_id`) REFERENCES  `webapp`.`user` (`id`);
ALTER TABLE `user_data` ADD CONSTRAINT `FK1435639E58132856` FOREIGN KEY (`address`) REFERENCES  `webapp`.`address` (`id`);
ALTER TABLE `user_data_book` ADD CONSTRAINT `FK47B722EA6561253E` FOREIGN KEY (`favorites_id`) REFERENCES `webapp`.`book` (`id`);
ALTER TABLE `user_data_book` ADD CONSTRAINT `FK47B722EADCA590C3` FOREIGN KEY (`user_data_id`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `user_order` ADD CONSTRAINT `FK731991DA3FE5F305` FOREIGN KEY (`user_data`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `user_order_book` ADD CONSTRAINT `FK7CA27A2E68CC417B` FOREIGN KEY (`listOrderBooks_id`) REFERENCES  `webapp`.`book` (`id`);
ALTER TABLE `user_order_book` ADD CONSTRAINT `FK7CA27A2EC74814DC` FOREIGN KEY (`user_order_id`) REFERENCES  `webapp`.`user_order` (`id`);
ALTER TABLE `feedback` ADD CONSTRAINT `FKF495EB853FE5F305` FOREIGN KEY (`user_data`) REFERENCES  `webapp`.`user_data` (`id`);
ALTER TABLE `feedback` ADD CONSTRAINT `FKF495EB85462E0C24` FOREIGN KEY (`book`) REFERENCES  `webapp`.`book` (`id`);