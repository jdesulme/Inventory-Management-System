SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `warehouse` ;
CREATE SCHEMA IF NOT EXISTS `warehouse` ;
USE `warehouse` ;

-- -----------------------------------------------------
-- Table `warehouse`.`Login`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warehouse`.`Login` ;

CREATE  TABLE IF NOT EXISTS `warehouse`.`Login` (
  `idLogin` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `accesstype` VARCHAR(45) NULL ,
  PRIMARY KEY (`idLogin`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`Branch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warehouse`.`Branch` ;

CREATE  TABLE IF NOT EXISTS `warehouse`.`Branch` (
  `idBranch` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `address` VARCHAR(45) NULL ,
  `city` VARCHAR(45) NULL ,
  `state` VARCHAR(45) NULL ,
  `zip` VARCHAR(45) NULL ,
  `phone` VARCHAR(45) NULL ,
  `fax` VARCHAR(45) NULL ,
  PRIMARY KEY (`idBranch`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warehouse`.`Item` ;

CREATE  TABLE IF NOT EXISTS `warehouse`.`Item` (
  `idItem` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `quantityInStock` INT NULL ,
  `cost` DECIMAL NULL ,
  `unitType` VARCHAR(5) NULL ,
  PRIMARY KEY (`idItem`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warehouse`.`Order` ;

CREATE  TABLE IF NOT EXISTS `warehouse`.`Order` (
  `idOrder` INT NOT NULL AUTO_INCREMENT ,
  `date` DATETIME NULL ,
  `cost` VARCHAR(45) NULL ,
  `idBranch` INT NULL ,
  PRIMARY KEY (`idOrder`) ,
  INDEX `idBranchFK` (`idBranch` ASC) ,
  CONSTRAINT `idBranchFK`
    FOREIGN KEY (`idBranch` )
    REFERENCES `warehouse`.`Branch` (`idBranch` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `warehouse`.`Order_Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warehouse`.`Order_Item` ;

CREATE  TABLE IF NOT EXISTS `warehouse`.`Order_Item` (
  `idOrder` INT NOT NULL AUTO_INCREMENT ,
  `idItem` INT NOT NULL ,
  `quantity` INT NULL ,
  PRIMARY KEY (`idOrder`, `idItem`) ,
  INDEX `idOrderFK` (`idOrder` ASC) ,
  INDEX `idItemFK` (`idItem` ASC) ,
  CONSTRAINT `idOrderFK`
    FOREIGN KEY (`idOrder` )
    REFERENCES `warehouse`.`Order` (`idOrder` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idItemFK`
    FOREIGN KEY (`idItem` )
    REFERENCES `warehouse`.`Item` (`idItem` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
