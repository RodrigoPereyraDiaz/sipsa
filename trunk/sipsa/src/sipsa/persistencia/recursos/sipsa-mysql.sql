-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.37

--
-- Create schema sipsa
--

CREATE DATABASE IF NOT EXISTS sipsa;
USE sipsa;

--
-- Definition of table `sipsa`.`Empresas`
--

DROP TABLE IF EXISTS `sipsa`.`Empresas`;
CREATE TABLE  `sipsa`.`Empresas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` varchar(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `sipsa`.`Modelos`
--

DROP TABLE IF EXISTS `sipsa`.`Modelos`;
CREATE TABLE  `sipsa`.`Modelos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoProducto` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `sipsa`.`OrdenesDeTrabajo`
--

DROP TABLE IF EXISTS `sipsa`.`OrdenesDeTrabajo`;
CREATE TABLE  `sipsa`.`OrdenesDeTrabajo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPac` int(11) NOT NULL,
  `idVenta` int(11) NOT NULL,
  `observacion` varchar(300) NOT NULL,
  `idEstado` int(11) NOT NULL,
  `motivoEstado` varchar(300) NOT NULL,
  `fechaEntrega` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `sipsa`.`Productos`
--

DROP TABLE IF EXISTS `sipsa`.`Productos`;
CREATE TABLE  `sipsa`.`Productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nroSerie` varchar(20) NOT NULL,
  `idModelo` int(11) NOT NULL,
  `idFabrica` int(11) NOT NULL,
  `fechaFabricacion` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `sipsa`.`TiposProducto`
--

DROP TABLE IF EXISTS `sipsa`.`TiposProducto`;
CREATE TABLE  `sipsa`.`TiposProducto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `duracionGarantia` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `sipsa`.`Ventas`
--

DROP TABLE IF EXISTS `sipsa`.`Ventas`;
CREATE TABLE  `sipsa`.`Ventas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPv` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `nroFactura` varchar(13) NOT NULL,
  `fechaFactura` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `sipsa`.`Fabricas`;
CREATE TABLE  `sipsa`.`Fabricas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
