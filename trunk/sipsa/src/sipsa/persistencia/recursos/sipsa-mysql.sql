SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

DROP SCHEMA IF EXISTS `sipsa` ;
CREATE SCHEMA IF NOT EXISTS `sipsa` ;
USE `sipsa`;

-- -----------------------------------------------------
-- Table `sipsa`.`Empresas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sipsa`.`Empresas` ;

CREATE  TABLE IF NOT EXISTS `sipsa`.`Empresas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `cuit` VARCHAR(11) NOT NULL ,
  `nombre` VARCHAR(50) NOT NULL ,
  `tipo` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sipsa`.`TiposProducto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sipsa`.`TiposProducto` ;

CREATE  TABLE IF NOT EXISTS `sipsa`.`TiposProducto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) NOT NULL ,
  `duracionGarantia` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sipsa`.`Modelos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sipsa`.`Modelos` ;

CREATE  TABLE IF NOT EXISTS `sipsa`.`Modelos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `idTipoProducto` INT(11) NOT NULL ,
  `nombre` VARCHAR(40) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Modelos_TiposProducto` (`idTipoProducto` ASC) ,
  CONSTRAINT `fk_Modelos_TiposProducto`
    FOREIGN KEY (`idTipoProducto` )
    REFERENCES `sipsa`.`TiposProducto` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sipsa`.`Fabricas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sipsa`.`Fabricas` ;

CREATE  TABLE IF NOT EXISTS `sipsa`.`Fabricas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sipsa`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sipsa`.`Productos` ;

CREATE  TABLE IF NOT EXISTS `sipsa`.`Productos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nroSerie` VARCHAR(20) NOT NULL ,
  `idModelo` INT(11) NOT NULL ,
  `idFabrica` INT(11) NOT NULL ,
  `fechaFabricacion` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Productos_Modelos` (`idModelo` ASC) ,
  INDEX `fk_Productos_Fabricas` (`idFabrica` ASC) ,
  CONSTRAINT `fk_Productos_Modelos`
    FOREIGN KEY (`idModelo` )
    REFERENCES `sipsa`.`Modelos` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Productos_Fabricas`
    FOREIGN KEY (`idFabrica` )
    REFERENCES `sipsa`.`Fabricas` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sipsa`.`Ventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sipsa`.`Ventas` ;

CREATE  TABLE IF NOT EXISTS `sipsa`.`Ventas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `idPv` INT(11) NOT NULL ,
  `idProducto` INT(11) NOT NULL ,
  `nroFactura` VARCHAR(13) NOT NULL ,
  `fechaFactura` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Ventas_Empresas` (`idPv` ASC) ,
  INDEX `fk_Ventas_Productos` (`idProducto` ASC) ,
  CONSTRAINT `fk_Ventas_Empresas`
    FOREIGN KEY (`idPv` )
    REFERENCES `sipsa`.`Empresas` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ventas_Productos`
    FOREIGN KEY (`idProducto` )
    REFERENCES `sipsa`.`Productos` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sipsa`.`OrdenesDeTrabajo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sipsa`.`OrdenesDeTrabajo` ;

CREATE  TABLE IF NOT EXISTS `sipsa`.`OrdenesDeTrabajo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `idPac` INT(11) NOT NULL ,
  `idVenta` INT(11) NOT NULL ,
  `observacion` VARCHAR(300) NOT NULL ,
  `idEstado` INT(11) NOT NULL ,
  `motivoEstado` VARCHAR(300) NOT NULL ,
  `fechaEntrega` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_OrdenesDeTrabajo_Empresas` (`idPac` ASC) ,
  INDEX `fk_OrdenesDeTrabajo_Ventas` (`idVenta` ASC) ,
  CONSTRAINT `fk_OrdenesDeTrabajo_Empresas`
    FOREIGN KEY (`idPac` )
    REFERENCES `sipsa`.`Empresas` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdenesDeTrabajo_Ventas`
    FOREIGN KEY (`idVenta` )
    REFERENCES `sipsa`.`Ventas` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
