-- MySQL Script generated by MySQL Workbench
-- Sat Dec 16 11:06:12 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema MediRecord
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema MediRecord
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `MediRecord` DEFAULT CHARACTER SET utf8 ;
USE `MediRecord` ;

-- -----------------------------------------------------
-- Table `MediRecord`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MediRecord`.`users` ;

CREATE TABLE IF NOT EXISTS `MediRecord`.`users` (
  `UUID` CHAR(40) NOT NULL,
  `Username` VARCHAR(45) NULL,
  `FirstName` VARCHAR(50) NULL,
  `LastName` VARCHAR(80) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(100) NULL,
  `VerifiedUser` INT NULL,
  `Role` VARCHAR(45) NULL,
  PRIMARY KEY (`UUID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `MediRecord`.`records`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MediRecord`.`records` ;

CREATE TABLE IF NOT EXISTS `MediRecord`.`records` (
  `HeathcardID` INT NOT NULL,
  `FirstName` VARCHAR(50) NULL,
  `LastName` VARCHAR(80) NULL,
  `Gender` VARCHAR(45) NULL,
  `DateOfBirth` DATE NULL,
  `CreateDate` DATE NULL,
  `Allergies` TEXT NULL,
  `Diagnoses` TEXT NULL,
  PRIMARY KEY (`HeathcardID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
