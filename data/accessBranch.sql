
-- -----------------------------------------------------
-- Table Ingredient
-- -----------------------------------------------------

CREATE  TABLE Ingredient (
  idIngredient INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NULL ,
  cost DOUBLE NULL ,
  unitType VARCHAR(5) NULL ,
  PRIMARY KEY (idIngredient) )





-- -----------------------------------------------------
-- Table Branch
-- -----------------------------------------------------

CREATE  TABLE Branch (
  idBranch INT NOT NULL ,
  PRIMARY KEY (idBranch) )


-- -----------------------------------------------------
-- Table Bill
-- -----------------------------------------------------
CREATE  TABLE Bill (
  idBill INT NOT NULL  ,
  stamp DATETIME NULL ,
  cost VARCHAR(45) NULL ,
  idBranch INT NULL ,
  PRIMARY KEY (idBill) )
-- -----------------------------------------------------
-- Table Pizza
-- -----------------------------------------------------
CREATE  TABLE Pizza (
  idPizza INT NOT NULL  ,
  name VARCHAR(45) NULL ,
  size VARCHAR(45) NULL ,
  cost DOUBLE NULL ,
  PRIMARY KEY (idPizza) )


-- -----------------------------------------------------
-- Table Pizza_Ingredient
-- -----------------------------------------------------
CREATE  TABLE Pizza_Ingredient (
  idPizza INT NOT NULL ,
  idIngredient INT NOT NULL ,
  quantity INT NULL ,
  PRIMARY KEY (idPizza, idIngredient) )

-- -----------------------------------------------------
-- Table Pizza_Bill
-- -----------------------------------------------------
CREATE  TABLE Pizza_Bill (
  idPizza INT NOT NULL ,
  idBill INT NOT NULL ,
  numOfPizza INT NULL ,
  PRIMARY KEY (idPizza, idBill) )

-- -----------------------------------------------------
-- Table Branch_Ingredient
-- -----------------------------------------------------


CREATE  TABLE Branch_Ingredient (
  idBranch INT NOT NULL ,
  idIngredient INT NOT NULL ,
  quantityInStock INT NULL ,
  PRIMARY KEY (idBranch, idIngredient) ) 


-- -----------------------------------------------------
-- USED ADO Console to run the queries
-- -----------------------------------------------------