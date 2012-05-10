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

INSERT INTO `login` (`idLogin`, `username`, `password`, `accesstype`) VALUES
(1, 'owner', 'owner', 'admin'),
(2, 'branch1', 'branch1', 'branch'),
(3, 'branch2', 'branch2', 'branch'),
(4, 'cashier', 'cashier', 'cashier'),
(5, 'warehouse', 'warehouse', 'warehouse');

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

INSERT INTO `branch` (`idBranch`, `name`, `address`, `city`, `state`, `zip`, `phone`, `fax`) VALUES
(1, 'Branch1', '123 Second Street', 'Rochester', 'NY', '14623', '8489923412', '8489923345'),
(2, 'Branch2', '456 Community Street', 'West Henrietta', 'NY', '14586', '8488273456', '8486673429');
-- -----------------------------------------------------
-- Table `warehouse`.`Item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warehouse`.`Item` ;

CREATE  TABLE IF NOT EXISTS `warehouse`.`Item` (
  `idItem` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `quantityInStock` INT NULL ,
  `cost` DOUBLE NULL ,
  `unitType` VARCHAR(45) NULL ,
  PRIMARY KEY (`idItem`) )
ENGINE = InnoDB;


INSERT INTO `item` (`idItem`, `name`, `quantityInStock`, `cost`, `unitType`) VALUES
(1, 'Pepperoni', 100, 20, 'kilograms'),
(2, 'Cheese', 100, 10, 'kilograms'),
(3, 'Oil', 100, 2, 'kilograms'),
(4, 'Egg', 100, 3, 'dozens'),
(5, 'Dough', 100, 5, 'kilograms'),
(6, 'Bacon', 100, 10, 'kilograms'),
(7, 'Tuna', 100, 50, 'kilograms'),
(8, 'Milk', 100, 2, 'liters'),
(9, 'Italian Susage', 10000, 10, 'grams');
-- -----------------------------------------------------
-- Table `warehouse`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `warehouse`.`Order` ;

CREATE  TABLE IF NOT EXISTS `warehouse`.`Order` (
  `idOrder` INT NOT NULL AUTO_INCREMENT ,
  `date` DATETIME NULL ,
  `cost` DOUBLE NULL ,
  `idBranch` INT NULL ,
  PRIMARY KEY (`idOrder`) ,
  INDEX `idBranchFK` (`idBranch` ASC) ,
  CONSTRAINT `idBranchFK`
    FOREIGN KEY (`idBranch` )
    REFERENCES `warehouse`.`Branch` (`idBranch` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `order` (`idOrder`, `date`, `cost`, `idBranch`) VALUES
(1, '2011-01-01 08:20:08', '170', 1),
(2, '2011-01-01 14:19:38', '42.2', 2),
(3, '2011-05-05 09:55:28', '100', 1),
(4, '2011-05-05 05:26:53', '520', 2);
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


INSERT INTO `order_item` (`idOrder`, `idItem`, `quantity`) VALUES
(1, 1, 3),
(1, 2, 10),
(1, 3, 5),
(2, 3, 600),
(2, 4, 12),
(2, 9, 500),
(3, 5, 10),
(3, 6, 5),
(4, 7, 10),
(4, 8, 10);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
