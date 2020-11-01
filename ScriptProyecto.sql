-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema eif209_2020_p01
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eif209_2020_p01
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eif209_2020_p01` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `eif209_2020_p01` ;

-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`category` (
  `category` VARCHAR(100) NOT NULL,
  `iva` FLOAT NOT NULL,
  PRIMARY KEY (`category`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`identification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`identification` (
  `Tipo` INT NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Tipo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`ubication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`ubication` (
  `idUbication` INT NOT NULL AUTO_INCREMENT,
  `nomProvince` VARCHAR(20) NOT NULL,
  `nomCanton` VARCHAR(30) NOT NULL,
  `nomDistrito` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idUbication`))
ENGINE = InnoDB
AUTO_INCREMENT = 1043
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`user` (
  `idUser` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `status` INT NOT NULL DEFAULT '0',
  `rol` INT NOT NULL DEFAULT '1',
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`transmitter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`transmitter` (
  `dni` VARCHAR(25) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(10) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `tradename` VARCHAR(45) NOT NULL,
  `location` INT NOT NULL,
  `id_type` INT NOT NULL,
  `user` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_idf_type_idx` (`id_type` ASC) VISIBLE,
  INDEX `fk_location_idx` (`location` ASC) VISIBLE,
  INDEX `fk_user_p_i_idx` (`user` ASC) VISIBLE,
  CONSTRAINT `fk_idf_type`
    FOREIGN KEY (`id_type`)
    REFERENCES `eif209_2020_p01`.`identification` (`Tipo`),
  CONSTRAINT `fk_location`
    FOREIGN KEY (`location`)
    REFERENCES `eif209_2020_p01`.`ubication` (`idUbication`),
  CONSTRAINT `fk_user_p_i`
    FOREIGN KEY (`user`)
    REFERENCES `eif209_2020_p01`.`user` (`idUser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT,
  `detail` VARCHAR(45) NOT NULL,
  `price` FLOAT NOT NULL,
  `category` VARCHAR(100) NOT NULL,
  `owner` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idProduct`),
  INDEX `fk_owner_idx` (`owner` ASC) VISIBLE,
  INDEX `fk_category_idx` (`category` ASC) VISIBLE,
  CONSTRAINT `fk_category`
    FOREIGN KEY (`category`)
    REFERENCES `eif209_2020_p01`.`category` (`category`),
  CONSTRAINT `fk_owner`
    FOREIGN KEY (`owner`)
    REFERENCES `eif209_2020_p01`.`transmitter` (`dni`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`detail_line`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`detail_line` (
  `idDetailLine` INT NOT NULL AUTO_INCREMENT,
  `product` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`idDetailLine`),
  INDEX `fk_product_detail_idx` (`product` ASC) VISIBLE,
  CONSTRAINT `fk_product_detail`
    FOREIGN KEY (`product`)
    REFERENCES `eif209_2020_p01`.`product` (`idProduct`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`receiver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`receiver` (
  `dni` VARCHAR(25) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(10) NOT NULL,
  `e-mail` VARCHAR(45) NOT NULL,
  `location` INT NOT NULL,
  `id_type` INT NOT NULL,
  `transmitter_owner` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`dni`),
  INDEX `fk_idType_idx` (`id_type` ASC) VISIBLE,
  INDEX `fk_location_idx` (`location` ASC) VISIBLE,
  INDEX `fk_owner_idx` (`dni` ASC, `transmitter_owner` ASC) VISIBLE,
  INDEX `fk_t_owner_idx` (`transmitter_owner` ASC) VISIBLE,
  CONSTRAINT `fk_id_type`
    FOREIGN KEY (`id_type`)
    REFERENCES `eif209_2020_p01`.`identification` (`Tipo`),
  CONSTRAINT `fk_location_r`
    FOREIGN KEY (`location`)
    REFERENCES `eif209_2020_p01`.`ubication` (`idUbication`),
  CONSTRAINT `fk_t_owner`
    FOREIGN KEY (`transmitter_owner`)
    REFERENCES `eif209_2020_p01`.`transmitter` (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`factura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `emisor` VARCHAR(25) NOT NULL,
  `receptor` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_fac_emi_idx` (`emisor` ASC) VISIBLE,
  INDEX `fk_fac_rec_idx` (`receptor` ASC) VISIBLE,
  CONSTRAINT `fk_fac_emi`
    FOREIGN KEY (`emisor`)
    REFERENCES `eif209_2020_p01`.`transmitter` (`dni`),
  CONSTRAINT `fk_fac_rec`
    FOREIGN KEY (`receptor`)
    REFERENCES `eif209_2020_p01`.`receiver` (`dni`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eif209_2020_p01`.`detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eif209_2020_p01`.`detalle` (
  `idFac` INT NOT NULL,
  `idProd` INT NOT NULL,
  `cantidad` INT NOT NULL,
  INDEX `fk_detail_fac_idx` (`idFac` ASC) VISIBLE,
  INDEX `fk_detail_prod_idx` (`idProd` ASC) VISIBLE,
  CONSTRAINT `fk_detail_fac`
    FOREIGN KEY (`idFac`)
    REFERENCES `eif209_2020_p01`.`factura` (`idFactura`),
  CONSTRAINT `fk_detail_prod`
    FOREIGN KEY (`idProd`)
    REFERENCES `eif209_2020_p01`.`product` (`idProduct`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into user values('admin','admin',1,0);

insert into eif209_2020_p01.category values('Productos de la agricultura, silvicultura y pesca',0.01);
insert into eif209_2020_p01.category values('Minerales; electricidad, gas y agua',0.13);

insert into eif209_2020_p01.category values('Productos alimenticios, bebidas y tabaco',0.13);
insert into eif209_2020_p01.category values('Textiles, prendas de vestir y productos de cuero',0.13);

insert into eif209_2020_p01.category values('Bienes transportables, excepto productos metalicos, maquinaria y equipo',0.13);
insert into eif209_2020_p01.category values('Productos metalicos, maquinaria y equipo',0.13);
insert into eif209_2020_p01.category values('Construcciones y servicios de construccion',0.13);
insert into eif209_2020_p01.category values('Servicios de venta y distribucion',0.13);
insert into eif209_2020_p01.category values('Alojamiento',0.13);
insert into eif209_2020_p01.category values('Servicios de suministro de comidas y bebidas',0.13);
insert into eif209_2020_p01.category values('Servicios de transporte',0.13);
insert into eif209_2020_p01.category values('Servicios de distribucion de electricidad, gas y agua',0.13);

insert into eif209_2020_p01.category values('Servicios financieros y servicios conexos',0.02);
insert into eif209_2020_p01.category values('Servicios inmobiliarios',0.13);
insert into eif209_2020_p01.category values('Servicios de arrendamiento financiero (leasing)',0.13);

insert into eif209_2020_p01.category values('Servicios prestados a las empresas y servicios de produccion',0.13);
insert into eif209_2020_p01.category values('Servicios para la comunidad, sociales y personales',0.04);