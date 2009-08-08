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
  `cuit` varchar(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipo` tinyint(1) NOT NULL,
  PRIMARY KEY (`cuit`,`tipo`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `sipsa`.`Productos`
--

DROP TABLE IF EXISTS `sipsa`.`Productos`;
CREATE TABLE  `sipsa`.`Productos` (
  `nroSerie` varchar(10) NOT NULL,
  `modelo` varchar(10) NOT NULL,
  `fabrica` varchar(50) NOT NULL,
  `fechaFabricacion` date NOT NULL,
  PRIMARY KEY (`nroSerie`),
  KEY `fk_tipoProducto` (`modelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Definition of table `sipsa`.`TiposProducto`
--

DROP TABLE IF EXISTS `sipsa`.`TiposProducto`;
CREATE TABLE  `sipsa`.`TiposProducto` (
  `modelo` varchar(10) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `duracionGarantia` int(11) NOT NULL,
  PRIMARY KEY (`modelo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;