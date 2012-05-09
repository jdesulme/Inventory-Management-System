SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `branch` ;
CREATE SCHEMA IF NOT EXISTS `branch` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `branch` ;

-- -----------------------------------------------------
-- Table `branch`.`Ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `branch`.`Ingredient` ;

CREATE  TABLE IF NOT EXISTS `branch`.`Ingredient` (
  `idIngredient` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `cost` DECIMAL NULL ,
  `unitType` VARCHAR(5) NULL ,
  PRIMARY KEY (`idIngredient`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `branch`.`Branch`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `branch`.`Branch` ;

CREATE  TABLE IF NOT EXISTS `branch`.`Branch` (
  `idBranch` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`idBranch`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `branch`.`Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `branch`.`Bill` ;

CREATE  TABLE IF NOT EXISTS `branch`.`Bill` (
  `idBill` INT NOT NULL AUTO_INCREMENT ,
  `date` VARCHAR(45) NULL ,
  `cost` VARCHAR(45) NULL ,
  `idBranch` INT NULL ,
  PRIMARY KEY (`idBill`) ,
  INDEX `idBranchFK2` (`idBranch` ASC) ,
  CONSTRAINT `idBranchFK2`
    FOREIGN KEY (`idBranch` )
    REFERENCES `branch`.`Branch` (`idBranch` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `branch`.`Pizza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `branch`.`Pizza` ;

CREATE  TABLE IF NOT EXISTS `branch`.`Pizza` (
  `idPizza` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `size` VARCHAR(45) NULL ,
  `cost` DECIMAL NULL ,
  PRIMARY KEY (`idPizza`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `branch`.`Pizza_Ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `branch`.`Pizza_Ingredient` ;

CREATE  TABLE IF NOT EXISTS `branch`.`Pizza_Ingredient` (
  `idPizza` INT NOT NULL ,
  `idIngredient` INT NOT NULL ,
  `quantity` INT NULL ,
  PRIMARY KEY (`idPizza`, `idIngredient`) ,
  INDEX `idPizzaFK` (`idPizza` ASC) ,
  INDEX `idIngredient` (`idIngredient` ASC) ,
  CONSTRAINT `idPizzaFK`
    FOREIGN KEY (`idPizza` )
    REFERENCES `branch`.`Pizza` (`idPizza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idIngredient`
    FOREIGN KEY (`idIngredient` )
    REFERENCES `branch`.`Ingredient` (`idIngredient` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `branch`.`Pizza_Bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `branch`.`Pizza_Bill` ;

CREATE  TABLE IF NOT EXISTS `branch`.`Pizza_Bill` (
  `idPizza` INT NOT NULL ,
  `idBill` INT NOT NULL ,
  `numOfPizza` INT NULL ,
  PRIMARY KEY (`idPizza`, `idBill`) ,
  INDEX `idPizzaFK2` (`idPizza` ASC) ,
  INDEX `idBillFK1` (`idBill` ASC) ,
  CONSTRAINT `idPizzaFK2`
    FOREIGN KEY (`idPizza` )
    REFERENCES `branch`.`Pizza` (`idPizza` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idBillFK1`
    FOREIGN KEY (`idBill` )
    REFERENCES `branch`.`Bill` (`idBill` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `branch`.`Branch_Ingredient`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `branch`.`Branch_Ingredient` ;

CREATE  TABLE IF NOT EXISTS `branch`.`Branch_Ingredient` (
  `idBranch` INT NOT NULL ,
  `idIngredient` INT NOT NULL ,
  `quantityInStock` INT NULL ,
  PRIMARY KEY (`idBranch`, `idIngredient`) ,
  INDEX `idIngredientFK2` (`idIngredient` ASC) ,
  INDEX `idBranchFK1` (`idBranch` ASC) ,
  CONSTRAINT `idIngredientFK2`
    FOREIGN KEY (`idIngredient` )
    REFERENCES `branch`.`Ingredient` (`idIngredient` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idBranchFK1`
    FOREIGN KEY (`idBranch` )
    REFERENCES `branch`.`Branch` (`idBranch` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
