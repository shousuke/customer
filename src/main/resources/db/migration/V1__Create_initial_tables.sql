SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Table `customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `customer` ;

CREATE TABLE IF NOT EXISTS `customer` (
  `id` INT NOT NULL,
  `username` VARCHAR(25) NULL,
  `first_name` VARCHAR(25) NULL,
  `last_name` VARCHAR(25) NULL,
  `salt` VARCHAR(32) NULL,
  `password` VARCHAR(32) NULL,
  `primary_email` VARCHAR(255) NULL,
  `emails` TEXT NULL,
  `primary_address` VARCHAR(65) NULL,
  `address` TEXT NULL,
  `primary_phone` VARCHAR(15) NULL,
  `phones` TEXT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `address` VARCHAR(65) NOT NULL,
  `canonical_address` VARCHAR(45) NULL,
  `zipcode` VARCHAR(5) NULL,
  `created_at` TIMESTAMP NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_address_customer_idx` (`customer_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `phone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phone` ;

CREATE TABLE IF NOT EXISTS `phone` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `phone` VARCHAR(15) NOT NULL,
  `canonical_phone` VARCHAR(15) NULL,
  `created_at` TIMESTAMP NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_phone_customer1_idx` (`customer_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `email`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `email` ;

CREATE TABLE IF NOT EXISTS `email` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_email_customer1_idx` (`customer_id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
