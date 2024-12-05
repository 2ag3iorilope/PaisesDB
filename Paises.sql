-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Paises
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Paises
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Paises` DEFAULT CHARACTER SET utf8 ;
USE `Paises` ;

-- -----------------------------------------------------
-- Table `Paises`.`Kontinenteak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Paises`.`Kontinenteak` (
  `Izena` VARCHAR(45) NOT NULL,
  `Superficie` INT UNSIGNED NOT NULL,
  `Herrialde_Kop` INT UNSIGNED NOT NULL,
  `Populazioa` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`Izena`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Paises`.`Estatuak`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Paises`.`Estatuak` (
  `Pais` VARCHAR(45) NOT NULL,
  `Capital` VARCHAR(45) NOT NULL,
  `Moneda` VARCHAR(30) NOT NULL,
  `Superficie` INT UNSIGNED NOT NULL,
  `Poblacion` INT UNSIGNED NOT NULL,
  `Bizi_Esperantza` INT UNSIGNED NOT NULL,
  `Kontinenteak_Izena` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Pais`),
  INDEX `fk_Estatuak_Kontinenteak_idx` (`Kontinenteak_Izena` ASC) VISIBLE,
  CONSTRAINT `fk_Estatuak_Kontinenteak`
    FOREIGN KEY (`Kontinenteak_Izena`)
    REFERENCES `Paises`.`Kontinenteak` (`Izena`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
