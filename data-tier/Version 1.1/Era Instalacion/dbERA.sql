/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

#Version 1.2#
CREATE TABLE IF NOT EXISTS `actfij` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `lug` varchar(30) DEFAULT '',
  `ctadepre` varchar(45) NOT NULL,
  `ctadedu` varchar(45) NOT NULL,
  `ctagast` varchar(45) NOT NULL,
  `serprod` varchar(255) DEFAULT '',
  `descrip` varchar(1000) NOT NULL,
  `porcendep` float NOT NULL,
  `porcendedu` float NOT NULL,
  `cost` float NOT NULL,
  `sal` bit(1) DEFAULT b'0',
  `exportconta` bit(1) DEFAULT b'0',
  `totmesbaj` int(11) DEFAULT '0',
  `totacumes` float DEFAULT '0',
  `totvalactbaj` float DEFAULT '0',
  `totestadbaj` varchar(30) DEFAULT '',
  `costsal` float DEFAULT '0',
  `fadquisreal` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fadquisusr` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `finidep` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ffindep` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fbajdep` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `estadusr` varchar(30) NOT NULL,
  `tipact` varchar(30) NOT NULL,
  `comen` varchar(1000) DEFAULT '',
  `baj` bit(1) DEFAULT b'0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fbaj` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `actfijcat` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `concep` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `concep` (`concep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `activos` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `referencia` varchar(30) DEFAULT '',
  `descrip` varchar(255) DEFAULT '',
  `zona` varchar(30) DEFAULT '',
  `sucursal` varchar(30) DEFAULT '',
  `clasificacion` varchar(30) DEFAULT '',
  `responsable` varchar(30) DEFAULT '',
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `aduana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `codigo` varchar(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `almas` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `alma` varchar(30) NOT NULL,
  `respon` varchar(30) NOT NULL,
  `almadescrip` varchar(255) NOT NULL,
  `dir1` varchar(255) DEFAULT '',
  `dir2` varchar(255) DEFAULT '',
  `dir3` varchar(255) DEFAULT '',
  `actfij` bit(1) DEFAULT b'0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `alma` (`alma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `anaqs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `asientos_contables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idSerie` int(11) NOT NULL,
  `idempresa` varchar(45) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `documento` varchar(60) NOT NULL,
  `frecuencia` varchar(45) NOT NULL,
  `concepto` varchar(100) NOT NULL,
  `tipo` int(11) NOT NULL,
  `fecha_alta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idSeriePago` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `asocdesc` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `clien` varchar(30) NOT NULL,
  `prod` varchar(30) NOT NULL,
  `clas` varchar(30) NOT NULL,
  `clasjera` varchar(2048) NOT NULL,
  `util` float DEFAULT '0',
  `list` int(11) DEFAULT '1',
  `prec` float DEFAULT '0',
  `usar` varchar(10) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `clien` (`clien`),
  KEY `prod` (`prod`),
  KEY `clas` (`clas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `auxiliar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `venta` int(11) DEFAULT NULL,
  `partida` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `banco` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cuentabanco` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `cuentabanco` (`cuentabanco`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `basdats` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codemp` varchar(30) NOT NULL,
  `serv` varchar(255) NOT NULL,
  `usr` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `bd` varchar(255) NOT NULL,
  `usrs` varchar(255) NOT NULL,
  `rutap` varchar(500) DEFAULT '',
  `nom` varchar(255) DEFAULT '',
  `ladaen` varchar(10) DEFAULT '',
  `metcost` varchar(10) DEFAULT 'ultcost',
  `celen` varchar(255) DEFAULT '',
  `tel` varchar(255) DEFAULT '',
  `telen` varchar(255) DEFAULT '',
  `telper1en` varchar(255) DEFAULT '',
  `telper2en` varchar(255) DEFAULT '',
  `calle` varchar(255) DEFAULT '',
  `calleen` varchar(255) DEFAULT '',
  `col` varchar(255) DEFAULT '',
  `nointen` varchar(255) DEFAULT '',
  `colen` varchar(255) DEFAULT '',
  `noextenen` varchar(21) DEFAULT '',
  `CP` varchar(20) DEFAULT '',
  `CPen` varchar(20) DEFAULT '',
  `ciu` varchar(255) DEFAULT '',
  `ciuen` varchar(255) DEFAULT '',
  `estad` varchar(255) DEFAULT '',
  `estaden` varchar(255) DEFAULT '',
  `pai` varchar(255) DEFAULT '',
  `paien` varchar(255) DEFAULT '',
  `co1en` varchar(100) DEFAULT '',
  `co2en` varchar(100) DEFAULT '',
  `co3en` varchar(100) DEFAULT '',
  `RFC` varchar(21) DEFAULT '',
  `corr` varchar(100) DEFAULT '',
  `pagweb` varchar(255) DEFAULT '',
  `noint` varchar(21) DEFAULT '',
  `pers` varchar(2) DEFAULT '',
  `noext` varchar(21) DEFAULT '',
  `noexten` varchar(21) DEFAULT '',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `lugexp` varchar(255) DEFAULT '',
  `regfisc` varchar(255) DEFAULT '',
  `rutcer` varchar(2045) DEFAULT '',
  `rutkey` varchar(2045) DEFAULT '',
  `passcer` varchar(1000) DEFAULT '',
  `rutcerf` varchar(2045) DEFAULT '',
  `rutkeyf` varchar(2045) DEFAULT '',
  `passcerf` varchar(1000) DEFAULT '',
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `servOestac` varchar(30) NOT NULL,
  `tipEstac` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `plantilla` varchar(100) DEFAULT NULL,
  `test` int(11) DEFAULT 0,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codemp` (`codemp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP PROCEDURE IF EXISTS `Bitacora_Cliente`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Bitacora_Cliente`(
in par_emp varchar(30),
in par_nom varchar(255),
in par_ser varchar(30),
in par_accio varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_idempresa varchar(30))
BEGIN
INSERT INTO logemps(emp,nom,ser,accio,estac,sucu,nocaj,falt,idempresa)
VALUES(par_emp,par_nom,par_ser,par_accio,par_estac,par_sucu,par_nocaj,now(),par_idempresa); 
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `CancelaCXCPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CancelaCXCPorId`(in par_id int)
BEGIN
   UPDATE cxc set estado = 'CA' where id_id = par_id;   
END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `cfdi_relacionados_pago` (
  `id_pago` int(11) NOT NULL,
  `uuid` varchar(40) NOT NULL DEFAULT '',
  `tipo_relacion` varchar(5) NOT NULL DEFAULT '',
  KEY `fk_id_pago_idx` (`id_pago`),
  CONSTRAINT `fk_id_pago` FOREIGN KEY (`id_pago`) REFERENCES `documentos_pago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `chat` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `msj` varchar(1000) NOT NULL,
  `vist` varchar(2000) DEFAULT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `estacdestin` varchar(30) DEFAULT '',
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clasemp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clasificacion` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clasjeracli` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `clas` varchar(30) NOT NULL,
  `rut` varchar(2048) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `clas` (`clas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clasjeraprod` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `clas` varchar(30) NOT NULL,
  `rut` varchar(2048) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `clas` (`clas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clasjeraprov` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `clas` varchar(30) NOT NULL,
  `rut` varchar(2048) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`clas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clasprod` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  UNIQUE KEY `cod_UNIQUE` (`cod`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `clasprov` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `colos` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `compa` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `compa` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `compa` (`compa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comprs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcomp` varchar(30) NOT NULL,
  `noser` varchar(30) NOT NULL,
  `prov` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `notcred` varchar(30) DEFAULT '',
  `tipcam` decimal(22,6) NOT NULL,
  `tipcamnac` decimal(22,6) NOT NULL,
  `monedaID` int(11) NOT NULL,
  `notcredpag` varchar(250) DEFAULT '',
  `concep` varchar(30) DEFAULT '',
  `ruta` varchar(500) DEFAULT '',
  `referencia` varchar(255) DEFAULT NULL,
  `observ` varchar(255) DEFAULT '',
  `nomprov` varchar(255) NOT NULL,
  `metpag` varchar(42) DEFAULT '',
  `cta` varchar(42) DEFAULT '',
  `nodoc` varchar(50) NOT NULL,
  `fdoc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `impue` decimal(22,6) NOT NULL,
  `subtot` decimal(22,6) NOT NULL,
  `tip` varchar(30) DEFAULT NULL,
  `tot` decimal(22,6) NOT NULL,
  `archpdf` bit(1) DEFAULT b'0',
  `archxml` bit(1) DEFAULT b'0',
  `recib` decimal(22,6) DEFAULT '0.000000',
  `contra` int(11) DEFAULT '0',
  `estado` varchar(10) NOT NULL,
  `motiv` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `codord` varchar(30) DEFAULT '',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_traslado` decimal(22,6) NOT NULL DEFAULT '0.000000',
  `total_retencion` decimal(22,6) NOT NULL DEFAULT '0.000000',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcomp` (`codcomp`),
  KEY `idempresa` (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comprs_tmp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcomp` varchar(30) NOT NULL,
  `noser` varchar(30) NOT NULL,
  `prov` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `notcred` varchar(30) DEFAULT '',
  `tipcam` decimal(22,6) NOT NULL,
  `tipcamnac` decimal(22,6) NOT NULL,
  `monedaID` int(11) NOT NULL,
  `notcredpag` varchar(250) DEFAULT '',
  `concep` varchar(30) DEFAULT '',
  `ruta` varchar(500) DEFAULT '',
  `referencia` varchar(255) DEFAULT '',
  `observ` varchar(255) DEFAULT '',
  `nomprov` varchar(255) NOT NULL,
  `metpag` varchar(42) DEFAULT '',
  `cta` varchar(42) DEFAULT '',
  `nodoc` varchar(50) NOT NULL,
  `fdoc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `subtot` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) NOT NULL,
  `tip` varchar(30) DEFAULT NULL,
  `tot` decimal(22,6) NOT NULL,
  `archpdf` bit(1) DEFAULT b'0',
  `archxml` bit(1) DEFAULT b'0',
  `recib` decimal(22,6) DEFAULT '0.000000',
  `contra` int(11) DEFAULT '0',
  `estado` varchar(10) NOT NULL,
  `motiv` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `codord` varchar(30) DEFAULT '',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `total_traslado` decimal(22,6) NOT NULL,
  `total_retencion` decimal(22,6) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcomp` (`codcomp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `concepnot` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `concep` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `concep` (`concep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `conceppag` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `concep` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `concep` (`concep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `conceps` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `concep` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `confgral` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `clasif` varchar(45) NOT NULL,
  `conf` varchar(45) NOT NULL,
  `val` int(11) NOT NULL,
  `nume` float DEFAULT '0',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `dia` int(11) DEFAULT '0',
  `envia` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `extr` varchar(1000) DEFAULT '',
  `asun` varchar(255) DEFAULT '',
  `anio` int(11) DEFAULT '0',
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `clasif` (`clasif`),
  KEY `conf` (`conf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `consecs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `ser` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `tip` varchar(10) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `consec` int(11) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `contras` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_idp` int(11) NOT NULL,
  `prov` varchar(30) NOT NULL,
  `respon` varchar(100) NOT NULL,
  `comp` varchar(30) NOT NULL,
  `tot` float NOT NULL,
  `fech` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prov` (`prov`),
  KEY `comp` (`comp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `controlexportar` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_ultimaVentaExpo` int(6) NOT NULL DEFAULT '0',
  `id_ultimapartidaExpo` int(6) NOT NULL DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `fechaExpo` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fechaImpo` timestamp NULL DEFAULT NULL,
  `tipo` varchar(255) DEFAULT ' ',
  PRIMARY KEY (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `correo_terminal` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(350) NOT NULL,
  `contra` varchar(100) NOT NULL,
  `muestracomo` varchar(350) NOT NULL,
  `direccionserver` varchar(350) NOT NULL,
  `correoA` varchar(350) NOT NULL,
  `puerto` int(4) NOT NULL,
  `ingresocorreo` int(4) NOT NULL DEFAULT '1',
  `idempresa` varchar(30) NOT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `corrselec` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `srvsmtpsal` varchar(50) NOT NULL,
  `asunfac` varchar(255) NOT NULL,
  `asuncot` varchar(255) NOT NULL,
  `asuncontra` varchar(255) NOT NULL,
  `asunord` varchar(255) NOT NULL,
  `asunrec1` varchar(255) NOT NULL,
  `asunrec2` varchar(255) NOT NULL,
  `asunrec3` varchar(255) NOT NULL,
  `cuerpfac` varchar(255) NOT NULL,
  `cuerpcot` varchar(255) NOT NULL,
  `cuerpcontra` varchar(255) NOT NULL,
  `cuerpord` varchar(255) NOT NULL,
  `cuerprec1` varchar(255) NOT NULL,
  `cuerprec2` varchar(255) NOT NULL,
  `cuerprec3` varchar(255) NOT NULL,
  `portsmtp` int(11) NOT NULL,
  `actslenlog` bit(1) NOT NULL,
  `usr` varchar(61) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `corralter` varchar(50) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `estacglo` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `export` bit(1) DEFAULT b'0',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cortes` (
  `idCorte` int(11) NOT NULL AUTO_INCREMENT,
  `dia` date DEFAULT NULL,
  `hora` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCorte`),
  UNIQUE KEY `unico` (`dia`,`hora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `cortszx` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `numcort` int(11) NOT NULL,
  `cort` varchar(30) NOT NULL,
  `regis` int(11) DEFAULT '0',
  `totvtas` int(11) NOT NULL,
  `totingr` float NOT NULL,
  `totegre` float NOT NULL,
  `totcaj` float NOT NULL,
  `vtabruta` float DEFAULT '0',
  `descu` float DEFAULT '0',
  `devs` float DEFAULT '0',
  `vtanet` float DEFAULT '0',
  `impue` float DEFAULT '0',
  `vtanetimp` float DEFAULT '0',
  `totfacs` float DEFAULT '0',
  `tottics` float DEFAULT '0',
  `cantfac` int(11) DEFAULT '0',
  `canttics` int(11) DEFAULT '0',
  `totefe` float DEFAULT '0',
  `totdeb` float DEFAULT '0',
  `tottarcred` float DEFAULT '0',
  `totdep` float DEFAULT '0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `costs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `cant` float NOT NULL,
  `cost` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `monedaID` int(11) NOT NULL,
  `tipcam` decimal(22,6) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cots` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcot` varchar(30) NOT NULL,
  `proy` varchar(30) NOT NULL,
  `motiv` varchar(255) DEFAULT '',
  `noser` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `totdescu` float NOT NULL,
  `totcost` float NOT NULL,
  `vta` int(11) DEFAULT '0',
  `norefer` varchar(30) DEFAULT '',
  `tipcam` float NOT NULL,
  `mon` varchar(30) NOT NULL DEFAULT '',
  `noservta` varchar(30) DEFAULT '',
  `codemp` varchar(30) NOT NULL,
  `observ` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(255) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `subtotgral` float NOT NULL,
  `subtotgral2` float NOT NULL,
  `subtot` float NOT NULL,
  `manobr` float NOT NULL,
  `impue` float NOT NULL,
  `subtotmat` float NOT NULL,
  `subtotmat2` float NOT NULL,
  `tot` float NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estad` varchar(10) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `MonedaID` int DEFAULT 0,
  `total_traslado` DECIMAL(22,6) DEFAULT 0,
  `total_retencion` DECIMAL(22,6) DEFAULT 0,
  `fdoc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fentre` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipcamnac` FLOAT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcot` (`codcot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cuentas_contables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuenta` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `iCuenta` (`cuenta`,`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cumple` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `de` varchar(150) NOT NULL,
  `a` varchar(150) NOT NULL,
  `fcumple` varchar(30) NOT NULL,
  `codemp` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `estad` bit(1) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `anio` varchar(10) DEFAULT '',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fhoy` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codemp` (`codemp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cxc` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `norefer` varchar(50) NOT NULL,
  `noser` varchar(20) NOT NULL,
  `empre` varchar(30) NOT NULL,
  `formpag` varchar(30) DEFAULT '',
  `conceppag` varchar(30) DEFAULT '',
  `ser` varchar(20) NOT NULL,
  `subtot` decimal(22,6) NOT NULL,
  `tot` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) NOT NULL,
  `carg` decimal(22,6) NOT NULL,
  `abon` decimal(22,6) NOT NULL,
  `comen` varchar(500) DEFAULT '',
  `concep` varchar(30) DEFAULT '',
  `folbanc` varchar(50) DEFAULT '',
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fdoc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fol` int(11) DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `export` bit(1) DEFAULT b'0',
  `cuentabanco` varchar(30) DEFAULT '',
  `estado` varchar(30) DEFAULT '',
  `venta_origen` int(11) DEFAULT '0',
  `id_venta` int(11) NOT NULL DEFAULT '0',
  `monedaID` int(11) NOT NULL DEFAULT '0',
  `tipcam` decimal(22,6) NOT NULL DEFAULT '0.000000',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `noser` (`noser`),
  KEY `norefer` (`norefer`),
  KEY `empre` (`empre`),
  KEY `id_venta` (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cxp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `norefer` varchar(50) NOT NULL,
  `noser` varchar(30) NOT NULL,
  `prov` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `formpag` varchar(30) DEFAULT '',
  `conceppag` varchar(30) DEFAULT '',
  `monedaID` int(11) NOT NULL,
  `tipcam` decimal(22,6) NOT NULL,
  `comen` varchar(500) DEFAULT '',
  `subtot` decimal(22,6) NOT NULL,
  `tot` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) NOT NULL,
  `carg` decimal(22,6) NOT NULL,
  `abon` decimal(22,6) NOT NULL,
  `concep` varchar(30) DEFAULT '',
  `folbanc` varchar(50) DEFAULT '',
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fdoc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fol` int(11) DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `cuentabanco` varchar(30) DEFAULT '',
  `estado` varchar(30) DEFAULT '',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `norefer` (`norefer`),
  KEY `noser` (`noser`),
  KEY `prov` (`prov`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_aduana` (
  `c_Aduana` varchar(5) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`c_Aduana`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_claveprodserv` (
  `c_ClaveProdServ` varchar(12) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `FechaInicioVigencia` datetime DEFAULT NULL,
  `FechaFinVigencia` datetime DEFAULT NULL,
  PRIMARY KEY (`c_ClaveProdServ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_claveunidad` (
  `c_claveunidad_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_ClaveUnidad` varchar(5) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `Descripcion` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`c_claveunidad_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_codigopostal` (
  `c_codigopostal_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_CodigoPostal` varchar(5) NOT NULL,
  `c_Estado` varchar(5) DEFAULT NULL,
  `c_Municipio` varchar(5) DEFAULT NULL,
  `c_Localidad` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`c_codigopostal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_formapago` (
  `c_FormaPago` varchar(5) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`c_FormaPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_metodopago` (
  `c_metodopago_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_MetodoPago` varchar(5) DEFAULT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Fecha_inicio_de_vigencia` datetime DEFAULT NULL,
  PRIMARY KEY (`c_metodopago_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_moneda` (
  `c_moneda_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_Moneda` varchar(5) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Decimales` varchar(5) DEFAULT NULL,
  `Porcentaje_variación` int(11) NOT NULL,
  `Fecha_inicio_de_vigencia` datetime DEFAULT NULL,
  PRIMARY KEY (`c_moneda_id`),
  KEY `Porcentaje_variación_index` (`Porcentaje_variación`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_pais` (
  `c_pais_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_Pais` varchar(5) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Formato_de_código_postal` varchar(45) DEFAULT NULL,
  `Formato_de_Registro_de_Identidad_Tributaria` varchar(255) DEFAULT NULL,
  `Validación_del_Registro_de_Identidad_Tributaria` varchar(255) DEFAULT NULL,
  `Agrupaciones` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`c_pais_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_regimenfiscal` (
  `c_RegimenFiscal` int(11) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Física` tinyint(1) DEFAULT NULL,
  `Moral` tinyint(1) DEFAULT NULL,
  `Fecha_de_inicio_de_vigencia` datetime DEFAULT NULL,
  PRIMARY KEY (`c_RegimenFiscal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_tipodecomprobante` (
  `c_tipodecomprobante_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_TipoDeComprobante` varchar(5) DEFAULT NULL,
  `Descripcion` varchar(12) DEFAULT NULL,
  `Valor_maximo` varchar(25) DEFAULT NULL,
  `Fecha_inicio_de_vigencia` datetime DEFAULT NULL,
  PRIMARY KEY (`c_tipodecomprobante_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_tiporelacion` (
  `c_TipoRelacion` varchar(5) NOT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Fecha_inicio_de_vigencia` datetime DEFAULT NULL,
  PRIMARY KEY (`c_TipoRelacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `c_usocfdi` (
  `c_usocfdi_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_UsoCFDI` varchar(5) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Persona_Fisica` tinyint(1) DEFAULT NULL,
  `Persona_Moral` tinyint(1) DEFAULT NULL,
  `Fecha_inicio_de_vigencia` datetime DEFAULT NULL,
  PRIMARY KEY (`c_usocfdi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `datoscp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `vta` int(11) NOT NULL,
  `remitente` varchar(255) DEFAULT NULL,
  `callerem` varchar(255) DEFAULT NULL,
  `noextrem` varchar(255) DEFAULT NULL,
  `nointrem` varchar(255) DEFAULT NULL,
  `colrem` varchar(255) DEFAULT NULL,
  `cprem` varchar(255) DEFAULT NULL,
  `ciurem` varchar(255) DEFAULT NULL,
  `estadrem` varchar(255) DEFAULT NULL,
  `paisrem` varchar(255) DEFAULT NULL,
  `rfc` varchar(15) DEFAULT NULL,
  `calleremrec` varchar(255) DEFAULT NULL,
  `noextremrec` varchar(255) DEFAULT NULL,
  `nointremrec` varchar(255) DEFAULT NULL,
  `colremrec` varchar(255) DEFAULT NULL,
  `cpremrec` varchar(255) DEFAULT NULL,
  `ciuremrec` varchar(255) DEFAULT NULL,
  `estadremrec` varchar(255) DEFAULT NULL,
  `paisremrec` varchar(255) DEFAULT NULL,
  `fent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `desti` varchar(255) DEFAULT NULL,
  `calledesti` varchar(255) DEFAULT NULL,
  `noextdesti` varchar(255) DEFAULT NULL,
  `nointdesti` varchar(255) DEFAULT NULL,
  `coldesti` varchar(255) DEFAULT NULL,
  `cpdesti` varchar(255) DEFAULT NULL,
  `ciudesti` varchar(255) DEFAULT NULL,
  `estaddesti` varchar(255) DEFAULT NULL,
  `paisdesti` varchar(255) DEFAULT NULL,
  `calledestient` varchar(255) DEFAULT NULL,
  `noextdestient` varchar(255) DEFAULT NULL,
  `nointdestient` varchar(255) DEFAULT NULL,
  `coldestient` varchar(255) DEFAULT NULL,
  `cpdestient` varchar(255) DEFAULT NULL,
  `estaddestient` varchar(255) DEFAULT NULL,
  `ciudestient` varchar(255) DEFAULT NULL,
  `paisdestient` varchar(255) DEFAULT NULL,
  `nombretrans` varchar(255) DEFAULT NULL,
  `vehiculo` varchar(255) DEFAULT NULL,
  `placas` varchar(255) DEFAULT NULL,
  `idempresa` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP PROCEDURE IF EXISTS `DEL_AlmacenPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_AlmacenPorCodigo`(in par_alma varchar(30), in par_id_empresa varchar(30))
BEGIN
DELETE FROM almas
WHERE alma = par_alma and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_AlmacenPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_AlmacenPorId`(in par_id int, in par_id_empresa varchar(30))
BEGIN
DELETE FROM almas
WHERE id_id = par_id and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ChatCorporativo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ChatCorporativo`(in par_id_empresa varchar(30))
BEGIN
	DELETE FROM chat WHERE estacdestin = '' AND idempresa = par_id_empresa; 
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ChatUsuarios`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ChatUsuarios`(in par_id_empresa varchar(30))
BEGIN
   DELETE FROM chat WHERE estacdestin <> '' AND idempresa = par_id_empresa; 
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ClientePorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ClientePorCodigo`(
	IN `par_codigo` VARCHAR(45)
)
BEGIN
DELETE FROM emps WHERE codigo = par_codigo;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ClientePorCodigoEmpleado`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ClientePorCodigoEmpleado`(
	IN `par_cod_emp` VARCHAR(30)
)
BEGIN
DELETE FROM emps WHERE codemp = par_codemp;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ClientePorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ClientePorId`(
	IN `par_id_cliente` INT
)
BEGIN
DELETE FROM emps WHERE id_id = par_idcliente;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ClienteSerCod`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ClienteSerCod`(IN par_id_empresa VARCHAR(30), IN par_codemp VARCHAR(30),IN par_ser VARCHAR(30))
BEGIN
    DELETE FROM emps WHERE codemp = par_codemp AND ser = par_ser AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_Configuracion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_Configuracion`(in par_conf varchar(45), in par_id_empresa varchar(30))
BEGIN
   DELETE FROM confgral WHERE idempresa = par_id_empresa AND conf = par_conf;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ConfiguracionPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ConfiguracionPorId`(in par_id int)
BEGIN
   DELETE FROM confgral WHERE id_id = par_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_Correo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_Correo`(in par_id_id int, in par_id_empresa varchar(30))
BEGIN
   DELETE FROM corrselec WHERE id_id = par_id_id AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_CuentasPorPagarNoRefer`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_CuentasPorPagarNoRefer`(in par_id_empresa varchar(30), in par_norefer varchar(50))
BEGIN
DELETE FROM cxp
WHERE idempresa = par_id_empresa AND norefer = par_norefer;

END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `DEL_Impuesto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_Impuesto`(in par_id_empresa varchar(30), in par_codigo varchar(30))
BEGIN
   DELETE FROM impues
   WHERE codimpue = par_codigo and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_EstacPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_EstacPorCodigo`(in par_estac varchar(30), in par_id_empresa varchar(30))
BEGIN
   DELETE FROM estacs WHERE estac = par_estac AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_IngresoEncabezadoPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_IngresoEncabezadoPorId`(in par_id_empresa varchar(30), in par_id_id int)
BEGIN
   DELETE FROM ingresos_encab  WHERE id_empresa = par_id_empresa and id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_IngresoPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_IngresoPorId`(in par_id_empresa varchar(30), in par_id_id int)
BEGIN
   DELETE FROM ingres WHERE id_id = par_id_id AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ProductoPorID`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ProductoPorID`(
	IN `par_idproducto` INT
)
BEGIN
   DELETE FROM prods WHERE id_id = par_id_producto;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ProductoPorProd`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ProductoPorProd`(
	IN par_id_empresa VARCHAR(30), IN `par_prod` VARCHAR(255)
)
BEGIN
   DELETE FROM impues_x_product WHERE produ = par_prod AND idempresa = par_id_empresa;
   DELETE FROM prods WHERE prod = par_prod AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ProveedorPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ProveedorPorId`(IN par_id_empresa VARCHAR(30), in par_id_id int)
BEGIN
    DELETE FROM provs WHERE id_id = par_id_id AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_ProveedorPorProv`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_ProveedorPorProv`(
IN par_id_empresa VARCHAR(30), 
IN par_prov varchar(30),
IN par_ser varchar(30)
)
BEGIN
    DELETE FROM provs WHERE ser = par_ser AND prov = par_prov AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `DEL_Traspaso`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEL_Traspaso`(in par_id_id int)
BEGIN
DELETE FROM traspas
WHERE id_id = par_id_id;
END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `documentos_contabilizados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento_id` varchar(45) NOT NULL,
  `tipo_documento` varchar(60) NOT NULL,
  `serie` varchar(30) NOT NULL,
  `folio` varchar(30) NOT NULL,
  `numero_poliza` int(11) NOT NULL,
  `tipo_poliza` varchar(45) NOT NULL,
  `fecha_poliza` date NOT NULL,
  `fecha_alta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `documentos_origen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `fecha_alta` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO documentos_origen(nombre,tipo) VALUES('COMPRAS','COMP');
INSERT INTO documentos_origen(nombre,tipo) VALUES('PAGOS','CXC');
INSERT INTO documentos_origen(nombre,tipo) VALUES('FACTURAS','FAC');
INSERT INTO documentos_origen(nombre,tipo) VALUES('NOTAS DE CRÉDITO CLIENTES','NOTC');
INSERT INTO documentos_origen(nombre,tipo) VALUES('NOTAS DE CRÉDITO PROVEEDORES','NOTP');
INSERT INTO documentos_origen(nombre,tipo) VALUES('TICKETS','TIK');
INSERT INTO documentos_origen(nombre,tipo) VALUES('CLIENTES','EMP');

CREATE TABLE IF NOT EXISTS `documentos_pago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serie` varchar(45) DEFAULT NULL,
  `folio` varchar(45) DEFAULT NULL,
  `cuentabanco` varchar(60) DEFAULT NULL,
  `formapago` varchar(45) DEFAULT NULL,
  `concepto` varchar(45) DEFAULT NULL,
  `codigo_cliente_proveedor` varchar(45) DEFAULT NULL,
  `importe` decimal(22,6) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `folio_banco` varchar(45) NOT NULL DEFAULT '',
  `tipo` varchar(45) DEFAULT NULL,
  `pendiente` decimal(22,6) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `fecha_documento` date DEFAULT NULL,
  `idempresa` varchar(30) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT CURRENT_TIMESTAMP,
  `uuid_fiscal` varchar(40) NOT NULL DEFAULT '',
  `transactionid` varchar(50) NOT NULL DEFAULT '',
  `selloDigital` varchar(1000) NOT NULL DEFAULT '',
  `selloSat` varchar(1000) NOT NULL DEFAULT '',
  `fechaTimbrado` datetime DEFAULT NULL,
  `lugarExpedicion` varchar(6) NOT NULL DEFAULT '',
  `regimenFiscal` varchar(10) NOT NULL DEFAULT '',
  `cadenaOriginal` varchar(2000) NOT NULL DEFAULT '',
  `certificadosat` varchar(45) NOT NULL DEFAULT '',
  `usuario` varchar(30) DEFAULT 'INICIAL',
  `sucursal` varchar(30) DEFAULT 'INICIAL',
  `caja` varchar(30) DEFAULT 'INICIAL',
  `color` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `documentos_pago_idx_idempre_tipo_id_documen` (`idempresa`,`tipo`,`id`,`fecha_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `domentcli` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codemp` varchar(30) NOT NULL,
  `lada` varchar(10) DEFAULT '',
  `exten` varchar(10) DEFAULT '',
  `cel` varchar(255) DEFAULT '',
  `tel` varchar(255) DEFAULT '',
  `telper1` varchar(255) DEFAULT '',
  `telper2` varchar(255) DEFAULT '',
  `calle` varchar(255) DEFAULT '',
  `col` varchar(255) DEFAULT '',
  `noint` varchar(255) DEFAULT '',
  `noext` varchar(21) DEFAULT '',
  `CP` varchar(20) DEFAULT '',
  `ciu` varchar(255) DEFAULT '',
  `estad` varchar(255) DEFAULT '',
  `pai` varchar(255) DEFAULT '',
  `co1` varchar(100) DEFAULT '',
  `co2` varchar(100) DEFAULT '',
  `co3` varchar(100) DEFAULT '',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codemp` (`codemp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `emps` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL DEFAULT '',
  `codemp` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `lada` varchar(10) DEFAULT '',
  `vend` varchar(30) DEFAULT '',
  `codclas` varchar(30) NOT NULL,
  `banc` varchar(30) DEFAULT '',
  `clavbanc` varchar(255) DEFAULT '',
  `zon` varchar(30) DEFAULT '',
  `giro` varchar(30) DEFAULT '',
  `nom` varchar(255) NOT NULL,
  `clasjera` varchar(2048) DEFAULT '',
  `tel` varchar(255) DEFAULT '',
  `ctapred` varchar(100) DEFAULT '',
  `cel` varchar(255) DEFAULT '',
  `exten` varchar(20) DEFAULT '',
  `telper1` varchar(255) DEFAULT '',
  `telper2` varchar(255) DEFAULT '',
  `calle` varchar(255) DEFAULT '',
  `col` varchar(255) DEFAULT '',
  `curp` varchar(50) DEFAULT '',
  `CP` varchar(20) DEFAULT '',
  `ciu` varchar(255) DEFAULT '',
  `estad` varchar(255) DEFAULT '',
  `pai` varchar(255) DEFAULT '',
  `revis` varchar(100) DEFAULT '',
  `pags` varchar(100) DEFAULT '',
  `RFC` varchar(21) DEFAULT '',
  `descu` float DEFAULT '0',
  `deposit` float DEFAULT '0',
  `co1` varchar(100) DEFAULT '',
  `co2` varchar(100) DEFAULT '',
  `otramon` bit(1) DEFAULT b'1',
  `otramonc` bit(1) DEFAULT b'1',
  `co3` varchar(100) DEFAULT '',
  `pagweb1` varchar(255) DEFAULT '',
  `pagweb2` varchar(255) DEFAULT '',
  `contac` varchar(255) DEFAULT '',
  `puest` varchar(255) DEFAULT '',
  `contact2` varchar(255) DEFAULT '',
  `puest2` varchar(255) DEFAULT '',
  `observ` varchar(255) DEFAULT '',
  `noint` varchar(100) DEFAULT '',
  `noext` varchar(100) DEFAULT '',
  `diacred` varchar(21) DEFAULT '',
  `metpag` varchar(45) DEFAULT '',
  `cta` varchar(45) DEFAULT '0000',
  `encall` varchar(255) DEFAULT '',
  `enciu` varchar(255) DEFAULT '',
  `ennoext` varchar(21) DEFAULT '',
  `ennoexten` varchar(21) DEFAULT '',
  `enlada` varchar(10) DEFAULT '',
  `ennoint` varchar(21) DEFAULT '',
  `encol` varchar(255) DEFAULT '',
  `encp` varchar(20) DEFAULT '',
  `encel` varchar(255) DEFAULT '',
  `entel1` varchar(255) DEFAULT '',
  `entel2` varchar(255) DEFAULT '',
  `entel3` varchar(255) DEFAULT '',
  `enemail` varchar(100) DEFAULT '',
  `enco1` varchar(100) DEFAULT '',
  `enco2` varchar(100) DEFAULT '',
  `enco3` varchar(100) DEFAULT '',
  `enpagweb` varchar(255) DEFAULT '',
  `enpai` varchar(255) DEFAULT '',
  `enestad` varchar(255) DEFAULT '',
  `diapag` int(11) DEFAULT '0',
  `pers` varchar(2) DEFAULT '',
  `limtcred` float DEFAULT '0',
  `bloq` bit(1) DEFAULT b'0',
  `bloqlimcred` bit(1) DEFAULT b'0',
  `ctaconta` varchar(30) DEFAULT '',
  `list` int(11) NOT NULL,
  `contac3` varchar(255) DEFAULT '',
  `telcon3` varchar(255) DEFAULT '',
  `telper3` varchar(255) DEFAULT '',
  `telper33` varchar(255) DEFAULT '',
  `contac4` varchar(255) DEFAULT '',
  `telcon4` varchar(255) DEFAULT '',
  `telper4` varchar(255) DEFAULT '',
  `telper44` varchar(255) DEFAULT '',
  `contac5` varchar(255) DEFAULT '',
  `telcon5` varchar(255) DEFAULT '',
  `telper5` varchar(255) DEFAULT '',
  `telper55` varchar(255) DEFAULT '',
  `contac6` varchar(255) DEFAULT '',
  `telcon6` varchar(255) DEFAULT '',
  `telper6` varchar(255) DEFAULT '',
  `telper66` varchar(255) DEFAULT '',
  `contac7` varchar(255) DEFAULT '',
  `telcon7` varchar(255) DEFAULT '',
  `telper7` varchar(255) DEFAULT '',
  `telper77` varchar(255) DEFAULT '',
  `contac8` varchar(255) DEFAULT '',
  `telcon8` varchar(255) DEFAULT '',
  `telper8` varchar(255) DEFAULT '',
  `telper88` varchar(255) DEFAULT '',
  `contac9` varchar(255) DEFAULT '',
  `telcon9` varchar(255) DEFAULT '',
  `telper9` varchar(255) DEFAULT '',
  `telper99` varchar(255) DEFAULT '',
  `Contac10` varchar(255) DEFAULT '',
  `telcon10` varchar(255) DEFAULT '',
  `telper10` varchar(255) DEFAULT '',
  `telper100` varchar(255) DEFAULT '',
  `idempresa` varchar(30) NOT NULL,
  `beneficiario` varchar(30) NOT NULL,
  `usocfdi` varchar(10) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `cumple` varchar(30) DEFAULT '',
  `agradfec` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `anio` varchar(10) DEFAULT '',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codemp` (`codemp`),
  KEY `ser` (`ser`),
  KEY `codigo` (`codigo`),
  KEY `emps_idx_idempresa_ser_nom` (`idempresa`,`ser`,`nom`,`codemp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `er_ejercicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ejercicio` int(4) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date DEFAULT NULL,
  `fechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `er_movimientos_inventario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAlmacen` int(11) NOT NULL,
  `idMovtoComercial` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `tipoMovimiento` int(11) DEFAULT '0',
  `cantidad` decimal(14,0) DEFAULT '0',
  `unidad` varchar(16) DEFAULT NULL,
  `costoUnitario` decimal(22,2) DEFAULT '0.00',
  `costoPromedio` decimal(22,2) NOT NULL DEFAULT '0.00',
  `existActual` decimal(22,2) DEFAULT '0.00',
  `idempresa` varchar(30) NOT NULL,
  `fechaMovimiento` date NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lotePedimento` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idProd` (`idProducto`),
  KEY `idAlmacen` (`idAlmacen`),
  KEY `IdMovtoComercial` (`idMovtoComercial`),
  CONSTRAINT `er_movimientos_inventario_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `prods` (`id_id`),
  CONSTRAINT `er_movimientos_inventario_ibfk_2` FOREIGN KEY (`idAlmacen`) REFERENCES `almas` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `er_permisos` (
  `PKId` int(11) NOT NULL AUTO_INCREMENT,
  `FKIdUsuario` int(11) NOT NULL,
  `permisoConf` bit(1) NOT NULL DEFAULT b'1',
  `permisoCorreos` bit(1) NOT NULL DEFAULT b'1',
  `permisoDatosEmpresa` bit(1) NOT NULL DEFAULT b'1',
  `permisoSeries` bit(1) NOT NULL DEFAULT b'1',
  `permisoImpresoras` bit(1) NOT NULL DEFAULT b'1',
  `permisoCambiarIcono` bit(1) NOT NULL DEFAULT b'1',
  `permisoConfiguracionesGenerales` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosConfig` bit(1) NOT NULL DEFAULT b'1',
  `permisoUsuarios` bit(1) NOT NULL DEFAULT b'1',
  `permisoUsuariosDefinir` bit(1) NOT NULL DEFAULT b'1',
  `permisoUsuariosConectados` bit(1) NOT NULL DEFAULT b'1',
  `permisoUsuariosPermisos` bit(1) NOT NULL DEFAULT b'1',
  `permisoClaves` bit(1) NOT NULL DEFAULT b'1',
  `permisoReparar` bit(1) NOT NULL DEFAULT b'1',
  `permisoRepararErrores` int(11) NOT NULL DEFAULT '1',
  `permisoRepararRestaurar` bit(1) NOT NULL DEFAULT b'1',
  `permisoBaseDatos` bit(1) NOT NULL DEFAULT b'1',
  `permisoBaseDatosConexiones` bit(1) NOT NULL DEFAULT b'1',
  `permisoBaseDatosArchivo` bit(1) NOT NULL DEFAULT b'1',
  `permisoReportes` bit(1) NOT NULL DEFAULT b'1',
  `permisoReportesUsuarios` bit(1) NOT NULL DEFAULT b'1',
  `permisoReportesRespaldos` bit(1) NOT NULL DEFAULT b'1',
  `permisoReportesLog` bit(1) NOT NULL DEFAULT b'1',
  `permisoReportesEstadistica` bit(1) NOT NULL DEFAULT b'1',
  `permisoRevocacion` bit(1) NOT NULL DEFAULT b'1',
  `permisoActivarSistema` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosSistema` bit(1) NOT NULL DEFAULT b'1',
  `permisoContabilidad` bit(1) NOT NULL DEFAULT b'1',
  `permisoConceptosNC` bit(1) NOT NULL DEFAULT b'1',
  `permisoCatalogoGarantias` bit(1) NOT NULL DEFAULT b'1',
  `permisoZonas` bit(1) NOT NULL DEFAULT b'1',
  `permisoGiros` bit(1) NOT NULL DEFAULT b'1',
  `permisoMonedas` bit(1) NOT NULL DEFAULT b'1',
  `permisoImpuestos` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosModulos` bit(1) NOT NULL DEFAULT b'1',
  `permisoCompras` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasCancelar` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasDevolucion` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasParcial` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasNuevo` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasNotCredito` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasVer` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasCargarArchivo` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasBorrarArchivo` bit(1) NOT NULL DEFAULT b'1',
  `permisoComprasRecibirOrden` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosCompras` bit(1) NOT NULL DEFAULT b'1',
  `permisoProvee` bit(1) NOT NULL DEFAULT b'1',
  `permisoProveeNuevo` bit(1) NOT NULL DEFAULT b'1',
  `permisoProveeModificar` bit(1) NOT NULL DEFAULT b'1',
  `permisoProveeVer` bit(1) NOT NULL DEFAULT b'1',
  `permisoProveeBorrar` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosProvee` bit(1) NOT NULL DEFAULT b'1',
  `permisoPrevio` bit(1) NOT NULL DEFAULT b'1',
  `permisoPrevioNueva` bit(1) NOT NULL DEFAULT b'1',
  `permisoPrevioAbrir` bit(1) NOT NULL DEFAULT b'1',
  `permisoPrevioVer` bit(1) NOT NULL DEFAULT b'1',
  `permisoPrevioCancelar` bit(1) NOT NULL DEFAULT b'1',
  `permisoPrevioSeries` bit(1) NOT NULL DEFAULT b'1',
  `permisoPrevioCompra` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosPrevio` bit(1) NOT NULL DEFAULT b'1',
  `permisoInventario` bit(1) NOT NULL DEFAULT b'1',
  `permisoProductos` bit(1) NOT NULL DEFAULT b'1',
  `permisoProductosNuevo` bit(1) NOT NULL DEFAULT b'1',
  `permisoProductosModificar` bit(1) NOT NULL DEFAULT b'1',
  `permisProductosBorrar` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosInventario` bit(1) NOT NULL DEFAULT b'1',
  `permisoClientes` bit(1) NOT NULL DEFAULT b'1',
  `permisoClientesNuevo` bit(1) NOT NULL DEFAULT b'1',
  `permisoClientesModificar` bit(1) NOT NULL DEFAULT b'1',
  `permisoClientesVer` bit(1) NOT NULL DEFAULT b'1',
  `permisoClientesBorrar` bit(1) NOT NULL DEFAULT b'1',
  `permisoClientesEnviar` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosClientes` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentas` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasCancelar` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasDevolucion` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasParcial` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasNueva` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasNotCredito` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasVer` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasEnviar` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasTimbrar` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasEntregar` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasComprobar` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasAcuse` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasObtenerXml` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasFacturar` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasCargarArchivo` bit(1) NOT NULL DEFAULT b'1',
  `permisoVentasBorrarArchivo` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosVentas` bit(1) NOT NULL DEFAULT b'1',
  `permisoCotiza` bit(1) NOT NULL DEFAULT b'1',
  `permisoCotizaNueva` bit(1) NOT NULL DEFAULT b'1',
  `permisoCotizaAbrir` bit(1) NOT NULL DEFAULT b'1',
  `permisoCotizaVer` bit(1) NOT NULL DEFAULT b'1',
  `permisoCotizaCancelar` bit(1) NOT NULL DEFAULT b'1',
  `permisoCotizaReenviar` bit(1) NOT NULL DEFAULT b'1',
  `permisoCotizaVenta` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisosCotiza` bit(1) NOT NULL DEFAULT b'1',
  `idempresa` varchar(30) NOT NULL,
  `permisoCxc` bit(1) NOT NULL DEFAULT b'1',
  `permisoPagoNuevo` bit(1) NOT NULL DEFAULT b'1',
  `permisoCancelarPago` bit(1) NOT NULL DEFAULT b'1',
  `otorgaPermisoCxc` bit(1) NOT NULL DEFAULT b'1',
  `permisProductosListaPrecio` bit(1) NOT NULL DEFAULT b'1',
  `permisProductosCargadoImagen` bit(1) NOT NULL DEFAULT b'1',
  `permisoPagos` bit(1) NOT NULL DEFAULT b'1',
  `permisoTimbrarPagos` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`PKId`),
  KEY `FKIdUsuario_idx` (`FKIdUsuario`),
  CONSTRAINT `FKIdUsuario` FOREIGN KEY (`FKIdUsuario`) REFERENCES `estacs` (`id_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `estacs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `correo` varchar(255) NOT NULL DEFAULT '',
  `52m` bit(1) NOT NULL,
  `ptovta` bit(1) DEFAULT b'0',
  `descu` float DEFAULT '0',
  `comi` float DEFAULT '0',
  `habdesc` int(11) DEFAULT '0',
  `imptic` varchar(255) DEFAULT '',
  `impfac` varchar(255) DEFAULT '',
  `cort` varchar(3) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `estacglo` varchar(30) NOT NULL,
  `calle` varchar(255) DEFAULT '',
  `nom` varchar(255) DEFAULT '',
  `col` varchar(255) DEFAULT '',
  `cp` varchar(20) DEFAULT '',
  `tel` varchar(255) DEFAULT '',
  `cel` varchar(255) DEFAULT '',
  `pai` varchar(255) DEFAULT '',
  `ciu` varchar(255) DEFAULT '',
  `esta` varchar(255) DEFAULT '',
  `noint` varchar(255) DEFAULT '',
  `res1path` varchar(2048) DEFAULT '',
  `res2path` varchar(2048) DEFAULT '',
  `res3path` varchar(2048) DEFAULT '',
  `rutmysq` varchar(2048) DEFAULT '',
  `noext` varchar(255) DEFAULT '',
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `admcaj` bit(1) DEFAULT b'0',
  `vend` bit(1) DEFAULT b'0',
  `mandagra` bit(1) DEFAULT b'0',
  `manddia` int(11) DEFAULT '0',
  `mandcump` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `almacen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`),
  KEY `idempresa` (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `estadiscor` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `corrde` varchar(61) NOT NULL,
  `corr` varchar(61) NOT NULL,
  `nodoc` varchar(255) NOT NULL,
  `tipdoc` varchar(100) NOT NULL,
  `estad` varchar(100) NOT NULL,
  `motiv` varchar(500) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `export` bit(1) DEFAULT b'0',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `existalma` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `alma` varchar(30) NOT NULL,
  `prod` varchar(255) NOT NULL,
  `exist` float NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`prod`),
  KEY `prod` (`prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `fabs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `descrip` varchar(255) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `facturas` (
  `venta` int(11) NOT NULL,
  `cliente` varchar(30) NOT NULL,
  `usocfdi` varchar(5) NOT NULL,
  `fentrega` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `producto` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `unidad` varchar(30) NOT NULL,
  `cantidad` decimal(22,6) NOT NULL,
  `clavesat` varchar(10) NOT NULL,
  `precio` decimal(22,6) NOT NULL,
  `pdescuento` decimal(22,6) NOT NULL,
  `descuento` decimal(22,6) NOT NULL,
  `importe` decimal(22,6) NOT NULL,
  `subtotal` decimal(22,6) NOT NULL,
  `tdescuento` decimal(22,6) NOT NULL,
  `total_retencion` decimal(22,6) NOT NULL,
  `total_traslado` decimal(22,6) NOT NULL,
  `total` decimal(22,6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `fluj` (
  `fluj` int(11) NOT NULL AUTO_INCREMENT,
  `concep` varchar(100) NOT NULL,
  `tipdoc` varchar(50) NOT NULL,
  `norefer` varchar(50) NOT NULL,
  `ing_eg` varchar(5) NOT NULL,
  `impo` float NOT NULL,
  `mon` varchar(100) NOT NULL,
  `modd` varchar(10) NOT NULL,
  `vta` int(11) NOT NULL,
  `ncortz` int(11) NOT NULL,
  `corta` int(11) DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`fluj`),
  KEY `ix_flujo` (`ing_eg`,`corta`,`concep`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `flujact` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `usrenvi` varchar(30) NOT NULL,
  `usrrecib` varchar(30) NOT NULL,
  `tit` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `usrenvi` (`usrenvi`),
  KEY `usrrecib` (`usrrecib`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `garan` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `gara` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `gara` (`gara`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `giro` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `gir` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `gir` (`gir`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `hist_antiguedaddesaldo` (
  `idCorte` int(11) NOT NULL,
  `nom` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `codemp` varchar(30) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `ven` decimal(65,6) NOT NULL DEFAULT '0.000000',
  `Anti15` decimal(65,6) NOT NULL DEFAULT '0.000000',
  `Anti30` decimal(65,6) NOT NULL DEFAULT '0.000000',
  `Anti45` decimal(65,6) NOT NULL DEFAULT '0.000000',
  `Anti45Mas` decimal(65,6) NOT NULL DEFAULT '0.000000',
  PRIMARY KEY (`idCorte`),
  KEY `IX_Busqueda` (`nom`,`codemp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `hist_existenciaporalmacen` (
  `idCorte` int(1) NOT NULL DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `prod` varchar(255) CHARACTER SET utf8 NOT NULL,
  `descrip` varchar(2100) CHARACTER SET utf8 DEFAULT NULL,
  `unid` varchar(30) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `alma` varchar(30) CHARACTER SET utf8 NOT NULL,
  `clasjera` varchar(2048) CHARACTER SET utf8 DEFAULT '',
  `codmed` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `codubi` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `anaq` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `lug` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `lin` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `marc` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `impue` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `codext` varchar(30) CHARACTER SET utf8 DEFAULT '',
  `exist` float NOT NULL,
  PRIMARY KEY (`idCorte`,`idempresa`,`prod`,`alma`,`unid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `grals` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `impues` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codimpue` varchar(30) NOT NULL,
  `reten` bit(1) DEFAULT b'0',
  `impueval` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `impuestoXML` varchar(45) DEFAULT 'Traslado IVA',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codimpue` (`codimpue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `impuestos_venta` (
  `venta` int(11) NOT NULL,
  `impuesto` varchar(30) NOT NULL,
  `retencion` bit(1) NOT NULL,
  `total` decimal(22,6) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT '',
  `extr2` varchar(255) DEFAULT '',
  `extr3` varchar(255) DEFAULT '',
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `venta` (`venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `impuestos_x_compra` (
  `compra` int(11) DEFAULT NULL,
  `impuesto` varchar(30) DEFAULT NULL,
  `retencion` bit(1) DEFAULT NULL,
  `total` decimal(22,6) NOT NULL,
  `idempresa` varchar(30) DEFAULT NULL,
  `estac` varchar(30) DEFAULT NULL,
  `sucu` varchar(30) DEFAULT NULL,
  `nocaj` varchar(30) DEFAULT NULL,
  `export` bit(1) DEFAULT b'0',
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `impuestos_x_venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `venta` int(11) NOT NULL,
  `id_partida` int(11) NOT NULL DEFAULT '0',
  `impuesto` varchar(30) NOT NULL,
  `retencion` bit(1) NOT NULL,
  `total` decimal(22,6) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT '',
  `extr2` varchar(255) DEFAULT '',
  `extr3` varchar(255) DEFAULT '',
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `venta` (`venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `impuesxpartidacot` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idParts` int(11) NOT NULL,
  `idPartida` int(11) NOT NULL,
  `ret_tras` varchar(3) NOT NULL,
  `codigoImpuesto` varchar(30) NOT NULL,
  `total` decimal(22,6) NOT NULL,
  `retencion` int(11) NOT NULL,
  `tasa` decimal(22,6) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `impuesxpartidaped` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idParts` int(11) NOT NULL,
  `idPartida` int(11) NOT NULL,
  `ret_tras` varchar(3) NOT NULL,
  `codigoImpuesto` varchar(30) NOT NULL,
  `total` decimal(22,6) NOT NULL,
  `retencion` int(11) NOT NULL,
  `tasa` decimal(22,6) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `impues_x_product` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `produ` varchar(30) NOT NULL,
  `impue` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  UNIQUE KEY `produ_impue_unique` (`produ`,`impue`),
  KEY `produ` (`produ`),
  KEY `impue` (`impue`),
  CONSTRAINT `impues_x_product_ibfk_1` FOREIGN KEY (`produ`) REFERENCES `prods` (`prod`),
  CONSTRAINT `impues_x_product_ibfk_2` FOREIGN KEY (`impue`) REFERENCES `impues` (`codimpue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ingres` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idIngresCab` int(11) DEFAULT NULL,
  `prod` varchar(255) NOT NULL,
  `alma` varchar(255) NOT NULL,
  `unid` varchar(255) NOT NULL,
  `concep` varchar(50) NOT NULL,
  `cant` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `entsal` bit(1) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `activo` varchar(45) DEFAULT '',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `costo` varchar(50) DEFAULT '0',
  `cantsal` decimal(22,6) DEFAULT NULL,
  `tipcamnac` decimal(22,6) NOT NULL,
  `pedimento` varchar(30) not null default '',
  `lote` varchar(45) not null default '',
  `caducidad` date not null default '1700-01-01',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `alma` (`alma`),
  KEY `FK_Ingresos_idx` (`idIngresCab`),
  CONSTRAINT `FK_Ingresos` FOREIGN KEY (`idIngresCab`) REFERENCES `ingresos_encab` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ingresos_encab` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `alma` varchar(255) NOT NULL,
  `concep` varchar(50) NOT NULL,
  `canttotal` decimal(22,6) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `entsal` bit(1) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `noser` varchar(30) NOT NULL DEFAULT '',
  `norefer` varchar(30) NOT NULL DEFAULT '',
  `pedimento` varchar(30) NOT NULL DEFAULT '',
  `lote` varchar(45) NOT NULL DEFAULT '',
  `caducidad` date NOT NULL DEFAULT '1700-01-01',
  PRIMARY KEY (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP PROCEDURE IF EXISTS `inicio_almas`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_almas`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO almas(alma,almadescrip,estac,sucu,nocaj,respon,idempresa) VALUES('SYS','ALMACÉN GENÉRICO','INICIAL','INICIAL','INICIAL','',par_id_empresa);
INSERT INTO almas(alma,almadescrip,estac,sucu,nocaj,respon,idempresa) VALUES('ACTFIJ','ACTIVO FIJO','INICIAL','INICIAL','INICIAL','',par_id_empresa);
INSERT INTO almas(alma,almadescrip,estac,sucu,nocaj,respon,idempresa) VALUES('GENERAL','GENERAL','INICIAL','INICIAL','INICIAL','',par_id_empresa);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_basdats`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_basdats`(
in par_codemp varchar(30),
in par_nom varchar(255),
in par_serv varchar(255),
in par_usr varchar(255),
in par_pass varchar(255),
in par_bd varchar(255),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_usrs varchar(255),
in par_id_empresa varchar(30),
in par_servOestac varchar(30),
in par_tipEstac varchar(30),
in par_rutap varchar(500),
in par_rfc varchar(21),
in par_calle varchar(255),
in par_col varchar(255),
in par_cp varchar(255),
in par_ciu varchar(255),
in par_estad varchar(255),
in par_pai varchar(255),
in par_pers varchar(2),
in par_noext varchar(21),
in par_lugexp varchar(255),
in par_regfisc varchar(255),
in par_rutcer varchar(2045),
in par_rutkey varchar(2045),
in par_passcer varchar(1000),
in par_plantilla varchar(100)
)
BEGIN
INSERT INTO basdats(codemp,nom,serv,usr,pass,bd,estac,falt,sucu,nocaj,usrs,idempresa,servOestac,tipEstac,rutap,rfc,calle,col,cp,ciu,estad,pai,pers,noext,lugexp,regfisc,rutcer,rutkey,passcer,plantilla) 
VALUES(par_codemp,par_nom,par_serv,par_usr,par_pass,par_bd,par_estac,now(),par_sucu,par_nocaj,par_usrs,par_id_empresa,par_servOestac,par_tipEstac,par_rutap,par_rfc,par_calle,par_col,par_cp,par_ciu,par_estad,par_pai,par_pers,par_noext,par_lugexp,par_regfisc,par_rutcer,par_rutkey,par_passcer,par_plantilla);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_catalogos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_catalogos`()
BEGIN

INSERT INTO c_aduana
SELECT * from dbempresas.c_aduana;

INSERT INTO c_claveprodserv
SELECT * from dbempresas.c_claveprodserv;

INSERT INTO c_claveunidad
SELECT * from dbempresas.c_claveunidad;

INSERT INTO c_codigopostal
SELECT * from dbempresas.c_codigopostal;

INSERT INTO c_formapago
SELECT * from dbempresas.c_formapago;

INSERT INTO c_metodopago
SELECT * from dbempresas.c_metodopago;

INSERT INTO c_moneda
SELECT * from dbempresas.c_moneda;

INSERT INTO c_pais
SELECT * from dbempresas.c_pais;

INSERT INTO c_regimenfiscal
SELECT * from dbempresas.c_regimenfiscal;

INSERT INTO c_tipodecomprobante
SELECT * from dbempresas.c_tipodecomprobante;

INSERT INTO c_tiporelacion
SELECT * from dbempresas.c_tiporelacion;

INSERT INTO c_usocfdi
SELECT * from dbempresas.c_usocfdi;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_cliente_mostrador`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_cliente_mostrador`(in par_id_empresa varchar(30))
BEGIN
   INSERT INTO emps(codigo,codemp,ser,codclas,nom,RFC,descu,deposit,otramon,otramonc,cta,diapag,limtcred,bloq,bloqlimcred,list,idempresa,estac,sucu,nocaj,export,beneficiario,usocfdi)
   VALUES('EMPMOS','MOS','EMP','SYS','PUBLICO GENERAL','XAXX010101000',0,0,1,1,'000',0,0,0,0,1,par_id_empresa,'INICIAL','INICIAL','INICIAL',0,'','');

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_concep`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_concep`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('AIN','AJUSTE POR INVENTARIO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('MER','MERMA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('ROB','ROBO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('MAL','MALESTADO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('COM','COMPRA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('CAD','CADUCO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('ROT','ROTO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('DEF','DEFECTUOSO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('MOJ','MOJADO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('SINC','SIN CAJA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('PROMO','PROMOCIÓN','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('CORTE','CORTESÍA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('OFER','OFERTA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('NOFUN','NO FUNCIONA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('SALG','SALIDA GENERICA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('ENTG','ENTRADA GENERICA','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('MERMA','MERMA A GRANEL','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('PROR','PRORATEO','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('DONA','DONACIONES','INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO conceps(concep,descrip,estac,sucu,nocaj,idempresa) VALUES('TRAS','TRASPASO','INICIAL','INICIAL','INICIAL',par_id_empresa);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_confgral`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_confgral`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('prev','prevporusuario',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('prev','prevmonac',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('prev','prevmodesc',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('prev','prevmodprec',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('prev','prevunavezser',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('prev','prevobligarser',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(extr,clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('RESP','resp','respaut',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'inv','esexitmov',1,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'inv','traspasexis',1,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'inv','igualser',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,nume,idempresa) VALUES(0,'sist','redon',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',0,par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'sist','tipcamtod',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'sist','mostmsjusr',1,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'sist','usrmulti',1,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'sist','calc',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'sist','cuader',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'sist','apfavo',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(30,'sist','agrad',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(dia,clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES(0,'sist','cfdi33',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,nume, falt,fmod,estac,sucu,nocaj,idempresa) VALUES('sist','posdecimal',0,4, now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('sist','cumple',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('sist','dlogin',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','venunaser',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vencotunaser',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','venunaserpv',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','logorem',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','slimcredrem',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vremptovta',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','imprempto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','canrempto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('rems','vercanrem',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('rems','guapdfcan',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr,idempresa) VALUES('vtas','moddescrip',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','monfacfij',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','serfacfij',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr,nume,idempresa) VALUES('vtas','minfac',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS',100,par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr,idempresa) VALUES('vtas','almavtaf',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','devvtaspto',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','devpvtaspto',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','modlistfac',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','garandescfac',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','garandescpto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','descrip',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','modprec',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','almapto',0,'SYS',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','serfac',0,'FAC',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','sertic',0,'TIK',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','serrem',0,'REM',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','hoyvtap',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','autcortx',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','modp',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','clavsegfac',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','clavsegfacp',0,'',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,extr,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','insautcaj',0,'0',now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','chatptoc',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vmsjpto',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','guapdfcanf',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vercanvtaf',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','guapdfcan',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vercanvta',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','admcanvtas',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','descrippto',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','empspto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','canfacpto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','canticpto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','impfacpto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','impticpto',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vfacptovta',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vticptovta',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','cortxa',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','cortza',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vtasxusr',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','slimcredpvta',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','slimcredfac',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','logofac',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','logotik',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','alistpreclifac',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','alistpreclipvta',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','initpvta',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','msjexistnegfac',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','msjexistnegpvta',0,now(),now(),'INICIAL','INICIAL','NOCAJ',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vendsinexistpvta',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','vendsinexistfac',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','catgralpvta',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','catgralfac',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','otramon',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','cotunaser',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','cotconaser',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr,idempresa) VALUES('cots','moddescrip',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,extr,idempresa) VALUES('cots','almavtac',0,now(),now(),'INICIAL','INICIAL','INICIAL','SYS',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','modlistcot',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','garadesccot',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','descrip',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','modprec',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','otramon',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','cotsxusr',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','alistpreclicot',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','msjexistnegcot',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('cots','vendsinexistcot',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','barlat',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('vtas','imglin',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('comps','iniord',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('comps','descrip',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('comps','modprec',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('comps','vercancom',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('comps','guapdfcan',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('comps','compsxusr',0,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO confgral(clasif,conf,val,falt,fmod,estac,sucu,nocaj,idempresa) VALUES('comps','otramon',1,now(),now(),'INICIAL','INICIAL','INICIAL',par_id_empresa);

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_consecs`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_consecs`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('PREV','PREV','PREVIOS DE COMPRA',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('NOTC','NOTC','NOTAS DE CRÉDITO CLIENTES',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('NOTP','NOTP','NOTAS DE CRÉDITO PROVEEDORES',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('FAC','FAC','FACTURAS',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('TIK','TIK','TICKETS',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('COT','COT','COTIZACIONES',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('EMP','EMP','EMPRESAS',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('PROV','PROV','PROVEEDORES',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('REM','REM','REMISIONES',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('COMP','COMP','COMPRAS',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('ORDC','ORDC','ORDENES COMPRA',1,'INICIAL','INICIAL','INICIAL',par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('CXC','PAG','PAGOS', 1, 'INICIAL', 'INICIAL', 'INICIAL', par_id_empresa);
INSERT INTO consecs(tip,ser,descrip,consec,estac,sucu,nocaj,idempresa) VALUES('PEDIDOS','PED','PEDIDOS', 1, 'INICIAL', 'INICIAL', 'INICIAL', par_id_empresa);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_er_permisos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_er_permisos`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO er_permisos(FKIdUsuario,idempresa)
select id_id,par_id_empresa from estacs;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS  `inicio_estacs`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_estacs`(
in par_servicio_impresion varchar(255), 
in par_clave varchar(255),
in par_clave_venta varchar(255),
in par_clave_compra varchar(255),
in par_clave_caja varchar(255),
in par_clave_cxc varchar(255),
in par_clave_cxp varchar(255),
in par_id_empresa varchar(30)
)
BEGIN
INSERT INTO estacs(estac,nom,`52m`,descu,habdesc,imptic,impfac,cort,pass,estacglo,sucu,nocaj,falt,fmod,admcaj,vend,idempresa) 
VALUES('SUP','SUPERVISOR',0,100,1,par_servicio_impresion,par_servicio_impresion,1,par_clave,'INICIAL','INICIAL','INICIAL',now(),now(),1,1,par_id_empresa);

INSERT INTO estacs(estac,`52m`,descu,habdesc,imptic,impfac,cort,pass,estacglo,sucu,nocaj,falt,fmod,admcaj,idempresa) 
VALUES('RESPALDO',0,0,0,par_servicio_impresion,par_servicio_impresion,1,par_clave,'INICIAL','INICIAL','INICIAL',now(),now(),0,par_id_empresa);

INSERT INTO estacs(estac,`52m`,descu,habdesc,imptic,impfac,cort,pass,estacglo,sucu,nocaj,falt,fmod,admcaj,idempresa) 
VALUES('COMPRAS',0,0,1,par_servicio_impresion,par_servicio_impresion,1,par_clave_compra,'INICIAL','INICIAL','INICIAL',now(),now(),0,par_id_empresa);

INSERT INTO estacs(estac,`52m`,descu,habdesc,imptic,impfac,cort,pass,estacglo,sucu,nocaj,falt,fmod,admcaj,vend,idempresa,almacen) 
VALUES('VENTAS',0,0,1,par_servicio_impresion,par_servicio_impresion,1,par_clave_venta,'INICIAL','INICIAL','INICIAL',now(),now(),0,1,par_id_empresa,'GENERAL');

INSERT INTO estacs(estac,`52m`,descu,habdesc,imptic,impfac,cort,pass,estacglo,sucu,nocaj,falt,fmod,admcaj,idempresa) 
VALUES('CAJA',0,0,1,par_servicio_impresion,par_servicio_impresion,1,par_clave_caja,'INICIAL','INICIAL','INICIAL',now(),now(),0,par_id_empresa);

INSERT INTO estacs(estac,`52m`,descu,habdesc,imptic,impfac,cort,pass,estacglo,sucu,nocaj,falt,fmod,admcaj,idempresa) 
VALUES('CXC',0,0,1,par_servicio_impresion,par_servicio_impresion,1,par_clave_cxc,'INICIAL','INICIAL','INICIAL',now(),now(),0,par_id_empresa);

INSERT INTO estacs(estac,`52m`,descu,habdesc,imptic,impfac,cort,pass,estacglo,sucu,nocaj,falt,fmod,admcaj,idempresa) 
VALUES('CXP',0,0,1,par_servicio_impresion,par_servicio_impresion,1,par_clave_cxp,'INICIAL','INICIAL','INICIAL',now(),now(),0,par_id_empresa);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_impuestos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_impuestos`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO impues(codimpue, reten, impueval, idempresa, estac, sucu, nocaj, export, impuestoXML) VALUES
	('IEPS', b'0', 8, par_id_empresa, 'INICIAL', 'INICIAL', 'INICIAL', b'0', 'Traslado IVA'),
	('IVA', b'0', 16, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Traslado IVA'),
	('ISR', b'1', 4, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Retención ISR'),
	('RETENCION', b'1', 4, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Retención IVA'),
	('IVA10.66', b'1', 10.6667, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Retención IVA'),
	('ISR10', b'1', 10, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Retención ISR'),
	('ISH', b'0', 1.99, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Traslado IVA'),
	('ISH3', b'0', 3, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Traslado IVA'),
	('RETENCION16', b'1', 16, par_id_empresa, 'SUP', 'SUCURSAL', 'CAJA', b'0', 'Retención IVA');
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_lineas`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_lineas`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO lins(cod,descrip,img,idempresa,estac,sucu,nocaj,export)
VALUES ('SYS','LÍNEA GENERICA',-1,par_id_empresa,'INICIAL','INICIAL','INICIAL',0);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_medidas`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_medidas`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO meds(cod,descrip,idempresa,estac,sucu,nocaj,export)
VALUES('SYS','MEDIDA GENERICA',par_id_empresa,'INICIAL', 'INICIAL', 'INICIAL', 0);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_mons`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_mons`(in par_id_empresa varchar(30))
BEGIN
   INSERT INTO mons(mon,mondescrip,estac,sucu,nocaj,mn,val,simb,idempresa,c_moneda) VALUES('PESOS','MONEDA NACIONAL','INICIAL','INICIAL','INICIAL',1,1,'$',par_id_empresa,'MXN');
   INSERT INTO mons(mon,mondescrip,estac,val,sucu,nocaj,simb,idempresa,c_moneda) VALUES('USD','DOLAR','INICIAL',14,'INICIAL','INICIAL','$',par_id_empresa,'USD');
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_pags`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_pags`()
BEGIN
INSERT INTO pags (cod, descrip, estac, sucu, export, nocaj, extr1, extr2, extr3) VALUES
	('01', '01', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('02', '02', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('03', '03', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('04', '04', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('05', '05', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('06', '06', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('08', '08', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('28', '28', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('29', '29', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL),
	('99', '99', 'INICIAL', 'INICIAL', b'0', 'INICIAL', NULL, NULL, NULL);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `inicio_unids`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `inicio_unids`(in par_id_empresa varchar(30))
BEGIN
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('KILO','KILO','INICIAL','INICIAL','INICIAL',par_id_empresa,'KGM');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('METROCUADRADO','METROCUADRADO','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('CABEZA','CABEZA','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('KILOWATT','KILOWATT','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('KILOWATT/HORA','KILOWATT/HORA','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('GRAMONETO','GRAMONETO','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('DOCENAS','DOCENAS','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('GRAMO','GRAMO','INICIAL','INICIAL','INICIAL',par_id_empresa,'GRM');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('METROCÚBICO','METROCÚBICO','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('LITRO','LITRO','INICIAL','INICIAL','INICIAL',par_id_empresa,'LTR');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('MILLAR','MILLAR','INICIAL','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('TONELADA','TONELADA','TONELADA','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('DECENAS','DECENAS','TONELADA','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('CAJA','CAJA','CAJA','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('METRO LINEAL','METRO LINEAL','CAJA','INICIAL','INICIAL',par_id_empresa,'LM');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('PIEZA','PIEZA','INICIAL','INICIAL','INICIAL',par_id_empresa,'H87');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('PAR','PAR','CAJA','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('JUEGO','JUEGO','CAJA','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('BARRIL','BARRIL','CAJA','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('CIENTOS','CIENTOS','CAJA','INICIAL','INICIAL',par_id_empresa,'');
INSERT INTO unids(cod,descrip,estac,sucu,nocaj,idempresa,clavesat) VALUES('BOTELLA','BOTELLA','CAJA','INICIAL','INICIAL',par_id_empresa,'');
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Almacen`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Almacen`(
in par_alma varchar(30),
in par_respon varchar(30),
in par_almadescrip varchar(255),
in par_dir1 varchar(255),
in par_dir2 varchar(255),
in par_dir3 varchar(255),
in par_actfij bit,
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255) ,
in par_falt datetime,
in par_fmod datetime
)
BEGIN
INSERT INTO almas
(alma,
respon,
almadescrip,
dir1,
dir2,
dir3,
actfij,
idempresa,
estac,
sucu,
nocaj,
export,
extr1,
extr2,
extr3,
falt,
fmod)
VALUES
(
par_alma,
par_respon,
par_almadescrip,
par_dir1,
par_dir2,
par_dir3,
par_actfij,
par_idempresa,
par_estac,
par_sucu,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3,
par_falt,
par_fmod);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_ClasJerProveedor`; 

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_ClasJerProveedor`(
in par_clas varchar(30),
in par_rut varchar(2048),
in par_id_empresa varchar(20),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit(1),
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255))
BEGIN
INSERT INTO clasjeraprov
(clas,
rut,
idempresa,
estac,
sucu,
nocaj,
export,
extr1,
extr2,
extr3,
falt
)
VALUES
(
par_clas,
par_rut,
par_id_empresa,
par_estac,
par_sucu,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3,
now());

SELECT LAST_INSERT_ID();

END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `INS_Cliente`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Cliente`(
	IN `par_anio` VARCHAR(10),
	IN `par_banc` VARCHAR(10),
	IN `par_beneficiario` VARCHAR(30),
	IN `par_bloq` BIT,
	IN `par_bloqlimcred` BIT,
	IN `par_calle` VARCHAR(255),
	IN `par_cel` VARCHAR(255),
	IN `par_ciu` VARCHAR(255),
	IN `par_clasjera` VARCHAR(2048),
	IN `par_clavbanc` VARCHAR(255),
	IN `par_co1` VARCHAR(100),
	IN `par_co2` VARCHAR(100),
	IN `par_co3` VARCHAR(100),
	IN `par_codclas` VARCHAR(30),
	IN `par_codemp` VARCHAR(30),
	IN `par_codigo` VARCHAR(45),
	IN `par_col` VARCHAR(255),
	IN `par_CP` VARCHAR(20),
	IN `par_cta` VARCHAR(45),
	IN `par_ctaconta` VARCHAR(30),
	IN `par_ctapred` VARCHAR(100),
	IN `par_curp` VARCHAR(50),
	IN `par_deposit` FLOAT,
	IN `par_descu` FLOAT,
	IN `par_diacred` VARCHAR(21),
	IN `par_diapag` INT,
	IN `par_encall` VARCHAR(255),
	IN `par_encel` VARCHAR(255),
	IN `par_enciu` VARCHAR(255),
	IN `par_enco1` VARCHAR(100),
	IN `par_enco2` VARCHAR(100),
	IN `par_enco3` VARCHAR(100),
	IN `par_encol` VARCHAR(255),
	IN `par_encp` VARCHAR(20),
	IN `par_enemail` VARCHAR(100),
	IN `par_enestad` VARCHAR(255),
	IN `par_enlada` VARCHAR(10),
	IN `par_ennoext` VARCHAR(21),
	IN `par_ennoexten` VARCHAR(21),
	IN `par_ennoint` VARCHAR(21),
	IN `par_enpagweb` VARCHAR(255),
	IN `par_enpai` VARCHAR(255),
	IN `par_entel1` VARCHAR(255),
	IN `par_entel2` VARCHAR(255),
	IN `par_entel3` VARCHAR(255),
	IN `par_estac` VARCHAR(30),
	IN `par_estad` VARCHAR(255),
	IN `par_export` BIT,
	IN `par_exten` VARCHAR(20),
	IN `par_extr1` VARCHAR(255),
	IN `par_extr2` VARCHAR(255),
	IN `par_extr3` VARCHAR(255),
	IN `par_idempresa` VARCHAR(255),
	IN `par_lada` VARCHAR(10),
	IN `par_limtcred` FLOAT,
	IN `par_list` INT,
	IN `par_metpag` VARCHAR(45),
	IN `par_nocaj` VARCHAR(30),
	IN `par_noext` VARCHAR(100),
	IN `par_noint` VARCHAR(100),
	IN `par_nom` VARCHAR(255),
	IN `par_observ` VARCHAR(255),
	IN `par_otramon` BIT,
	IN `par_otramonc` BIT,
	IN `par_pags` VARCHAR(100),
	IN `par_pagweb1` VARCHAR(255),
	IN `par_pagweb2` VARCHAR(200),
	IN `par_pai` VARCHAR(255),
	IN `par_pers` VARCHAR(2),
	IN `par_revis` VARCHAR(100),
	IN `par_RFC` VARCHAR(21),
	IN `par_ser` VARCHAR(30),
	IN `par_sucu` VARCHAR(30),
	IN `par_tel` VARCHAR(255),
	IN `par_telper1` VARCHAR(255),
	IN `par_telper2` VARCHAR(255),
	IN `par_usocfdi` VARCHAR(10),
	IN `par_vend` VARCHAR(30)

)
BEGIN
INSERT INTO emps (anio ,
banc ,
beneficiario ,
bloq ,
bloqlimcred ,
calle ,
cel ,
ciu ,
clasjera ,
clavbanc ,
co1 ,
co2 ,
co3 ,
codclas ,
codemp ,
codigo ,
col ,
CP ,
cta ,
ctaconta ,
ctapred ,
curp ,
deposit ,
descu ,
diacred ,
diapag ,
encall ,
encel ,
enciu ,
enco1 ,
enco2 ,
enco3 ,
encol ,
encp ,
enemail ,
enestad ,
enlada ,
ennoext ,
ennoexten ,
ennoint ,
enpagweb ,
enpai ,
entel1 ,
entel2 ,
entel3 ,
estac ,
estad ,
export ,
exten , 
extr1 ,
extr2 ,
extr3 ,
idempresa ,
lada ,
limtcred ,
list ,
metpag ,
nocaj ,
noext ,
noint ,
nom ,
observ ,
otramon ,
otramonc ,
pags ,
pagweb1 ,
pagweb2 ,
pai ,
pers ,
revis ,
RFC ,
ser ,
sucu ,
tel ,
telper1 ,
telper2 ,
usocfdi ,
vend)
VALUES
(par_anio ,
par_banc ,
par_beneficiario ,
par_bloq ,
par_bloqlimcred ,
par_calle ,
par_cel ,
par_ciu ,
par_clasjera ,
par_clavbanc ,
par_co1 ,
par_co2 ,
par_co3 ,
par_codclas ,
par_codemp ,
par_codigo ,
par_col ,
par_CP ,
par_cta ,
par_ctaconta ,
par_ctapred ,
par_curp ,
par_deposit ,
par_descu ,
par_diacred ,
par_diapag ,
par_encall ,
par_encel ,
par_enciu ,
par_enco1 ,
par_enco2 ,
par_enco3 ,
par_encol ,
par_encp ,
par_enemail ,
par_enestad ,
par_enlada ,
par_ennoext ,
par_ennoexten ,
par_ennoint ,
par_enpagweb ,
par_enpai ,
par_entel1 ,
par_entel2 ,
par_entel3 ,
par_estac ,
par_estad ,
par_export ,
par_exten , 
par_extr1 ,
par_extr2 ,
par_extr3 ,
par_idempresa ,
par_lada ,
par_limtcred ,
par_list ,
par_metpag ,
par_nocaj ,
par_noext ,
par_noint ,
par_nom ,
par_observ ,
par_otramon ,
par_otramonc ,
par_pags ,
par_pagweb1 ,
par_pagweb2 ,
par_pai ,
par_pers ,
par_revis ,
par_RFC ,
par_ser ,
par_sucu ,
par_tel ,
par_telper1 ,
par_telper2 ,
par_usocfdi ,
par_vend);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Compra`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Compra`(
in par_codcomp varchar(30),
in par_noser varchar(30),
in par_prov varchar(30),
in par_ser varchar(30),
in par_nodoc varchar(50),
in par_estac varchar(30),
in par_fdoc datetime,
in par_subtot decimal(22,6),
in par_impue decimal(22,6),
in par_tot decimal(22,6),
in par_estado varchar(10),
in par_motiv varchar(255),
in par_nomprov varchar(255),
in par_fvenc datetime,
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_tip varchar(30),
in par_fent varchar(30),
in par_metpag varchar(42),
in par_cta varchar(42),
in par_monedaID int,
in par_tipcam decimal(22,6),
in par_codord varchar(30),
in par_archpdf bit,
in par_archxml bit,
in par_id_empresa varchar(30),
in par_total_traslado decimal(22,6),
in par_total_retencion decimal(22,6),
in par_tipcamnac decimal(22,6))
BEGIN
INSERT INTO comprs(
codcomp,
noser,
prov,
ser,
nodoc,
estac,
fdoc,
subtot,
impue,
tot,
estado,
falt,
motiv,
nomprov,
fvenc,
sucu,
nocaj,
tip,
fent,
metpag,
cta,
monedaID,
tipcam,
codord,
archpdf,
archxml,
idempresa,
total_traslado,
total_retencion,
tipcamnac) 
VALUES(
par_codcomp,
par_noser,
par_prov,
par_ser,
par_nodoc,
par_estac,
par_fdoc,
par_subtot,
par_impue,
par_tot,
par_estado,
now(),
par_motiv,
par_nomprov,
par_fvenc,
par_sucu,
par_nocaj,
par_tip,
par_fent,
par_metpag,
par_cta,
par_monedaID,
par_tipcam,
par_codord,
par_archpdf,
par_archxml,
par_id_empresa,
par_total_traslado,
par_total_retencion,
par_tipcamnac
);

SELECT LAST_INSERT_ID();
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Configuraciones`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Configuraciones`(
in par_clasif varchar(45),
in par_conf varchar(45),
in par_val int,
in par_nume float,
in par_idempresa  varchar(30),
in par_estac varchar(30),
in par_dia int,
in par_extr varchar(1000), 
in par_asun varchar(255),
in par_anio int,
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255))
BEGIN
INSERT INTO confgral
(clasif,
conf,
val,
nume,
falt,
idempresa,
estac,
dia,
envia,
extr,
asun,
anio,
sucu,
nocaj,
export,
extr1,
extr2,
extr3)
VALUES
(par_clasif,
par_conf,
par_val,
par_nume,
now(),
par_idempresa,
par_estac,
par_dia,
now(),
par_extr,
par_asun,
par_anio,
par_sucu,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Correo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Correo`(
in par_srvsmtpsal varchar(50),
in par_portsmtp int,
in par_actslenlog bit,
in par_usr varchar(61),
in par_pass varchar(255),
in par_corralter varchar(50),
in par_estac varchar(30),
in par_falt date,
in par_estacglo varchar(30),
in par_asunfac varchar(255),
in par_asuncot varchar(255),
in par_asuncontra varchar(255),
in par_asunord varchar(255),
in par_cuerpfac varchar(255),
in par_cuerpcot varchar(255),
in par_cuerpcontra varchar(255),
in par_cuerpord varchar(255),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_asunrec1 varchar(255),
in par_asunrec2 varchar(255),
in par_asunrec3 varchar(255),
in par_cuerprec1 varchar(255),
in par_cuerprec2 varchar(255),
in par_cuerprec3 varchar(255),
in par_idempresa varchar(30))
BEGIN
INSERT INTO corrselec (
srvsmtpsal,
portsmtp,
actslenlog,
usr,
pass,
corralter,
estac,
falt,
estacglo,
asunfac,
asuncot,
asuncontra,
asunord,
cuerpfac,
cuerpcot,
cuerpcontra,
cuerpord,
sucu,
nocaj,
asunrec1,
asunrec2,
asunrec3,
cuerprec1,
cuerprec2,
cuerprec3,
idempresa) 
VALUES(
par_srvsmtpsal,
par_portsmtp,
par_actslenlog,
par_usr,
par_pass,
par_corralter,
par_estac,
par_falt,
par_estacglo,
par_asunfac,
par_asuncot,
par_asuncontra,
par_asunord,
par_cuerpfac,
par_cuerpcot,
par_cuerpcontra,
par_cuerpord,
par_sucu,
par_nocaj,
par_asunrec1,
par_asunrec2,
par_asunrec3,
par_cuerprec1,
par_cuerprec2,
par_cuerprec3,
par_idempresa);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_CuentasPorPagar`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_CuentasPorPagar`(
in par_norefer varchar(50),
in par_noser varchar(30),
in par_prov varchar(30),
in par_ser varchar(30),
in par_formpag varchar(30),
in par_conceppag varchar(30),
in par_monedaID int,
in par_tipcam decimal(22,6),
in par_comen varchar(500),
in par_subtot decimal(22,6),
in par_tot decimal(22,6),
in par_impue decimal(22,6),
in par_carg decimal(22,6),
in par_abon decimal(22,6),
in par_concep varchar(30),
in par_folbanc varchar(50),
in par_fvenc date,
in par_fdoc date,
in par_fmod date,
in par_fol int,
in par_id_empresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_cuentabanco varchar(30),
in par_estado varchar(30),
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255)
)
BEGIN
INSERT INTO cxp
(`norefer`,
`noser`,
`prov`,
`ser`,
`formpag`,
`conceppag`,
`monedaID`,
`tipcam`,
`comen`,
`subtot`,
`tot`,
`impue`,
`carg`,
`abon`,
`concep`,
`folbanc`,
`fvenc`,
`fdoc`,
`falt`,
`fmod`,
`fol`,
`idempresa`,
`estac`,
`sucu`,
`nocaj`,
`export`,
`cuentabanco`,
`estado`,
`extr1`,
`extr2`,
`extr3`)
VALUES
(par_norefer,
par_noser,
par_prov,
par_ser,
par_formpag,
par_conceppag,
par_monedaID,
par_tipcam,
par_comen,
par_subtot,
par_tot,
par_impue,
par_carg,
par_abon,
par_concep,
par_folbanc,
par_fvenc,
par_fdoc,
now(),
par_fmod,
par_fol,
par_id_empresa,
par_estac,
par_sucu,
par_nocaj,
par_export,
par_cuentabanco,
par_estado,
par_extr1,
par_extr2,
par_extr3);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Estac`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Estac`(in par_estac varchar(30), 
in par_pass varchar(255), 
in par_estacglo varchar(30), 
in par_imptic varchar(255), 
in par_impfac varchar(255), 
in par_52m bit,
in par_cort varchar(3),
in par_descu float,
in par_habdesc int,
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_nom varchar(255),
in par_calle varchar(255),
in par_col varchar(255),
in par_cp varchar(20),
in par_tel varchar(255),
in par_cel varchar(255),
in par_pai varchar(255),
in par_esta varchar(255),
in par_noint varchar(255),
in par_noext varchar(2048),
in par_admcaj bit,
in par_vend bit,
in par_ciu varchar(255),
in par_comi float,
in par_ptovta bit,
in par_idempresa varchar(255),
in par_almacen varchar(50),
in par_correo varchar(255))
BEGIN
INSERT INTO estacs(estac,pass,falt,estacglo,imptic,impfac,`52m`,cort,descu,habdesc,sucu,nocaj,nom,calle,col,cp,tel,cel,pai,esta,noint,noext,admcaj,vend,ciu,comi,ptovta,idempresa,almacen,correo)
VALUES(
par_estac, 
par_pass, 
now(),  
par_estacglo, 
par_imptic, 
par_impfac, 
par_52m,
par_cort,
par_descu,
par_habdesc,
par_sucu,
par_nocaj,
par_nom,
par_calle,
par_col,
par_cp,
par_tel,
par_cel,
par_pai,
par_esta,
par_noint,
par_noext,
par_admcaj,
par_vend,
par_ciu,
par_comi,
par_ptovta,
par_idempresa,
par_almacen,
par_correo);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Impuesto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Impuesto`(
in par_codimpue varchar(30),
in par_reten bit(1),
in par_impueval float,
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(39),
in par_impuestoXML varchar(45))
BEGIN
INSERT INTO impues
(codimpue,
reten,
impueval,
idempresa,
estac,
sucu,
nocaj,
impuestoXML)
VALUES
(par_codimpue,
par_reten,
par_impueval,
par_idempresa,
par_estac,
par_sucu,
par_nocaj,
par_impuestoXML);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Ingreso`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Ingreso`(
in par_idIngresCab int,
in par_prod varchar(255),
in par_alma varchar(255),
in par_unid varchar(255),
in par_concep varchar(50),
in par_cant float,
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu  varchar(30),
in par_entsal bit,
in par_nocaj  varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_activo varchar(45),
in par_falt date,
in par_costo varchar(50),
in par_cantsal decimal(22,6),
in par_tipcamnac decimal(22,6),
in par_pedimento varchar(30),
in par_lote varchar(45),
in par_caducidad date)
BEGIN
INSERT INTO ingres
(idIngresCab,
prod,
alma,
unid,
concep,
cant,
idempresa,
estac,
sucu,
entsal,
nocaj,
export,
extr1,
extr2,
extr3,
activo,
falt,
costo,
cantsal,
tipcamnac,
pedimento,
lote,
caducidad)
VALUES
(par_idIngresCab,
par_prod,
par_alma,
par_unid,
par_concep,
par_cant,
par_idempresa,
par_estac,
par_sucu,
par_entsal,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3,
par_activo,
par_falt,
par_costo,
par_cantsal,
par_tipcamnac,
par_pedimento,
par_lote,
par_caducidad);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_IngresosEncab`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_IngresosEncab`(
in par_alma varchar(255),
in par_concep varchar(50),
in par_canttotal decimal(22,6),
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_entsal bit,
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_falt date,
in par_noser varchar(30),
in par_norefer varchar(30))
BEGIN
INSERT INTO ingresos_encab
(alma,
concep,
canttotal,
idempresa,
estac,
sucu,
entsal,
nocaj,
export,
extr1,
extr2,
extr3,
falt,
noser,
norefer)
VALUES
(par_alma,
par_concep,
par_canttotal,
par_idempresa,
par_estac,
par_sucu,
par_entsal,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3,
par_falt,
par_noser,
par_norefer);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_InsertPartidaVenta`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_InsertPartidaVenta`(
par_vta int(11)
,par_prod varchar(255)
,par_cant decimal(22,6)
,par_unid varchar(30)
,par_descrip varchar(255)
,par_pre decimal(22,6)
,par_descu decimal(22,6)
,par_impue int(11)
,par_impo decimal(22,6)
#,par_falt datetime
,par_eskit bit(1)
,par_kitmae int(11)
,par_tipdoc varchar(30)
,par_list int(11) 
,par_alma varchar(30)
,par_ueps decimal(22,6)
,par_peps decimal(22,6)
,par_tall varchar(30)
,par_colo varchar(30)
,par_cantentre decimal(22,6)
,par_serprod varchar(30)
,par_comenser varchar(255)
,par_tipcam decimal(22,6)
,par_garan varchar(255)
,par_cost decimal(22,6)
,par_costprom decimal(22,6)
,par_idlotped int(11)
,par_lot varchar(255)
,par_pedimen varchar(255)
#,par_fcadu datetime 
,par_codimpue varchar(30)
,par_idempresa varchar(30)
,par_cuentacontable varchar(45)
,par_monedaID int(11))
BEGIN
INSERT INTO partvta(
vta
,prod
,cant
,unid
,descrip
,pre
,descu
,impue
,impo
#,falt
,eskit
,kitmae
,tipdoc
,list
,alma
,ueps
,peps
,tall
,colo
,cantentre
,serprod
,comenser
,tipcam
,garan
,cost
,costprom
,idlotped
,lot
,pedimen
#,fcadu
,codimpue
,idempresa
,cuentacontable
,monedaID) 
VALUES
(
par_vta
,par_prod
,par_cant
,par_unid
,par_descrip
,par_pre
,par_descu
,par_impue
,par_impo
#,par_falt
,par_eskit
,par_kitmae
,par_tipdoc
,par_list
,par_alma
,par_ueps
,par_peps
,par_tall
,par_colo
,par_cantentre
,par_serprod
,par_comenser
,par_tipcam
,par_garan
,par_cost
,par_costprom
,par_idlotped
,par_lot
,par_pedimen
#,par_fcadu
,par_codimpue
,par_idempresa
,par_cuentacontable
,par_monedaID);

SELECT LAST_INSERT_ID();
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_PartidaCompras`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_PartidaCompras`(
in par_codcom varchar(30),
in par_prod varchar(255),
in par_cant int,
in par_impue decimal(22,6),
in par_unid varchar(30),
in par_descrip varchar(255),
in par_cost decimal(22,6),
in par_descu decimal(22,6),
in par_descad decimal(22,6),
in par_codimpue varchar(30),
in par_mon varchar(30),
in par_impo decimal(22,6),
in par_recib decimal(22,6),
in par_alma varchar(30),
in par_costpro decimal(22,6),
in par_lot varchar(30),
in par_pedimen varchar(30),
in par_flotvenc datetime,
in par_cantlotpend decimal(22,6),
in par_serprod varchar(30),
in par_comenser varchar(255),
in par_garan varchar(255),
in par_tipcam decimal(22,6),
in par_eskit bit,
in par_tall varchar(30),
in par_colo varchar(30),
in par_id_empresa varchar(30), 
in par_cuentacontable varchar(45), 
in par_activo varchar(45),
in par_lotepedimento int(11))
BEGIN
INSERT INTO partcomprs(
codcom,
prod,
cant,
impue,
unid,
descrip,
cost,
descu,
descad,
codimpue,
mon,
impo,
falt,
recib,
alma,
costpro,
lot,
pedimen,
flotvenc,
cantlotpend,
serprod,
comenser,
garan,
tipcam,
eskit,
tall,
colo,
idempresa, 
cuentacontable, 
activo,
lotepedimento) 
VALUES(par_codcom,
par_prod,
par_cant,
par_impue,
par_unid,
par_descrip,
par_cost,
par_descu,
par_descad,
par_codimpue,
par_mon,
par_impo,
now(),
par_recib,
par_alma,
par_costpro,
par_lot,
par_pedimen,
par_flotvenc,
par_cantlotpend,
par_serprod,
par_comenser,
par_garan,
par_tipcam,
par_eskit,
par_tall,
par_colo,
par_id_empresa, 
par_cuentacontable, 
par_activo,
par_lotepedimento);

SELECT LAST_INSERT_ID();
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_PermisosUsuarios`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_PermisosUsuarios`(in par_id_usuario int, in par_id_empresa varchar(30))
BEGIN
   INSERT INTO er_permisos (FKIdUsuario, idempresa) VALUES(par_id_usuario , par_id_empresa);
   SELECT LAST_INSERT_ID();
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Producto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Producto`(
	IN `par_alma` VARCHAR(30),
	IN `par_anaq` VARCHAR(30),
	IN `par_bajcost` INT,
	IN `par_clavesat` VARCHAR(25),
	IN `par_codubi` VARCHAR(30),
	IN `par_comenser` VARCHAR(600),
	IN `par_compue` INT,
	IN `par_cost` FLOAT,
	IN `par_costre` FLOAT,
	IN `par_descrip` VARCHAR(2100),
	IN `par_descripcort` VARCHAR(255),
    IN `par_descprov` VARCHAR(100),
	IN `par_estac` VARCHAR(300),
	IN `par_estaccrea` VARCHAR(300),
	IN `par_esvta` INT,
	IN `par_exist` FLOAT,
	IN `par_export` BIT,
	IN `par_extr1` VARCHAR(255),
	IN `par_extr2` VARCHAR(255),
	IN `par_extr3` VARCHAR(255),
	IN `par_idempresa` VARCHAR(30),
	IN `par_impue` VARCHAR(30),
	IN `par_infor` VARCHAR(255),
	IN `par_invent` INT,
	IN `par_lote` VARCHAR(30),
	IN `par_lotped` BIT,
	IN `par_lug` VARCHAR(30),
	IN `par_max` INT,
	IN `par_metcost` VARCHAR(10),
	IN `par_min` INT,
	IN `par_nocaj` VARCHAR(30),
	IN `par_noser` VARCHAR(30),
	IN `par_pedimen` VARCHAR(30),
	IN `par_pesman` FLOAT,
	IN `par_prelist1` FLOAT,
	IN `par_prelist10` FLOAT,
	IN `par_prelist2` FLOAT,
	IN `par_prelist3` FLOAT,
	IN `par_prelist4` FLOAT,
	IN `par_prelist5` FLOAT,
	IN `par_prelist6` FLOAT,
	IN `par_prelist7` FLOAT,
	IN `par_prelist8` FLOAT,
	IN `par_prelist9` FLOAT,
	IN `par_prodop1` VARCHAR(500),
    IN `par_prodop2` VARCHAR(500),
    IN `par_provop1` VARCHAR(30),
    IN `par_provop2` VARCHAR(30),
    IN `par_provprincipal` INT,
    IN `par_prod` VARCHAR(255),
	IN `par_rutimg` VARCHAR(500),
	IN `par_servi` BIT,
	IN `par_solmaxmin` INT,
	IN `par_solser` BIT,
	IN `par_sucu` VARCHAR(30),
	IN `par_unid` VARCHAR(30),
	IN `par_utilvta1` FLOAT,
	IN `par_utilvta10` FLOAT,
	IN `par_utilvta2` FLOAT,
	IN `par_utilvta3` FLOAT,
	IN `par_utilvta4` FLOAT,
	IN `par_utilvta5` FLOAT,
	IN `par_utilvta6` FLOAT,
	IN `par_utilvta7` FLOAT,
	IN `par_utilvta8` FLOAT,
	IN `par_utilvta9` FLOAT,
    IN `par_id_garan` INT,
    IN `par_id_lin` INT,
    IN `par_id_tip` INT,
    IN `par_id_marc` INT,
    IN `par_id_mode` INT,
    IN `par_id_fab` INT,
    IN `par_id_colo` INT,
    IN `par_id_pes` INT,
    IN `par_id_unid` INT,
    IN `par_id_lug` INT,
    IN `par_id_alma` INT
)
BEGIN
INSERT INTO prods
    (alma,
	 anaq,
    bajcost,
    clavesat,
    codubi,
    comenser,
    compue,
    cost,
    costre,
    descrip, 
    descripcort,
    descprov,
    estac,
    estaccrea,
    esvta,
    exist,
    export,
    extr1,
    extr2,
    extr3,
    idempresa,
    impue,
    infor,
    invent,
    lote,
    lotped,
    lug,
    max,
    metcost,
    min,
    nocaj,
    noser, 
    pedimen,
    pesman,
    prelist1,
    prelist10,
    prelist2,
    prelist3,
    prelist4,
    prelist5,
    prelist6,
    prelist7,
    prelist8,
    prelist9,
    prodop1,
    prodop2,
    provop1,
    provop2,
    provprincipal,
    prod,
    rutimg,
    servi,
    solmaxmin, 
    solser,
    sucu,
    unid,
    utilvta1,
    utilvta10,
    utilvta2,
    utilvta3,
    utilvta4,
    utilvta5,
    utilvta6,
    utilvta7,
    utilvta8,
    utilvta9,
    id_garan,
    id_lin,
    id_tip,
    id_marc,
    id_mode,
    id_fab,
    id_colo,
    id_pes,
    id_unid,
    id_lug,
    id_alma)
    VALUES
    (par_alma,
par_anaq,
par_bajcost,
par_clavesat,
par_codubi,
par_comenser,
par_compue,
par_cost,
par_costre,
par_descrip, 
par_descripcort,
par_descprov,
par_estac,
par_estaccrea,
par_esvta,
par_exist,
par_export,
par_extr1,
par_extr2,
par_extr3,
par_idempresa,
par_impue,
par_infor,
par_invent,
par_lote,
par_lotped,
par_lug,
par_max,
par_metcost,
par_min,
par_nocaj,
par_noser, 
par_pedimen,
par_pesman,
par_prelist1,
par_prelist10,
par_prelist2,
par_prelist3,
par_prelist4,
par_prelist5,
par_prelist6,
par_prelist7,
par_prelist8,
par_prelist9,
par_prodop1,
par_prodop2,
par_provop1,
par_provop2,
par_provprincipal,
par_prod,
par_rutimg,
par_servi,
par_solmaxmin, 
par_solser,
par_sucu,
par_unid,
par_utilvta1,
par_utilvta10,
par_utilvta2,
par_utilvta3,
par_utilvta4,
par_utilvta5,
par_utilvta6,
par_utilvta7,
par_utilvta8,
par_utilvta9,
par_id_garan,
par_id_lin,
par_id_tip,
par_id_marc,
par_id_mode,
par_id_fab,
par_id_colo,
par_id_pes,
par_id_unid,
par_id_lug,
par_id_alma
);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Proveedores`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Proveedores`(in par_prov varchar(30),
in par_ser varchar(30),
in par_codclas varchar(30),
in par_zon varchar(30),
in par_giro varchar(30),
in par_tentre varchar(255),
in par_rubr varchar(30),
in par_banc varchar(30),
in par_clavbanc varchar(255),
in par_lada varchar(10),
in par_metpag varchar(45),
in par_cta varchar(45),
in par_enlada varchar(10),
in par_nom varchar(255),
in par_tel varchar(255),
in par_entel varchar(255),
in par_cel varchar(255),
in par_encel varchar(255),
in par_clasjera varchar(2048),
in par_exten varchar(20),
in par_enexten varchar(255),
in par_calle varchar(255),
in par_encalle varchar(255),
in par_col varchar(255),
in par_encol varchar(255),
in par_cp varchar(20),
in par_encp varchar(20),
in par_ennoint varchar(100),
in par_noint varchar(100),
in par_noext varchar(100),
in par_ennoext varchar(100),
in par_ciu varchar(255),
in par_enciu varchar(255),
in par_estad varchar(255),
in par_enestad varchar(255),
in par_otramon bit(1),
in par_otramonc bit(1),
in par_bloq bit(1),
in par_ctaconta varchar(30),
in par_revis varchar(100),
in par_pags varchar(100),
in par_pais varchar(255),
in par_enpais varchar(255),
in par_rfc varchar(21),
in par_descu float,
in par_diacred varchar(21),
in par_limcred float,
in par_bloqlimcred bit(1),
in par_co1 varchar(100),
in par_enco1 varchar(100),
in par_co2 varchar(100),
in par_enco2 varchar(100),
in par_co3 varchar(100),
in par_enco3 varchar(100),
in par_pagweb1 varchar(255),
in par_pagweb2 varchar(255),
in par_eje1 varchar(255),
in par_telper1 varchar(255),
in par_entelper1 varchar(255),
in par_telper2 varchar(255),
in par_entelper2 varchar(255),
in par_eje2 varchar(255),
in par_telper21 varchar(255),
in par_telper22 varchar(255),
in par_observ varchar(255),
in par_pers varchar(2),
in par_contac3 varchar(255),
in par_telcon3 varchar(255),
in par_telper3 varchar(255),
in par_telper33 varchar(255),
in par_contac4 varchar(255),
in par_telcon4 varchar(255),
in par_telper4 varchar(255),
in par_telper44 varchar(255),
in par_contac5 varchar(255),
in par_telcon5 varchar(255),
in par_telper5 varchar(255),
in par_telper55 varchar(255),
in par_contac6 varchar(255),
in par_telcon6 varchar(255),
in par_telper6 varchar(255),
in par_telper66 varchar(255),
in par_contac7 varchar(255),
in par_telcon7 varchar(255),
in par_telper7 varchar(255),
in par_telper77 varchar(255),
in par_contac8 varchar(255),
in par_telcon8 varchar(255),
in par_telper8 varchar(255),
in par_telper88 varchar(255),
in par_contac9 varchar(255),
in par_telcon9 varchar(255),
in par_telper9 varchar(255),
in par_telper99 varchar(255),
in par_contac10 varchar(255),
in par_telcon10 varchar(255),
in par_telper10 varchar(255),
in par_telper100 varchar(255),
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit(1),
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_beneficiario varchar(255)
)
BEGIN
INSERT INTO provs
(prov,
ser,
codclas,
zon,
giro,
tentre,
rubr,
banc,
clavbanc,
lada,
metpag,
cta,
enlada,
nom,
tel,
entel,
cel,
encel,
clasjera,
exten,
enexten,
calle,
encalle,
col,
encol,
cp,
encp,
ennoint,
noint,
noext,
ennoext,
ciu,
enciu,
estad,
enestad,
otramon,
otramonc,
bloq,
ctaconta,
revis,
pags,
pais,
enpais,
rfc,
descu,
diacred,
limcred,
bloqlimcred,
co1,
enco1,
co2,
enco2,
co3,
enco3,
pagweb1,
pagweb2,
eje1,
telper1,
entelper1,
telper2,
entelper2,
eje2,
telper21,
telper22,
observ,
pers,
contac3,
telcon3,
telper3,
telper33,
contac4,
telcon4,
telper4,
telper44,
contac5,
telcon5,
telper5,
telper55,
contac6,
telcon6,
telper6,
telper66,
contac7,
telcon7,
telper7,
telper77,
contac8,
telcon8,
telper8,
telper88,
contac9,
telcon9,
telper9,
telper99,
contac10,
telcon10,
telper10,
telper100,
idempresa,
estac,
sucu,
nocaj,
export,
extr1,
extr2,
extr3,
beneficiario)
VALUES
(
par_prov,
par_ser,
par_codclas,
par_zon,
par_giro,
par_tentre,
par_rubr,
par_banc,
par_clavbanc,
par_lada,
par_metpag,
par_cta,
par_enlada,
par_nom,
par_tel,
par_entel,
par_cel,
par_encel,
par_clasjera,
par_exten,
par_enexten,
par_calle,
par_encalle,
par_col,
par_encol,
par_cp,
par_encp,
par_ennoint,
par_noint,
par_noext,
par_ennoext,
par_ciu,
par_enciu,
par_estad,
par_enestad,
par_otramon,
par_otramonc,
par_bloq,
par_ctaconta,
par_revis,
par_pags,
par_pais,
par_enpais,
par_rfc,
par_descu,
par_diacred,
par_limcred,
par_bloqlimcred,
par_co1,
par_enco1,
par_co2,
par_enco2,
par_co3,
par_enco3,
par_pagweb1,
par_pagweb2,
par_eje1,
par_telper1,
par_entelper1,
par_telper2,
par_entelper2,
par_eje2,
par_telper21,
par_telper22,
par_observ,
par_pers,
par_contac3,
par_telcon3,
par_telper3,
par_telper33,
par_contac4,
par_telcon4,
par_telper4,
par_telper44,
par_contac5,
par_telcon5,
par_telper5,
par_telper55,
par_contac6,
par_telcon6,
par_telper6,
par_telper66,
par_contac7,
par_telcon7,
par_telper7,
par_telper77,
par_contac8,
par_telcon8,
par_telper8,
par_telper88,
par_contac9,
par_telcon9,
par_telper9,
par_telper99,
par_contac10,
par_telcon10,
par_telper10,
par_telper100,
par_idempresa,
par_estac,
par_sucu,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3,
par_beneficiario);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Traspaso`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Traspaso`(
in par_prod varchar(255),
in par_alma varchar(255),
in par_concep varchar(50),
in par_unid varchar(30),
in par_cantsal float,
in par_almaa varchar(30),
in par_cantent float,
in par_id_empresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit(1),
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_UsuarioResponsableTras varchar(50),
in par_lotePedimento int,
in par_costo decimal(22,6),
in par_estado  varchar(35),
in par_reporteSalida varchar(35),
in par_reporteEntrada varchar(35))
BEGIN
INSERT INTO traspas
(prod,
alma,
concep,
unid,
cantsal,
almaa,
cantent,
idempresa,
estac,
sucu,
nocaj,
export,
extr1,
extr2,
extr3,
falt,
UsuarioResponsableTras,
lotePedimento,
costo,
estado,
reporteSalida,
reporteEntrada)
VALUES
(par_prod,
par_alma,
par_concep,
par_unid,
par_cantsal,
par_almaa,
par_cantent,
par_idempresa,
par_estac,
par_sucu,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3,
now(),
par_UsuarioResponsableTras,
par_lotePedimento,
par_costo,
par_estado,
par_reporteSalida,
par_reporteEntrada);

SELECT LAST_INSERT_ID();

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `INS_Venta`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `INS_Venta`(
par_norefer varchar(30),
par_noser varchar(30),
par_monedaID int(11),
par_vend varchar(30),
par_codcot varchar(30),
par_folfisc varchar(100),
par_transid varchar(100),
par_sell varchar(1000),
par_sellsat varchar(1000),
par_certsat varchar(1000),
par_lugexp varchar(100),
par_regfisc varchar(255),
par_cadori varchar(2000),
par_cort varchar(5),
par_referencia varchar(255),
par_formpag varchar(30),
par_nocort int(11),
par_venta_origen int(11),
par_cierr int(11),
par_vtadevp int(11),
par_ptovta bit(1),
par_catgral varchar(500),
par_factu bit(1),
par_tipcam decimal(22,6),
par_tipcamnac decimal(22,6),
par_total_traslado decimal(22,6),
par_total_retencion decimal(22,6),
par_tipdoc varchar(30),
par_notcred varchar(30),
par_notcredpag varchar(250),
par_impnotcred decimal(22,6),
par_totdescu decimal(22,6),
par_totcost decimal(22,6),
par_totcostprom decimal(22,6),
par_totueps decimal(22,6),
par_totpeps decimal(22,6),
par_codemp varchar(30),
par_ser varchar(30),
par_metpag varchar(42),
par_cta  varchar(42),
#par_femi datetime,
#par_fent datetime,
par_subtot decimal(22,6),
par_impue decimal(22,6),
par_tot decimal(22,6),
par_tic int(11),
par_estad varchar(10),
par_motiv varchar(255),
par_observ varchar(1000),
par_timbr bit(1),
par_autrecibde varchar(255),
par_autmarc varchar(255),
par_autmod varchar(255),
par_autcolo varchar(100),
par_autplacs varchar(255),
par_autnom varchar(255),
par_auttarcirc varchar(255),
par_autnumlic varchar(255),
par_auttel varchar(255),
par_autdirpart varchar(255),
par_autdirofi varchar(255),
par_auttelofi varchar(255),
par_autimpo decimal(22,6),
par_autmotiv varchar(255),
par_idempresa varchar(30),
par_estac varchar(30),
par_sucu varchar(30),
par_nocaj varchar(30),
par_export bit(1),
par_extr1 varchar(255),
par_extr2 varchar(255),
par_extr3 varchar(255),
par_vtaRef int(11),
par_usocfdi varchar(5),
par_tiporelacion varchar(5),
par_activo varchar(10),
par_subramo varchar(10),
par_sector varchar(10),
par_id_tipodoc int(11),
par_id_emp int(11))
BEGIN

START TRANSACTION;

INSERT INTO vtas
(norefer,
noser,
monedaID,
vend,
codcot,
folfisc,
transid,
sell,
sellsat,
certsat,
lugexp,
regfisc,
cadori,
cort,
referencia,
formpag,
nocort,
venta_origen,
cierr,
vtadevp,
ptovta,
catgral,
factu,
tipcam,
tipcamnac,
total_traslado,
total_retencion,
tipdoc,
notcred,
notcredpag,
impnotcred,
totdescu,
totcost,
totcostprom,
totueps,
totpeps,
codemp,
ser,
metpag,
cta,
#femi,
#fent,
subtot,
impue,
tot,
tic,
estad,
motiv,
observ,
timbr,
autrecibde,
autmarc,
autmod,
autcolo,
autplacs,
autnom,
auttarcirc,
autnumlic,
auttel,
autdirpart,
autdirofi,
auttelofi,
autimpo,
autmotiv,
idempresa,
estac,
sucu,
nocaj,
export,
extr1,
extr2,
extr3,
vtaRef,
usocfdi,
tiporelacion,
activo,
subramo,
sector,
id_tipodoc,
id_emp)
VALUES
(par_norefer,
par_noser,
par_monedaID,
par_vend,
par_codcot,
par_folfisc,
par_transid,
par_sell,
par_sellsat,
par_certsat,
par_lugexp,
par_regfisc,
par_cadori,
par_cort,
par_referencia,
par_formpag,
par_nocort,
par_venta_origen,
par_cierr,
par_vtadevp,
par_ptovta,
par_catgral,
par_factu,
par_tipcam,
par_tipcamnac,
par_total_traslado,
par_total_retencion,
par_tipdoc,
par_notcred,
par_notcredpag,
par_impnotcred,
par_totdescu,
par_totcost,
par_totcostprom,
par_totueps,
par_totpeps,
par_codemp,
par_ser,
par_metpag,
par_cta,
#par_femi,
#par_fent,
par_subtot,
par_impue,
par_tot,
par_tic,
par_estad,
par_motiv,
par_observ,
par_timbr,
par_autrecibde,
par_autmarc,
par_autmod,
par_autcolo,
par_autplacs,
par_autnom,
par_auttarcirc,
par_autnumlic,
par_auttel,
par_autdirpart,
par_autdirofi,
par_auttelofi,
par_autimpo,
par_autmotiv,
par_idempresa,
par_estac,
par_sucu,
par_nocaj,
par_export,
par_extr1,
par_extr2,
par_extr3,
par_vtaRef,
par_usocfdi,
par_tiporelacion,
par_activo,
par_subramo,
par_sector,
par_id_tipodoc,
par_id_emp);

SELECT LAST_INSERT_ID();

COMMIT;

END//
DELIMITER ;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `LlenaFechas`()
BEGIN
SET @fecha  = cast('2017-01-01' as date);

WHILE @fecha <= '2030-12-31' DO
insert into cortes(dia,hora) values(@fecha, 0);
SET @fecha = date_add(@fecha, interval 1 day);
END WHILE;

END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `interbd` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `inst` varchar(255) NOT NULL,
  `insteas` varchar(255) NOT NULL,
  `usr` varchar(255) NOT NULL,
  `usreas` varchar(255) NOT NULL,
  `contra` varchar(255) NOT NULL,
  `contraeas` varchar(255) NOT NULL,
  `bd` varchar(255) NOT NULL,
  `bdeas` varchar(255) NOT NULL,
  `port` int(11) NOT NULL,
  `porteas` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `usr2` varchar(255) NOT NULL,
  `contra2` varchar(255) NOT NULL,
  `tip` varchar(20) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `retivaflet` float DEFAULT '0',
  `retiva` float DEFAULT '0',
  `retisr` float DEFAULT '0',
  `ctaivaacred` varchar(30) DEFAULT '',
  `ivapendac` varchar(30) DEFAULT '',
  `ctaremvta1` varchar(30) DEFAULT '',
  `ctaremvta2` varchar(30) DEFAULT '',
  `ctaremrta1` varchar(30) DEFAULT '',
  `ctaremrta2` varchar(30) DEFAULT '',
  `ctaremint1` varchar(30) DEFAULT '',
  `ctaremint2` varchar(30) DEFAULT '',
  `cta1flet` varchar(30) DEFAULT '',
  `cta2flet` varchar(30) DEFAULT '',
  `cta3flet` varchar(30) DEFAULT '',
  `cta1arr` varchar(30) DEFAULT '',
  `cta2arr` varchar(30) DEFAULT '',
  `cta3arr` varchar(30) DEFAULT '',
  `cta1hon` varchar(30) DEFAULT '',
  `cta2hon` varchar(30) DEFAULT '',
  `cta3hon` varchar(30) DEFAULT '',
  `cta1merc` varchar(30) DEFAULT '',
  `cta2merc` varchar(30) DEFAULT '',
  `cta1gast` varchar(30) DEFAULT '',
  `cta2gast` varchar(30) DEFAULT '',
  `cta1cv` varchar(30) DEFAULT '',
  `cta1vta` varchar(30) DEFAULT '',
  `cta2vta` varchar(30) DEFAULT '',
  `cta3vta` varchar(30) DEFAULT '',
  `cta4vta` varchar(30) DEFAULT '',
  `ctadevsobvta` varchar(30) DEFAULT '',
  `ctabanc` varchar(30) DEFAULT '',
  `ctagaran` varchar(30) DEFAULT '',
  `ctaivapendpag` varchar(30) DEFAULT '',
  `ctaivaxpag` varchar(30) DEFAULT '',
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `interdpark` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `inst` varchar(255) DEFAULT '',
  `usr` varchar(255) DEFAULT '',
  `usrmand` varchar(30) DEFAULT '',
  `serfac` varchar(30) DEFAULT '',
  `mon` varchar(30) DEFAULT '',
  `contra` varchar(255) DEFAULT '',
  `bd` varchar(255) DEFAULT '',
  `codemploc` varchar(30) DEFAULT '',
  `prod` varchar(30) DEFAULT '',
  `port` int(11) DEFAULT '0',
  `diacort` int(11) DEFAULT '0',
  `automat` bit(1) DEFAULT b'0',
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fultcort` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `kits` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codkit` varchar(30) NOT NULL,
  `prod` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `cant` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codkit` (`codkit`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lins` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `img` varchar(255) DEFAULT '',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logactcat` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logacttip` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logalmas` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `loganaq` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logbanco` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logcatgral` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logclasemp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logclasext` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logclasificacion` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logclasprov` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logcolo` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logconcep` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logconcnot` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logconcpag` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logcorrs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `corrde` varchar(61) NOT NULL,
  `corr` varchar(61) NOT NULL,
  `nodoc` varchar(255) NOT NULL,
  `tipdoc` varchar(100) NOT NULL,
  `estad` varchar(100) NOT NULL,
  `motiv` varchar(500) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `export` bit(1) DEFAULT b'0',
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logcuentas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuenta` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logemps` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logestac` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `proxlog` time NOT NULL,
  `port` varchar(30) NOT NULL,
  `portudp` varchar(30) NOT NULL,
  `host` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logfabs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `loggara` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `loggiro` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logimpue` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `val` float NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logini` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `entsal` bit(1) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logkit` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `kit` varchar(30) NOT NULL,
  `prod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `loglins` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `loglugs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logmarc` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logmed` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logmod` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logmons` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logpes` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logprods` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logprovs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prov` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logresponsable` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logsucursal` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logtall` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logtip` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logubiad` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logunid` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `logzona` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `accio` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `accio` (`accio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lotped` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `lot` varchar(255) NOT NULL,
  `pedimen` varchar(255) NOT NULL,
  `aduana` varchar(50) NOT NULL DEFAULT '',
  `fcadu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `exist` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `alma` (`alma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `lugs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `marcprod` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `marc` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `marc` (`marc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `marcs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `maxminconf` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `hrs` int(11) NOT NULL,
  `estacglo` varchar(255) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `meds` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `model` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `modelprod` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `mode` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `mode` (`mode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `modifica_impuestos` (
  `venta` int(11) DEFAULT NULL,
  `partida` int(11) DEFAULT NULL,
  `total_anterior` decimal(22,6) DEFAULT NULL,
  `total_nuevo` decimal(22,6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `moninven` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(255) NOT NULL,
  `cant` float NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `unid` varchar(30) NOT NULL,
  `nodoc` varchar(30) NOT NULL,
  `noser` varchar(30) NOT NULL,
  `concep` varchar(50) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `emp` varchar(30) NOT NULL,
  `entsal` bit(1) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `existenciainicial` decimal(22,6) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `alma` (`alma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `mons` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `mon` varchar(30) NOT NULL,
  `val` float DEFAULT '0',
  `mondescrip` varchar(255) NOT NULL,
  `simb` varchar(5) NOT NULL,
  `c_moneda` varchar(5) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `mn` bit(1) DEFAULT b'0',
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `mon` (`mon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `movimientos_asientos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAsiento` int(11) NOT NULL,
  `numeroMovimiento` int(11) NOT NULL,
  `cuenta` varchar(45) NOT NULL,
  `importe` varchar(60) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `concepto` varchar(255) NOT NULL,
  `referencia` varchar(60) NOT NULL,
  `segmento_negocio` varchar(100) NOT NULL,
  `concentrado` tinyint(1) DEFAULT '0',
  `porcentaje` decimal(4,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`),
  KEY `FK_asiento_id_idx` (`idAsiento`),
  CONSTRAINT `FK_asiento_id` FOREIGN KEY (`idAsiento`) REFERENCES `asientos_contables` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `movimientos_pagos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pago_id` int(11) DEFAULT NULL,
  `serie` varchar(45) DEFAULT NULL,
  `folio` varchar(45) DEFAULT NULL,
  `subtotal` decimal(22,6) DEFAULT NULL,
  `impuestos` decimal(22,6) DEFAULT NULL,
  `total` decimal(22,6) DEFAULT NULL,
  `pendiente` decimal(22,6) DEFAULT NULL,
  `abono` decimal(22,6) DEFAULT NULL,
  `docto_origen` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `movimientos_pagos_idx_id` (`pago_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `msjs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `msj` varchar(1000) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ords` (
  `codord` int(11) NOT NULL AUTO_INCREMENT,
  `prov` varchar(30) NOT NULL,
  `proy` varchar(30) NOT NULL,
  `subtot` float NOT NULL,
  `impue` float NOT NULL,
  `total` float NOT NULL,
  `eje` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`codord`),
  KEY `prov` (`prov`),
  KEY `proy` (`proy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pags` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `nocaj` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partcomprs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcom` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `prod` varchar(255) NOT NULL,
  `cant` int(11) NOT NULL,
  `cantlotpend` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) DEFAULT '0.000000',
  `devs` int(11) DEFAULT '0',
  `unid` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `cost` decimal(22,6) NOT NULL,
  `costpro` decimal(22,6) NOT NULL,
  `serprod` varchar(30) NOT NULL,
  `tall` varchar(30) DEFAULT '',
  `colo` varchar(30) DEFAULT '',
  `garan` varchar(255) NOT NULL,
  `comenser` varchar(255) NOT NULL,
  `peps` decimal(22,6) DEFAULT '0.000000',
  `ueps` decimal(22,6) DEFAULT '0.000000',
  `descu` decimal(22,6) NOT NULL,
  `descad` decimal(22,6) NOT NULL,
  `recib` decimal(22,6) DEFAULT '0.000000',
  `codimpue` varchar(30) NOT NULL,
  `mon` varchar(30) NOT NULL,
  `lot` varchar(30) DEFAULT '',
  `pedimen` varchar(30) DEFAULT '',
  `aplic` bit(1) DEFAULT b'0',
  `idkit` int(11) DEFAULT '-1',
  `kitmae` bit(1) DEFAULT b'0',
  `eskit` bit(1) DEFAULT b'0',
  `impo` decimal(22,6) NOT NULL,
  `tipcam` decimal(22,6) NOT NULL,
  `flotvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cuentacontable` varchar(45) DEFAULT NULL,
  `activo` varchar(45) DEFAULT NULL,
  `lotePedimento` int(11) DEFAULT '0',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcom` (`codcom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partcomprs_tmp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcom` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `prod` varchar(255) NOT NULL,
  `cant` int(11) NOT NULL,
  `cantlotpend` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) DEFAULT '0.000000',
  `devs` int(11) DEFAULT '0',
  `unid` varchar(30) NOT NULL,
  `descrip` varchar(2100) NOT NULL,
  `cost` decimal(22,6) NOT NULL,
  `costpro` decimal(22,6) NOT NULL,
  `serprod` varchar(30) NOT NULL,
  `tall` varchar(30) DEFAULT '',
  `colo` varchar(30) DEFAULT '',
  `garan` varchar(255) NOT NULL,
  `comenser` varchar(255) NOT NULL,
  `peps` decimal(22,6) DEFAULT '0.000000',
  `ueps` decimal(22,6) DEFAULT '0.000000',
  `descu` decimal(22,6) NOT NULL,
  `descad` decimal(22,6) NOT NULL,
  `recib` decimal(22,6) DEFAULT '0.000000',
  `codimpue` varchar(30) NOT NULL,
  `mon` varchar(30) NOT NULL,
  `lot` varchar(30) DEFAULT '',
  `pedimen` varchar(30) DEFAULT '',
  `aplic` bit(1) DEFAULT b'0',
  `idkit` int(11) DEFAULT '-1',
  `kitmae` bit(1) DEFAULT b'0',
  `eskit` bit(1) DEFAULT b'0',
  `impo` decimal(22,6) NOT NULL,
  `tipcam` decimal(22,6) NOT NULL,
  `flotvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `activo` varchar(45) DEFAULT '',
  `cuentacontable` varchar(45) DEFAULT '',
  `lotePedimento` int(11) DEFAULT '0',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcom` (`codcom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partcot` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcot` varchar(30) NOT NULL,
  `prod` varchar(30) NOT NULL,
  `tipcam` float NOT NULL,
  `cost` float DEFAULT '0',
  `unid` varchar(30) NOT NULL,
  `mon` varchar(30) NOT NULL,
  `cant` int(11) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `eskit` bit(1) DEFAULT b'0',
  `serprod` varchar(30) NOT NULL,
  `comenser` varchar(255) NOT NULL,
  `tall` varchar(30) DEFAULT '',
  `fentre` varchar(30) DEFAULT '',
  `codimpue` varchar(30) NOT NULL,
  `colo` varchar(30) DEFAULT '',
  `garan` varchar(255) DEFAULT '',
  `list` int(11) DEFAULT '1',
  `lot` varchar(255) DEFAULT '',
  `pedimen` varchar(255) DEFAULT '',
  `fcadu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pre` float NOT NULL,
  `pre2` float NOT NULL,
  `desc1` float NOT NULL,
  `desc2` float NOT NULL,
  `desc3` float NOT NULL,
  `desc4` float NOT NULL,
  `desc5` float NOT NULL,
  `impo` float NOT NULL,
  `impo2` float NOT NULL,
  `impueval` float NOT NULL,
  `impueimpo` float NOT NULL,
  `impueimpo2` float NOT NULL,
  `impodesc` float DEFAULT '0',
  `alma` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `descripcionOpcional` VARCHAR(255) NULL DEFAULT '',
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcot` (`codcot`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partflujact` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `idfluj` int(11) NOT NULL,
  `segui` varchar(2148) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `idfluj` (`idfluj`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partords` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codord` varchar(30) NOT NULL,
  `codcot` varchar(30) NOT NULL,
  `prod` varchar(30) NOT NULL,
  `cant` int(11) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `unid` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `mon` varchar(30) NOT NULL,
  `descu` int(11) NOT NULL,
  `descad` int(11) NOT NULL,
  `impue` varchar(30) NOT NULL,
  `impueval` int(11) NOT NULL,
  `ultcost` float NOT NULL,
  `impo` float NOT NULL,
  `impoimpue` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codord` (`codord`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partprevcomprs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcom` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `prod` varchar(255) NOT NULL,
  `cant` int(11) NOT NULL,
  `cantlotpend` float NOT NULL,
  `impue` float DEFAULT '0',
  `devs` int(11) DEFAULT '0',
  `unid` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `cost` float NOT NULL,
  `costpro` float NOT NULL,
  `serprod` varchar(30) NOT NULL,
  `tall` varchar(30) DEFAULT '',
  `colo` varchar(30) DEFAULT '',
  `garan` varchar(255) NOT NULL,
  `comenser` varchar(255) NOT NULL,
  `peps` float DEFAULT '0',
  `ueps` float DEFAULT '0',
  `descu` float NOT NULL,
  `descad` float NOT NULL,
  `recib` float DEFAULT '0',
  `codimpue` varchar(30) NOT NULL,
  `mon` varchar(30) NOT NULL,
  `lot` varchar(30) DEFAULT '',
  `pedimen` varchar(30) DEFAULT '',
  `aplic` bit(1) DEFAULT b'0',
  `idkit` int(11) DEFAULT '-1',
  `kitmae` bit(1) DEFAULT b'0',
  `eskit` bit(1) DEFAULT b'0',
  `impo` float NOT NULL,
  `tipcam` float NOT NULL,
  `flotvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `activo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcom` (`codcom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partprevcomprs_tmp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcom` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `prod` varchar(255) NOT NULL,
  `cant` int(11) NOT NULL,
  `cantlotpend` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) DEFAULT '0.000000',
  `devs` int(11) DEFAULT '0',
  `unid` varchar(30) NOT NULL,
  `descrip` varchar(2100) NOT NULL,
  `cost` decimal(22,6) NOT NULL,
  `costpro` decimal(22,6) NOT NULL,
  `serprod` varchar(30) NOT NULL,
  `tall` varchar(30) DEFAULT '',
  `colo` varchar(30) DEFAULT '',
  `garan` varchar(255) NOT NULL,
  `comenser` varchar(255) NOT NULL,
  `peps` decimal(22,6) DEFAULT '0.000000',
  `ueps` decimal(22,6) DEFAULT '0.000000',
  `descu` decimal(22,6) NOT NULL,
  `descad` decimal(22,6) NOT NULL,
  `recib` decimal(22,6) DEFAULT '0.000000',
  `codimpue` varchar(30) NOT NULL,
  `mon` varchar(30) NOT NULL,
  `lot` varchar(30) DEFAULT '',
  `pedimen` varchar(30) DEFAULT '',
  `aplic` bit(1) DEFAULT b'0',
  `idkit` int(11) DEFAULT '-1',
  `kitmae` bit(1) DEFAULT b'0',
  `eskit` bit(1) DEFAULT b'0',
  `impo` decimal(22,6) NOT NULL,
  `tipcam` decimal(22,6) NOT NULL,
  `flotvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `activo` varchar(45) DEFAULT '',
  `cuentacontable` varchar(45) DEFAULT '',
  `lotePedimento` int(11) DEFAULT '0',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcom` (`codcom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `partvta` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(255) NOT NULL,
  `vta` int(11) NOT NULL,
  `tipdoc` varchar(30) NOT NULL,
  `cant` decimal(22,6) NOT NULL,
  `tipcam` decimal(22,6) NOT NULL,
  `devs` decimal(22,6) DEFAULT '0.000000',
  `garan` varchar(255) DEFAULT '',
  `eskit` bit(1) DEFAULT b'0',
  `kitmae` int(11) DEFAULT '0',
  `idkit` int(11) DEFAULT '-1',
  `idlotped` int(11) DEFAULT '-1',
  `list` int(11) DEFAULT '1',
  `unid` varchar(30) NOT NULL,
  `codimpue` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `serprod` varchar(30) NOT NULL,
  `comenser` varchar(255) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `pre` decimal(22,6) NOT NULL,
  `descu` decimal(22,6) NOT NULL,
  `costprom` decimal(22,6) DEFAULT '0.000000',
  `cost` decimal(22,6) DEFAULT '0.000000',
  `idultcost` int(11) DEFAULT '0',
  `peps` decimal(22,6) NOT NULL,
  `idpeps` varchar(2000) DEFAULT '',
  `ueps` decimal(22,6) NOT NULL,
  `idueps` varchar(2000) DEFAULT '',
  `mon` varchar(30) NOT NULL DEFAULT '',
  `lot` varchar(255) DEFAULT '',
  `pedimen` varchar(255) DEFAULT '',
  `fcadu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `impo` decimal(22,6) NOT NULL,
  `impue` int(11) NOT NULL,
  `tall` varchar(30) DEFAULT '',
  `colo` varchar(30) DEFAULT '',
  `cantentre` decimal(22,6) DEFAULT '0.000000',
  `entrenow` decimal(22,6) DEFAULT '0.000000',
  `export` bit(1) DEFAULT b'0',
  `idempresa` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fentre` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `activo` varchar(45) NOT NULL DEFAULT '',
  `cuentacontable` varchar(45) DEFAULT NULL,
  `lotePedimento` int(11) DEFAULT '0',
  `monedaID` int(11) NOT NULL DEFAULT '0',
  `partidaIdOriginal` int(11) NOT NULL DEFAULT '0',
  `descripcionOpcional` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `vta` (`vta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pedidos` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codcot` varchar(30) NOT NULL,
  `motiv` varchar(255) DEFAULT '',
  `ser` varchar(30) NOT NULL,
  `totdescu` decimal(22,6) NOT NULL,
  `totcost` decimal(22,6) NOT NULL,
  `noser` varchar(30) NOT NULL,
  `norefer` varchar(30) DEFAULT '',
  `vta` int(11) DEFAULT '0',
  `tipcam` decimal(22,6) NOT NULL,
  `tipcamnac` decimal(22,6) NOT NULL,
  `monedaID` int(11) NOT NULL,
  `noservta` varchar(30) DEFAULT '',
  `codemp` varchar(30) NOT NULL,
  `referencia` varchar(255) DEFAULT '',
  `observ` varchar(255) NOT NULL,
  `total_traslado` decimal(22,6) NOT NULL,
  `total_retencion` decimal(22,6) NOT NULL,
  `subtot` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) NOT NULL,
  `tot` decimal(22,6) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estad` varchar(10) NOT NULL,
  `fdoc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fentre` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(255) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codcot` (`codcot`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `pedidos_parts` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `pedidoID` int(11) NOT NULL,
  `prod` varchar(30) NOT NULL,
  `tipcam` decimal(22,6) NOT NULL,
  `cost` decimal(22,6) DEFAULT '0.000000',
  `unid` varchar(30) NOT NULL,
  `mon` varchar(30) NOT NULL,
  `cant` int(11) NOT NULL,
  `recibidas` int(11) NOT NULL,
  `descrip` varchar(500) NOT NULL,
  `eskit` bit(1) DEFAULT b'0',
  `serprod` varchar(30) NOT NULL,
  `comenser` varchar(255) NOT NULL,
  `tall` varchar(30) DEFAULT '',
  `fentre` varchar(30) DEFAULT '',
  `codimpue` varchar(30) NOT NULL,
  `colo` varchar(30) DEFAULT '',
  `garan` varchar(255) DEFAULT '',
  `list` int(11) DEFAULT '1',
  `lot` varchar(255) DEFAULT '',
  `pedimen` varchar(255) DEFAULT '',
  `fcadu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pre` decimal(22,6) NOT NULL,
  `pre2` decimal(22,6) NOT NULL,
  `desc1` decimal(22,6) NOT NULL,
  `desc2` decimal(22,6) NOT NULL,
  `desc3` decimal(22,6) NOT NULL,
  `desc4` decimal(22,6) NOT NULL,
  `desc5` decimal(22,6) NOT NULL,
  `impo` decimal(22,6) NOT NULL,
  `impo2` decimal(22,6) NOT NULL,
  `impueval` decimal(22,6) NOT NULL,
  `impueimpo` decimal(22,6) NOT NULL,
  `impueimpo2` decimal(22,6) NOT NULL,
  `impodesc` decimal(22,6) DEFAULT '0.000000',
  `alma` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `descripcionOpcional` varchar(255) DEFAULT '',
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `pedidoID` (`pedidoID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `pers` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `act` bit(1) DEFAULT b'1',
  `rutimg` varchar(500) DEFAULT '',
  `calle` varchar(255) DEFAULT '',
  `col` varchar(255) DEFAULT '',
  `noext` varchar(21) DEFAULT '',
  `noint` varchar(21) DEFAULT '',
  `CP` varchar(6) DEFAULT '',
  `tel1` varchar(255) DEFAULT '',
  `tel2` varchar(255) DEFAULT '',
  `cel1` varchar(255) DEFAULT '',
  `cel2` varchar(255) DEFAULT '',
  `fingemp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fsalemp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `teleme1` varchar(255) DEFAULT '',
  `teleme2` varchar(255) DEFAULT '',
  `contac1` varchar(4255) DEFAULT NULL,
  `contac2` varchar(255) DEFAULT '',
  `sueldactua` float DEFAULT '0',
  `textra` float DEFAULT '0',
  `sueldfora` float DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `nom` (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `pes` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  UNIQUE KEY `cod_UNIQUE` (`cod`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `petis` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `nomarch` varchar(1000) NOT NULL,
  `path` varchar(1000) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `estacdestin` varchar(30) NOT NULL,
  `val` bit(1) NOT NULL,
  `estad` bit(1) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `prevcomprs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codprevcomp` varchar(30) NOT NULL,
  `motiv` varchar(255) NOT NULL,
  `noser` varchar(30) NOT NULL,
  `nodoc` varchar(30) DEFAULT '',
  `prov` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `codcomp` varchar(30) DEFAULT '',
  `nosercomp` varchar(30) NOT NULL,
  `notcredpag` varchar(250) DEFAULT '',
  `tipcam` float NOT NULL,
  `mon` varchar(30) NOT NULL,
  `ruta` varchar(500) DEFAULT '',
  `observ` varchar(255) DEFAULT '',
  `subtot` float NOT NULL,
  `impue` float NOT NULL,
  `tip` varchar(30) DEFAULT 'PREV',
  `tot` float NOT NULL,
  `estado` varchar(10) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fdoc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codprevcomp` (`codprevcomp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `prodpart` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `part` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `part` (`part`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `prods` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(255) NOT NULL,
  `prodop1` varchar(30) NOT NULL,
  `prodop2` varchar(30) NOT NULL,
  `provop1` varchar(30) DEFAULT '',
  `provop2` varchar(30) DEFAULT '',
  `codmed` varchar(30) DEFAULT '',
  `garan` varchar(30) DEFAULT '',
  `clasjera` varchar(2048) DEFAULT '',
  `descrip` varchar(2100) NOT NULL,
  `descripcort` varchar(255) DEFAULT '',
  `lin` varchar(30) DEFAULT '',
  `metcost` varchar(10) DEFAULT 'ultcost',
  `tip` varchar(30) DEFAULT '',
  `solmaxmin` int(11) DEFAULT '1',
  `marc` varchar(30) DEFAULT '',
  `codubi` varchar(30) DEFAULT '',
  `mode` varchar(30) DEFAULT '',
  `fab` varchar(30) DEFAULT '',
  `colo` varchar(30) DEFAULT '',
  `solser` bit(1) DEFAULT b'0',
  `codext` varchar(30) DEFAULT '',
  `noser` varchar(30) DEFAULT '',
  `comenser` varchar(600) DEFAULT '',
  `rutimg` varchar(500) DEFAULT '',
  `impue` varchar(30) DEFAULT '',
  `pes` varchar(30) DEFAULT '',
  `pesman` float NOT NULL,
  `prelist1` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist2` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist3` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist4` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist5` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist6` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist7` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist8` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist9` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `prelist10` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta1` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta2` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta3` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta4` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta5` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta6` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta7` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta8` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta9` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `utilvta10` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `med` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `cost` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `costre` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `exist` DECIMAL(22,6) NOT NULL DEFAULT 0 ,
  `unid` varchar(30) DEFAULT '',
  `anaq` varchar(30) DEFAULT '',
  `lug` varchar(30) DEFAULT '',
  `alma` varchar(30) DEFAULT '',
  `descprov` varchar(100) NOT NULL,
  `infor` varchar(255) NOT NULL,
  `min` int(11) NOT NULL,
  `max` int(11) NOT NULL,
  `bajcost` int(11) NOT NULL,
  `esvta` int(11) DEFAULT '0',
  `compue` int(11) DEFAULT '0',
  `invent` int(11) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `estaccrea` varchar(30) DEFAULT '',
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `lote` varchar(30) DEFAULT '',
  `pedimen` varchar(30) DEFAULT '',
  `servi` bit(1) DEFAULT b'0',
  `lotped` bit(1) DEFAULT b'0',
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `fcadu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `clavesat` varchar(25) NOT NULL,
  `provprincipal` int(11) NOT NULL DEFAULT '1',
  `id_garan` int(11) DEFAULT '0',
  `id_lin` int(11) DEFAULT '0',
  `id_tip` int(11) DEFAULT '0',
  `id_marc` int(11) DEFAULT '0',
  `id_mode` int(11) DEFAULT '0',
  `id_fab` int(11) DEFAULT '0',
  `id_colo` int(11) DEFAULT '0',
  `id_pes` int(11) DEFAULT '0',
  `id_unid` int(11) DEFAULT '0',
  `id_lug` int(11) DEFAULT '0',
  `id_alma` int(11) DEFAULT '0',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `provs` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prov` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `codclas` varchar(30) NOT NULL,
  `zon` varchar(30) DEFAULT '',
  `giro` varchar(30) DEFAULT '',
  `tentre` varchar(255) DEFAULT '',
  `rubr` varchar(30) DEFAULT '',
  `banc` varchar(30) DEFAULT '',
  `clavbanc` varchar(255) DEFAULT '',
  `lada` varchar(10) DEFAULT '',
  `metpag` varchar(45) DEFAULT '',
  `cta` varchar(45) DEFAULT '0000',
  `enlada` varchar(10) DEFAULT '',
  `nom` varchar(255) NOT NULL,
  `tel` varchar(255) DEFAULT '',
  `entel` varchar(255) DEFAULT '',
  `cel` varchar(255) DEFAULT '',
  `encel` varchar(255) DEFAULT '',
  `clasjera` varchar(2048) DEFAULT '',
  `exten` varchar(20) DEFAULT '',
  `enexten` varchar(20) DEFAULT '',
  `calle` varchar(255) DEFAULT '',
  `encalle` varchar(255) DEFAULT '',
  `col` varchar(255) DEFAULT '',
  `encol` varchar(255) DEFAULT '',
  `cp` varchar(20) DEFAULT '',
  `encp` varchar(20) DEFAULT '',
  `ennoint` varchar(100) DEFAULT '',
  `noint` varchar(100) DEFAULT '',
  `noext` varchar(100) DEFAULT '',
  `ennoext` varchar(100) DEFAULT '',
  `ciu` varchar(255) DEFAULT '',
  `enciu` varchar(255) DEFAULT '',
  `estad` varchar(255) DEFAULT '',
  `enestad` varchar(255) DEFAULT '',
  `otramon` bit(1) DEFAULT b'1',
  `otramonc` bit(1) DEFAULT b'1',
  `bloq` bit(1) DEFAULT b'1',
  `ctaconta` varchar(30) DEFAULT '',
  `revis` varchar(100) DEFAULT '',
  `pags` varchar(100) DEFAULT '',
  `pais` varchar(255) DEFAULT '',
  `enpais` varchar(255) DEFAULT '',
  `rfc` varchar(21) DEFAULT '',
  `descu` float DEFAULT '0',
  `diacred` varchar(21) DEFAULT '0',
  `limcred` float DEFAULT '0',
  `bloqlimcred` bit(1) DEFAULT b'0',
  `co1` varchar(100) DEFAULT '',
  `enco1` varchar(100) DEFAULT '',
  `co2` varchar(100) DEFAULT '',
  `enco2` varchar(100) DEFAULT '',
  `co3` varchar(100) DEFAULT '',
  `enco3` varchar(100) DEFAULT '',
  `pagweb1` varchar(255) DEFAULT '',
  `pagweb2` varchar(255) DEFAULT '',
  `eje1` varchar(255) DEFAULT '',
  `telper1` varchar(255) DEFAULT '',
  `entelper1` varchar(255) DEFAULT '',
  `telper2` varchar(255) DEFAULT '',
  `entelper2` varchar(255) DEFAULT '',
  `eje2` varchar(255) DEFAULT '',
  `telper21` varchar(255) DEFAULT '',
  `telper22` varchar(255) DEFAULT '',
  `observ` varchar(255) DEFAULT '',
  `pers` varchar(2) DEFAULT '',
  `contac3` varchar(255) DEFAULT '',
  `telcon3` varchar(255) DEFAULT '',
  `telper3` varchar(255) DEFAULT '',
  `telper33` varchar(255) DEFAULT '',
  `contac4` varchar(255) DEFAULT '',
  `telcon4` varchar(255) DEFAULT '',
  `telper4` varchar(255) DEFAULT '',
  `telper44` varchar(255) DEFAULT '',
  `contac5` varchar(255) DEFAULT '',
  `telcon5` varchar(255) DEFAULT '',
  `telper5` varchar(255) DEFAULT '',
  `telper55` varchar(255) DEFAULT '',
  `contac6` varchar(255) DEFAULT '',
  `telcon6` varchar(255) DEFAULT '',
  `telper6` varchar(255) DEFAULT '',
  `telper66` varchar(255) DEFAULT '',
  `contac7` varchar(255) DEFAULT '',
  `telcon7` varchar(255) DEFAULT '',
  `telper7` varchar(255) DEFAULT '',
  `telper77` varchar(255) DEFAULT '',
  `contac8` varchar(255) DEFAULT '',
  `telcon8` varchar(255) DEFAULT '',
  `telper8` varchar(255) DEFAULT '',
  `telper88` varchar(255) DEFAULT '',
  `contac9` varchar(255) DEFAULT '',
  `telcon9` varchar(255) DEFAULT '',
  `telper9` varchar(255) DEFAULT '',
  `telper99` varchar(255) DEFAULT '',
  `contac10` varchar(255) DEFAULT '',
  `telcon10` varchar(255) DEFAULT '',
  `telper10` varchar(255) DEFAULT '',
  `telper100` varchar(255) DEFAULT '',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `beneficiario` varchar(255) DEFAULT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prov` (`prov`),
  KEY `ser` (`ser`),
  KEY `idempresa` (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `proys` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `proy` varchar(30) NOT NULL,
  `codemp` varchar(30) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `obra` varchar(255) NOT NULL,
  `tipobr` varchar(100) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `plant` varchar(255) NOT NULL,
  `tot` float NOT NULL,
  `subtot` float NOT NULL,
  `iva` float NOT NULL,
  `otr` varchar(255) NOT NULL,
  `ubigraf` varchar(350) NOT NULL,
  `ubic` varchar(255) NOT NULL,
  `estad` varchar(10) NOT NULL,
  `estatu` int(11) DEFAULT '0',
  `iniobr` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `termobr` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tiement` varchar(255) NOT NULL,
  `condpag` varchar(100) NOT NULL,
  `nompers` varchar(500) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(255) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `proyvac` int(11) DEFAULT '0',
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `proy` (`proy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `registroemail` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(350) NOT NULL,
  `contra` varchar(100) NOT NULL,
  `generada_fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cambiada_fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ya_entro_booleano` int(3) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `registros` (
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `resp` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `hrs` int(11) NOT NULL,
  `estacres` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estacres` (`estacres`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `resp355834` (
  `venta` int(11) NOT NULL,
  `id_partida` int(11) NOT NULL DEFAULT '0',
  `impuesto` varchar(30) NOT NULL,
  `retencion` bit(1) NOT NULL,
  `total` decimal(22,6) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT '',
  `extr2` varchar(255) DEFAULT '',
  `extr3` varchar(255) DEFAULT '',
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `resplog` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `tip` bit(1) NOT NULL,
  `return` int(11) DEFAULT '-1',
  `pathdemysq` varchar(2048) DEFAULT '',
  `pathamysq` varchar(2048) DEFAULT '',
  `pathde` varchar(2048) DEFAULT '',
  `patha` varchar(2048) DEFAULT '',
  `msj` varchar(500) DEFAULT '',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `tip` (`tip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `responsable` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `rubr` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ruts` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `program` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `rut` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `estac` (`estac`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sectores` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(30) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `estacion` varchar(30) NOT NULL,
  `sucursal` varchar(30) NOT NULL,
  `caja` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codigo` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP PROCEDURE IF EXISTS `SEL_AlmacenPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_AlmacenPorCodigo`(in par_id_empresa varchar(30), in par_alma varchar(30))
BEGIN
SELECT id_id,
    alma,
    respon,
    almadescrip,
    dir1,
    dir2,
    dir3,
    actfij,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM almas
WHERE idempresa = par_id_empresa and alma = par_alma;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_AlmacenPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_AlmacenPorId`(in par_id_empresa varchar(30), in par_id int)
BEGIN
SELECT id_id,
    alma,
    respon,
    almadescrip,
    dir1,
    dir2,
    dir3,
    actfij,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM almas
WHERE idempresa = par_id_empresa and id_id = par_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_BuscaCorreo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_BuscaCorreo`(in par_id_empresa varchar(30), in par_busqueda VARCHAR(255))
BEGIN
SELECT 
corrselec.id_id, 
corrselec.srvsmtpsal, 
corrselec.asunfac,  
corrselec.asuncot, 
corrselec.asuncontra,  
corrselec.asunord, 
corrselec.asunrec1, 
corrselec.asunrec2,
corrselec.asunrec3,
corrselec.cuerpfac,
corrselec.cuerpcot,
corrselec.cuerpcontra,
corrselec.cuerpord, 
corrselec.cuerprec1, 
corrselec.cuerprec2, 
corrselec.cuerprec3, 
corrselec.portsmtp, 
corrselec.actslenlog, 
corrselec.usr,  
corrselec.pass,  
corrselec.corralter,  
corrselec.idempresa,  
corrselec.estac,  
corrselec.estacglo,  
corrselec.sucu,
corrselec.nocaj, 
corrselec.extr1, 
corrselec.extr2, 
corrselec.extr3, 
corrselec.export, 
corrselec.falt, 
corrselec.fmod, 
estacs.NOM nombreestac
FROM corrselec 
LEFT OUTER JOIN estacs ON estacs.ESTAC = corrselec.ESTAC 
WHERE (corrselec.ID_ID LIKE CONCAT('%',par_busqueda,'%') 
 OR srvsmtpsal LIKE CONCAT('%',par_busqueda,'%')  
 OR portsmtp LIKE CONCAT('%',par_busqueda,'%')  
 OR corrselec.USR LIKE CONCAT('%',par_busqueda,'%') 
 OR corrselec.PASS LIKE CONCAT('%',par_busqueda,'%') 
 OR corrselec.CORRALTER LIKE CONCAT('%',par_busqueda,'%') 
 OR corrselec.ESTAC LIKE CONCAT('%',par_busqueda,'%') 
 OR corrselec.ESTACGLO LIKE CONCAT('%',par_busqueda,'%')  
 OR corrselec.FALT LIKE CONCAT('%',par_busqueda,'%') 
 OR corrselec.FMOD LIKE CONCAT('%',par_busqueda,'%') )
AND corrselec.idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS  `SEL_ClasJerProveedorPorRut`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ClasJerProveedorPorRut`(in par_id_empresa varchar(30), in par_rut varchar(2048))
BEGIN
SELECT id_id,
    clas,
    rut,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM clasjeraprov;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_ClientePorSerCod`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ClientePorSerCod`(IN par_sercod varchar(30), IN par_id_empresa VARCHAR(30))
BEGIN
SELECT  id_id ,
     anio ,
     banc ,
     beneficiario ,
     bloq ,
     bloqlimcred ,
     calle ,
     cel ,
     ciu ,
     clasjera ,
     clavbanc ,
     co1 ,
     co2 ,
     co3 ,
     codclas ,
     codemp ,
     codigo ,
     col ,
     CP ,
     cta ,
     ctaconta ,
     ctapred ,
     curp ,
     deposit ,
     descu ,
     diacred ,
     diapag ,
     encall ,
     encel ,
     enciu ,
     enco1 ,
     enco2 ,
     enco3 ,
     encol ,
     encp ,
     enemail ,
     enestad ,
     enlada ,
     ennoext ,
     ennoexten ,
     ennoint ,
     enpagweb ,
     enpai ,
     entel1 ,
     entel2 ,
     entel3 ,
     estac ,
     estad ,
     export ,
     exten ,
     extr1 ,
     extr2 ,
     extr3 ,
     falt ,
     fmod 
     idempresa ,
     lada ,
     limtcred ,
     list ,
     metpag ,
     nocaj ,
     noext ,
     noint ,
     nom ,
     observ ,
     otramon ,
     otramonc ,
     pags ,
     pagweb1 ,
     pagweb2 ,
     pai ,
     pers ,
     revis ,
     RFC ,
     ser ,
     sucu ,
     tel ,
     telper1 ,
     telper2 ,
     usocfdi ,
     vend 
FROM  emps
WHERE CONCAT_WS('', ser, codemp)= par_sercod AND 
emps.idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ConfiguracionesPorClasificacion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ConfiguracionesPorClasificacion`(in par_clasif varchar(30), in par_id_empresa varchar(30))
BEGIN
   SELECT id_id,clasif,conf,val,nume,falt,fmod,idempresa,estac,dia,envia,extr,asun,anio,sucu,nocaj,export,extr1,extr2,extr3 FROM confgral
   WHERE idempresa=par_id_empresa and clasif = par_clasif;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ConfiguracionesPorClasificacionActivo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ConfiguracionesPorClasificacionActivo`(in par_clasif varchar(30), in par_id_empresa varchar(30))
BEGIN
   SELECT id_id,clasif,conf,val,nume,falt,fmod,idempresa,estac,dia,envia,extr,asun,anio,sucu,nocaj,export,extr1,extr2,extr3 FROM confgral
   WHERE idempresa=par_id_empresa and clasif = par_clasif and val = 1;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ConfiguracionPorConfig`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ConfiguracionPorConfig`(in par_id_empresa varchar(30), in par_conf varchar(45))
BEGIN
   SELECT id_id,clasif,conf,val,nume,falt,fmod,idempresa,estac,dia,envia,extr,asun,anio,sucu,nocaj,export,extr1,extr2,extr3 FROM confgral
   WHERE idempresa=par_id_empresa and conf = par_conf;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ConfiguracionPosicionDecimal`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ConfiguracionPosicionDecimal`(in par_id_empresa  varchar(30))
BEGIN
   SELECT nume FROM confgral WHERE clasif = 'sist' AND conf = 'posdecimal' AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ConsecutivoPorTipSer`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ConsecutivoPorTipSer`(IN par_tip varchar(10), IN par_ser varchar(10), IN par_id_empresa varchar(30))
BEGIN
   SELECT id_id,
   ser,
   descrip,
   tip,
   export,
   consec,
   idempresa,
   estac,
   sucu,
   nocaj,
   extr1,
   extr2,
   extr3,
   falt,
   fmod FROM consecs 
   WHERE tip = par_tip 
   AND ser = par_ser
   AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_CuentaContable`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_CuentaContable`(in par_id_empresa varchar(30), in par_cuenta varchar(30))
BEGIN
SELECT id,
    cuenta,
    descrip,
    estac,
    sucu,
    export,
    nocaj,
    falt,
    fmod,
    idempresa
FROM cuentas_contables where idempresa = par_id_empresa and cuenta = par_cuenta;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_CuentasPorPagarPorNoRefer`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_CuentasPorPagarPorNoRefer`(in par_id_empresa varchar(30), in par_norefer varchar(50))
BEGIN
SELECT id_id,
    norefer,
    noser,
    prov,
    ser,
    formpag,
    conceppag,
    monedaID,
    tipcam,
    comen,
    subtot,
    tot,
    impue,
    carg,
    abon,
    concep,
    folbanc,
    fvenc,
    fdoc,
    falt,
    fmod,
    fol,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    cuentabanco,
    estado,
    extr1,
    extr2,
    extr3
FROM cxp
WHERE idempresa = par_id_empresa and norefer = par_norefer;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_DatosMoneda`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_DatosMoneda`(IN par_codigo varchar(5), IN par_id_empresa VARCHAR(30))
BEGIN
SELECT 
m.id_id,
m.c_moneda codigo_moneda, 
m.val valor, 
c.decimales decimales,
m.mondescrip descripcion,
c.Descripcion descipcionSAT,
m.simb as simbolo
FROM mons m 
inner join c_moneda c on m.c_moneda = c.c_moneda
WHERE m.mon = par_codigo AND m.idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_DescripcionPorTipSer`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_DescripcionPorTipSer`(IN par_tip varchar(10), IN par_ser varchar(10), IN par_id_empresa varchar(30))
BEGIN
   SELECT descrip FROM consecs 
   WHERE tip = par_tip 
   AND ser = par_ser
   AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_DocRelacionadoNotCred`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_DocRelacionadoNotCred`(IN par_notcred varchar(30), par_id_empresa varchar(30))
BEGIN
   SELECT 
   folfisc, 
   tiporelacion
   FROM vtas
   WHERE notcred = par_notcred  AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_DocRelacionadoVentaRef`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_DocRelacionadoVentaRef`(IN par_vta int(11), IN par_id_empresa varchar(30))
BEGIN
SELECT 
folfisc, 
tiporelacion 
FROM vtas 
WHERE vtaRef = par_vta
AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_EntregasCliente`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_EntregasCliente`(IN par_codemp varchar(30))
BEGIN
SELECT 
tel,
lada,
exten,
cel,
telper1,
telper2,
calle,
col,
noext,
noint,
cp,
ciu,
estad,
pai,
co1,
co2,
co3 
FROM domentcli WHERE codemp = par_codemp;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_EstacionesPorEstac`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_EstacionesPorEstac`(in par_id_empresa varchar(30), in par_estac varchar(30))
BEGIN
SELECT id_id,
    idempresa,
    estac,
    correo,
    52m,
    ptovta,
    descu,
    comi,
    habdesc,
    imptic,
    impfac,
    cort,
    pass,
    estacglo,
    calle,
    nom,
    col,
    cp,
    tel,
    cel,
    pai,
    ciu,
    esta,
    noint,
    res1path,
    res2path,
    res3path,
    rutmysq,
    noext,
    sucu,
    nocaj,
    export,
    admcaj,
    vend,
    mandagra,
    manddia,
    mandcump,
    extr1,
    extr2,
    extr3,
    falt,
    fmod,
    almacen
FROM estacs 
WHERE idempresa = par_id_empresa
AND estac = par_estac;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_GiroPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_GiroPorCodigo`(in par_id_empresa varchar(30), in par_gir varchar(30))
BEGIN
SELECT id_id,
    gir,
    descrip,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM giro
WHERE idempresa = par_id_empresa AND gir = par_gir;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_IdCXC`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_IdCXC`(in par_empre varchar(30), in par_norefer varchar(50), in par_noser varchar(20), in par_id_venta int, in par_id_empresa varchar(30))
BEGIN
SELECT id_id FROM cxc 
WHERE empre = par_empre 
AND norefer = par_norefer
AND noser = par_noser
AND id_venta = par_id_venta
AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ImpuestoBusqueda`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ImpuestoBusqueda`(in par_id_empresa varchar(30), in par_busqueda varchar(1000))
BEGIN
SELECT 
id_id,
codimpue,
reten,
impueval,
idempresa,
estac,
sucu,
nocaj,
export,
extr1,
extr2,
extr3,
falt,
fmod,
impuestoXML
FROM impues 
WHERE (codimpue LIKE CONCAT('%',par_busqueda,'%') 
OR impueval LIKE CONCAT('%',par_busqueda,'%') 
OR falt LIKE CONCAT('%',par_busqueda,'%') 
OR fmod LIKE CONCAT('%',par_busqueda,'%')) 
AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ImpuestoPorProducto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ImpuestoPorProducto`(IN par_produ varchar(30), IN par_id_empresa varchar(30))
BEGIN
SELECT 
i.id_id,
i.codimpue,
i.reten,
i.impueval,
i.idempresa,
i.estac,
i.sucu,
i.nocaj,
i.export,
i.falt,
i.fmod,
i.impuestoXML
FROM impues_x_product ixp
LEFT OUTER JOIN impues i ON ixp.impue = i.codimpue AND ixp.idempresa = i.idempresa
WHERE ixp.produ = par_produ AND ixp.idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ImpuestosPorVenta`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ImpuestosPorVenta`(IN par_venta int)
BEGIN
select 
i.impuesto, 
i.retencion, 
sum(truncate(i.total, 2)) total,
m.impuestoXML, 
m.impueval 
from impuestos_x_venta i
inner join impues m on i.impuesto = m.codimpue 
and i.idempresa = m.idempresa 
and i.venta = par_venta
group by impuesto;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_IngresoEncabezadoPorSerie`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_IngresoEncabezadoPorSerie`(in par_id_empresa varchar(30), in par_noser varchar(30), in par_norefer varchar(30))
BEGIN
SELECT id_id,
    alma,
    concep,
    canttotal,
    idempresa,
    estac,
    sucu,
    entsal,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    noser,
    norefer
FROM ingresos_encab
WHERE idempresa = par_id_empresa and noser = par_noser and norefer = par_norefer;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_IngresoPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_IngresoPorId`(in par_idempresa varchar(30), in par_id_id int)
BEGIN
SELECT id_id,
    idIngresCab,
    prod,
    alma,
    unid,
    concep,
    cant,
    idempresa,
    estac,
    sucu,
    entsal,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    activo,
    falt,
    costo,
    cantsal,
    tipcamnac
FROM ingres
WHERE idempresa = par_idempresa AND id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_IngresosPorIdEncab`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_IngresosPorIdEncab`(in par_id_empresa varchar(30), in par_id_id int)
BEGIN
SELECT 
    i.id_id,
    i.idIngresCab,
    i.prod,
    i.alma,
    i.unid,
    i.concep,
    i.cant,
    i.idempresa,
    i.estac,
    i.sucu,
    i.entsal,
    i.nocaj,
    i.export,
    i.extr1,
    i.extr2,
    i.extr3,
    i.activo,
    i.falt,
    i.costo,
    i.cantsal,
    i.tipcamnac
FROM ingresos_encab en
JOIN ingres i ON en.id_id = i.idIngresCab AND en.idempresa = i.idempresa
WHERE en.idempresa = par_id_empresa AND en.id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_IngresosPorParametro`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_IngresosPorParametro`(
	IN `b_id_id` bool,
	IN `b_idIngresCab` bool,
	IN `b_prod` bool,
	IN `b_alma` bool,
	IN `b_unid` bool,
	IN `b_concep` bool,
	IN `b_cant` bool,
	IN `b_idempresa` bool,
	IN `b_estac` bool,
	IN `b_sucu` bool,
	IN `b_entsal` bool,
	IN `b_nocaj` bool,
	IN `b_export` bool,
	IN `b_costo` bool,
	IN `b_cantsal` bool,
	IN `b_tipcamnac` bool,
	IN `par_id_id` int,
	IN `par_idIngresCab` int,
	IN `par_prod` varchar(255),
	IN `par_alma` varchar(255),
	IN `par_unid` varchar(255),
	IN `par_concep` varchar(50),
	IN `par_cant` float,
	IN `par_idempresa` varchar(30),
	IN `par_estac` varchar(30),
	IN `par_sucu` varchar(30),
	IN `par_entsal` bit,
	IN `par_nocaj` varchar(30),
	IN `par_export` bit,
	IN `par_costo` varchar(50),
	IN `par_cantsal` decimal(22,6),
	IN `par_tipcamnac` decimal(22,6)
)
BEGIN
SELECT id_id,idIngresCab,prod,alma,unid,concep,cant,idempresa,estac,sucu,entsal,nocaj,export,extr1,extr2,extr3,activo,falt,costo,cantsal,tipcamnac
FROM ingres
WHERE
((b_id_id = true AND id_id = par_id_id) OR (b_id_id = false))
and
((b_idIngresCab = true AND idIngresCab = par_idIngresCab) OR (b_idIngresCab = false))
and
((b_prod = true AND prod = par_prod) OR (b_prod = false))
and
((b_alma = true AND alma = par_alma) OR (b_alma = false))
and
((b_unid = true AND unid = par_unid) OR (b_unid = false))
and
((b_concep = true AND concep = par_concep) OR (b_concep = false))
and
((b_cant = true AND cant = par_cant) OR (b_cant = false))
and
((b_idempresa = true AND idempresa = par_idempresa) OR (b_idempresa = false))
and
((b_estac = true AND estac = par_estac) OR (b_estac = false))
and
((b_sucu = true AND sucu = par_sucu) OR (b_sucu = false))
and
((b_entsal = true AND entsal = par_entsal) OR (b_entsal = false))
and
((b_nocaj = true AND nocaj = par_nocaj) OR (b_nocaj = false))
and
((b_export = true AND export = par_export) OR (b_export = false))
and
((b_costo = true AND costo = par_costo) OR (b_costo = false))
and 
((b_cantsal = true AND cantsal = par_cantsal) OR (b_cantsal = false))
and
((b_tipcamnac = true AND tipcamnac = par_tipcamnac) OR (b_tipcamnac = false))
;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_IngresosSerieEncabezado`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_IngresosSerieEncabezado`(in par_id_empresa varchar(30) , in par_noser varchar(30), in par_norefer varchar(30))
BEGIN
SELECT 
    i.id_id,
    i.idIngresCab,
    i.prod,
    i.alma,
    i.unid,
    i.concep,
    i.cant,
    i.idempresa,
    i.estac,
    i.sucu,
    i.entsal,
    i.nocaj,
    i.export,
    i.extr1,
    i.extr2,
    i.extr3,
    i.activo,
    i.falt,
    i.costo,
    i.cantsal,
    i.tipcamnac
FROM ingresos_encab en
JOIN ingres i ON en.id_id = i.idIngresCab AND en.idempresa = i.idempresa
WHERE en.idempresa = par_id_empresa AND en.noser = par_noser AND en.norefer = par_norefer;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_LineaPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_LineaPorCodigo`(IN par_cod varchar(30), IN par_id_empresa varchar(30))
BEGIN
SELECT id_id,
   cod,
   descrip,
   img,
   idempresa,
   estac,
   sucu,
   nocaj,
   export,
   extr1,
   extr2,
   extr3,
   falt,
   fmod
FROM lins
WHERE cod = par_cod and idempresa=par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_LineaPorDescripcion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_LineaPorDescripcion`(IN par_descrip varchar(30), IN par_id_empresa varchar(30))
BEGIN
SELECT id_id,
   cod,
   descrip,
   img,
   idempresa,
   estac,
   sucu,
   nocaj,
   export,
   extr1,
   extr2,
   extr3,
   falt,
   fmod
FROM lins
WHERE descrip = par_descrip and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_LineaPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_LineaPorId`(IN par_id int)
BEGIN
SELECT id_id,
   cod,
   descrip,
   img,
   idempresa,
   estac,
   sucu,
   nocaj,
   export,
   extr1,
   extr2,
   extr3,
   falt,
   fmod
FROM lins
WHERE id_id = par_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_Lineas`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_Lineas`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    lins.cod,
    lins.descrip,
    lins.img,
    lins.idempresa,
    lins.estac,
    lins.sucu,
    lins.nocaj,
    lins.export,
    lins.extr1,
    lins.extr2,
    lins.extr3,
    lins.falt,
    lins.fmod
FROM lins
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaAlmacenes`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaAlmacenes`()
BEGIN
SELECT id_id,
    alma,
    respon,
    almadescrip,
    dir1,
    dir2,
    dir3,
    actfij,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM almas;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaClasJerProveedor`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaClasJerProveedor`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    clas,
    rut,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM clasjeraprov;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_ListaClientes`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaClientes`()
BEGIN
SELECT  id_id ,
     anio ,
     banc ,
     beneficiario ,
     bloq ,
     bloqlimcred ,
     calle ,
     cel ,
     ciu ,
     clasjera ,
     clavbanc ,
     co1 ,
     co2 ,
     co3 ,
     codclas ,
     codemp ,
     codigo ,
     col ,
     CP ,
     cta ,
     ctaconta ,
     ctapred ,
     curp ,
     deposit ,
     descu ,
     diacred ,
     diapag ,
     encall ,
     encel ,
     enciu ,
     enco1 ,
     enco2 ,
     enco3 ,
     encol ,
     encp ,
     enemail ,
     enestad ,
     enlada ,
     ennoext ,
     ennoexten ,
     ennoint ,
     enpagweb ,
     enpai ,
     entel1 ,
     entel2 ,
     entel3 ,
     estac ,
     estad ,
     export ,
     exten ,
     extr1 ,
     extr2 ,
     extr3 ,
     falt ,
     fmod 
     idempresa ,
     lada ,
     limtcred ,
     list ,
     metpag ,
     nocaj ,
     noext ,
     noint ,
     nom ,
     observ ,
     otramon ,
     otramonc ,
     pags ,
     pagweb1 ,
     pagweb2 ,
     pai ,
     pers ,
     revis ,
     RFC ,
     ser ,
     sucu ,
     tel ,
     telper1 ,
     telper2 ,
     usocfdi ,
     vend 
FROM  campanita . emps 
ORDER BY id_id DESC;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaComprasBusqueda`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaComprasBusqueda`(
in par_id_empresa varchar(30), 
in par_limit int, in par_offset int, 
in b_estac bit, in par_estac varchar(30),
in b_tipo bit, in par_tipo varchar(30), 
in par_busqueda varchar(255))
BEGIN
SELECT provs.NOM, comprs.archpdf,comprs.archxml,comprs.codcomp,codord,concep,comprs.contra,comprs.cta,comprs.estac,comprs.estado,comprs.export,comprs.extr1,comprs.extr2, comprs.extr3, comprs.falt,comprs.fdoc,comprs.fent,comprs.fmod,comprs.fvenc,comprs.id_id,comprs.idempresa,comprs.impue,comprs.metpag,comprs.monedaID,comprs.motiv,comprs.nocaj,comprs.nodoc,comprs.nomprov,comprs.noser,comprs.notcred,comprs.notcredpag,comprs.observ,comprs.prov,comprs.recib,comprs.ruta,comprs.ser,comprs.subtot,comprs.sucu,comprs.tip,comprs.tipcam,comprs.tot,comprs.total_retencion,comprs.total_traslado FROM comprs  LEFT OUTER JOIN provs ON CONCAT(provs.SER,provs.PROV) = comprs.PROV and comprs.idempresa = provs.idempresa 
WHERE 
comprs.idempresa = par_id_empresa 
AND (comprs.CODCOMP LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.NODOC LIKE CONCAT('%', par_busqueda, '%') 
OR provs.NOM LIKE CONCAT('%', par_busqueda, '%')  
OR comprs.TOT LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.FALT LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.FDOC LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.FMOD LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.ESTADO LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.ESTAC LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.MOTIV LIKE CONCAT('%', par_busqueda, '%'))
AND ((b_estac = true AND comprs.ESTAC = par_estac) OR b_estac = false) 
AND ((b_tipo  = true AND comprs.tip = par_tipo) OR b_tipo  = false) 
ORDER BY id_id DESC LIMIT par_limit OFFSET par_offset;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaComprasEncabezado`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaComprasEncabezado`(in par_id_empresa nvarchar(30),
in par_limit int, in par_offset int,
in b_estac bit, in par_estac varchar(30),
in b_tipo bit, in par_tipo varchar(30)
)
BEGIN
SELECT provs.NOM, comprs.archpdf,comprs.archxml,comprs.codcomp,codord,concep,comprs.contra,comprs.cta,comprs.estac,comprs.estado,comprs.export,comprs.extr1,comprs.extr2, comprs.extr3, comprs.falt,comprs.fdoc,comprs.fent,comprs.fmod,comprs.fvenc,comprs.id_id,comprs.idempresa,comprs.impue,comprs.metpag,comprs.monedaID,comprs.motiv,comprs.nocaj,comprs.nodoc,comprs.nomprov,comprs.noser,comprs.notcred,comprs.notcredpag,comprs.observ,comprs.prov,comprs.recib,comprs.ruta,comprs.ser,comprs.subtot,comprs.sucu,comprs.tip,comprs.tipcam,comprs.tot,comprs.total_retencion,comprs.total_traslado FROM comprs  LEFT OUTER JOIN provs ON CONCAT(provs.SER,provs.PROV) = comprs.PROV and comprs.idempresa = provs.idempresa 
WHERE comprs.idempresa = par_id_empresa
AND ((b_estac = true AND comprs.ESTAC = par_estac) OR b_estac = false) 
AND ((b_tipo  = true AND comprs.tip = par_tipo) OR b_tipo  = false) 
ORDER BY id_id DESC LIMIT par_limit OFFSET par_offset;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_ListaConfiguraciones`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaConfiguraciones`(in par_id_empresa varchar(30))
BEGIN
   SELECT id_id,clasif,conf,val,nume,falt,fmod,idempresa,estac,dia,envia,extr,asun,anio,sucu,nocaj,export,extr1,extr2,extr3 
   FROM confgral
   WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaConfiguracionesActivo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaConfiguracionesActivo`(in par_id_empresa varchar(30))
BEGIN
   SELECT id_id,clasif,conf,val,nume,falt,fmod,idempresa,estac,dia,envia,extr,asun,anio,sucu,nocaj,export,extr1,extr2,extr3 FROM confgral
   WHERE idempresa=par_id_empresa and val = 1;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaCorreos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaCorreos`(in par_id_empresa varchar(30))
BEGIN
SELECT 
corrselec.id_id, 
corrselec.srvsmtpsal, 
corrselec.asunfac,  
corrselec.asuncot, 
corrselec.asuncontra,  
corrselec.asunord, 
corrselec.asunrec1, 
corrselec.asunrec2,
corrselec.asunrec3,
corrselec.cuerpfac,
corrselec.cuerpcot,
corrselec.cuerpcontra,
corrselec.cuerpord, 
corrselec.cuerprec1, 
corrselec.cuerprec2, 
corrselec.cuerprec3, 
corrselec.portsmtp, 
corrselec.actslenlog, 
corrselec.usr,  
corrselec.pass,  
corrselec.corralter,  
corrselec.idempresa,  
corrselec.estac,  
corrselec.estacglo,  
corrselec.sucu,
corrselec.nocaj, 
corrselec.extr1, 
corrselec.extr2, 
corrselec.extr3, 
corrselec.export, 
corrselec.falt, 
corrselec.fmod, 
estacs.NOM nombreestac
FROM corrselec 
LEFT OUTER JOIN estacs ON estacs.ESTAC = corrselec.ESTAC AND estacs.IDEMPRESA = corrselec.idempresa
WHERE corrselec.idempresa = par_id_empresa;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_ListaCuentasPorPagar`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaCuentasPorPagar`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    norefer,
    noser,
    prov,
    ser,
    formpag,
    conceppag,
    monedaID,
    tipcam,
    comen,
    subtot,
    tot,
    impue,
    carg,
    abon,
    concep,
    folbanc,
    fvenc,
    fdoc,
    falt,
    fmod,
    fol,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    cuentabanco,
    estado,
    extr1,
    extr2,
    extr3
FROM cxp
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaEstaciones`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaEstaciones`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    idempresa,
    estac,
    correo,
    52m,
    ptovta,
    descu,
    comi,
    habdesc,
    imptic,
    impfac,
    cort,
    pass,
    estacglo,
    calle,
    nom,
    col,
    cp,
    tel,
    cel,
    pai,
    ciu,
    esta,
    noint,
    res1path,
    res2path,
    res3path,
    rutmysq,
    noext,
    sucu,
    nocaj,
    export,
    admcaj,
    vend,
    mandagra,
    manddia,
    mandcump,
    extr1,
    extr2,
    extr3,
    falt,
    fmod,
    almacen
FROM estacs
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaEstacionesBusqueda`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaEstacionesBusqueda`(in par_id_empresa varchar(30), in par_busqueda varchar(1000))
BEGIN
SELECT id_id,
    idempresa,
    estac,
    52m,
    ptovta,
    descu,
    comi,
    habdesc,
    imptic,
    impfac,
    cort,
    pass,
    estacglo,
    calle,
    nom,
    col,
    cp,
    tel,
    cel,
    pai,
    ciu,
    esta,
    noint,
    res1path,
    res2path,
    res3path,
    rutmysq,
    noext,
    sucu,
    nocaj,
    export,
    admcaj,
    vend,
    mandagra,
    manddia,
    mandcump,
    extr1,
    extr2,
    extr3,
    falt,
    fmod,
    almacen
FROM estacs
WHERE idempresa = par_id_empresa AND 
(estac LIKE concat('%', par_busqueda, '%') OR 
pass LIKE concat('%', par_busqueda, '%') OR 
falt LIKE concat('%', par_busqueda, '%') OR 
fmod LIKE concat('%', par_busqueda, '%'));
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaEstacParaPermisos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaEstacParaPermisos`(in par_estac varchar(30), par_id_empresa varchar(30))
BEGIN
SELECT estac FROM estacs 
WHERE idempresa = par_id_empresa
AND estac <> par_estac
AND admcaj <= 
(SELECT admcaj FROM estacs WHERE estac = par_estac AND idempresa = par_id_empresa);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaGiros`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaGiros`(in par_id_empresa nvarchar(30))
BEGIN
SELECT id_id,
    gir,
    descrip,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM giro
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaImpuestos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaImpuestos`(in par_id_empresa varchar(30))
BEGIN
   SELECT 
   id_id,
   codimpue, 
   impueval, 
   impuestoXML 
   FROM impues 
   WHERE codimpue <> '-' AND 
   idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaIngresos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaIngresos`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    idIngresCab,
    prod,
    alma,
    unid,
    concep,
    cant,
    idempresa,
    estac,
    sucu,
    entsal,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    activo,
    falt,
    costo,
    cantsal,
    tipcamnac
FROM ingres
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaIngresosEncabezado`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaIngresosEncabezado`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    alma,
    concep,
    canttotal,
    idempresa,
    estac,
    sucu,
    entsal,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    noser,
    norefer
FROM ingresos_encab
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaPermisosUsuario`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaPermisosUsuario`(in par_id_usuario int, in par_id_empresa varchar(30))
BEGIN
SELECT PKId,
    FKIdUsuario,
    permisoConf,
    permisoCorreos,
    permisoDatosEmpresa,
    permisoSeries,
    permisoImpresoras,
    permisoCambiarIcono,
    permisoConfiguracionesGenerales,
    otorgaPermisosConfig,
    permisoUsuarios,
    permisoUsuariosDefinir,
    permisoUsuariosConectados,
    permisoUsuariosPermisos,
    permisoClaves,
    permisoReparar,
    permisoRepararErrores,
    permisoRepararRestaurar,
    permisoBaseDatos,
    permisoBaseDatosConexiones,
    permisoBaseDatosArchivo,
    permisoReportes,
    permisoReportesUsuarios,
    permisoReportesRespaldos,
    permisoReportesLog,
    permisoReportesEstadistica,
    permisoRevocacion,
    permisoActivarSistema,
    otorgaPermisosSistema,
    permisoContabilidad,
    permisoConceptosNC,
    permisoCatalogoGarantias,
    permisoZonas,
    permisoGiros,
    permisoMonedas,
    permisoImpuestos,
    otorgaPermisosModulos,
    permisoCompras,
    permisoComprasCancelar,
    permisoComprasDevolucion,
    permisoComprasParcial,
    permisoComprasNuevo,
    permisoComprasNotCredito,
    permisoComprasVer,
    permisoComprasCargarArchivo,
    permisoComprasBorrarArchivo,
    permisoComprasRecibirOrden,
    otorgaPermisosCompras,
    permisoProvee,
    permisoProveeNuevo,
    permisoProveeModificar,
    permisoProveeVer,
    permisoProveeBorrar,
    otorgaPermisosProvee,
    permisoPrevio,
    permisoPrevioNueva,
    permisoPrevioAbrir,
    permisoPrevioVer,
    permisoPrevioCancelar,
    permisoPrevioSeries,
    permisoPrevioCompra,
    otorgaPermisosPrevio,
    permisoInventario,
    permisoProductos,
    permisoProductosNuevo,
    permisoProductosModificar,
    permisProductosBorrar,
    otorgaPermisosInventario,
    permisoClientes,
    permisoClientesNuevo,
    permisoClientesModificar,
    permisoClientesVer,
    permisoClientesBorrar,
    permisoClientesEnviar,
    otorgaPermisosClientes,
    permisoVentas,
    permisoVentasCancelar,
    permisoVentasDevolucion,
    permisoVentasParcial,
    permisoVentasNueva,
    permisoVentasNotCredito,
    permisoVentasVer,
    permisoVentasEnviar,
    permisoVentasTimbrar,
    permisoVentasEntregar,
    permisoVentasComprobar,
    permisoVentasAcuse,
    permisoVentasObtenerXml,
    permisoVentasFacturar,
    permisoVentasCargarArchivo,
    permisoVentasBorrarArchivo,
    otorgaPermisosVentas,
    permisoCotiza,
    permisoCotizaNueva,
    permisoCotizaAbrir,
    permisoCotizaVer,
    permisoCotizaCancelar,
    permisoCotizaReenviar,
    permisoCotizaVenta,
    otorgaPermisosCotiza,
    idempresa,
    permisoCxc,
    permisoPagoNuevo,
    permisoCancelarPago,
    otorgaPermisoCxc,
    permisProductosListaPrecio,
    permisProductosCargadoImagen
FROM er_permisos
WHERE FKIdUsuario = par_id_usuario AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaProductos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaProductos`()
BEGIN
SELECT id_id,
    alma,
    anaq,
    bajcost,
    clavesat
    codubi,
    comenser,
    compue,
    cost,
    costre,
    descrip, 
    descripcort,
    estac,
    estaccrea,
    esvta,
    exist,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fcadu,
    fmod,
    idempresa,
    impue,
    infor,
    invent,
    lote,
    lotped,
    lug,
    max,
    metcost,
    min,
    nocaj,
    noser, 
    pedimen,
    pesman,
    prelist1,
    prelist10,
    prelist2,
    prelist3,
    prelist4,
    prelist5,
    prelist6,
    prelist7,
    prelist8,
    prelist9,
    prod,
    rutimg,
    servi,
    solmaxmin, 
    solser,
    sucu,
    unid,
    utilvta1,
    utilvta10,
    utilvta2,
    utilvta3,
    utilvta4,
    utilvta5,
    utilvta6,
    utilvta7,
    utilvta8,
    utilvta9
FROM prods
ORDER BY id_id DESC;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaProveedores`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaProveedores`()
BEGIN
SELECT id_id,
    prov,
    ser,
    codclas,
    zon,
    giro,
    tentre,
    rubr,
    banc,
    clavbanc,
    lada,
    metpag,
    cta,
    enlada,
    nom,
    tel,
    entel,
    cel,
    encel,
    clasjera,
    exten,
    enexten,
    calle,
    encalle,
    col,
    encol,
    cp,
    encp,
    ennoint,
    noint,
    noext,
    ennoext,
    ciu,
    enciu,
    estad,
    enestad,
    otramon,
    otramonc,
    bloq,
    ctaconta,
    revis,
    pags,
    pais,
    enpais,
    rfc,
    descu,
    diacred,
    limcred,
    bloqlimcred,
    co1,
    enco1,
    co2,
    enco2,
    co3,
    enco3,
    pagweb1,
    pagweb2,
    eje1,
    telper1,
    entelper1,
    telper2,
    entelper2,
    eje2,
    telper21,
    telper22,
    observ,
    pers,
    contac3,
    telcon3,
    telper3,
    telper33,
    contac4,
    telcon4,
    telper4,
    telper44,
    contac5,
    telcon5,
    telper5,
    telper55,
    contac6,
    telcon6,
    telper6,
    telper66,
    contac7,
    telcon7,
    telper7,
    telper77,
    contac8,
    telcon8,
    telper8,
    telper88,
    contac9,
    telcon9,
    telper9,
    telper99,
    contac10,
    telcon10,
    telper10,
    telper100,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod,
    beneficiario
FROM provs;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaRubros`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaRubros`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    cod,
    descrip,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM rubr 
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_ListaSeriePorTipoDoc`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaSeriePorTipoDoc`(in par_tip varchar(10), in par_id_empresa varchar(30))
BEGIN
   SELECT ser FROM consecs WHERE tip = par_tip AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaTraspaso`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaTraspaso`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    prod,
    alma,
    concep,
    unid,
    cantsal,
    almaa,
    cantent,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    UsuarioResponsableTras,
    lotePedimento,
    costo,
    estado,
    reporteSalida,
    reporteEntrada
FROM traspas;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ListaZona`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ListaZona`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    cod,
    descrip,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM zona
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_LotePedimento`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_LotePedimento`(in par_lot varchar(255), in par_pediment varchar(255), in par_id_empresa varchar(30))
BEGIN
   SELECT id_id,
    prod,
    alma,
    lot,
    pedimen,
    fcadu,
    exist,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    aduana,
    falt,
    fmod
   FROM lotped WHERE lot = par_lot AND pedimen = par_pediment AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_Moneda`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_Moneda`(in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    mon,
    val,
    mondescrip,
    simb,
    c_moneda,
    idempresa,
    estac,
    sucu,
    nocaj,
    mn,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM mons where idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_MonedaPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_MonedaPorCodigo`(in par_id_empresa varchar(30), 
in par_mon varchar(30))
BEGIN
SELECT id_id,
    mon,
    val,
    mondescrip,
    simb,
    c_moneda,
    idempresa,
    estac,
    sucu,
    nocaj,
    mn,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM mons where idempresa = par_id_empresa and mon = par_mon;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_MuestraVenta`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_MuestraVenta`(IN par_venta INT, IN par_idempresa varchar(30))
BEGIN

SELECT 
pags.DESCRIP AS metodoPago, 
mons.mon, 
emps.ser, 
vtas.impue, 
vtas.metpag, 
vtas.cta, 
vtas.monedaid, 
vtas.tot, 
vtas.subtot, 
vtas.observ, 
emps.metpag, 
emps.cta, 
vtas.noser, 
vtas.tipdoc, 
CASE WHEN emps.DIACRED = '' THEN '0' ELSE emps.DIACRED END AS diacred,
emps.limtcred, 
emps.co1, 
emps.co2,
emps.co3, 
emps.estad, 
emps.ciu, 
emps.rfc, 
emps.list, 
emps.noext, 
emps.noint, 
emps.cp, 
emps.pai, 
emps.tel, 
emps.col, 
emps.calle, 
emps.nom, 
vtas.ser vtaser, 
vtas.codemp
FROM vtas LEFT OUTER JOIN pags ON pags.COD = vtas.METPAG 
LEFT OUTER JOIN mons ON mons.id_id = vtas.monedaID 
LEFT OUTER JOIN emps ON emps.codigo = vtas.CODEMP 
WHERE vtas.VTA = par_venta AND vtas.idempresa = par_idempresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_OtorgaPermisos`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_OtorgaPermisos`(in par_id int, in par_id_empresa varchar(30))
BEGIN
SELECT 
otorgaPermisosConfig, 
otorgaPermisosSistema, 
otorgaPermisosModulos, 
otorgaPermisosCompras, 
otorgaPermisosProvee, 
otorgaPermisosPrevio, 
otorgaPermisosInventario, 
otorgaPermisosClientes, 
otorgaPermisosVentas, 
otorgaPermisosCotiza 
FROM er_permisos 
WHERE FKIdUsuario = par_id and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_PartidaCompraPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_PartidaCompraPorCodigo`(in par_id_empresa varchar(30),in par_codcom varchar(30))
BEGIN
SELECT 
id_id,
codcom,
alma,
prod,
cant,
cantlotpend,
impue,
devs,
unid,
descrip,
cost,
costpro,
serprod,
tall,
colo,
garan,
comenser,
peps,
ueps,
descu,
descad,
recib,
codimpue,
mon,
lot,
pedimen,
aplic,
idkit,
kitmae,
eskit,
impo,
tipcam,
flotvenc,
idempresa,
export,
extr1,
extr2,
extr3,
falt,
fmod,
cuentacontable,
activo,
lotePedimento
FROM partcomprs
WHERE idempresa = par_id_empresa and codcom = par_codcom;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_PartidaPorImpuesto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_PartidaPorImpuesto`(in par_codimpue varchar(30), in par_id_empresa varchar(30))
BEGIN
SELECT 
COUNT(*) as total FROM partvta 
WHERE codimpue = par_codimpue AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_PedidoPorVenta`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_PedidoPorVenta`(in par_vta int, in par_id_empresa varchar(30))
BEGIN
SELECT id_id,
    codcot,
    motiv,
    ser,
    totdescu,
    totcost,
    vta,
    norefer,
    tipcam,
    tipcamnac,
    monedaID,
    noservta,
    codemp,
    referencia,
    observ,
    total_traslado,
    total_retencion,
    subtot,
    impue,
    tot,
    descrip,
    estad,
    fdoc,
    fentre,
    fvenc,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod,
    noser
FROM pedidos
WHERE vta = par_vta and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_PendientePago`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_PendientePago`(in par_id_empresa varchar(30), in par_prov varchar(30))
BEGIN
SELECT 
IFNULL((SUM(carg) - SUM(abon)),0) AS pendpag FROM cxp 
WHERE prov = par_prov AND concep <> 'NOT' 
AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ProductoPorDescripcion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ProductoPorDescripcion`(
	IN `par_descripcion` VARCHAR(2100)
)
BEGIN
SELECT id_id,
    alma,
    anaq,
    bajcost,
    clavesat
    codubi,
    comenser,
    compue,
    cost,
    costre,
    descrip, 
    descripcort,
    estac,
    estaccrea,
    esvta,
    exist,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fcadu,
    fmod,
    idempresa,
    impue,
    infor,
    invent,
    lote,
    lotped,
    lug,
    max,
    metcost,
    min,
    nocaj,
    noser, 
    pedimen,
    pesman,
    prelist1,
    prelist10,
    prelist2,
    prelist3,
    prelist4,
    prelist5,
    prelist6,
    prelist7,
    prelist8,
    prelist9,
    prod,
    rutimg,
    servi,
    solmaxmin, 
    solser,
    sucu,
    unid,
    utilvta1,
    utilvta10,
    utilvta2,
    utilvta3,
    utilvta4,
    utilvta5,
    utilvta6,
    utilvta7,
    utilvta8,
    utilvta9
FROM prods
WHERE descrip LIKE CONCAT('%',par_descripcion,'%');

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ProductoPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ProductoPorId`(
	IN `par_idProducto` INT
)
BEGIN
SELECT alma,
    anaq,
    bajcost,
    clavesat
    codubi,
    comenser,
    compue,
    cost,
    costre,
    descrip, 
    descripcort,
    estac,
    estaccrea,
    esvta,
    exist,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fcadu,
    fmod,
    idempresa,
    impue,
    infor,
    invent,
    lote,
    lotped,
    lug,
    max,
    metcost,
    min,
    nocaj,
    noser, 
    pedimen,
    pesman,
    prelist1,
    prelist10,
    prelist2,
    prelist3,
    prelist4,
    prelist5,
    prelist6,
    prelist7,
    prelist8,
    prelist9,
    prod,
    rutimg,
    servi,
    solmaxmin, 
    solser,
    sucu,
    unid,
    utilvta1,
    utilvta10,
    utilvta2,
    utilvta3,
    utilvta4,
    utilvta5,
    utilvta6,
    utilvta7,
    utilvta8,
    utilvta9
FROM prods WHERE id_id = par_id_producto;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ProductoPorIdEmpresa`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ProductoPorIdEmpresa`(
	IN `par_id_empresa` VARCHAR(30)
)
BEGIN
  SELECT prod,descrip, alma
  FROM prods
  WHERE (idempresa = par_id_empresa AND par_id_empresa != '0')
        OR ('0' = par_id_empresa)
  ORDER BY prod;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ProductoPorLinea`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ProductoPorLinea`(IN par_lin varchar(30), IN par_id_empresa varchar(30))
BEGIN
SELECT    id_id  ,
          prod  ,
          prodop1  ,
          prodop2  ,
          provop1  ,
          provop2  ,
          codmed  ,
          garan  ,
          clasjera  ,
          descrip  ,
          descripcort  ,
          lin  ,
          metcost  ,
          tip  ,
          solmaxmin  ,
          marc  ,
          codubi  ,
          mode  ,
          fab  ,
          colo  ,
          solser  ,
          codext  ,
          noser  ,
          comenser  ,
          rutimg  ,
          impue  ,
          pes  ,
          pesman  ,
          prelist1  ,
          prelist2  ,
          prelist3  ,
          prelist4  ,
          prelist5  ,
          prelist6  ,
          prelist7  ,
          prelist8  ,
          prelist9  ,
          prelist10  ,
          utilvta1  ,
          utilvta2  ,
          utilvta3  ,
          utilvta4  ,
          utilvta5  ,
          utilvta6  ,
          utilvta7  ,
          utilvta8  ,
          utilvta9  ,
          utilvta10  ,
          med  ,
          cost  ,
          costre  ,
          exist  ,
          unid  ,
          anaq  ,
          lug  ,
          alma  ,
          descprov  ,
          infor  ,
          min  ,
          max  ,
          bajcost  ,
          esvta  ,
          compue  ,
          invent  ,
          idempresa  ,
          estac  ,
          estaccrea  ,
          sucu  ,
          nocaj  ,
          lote  ,
          pedimen  ,
          servi  ,
          lotped  ,
          export  ,
          extr1  ,
          extr2  ,
          extr3  ,
          fcadu  ,
          falt  ,
          fmod  ,
          clavesat  ,
          id_garan  ,
          id_lin  ,
          id_tip  ,
          id_marc  ,
          id_mode  ,
          id_fab  ,
          id_colo  ,
          id_pes  ,
          id_unid  ,
          id_lug  ,
          id_alma  
FROM prods
where lin = par_lin and idempresa = par_id_empresa;  
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ProductoPorProd`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ProductoPorProd`(
	IN par_id_empresa varchar(30),
    IN par_prod varchar(30)
)
BEGIN
SELECT alma,
    anaq,
    bajcost,
    clavesat
    codubi,
    comenser,
    compue,
    cost,
    costre,
    descrip, 
    descripcort,
    estac,
    estaccrea,
    esvta,
    exist,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fcadu,
    fmod,
    idempresa,
    impue,
    infor,
    invent,
    lote,
    lotped,
    lug,
    max,
    metcost,
    min,
    nocaj,
    noser, 
    pedimen,
    pesman,
    prelist1,
    prelist10,
    prelist2,
    prelist3,
    prelist4,
    prelist5,
    prelist6,
    prelist7,
    prelist8,
    prelist9,
    prod,
    rutimg,
    servi,
    solmaxmin, 
    solser,
    sucu,
    unid,
    utilvta1,
    utilvta10,
    utilvta2,
    utilvta3,
    utilvta4,
    utilvta5,
    utilvta6,
    utilvta7,
    utilvta8,
    utilvta9
FROM prods WHERE prod = par_prod and idempresa=par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ProveedorPorProv`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ProveedorPorProv`(
in par_id_empresa varchar(30), 
in par_proveedor varchar(60))
BEGIN
SELECT provs.id_id,
    provs.prov,
    provs.ser,
    provs.codclas,
    provs.zon,
    provs.giro,
    provs.tentre,
    provs.rubr,
    provs.banc,
    provs.clavbanc,
    provs.lada,
    provs.metpag,
    provs.cta,
    provs.enlada,
    provs.nom,
    provs.tel,
    provs.entel,
    provs.cel,
    provs.encel,
    provs.clasjera,
    provs.exten,
    provs.enexten,
    provs.calle,
    provs.encalle,
    provs.col,
    provs.encol,
    provs.cp,
    provs.encp,
    provs.ennoint,
    provs.noint,
    provs.noext,
    provs.ennoext,
    provs.ciu,
    provs.enciu,
    provs.estad,
    provs.enestad,
    provs.otramon,
    provs.otramonc,
    provs.bloq,
    provs.ctaconta,
    provs.revis,
    provs.pags,
    provs.pais,
    provs.enpais,
    provs.rfc,
    provs.descu,
    provs.diacred,
    provs.limcred,
    provs.bloqlimcred,
    provs.co1,
    provs.enco1,
    provs.co2,
    provs.enco2,
    provs.co3,
    provs.enco3,
    provs.pagweb1,
    provs.pagweb2,
    provs.eje1,
    provs.telper1,
    provs.entelper1,
    provs.telper2,
    provs.entelper2,
    provs.eje2,
    provs.telper21,
    provs.telper22,
    provs.observ,
    provs.pers,
    provs.contac3,
    provs.telcon3,
    provs.telper3,
    provs.telper33,
    provs.contac4,
    provs.telcon4,
    provs.telper4,
    provs.telper44,
    provs.contac5,
    provs.telcon5,
    provs.telper5,
    provs.telper55,
    provs.contac6,
    provs.telcon6,
    provs.telper6,
    provs.telper66,
    provs.contac7,
    provs.telcon7,
    provs.telper7,
    provs.telper77,
    provs.contac8,
    provs.telcon8,
    provs.telper8,
    provs.telper88,
    provs.contac9,
    provs.telcon9,
    provs.telper9,
    provs.telper99,
    provs.contac10,
    provs.telcon10,
    provs.telper10,
    provs.telper100,
    provs.idempresa,
    provs.estac,
    provs.sucu,
    provs.nocaj,
    provs.export,
    provs.extr1,
    provs.extr2,
    provs.extr3,
    provs.falt,
    provs.fmod,
    provs.beneficiario,
    clasprov.descrip
FROM provs
LEFT OUTER JOIN clasprov ON clasprov.COD = provs.CODCLAS
WHERE CONCAT_WS('', provs.ser, provs.prov) = par_proveedor AND provs.idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_SATClaveUnidad`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_RubroPorCodigo`(in par_id_empresa varchar(30), in par_cod varchar(30))
BEGIN
SELECT id_id,
    cod,
    descrip,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM rubr 
WHERE idempresa = par_id_empresa and cod = par_cod;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_SATClaveUnidad`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_SATClaveUnidad`(IN par_codigo VARCHAR(30), IN par_id_empresa VARCHAR(30))
BEGIN
   select clavesat from unids 
   where cod = par_codigo and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_TotalComprasProveedor`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_TotalComprasProveedor`(in par_prov varchar(30), in par_id_empresa varchar(30))
BEGIN
   SELECT COUNT(prov) as total FROM comprs WHERE prov = par_prov AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_TotalListaCompraEncabezado`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_TotalListaCompraEncabezado`(
in par_id_empresa nvarchar(30),
in b_estac bit, in par_estac varchar(30),
in b_tipo bit, in par_tipo varchar(30))
BEGIN
SELECT COUNT(*) total
FROM comprs  LEFT OUTER JOIN provs ON CONCAT(provs.SER,provs.PROV) = comprs.PROV and comprs.idempresa = provs.idempresa 
WHERE comprs.idempresa = par_id_empresa
AND ((b_estac = true AND comprs.ESTAC = par_estac) OR b_estac = false) 
AND ((b_tipo  = true AND comprs.tip = par_tipo) OR b_tipo  = false) ;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_TotalListaComprasBusqueda`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_TotalListaComprasBusqueda`(
in par_id_empresa varchar(30), 
in b_estac bit, in par_estac varchar(30),
in b_tipo bit, in par_tipo varchar(30), 
in par_busqueda varchar(255))
BEGIN
SELECT COUNT(*) total
FROM comprs LEFT OUTER JOIN provs ON CONCAT(provs.SER,provs.PROV) = comprs.PROV and comprs.idempresa = provs.idempresa 
WHERE 
comprs.idempresa = par_id_empresa 
AND (comprs.CODCOMP LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.NODOC LIKE CONCAT('%', par_busqueda, '%') 
OR provs.NOM LIKE CONCAT('%', par_busqueda, '%')  
OR comprs.TOT LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.FALT LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.FDOC LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.FMOD LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.ESTADO LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.ESTAC LIKE CONCAT('%', par_busqueda, '%') 
OR comprs.MOTIV LIKE CONCAT('%', par_busqueda, '%'))
AND ((b_estac = true AND comprs.ESTAC = par_estac) OR b_estac = false) 
AND ((b_tipo  = true AND comprs.tip = par_tipo) OR b_tipo  = false); 
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_TraspasoPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_TraspasoPorId`(in par_id_empresa varchar(30), in par_id_id int)
BEGIN
SELECT id_id,
    prod,
    alma,
    concep,
    unid,
    cantsal,
    almaa,
    cantent,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    UsuarioResponsableTras,
    lotePedimento,
    costo,
    estado,
    reporteSalida,
    reporteEntrada
FROM traspas
WHERE idempresa = par_id_empresa AND id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_TraspasosPorParametro`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_TraspasosPorParametro`(
in b_prod boolean,
in b_alma boolean,
in b_estado boolean,
in par_prod varchar(255),
in par_alma varchar(255),
in par_estado varchar(35),
in par_id_empresa varchar(30)
)
BEGIN
SELECT id_id,
    prod,
    alma,
    concep,
    unid,
    cantsal,
    almaa,
    cantent,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    UsuarioResponsableTras,
    lotePedimento,
    costo,
    estado,
    reporteSalida,
    reporteEntrada
FROM traspas
WHERE idempresa = par_id_empresa 
AND 
((b_prod = true AND prod = par_prod) OR (b_prod = false))
AND 
((b_alma = true AND alma = par_alma) OR (b_alma = false))
AND 
((b_estado = true AND estado = par_estado) OR (b_estado = false));
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_UsuariosConectados`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_UsuariosConectados`(in par_estac varchar(30), in par_id_empresa varchar(30))
BEGIN
SELECT 
logestac.ESTAC, 
logestac.SUCU, 
logestac.NOCAJ, 
estacs.NOM 
FROM logestac 
LEFT OUTER JOIN estacs 
ON logestac.ESTAC = estacs.ESTAC
WHERE logestac.ESTAC <> par_estac
AND logestac.idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ValidaCatalogo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ValidaCatalogo`(in par_nombre_tabla varchar(255), in par_valor varchar(30))
BEGIN
   IF par_nombre_tabla = 'almas' THEN 
   SELECT COUNT(*) as total FROM almas WHERE alma = par_valor;
   ELSEIF par_nombre_tabla = 'anaqs' THEN
   SELECT COUNT(*) as total FROM almas WHERE alma = par_valor;
   ELSE 
   SELECT -1;
   END IF;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS  `SEL_ValidaDocumentoCompra`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ValidaDocumentoCompra`(in par_id_empresa varchar(30), in par_prov varchar(30), in par_nodoc varchar(50))
BEGIN
SELECT COUNT(nodoc) total FROM comprs 
WHERE prov = par_prov 
AND nodoc = par_nodoc
AND idempresa = par_id_empresa;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS  `SEL_ValidaRFCProveedor`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ValidaRFCProveedor`(in par_id_empresa varchar(30), in par_rfc varchar(21), in par_nom varchar(255))
BEGIN
   SELECT COUNT(*) total FROM provs where idempresa = par_id_empresa AND rfc = par_rfc AND nom = par_nom;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `SEL_VentaPorVentaRef`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_VentaPorVentaRef`(in par_vtaref int, in par_id_empresa varchar(30))
BEGIN
SELECT vta,
    norefer,
    noser,
    monedaID,
    vend,
    codcot,
    folfisc,
    transid,
    sell,
    sellsat,
    certsat,
    lugexp,
    regfisc,
    cadori,
    cort,
    referencia,
    formpag,
    nocort,
    venta_origen,
    cierr,
    vtadevp,
    ptovta,
    catgral,
    factu,
    tipcam,
    tipcamnac,
    total_traslado,
    total_retencion,
    tipdoc,
    notcred,
    notcredpag,
    impnotcred,
    totdescu,
    totcost,
    totcostprom,
    totueps,
    totpeps,
    codemp,
    ser,
    metpag,
    cta,
    femi,
    fent,
    subtot,
    impue,
    tot,
    tic,
    estad,
    motiv,
    observ,
    timbr,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    fvenc,
    falt,
    fmod,
    vtaRef,
    usocfdi,
    tiporelacion,
    activo,
    subramo,
    sector,
    id_tipodoc,
    id_emp
FROM vtas 
WHERE vtaRef = par_vtaref and idempresa = par_id_empresa;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SEL_ZonaPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SEL_ZonaPorCodigo`(in par_id_empresa varchar(30), in par_cod varchar(30))
BEGIN
SELECT id_id,
    cod,
    descrip,
    idempresa,
    estac,
    sucu,
    nocaj,
    export,
    extr1,
    extr2,
    extr3,
    falt,
    fmod
FROM zona
WHERE idempresa = par_id_empresa
AND cod = par_cod;
END//
DELIMITER ;


CREATE TABLE IF NOT EXISTS `serieprod` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `ser` varchar(255) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `exist` float NOT NULL,
  `comen` varchar(500) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `ser` (`ser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP PROCEDURE IF EXISTS `SP_ActualizaVentaTimbrado`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ActualizaVentaTimbrado`(
IN par_transid varchar(100),
IN par_sell varchar(1000),
IN par_certsat varchar(1000),
IN par_lugexp varchar(100),
IN par_regfisc varchar(255),
IN par_sellsat varchar(1000),
IN par_cadori varchar(2000),
IN par_folfisc varchar(100),
IN par_id_empresa varchar(30), 
IN par_vta INT
)
BEGIN
UPDATE vtas SET 
timbr   = 1,
transid = par_transid,
sell    = par_sell,
certsat = par_certsat,
lugexp  = par_lugexp,
regfisc = par_regfisc,
sellsat = par_sellsat,
cadori  = par_cadori,
folfisc = par_folfisc                   
WHERE vta = par_vta AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `sp_encabezadoclientes`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_encabezadoclientes`(
	IN `par_id_empresa` VARCHAR(30),
	IN `par_busqueda` VARCHAR(255)

)
BEGIN
select codemp,ser,nom from vw_encabezadoclientes
WHERE idempresa = par_id_empresa
AND (
CONCAT_WS('', ser, codemp) LIKE CONCAT('%',par_busqueda,'%') 
OR nom LIKE CONCAT('%',par_busqueda,'%') 
OR ser LIKE CONCAT('%',par_busqueda,'%') 
OR tel LIKE CONCAT('%',par_busqueda,'%') 
OR telper1 LIKE CONCAT('%',par_busqueda,'%') 
OR telper2 LIKE CONCAT('%',par_busqueda,'%') 
OR calle LIKE CONCAT('%',par_busqueda,'%') 
OR col LIKE CONCAT('%',par_busqueda,'%') 
OR cp LIKE CONCAT('%',par_busqueda,'%') 
OR ciu LIKE CONCAT('%',par_busqueda,'%') 
OR estad LIKE CONCAT('%',par_busqueda,'%') 
OR rfc LIKE CONCAT('%',par_busqueda,'%') 
OR descu LIKE CONCAT('%',par_busqueda,'%') 
OR co1 LIKE CONCAT('%',par_busqueda,'%') 
OR co2 LIKE CONCAT('%',par_busqueda,'%') 
OR co3 LIKE CONCAT('%',par_busqueda,'%') 
OR pagweb1 LIKE CONCAT('%',par_busqueda,'%') 
OR pagweb2 LIKE CONCAT('%',par_busqueda,'%') 
OR contact2 LIKE CONCAT('%',par_busqueda,'%') 
OR puest2 LIKE CONCAT('%',par_busqueda,'%') 
OR observ LIKE CONCAT('%',par_busqueda,'%') 
OR noint LIKE CONCAT('%',par_busqueda,'%') 
OR noext LIKE CONCAT('%',par_busqueda,'%') 
OR diacred LIKE CONCAT('%',par_busqueda,'%') 
OR limtcred LIKE CONCAT('%',par_busqueda,'%') 
OR falt LIKE CONCAT('%',par_busqueda,'%')
OR fmod LIKE CONCAT('%',par_busqueda,'%')
)
ORDER BY ser, codemp
;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `sp_encabezadoproveedores`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_encabezadoproveedores`(
IN par_id_empresa VARCHAR(30),
IN par_busqueda VARCHAR(255))
BEGIN
SELECT prov, ser, nom 
FROM provs 
WHERE (CONCAT_WS('', ser, prov ) LIKE CONCAT('%',par_busqueda,'%')
OR nom LIKE CONCAT('%',par_busqueda,'%')
OR ser LIKE CONCAT('%',par_busqueda,'%') 
OR tel LIKE CONCAT('%',par_busqueda,'%')
OR calle LIKE CONCAT('%',par_busqueda,'%') 
OR col LIKE CONCAT('%',par_busqueda,'%')
OR cp LIKE CONCAT('%',par_busqueda,'%')
OR noint LIKE CONCAT('%',par_busqueda,'%') 
OR noext LIKE CONCAT('%',par_busqueda,'%') 
OR ciu LIKE CONCAT('%',par_busqueda,'%') 
OR pais LIKE CONCAT('%',par_busqueda,'%')
OR estad LIKE CONCAT('%',par_busqueda,'%') 
OR rfc LIKE CONCAT('%',par_busqueda,'%') 
OR descu LIKE CONCAT('%',par_busqueda,'%')
OR diacred LIKE CONCAT('%',par_busqueda,'%')
OR limcred LIKE CONCAT('%',par_busqueda,'%')
OR co1 LIKE CONCAT('%',par_busqueda,'%')
OR co2 LIKE CONCAT('%',par_busqueda,'%')
OR co3 LIKE CONCAT('%',par_busqueda,'%')
OR pagweb1 LIKE CONCAT('%',par_busqueda,'%')
OR pagweb2 LIKE CONCAT('%',par_busqueda,'%')
OR telper1 LIKE CONCAT('%',par_busqueda,'%')
OR telper2 LIKE CONCAT('%',par_busqueda,'%')
OR eje1 LIKE CONCAT('%',par_busqueda,'%') 
OR eje2 LIKE CONCAT('%',par_busqueda,'%')
OR telper21 LIKE CONCAT('%',par_busqueda,'%')
OR telper22 LIKE CONCAT('%',par_busqueda,'%')
OR observ LIKE CONCAT('%',par_busqueda,'%')
OR falt LIKE CONCAT('%',par_busqueda,'%')
OR fmod LIKE CONCAT('%',par_busqueda,'%')) 
AND idempresa = par_id_empresa ORDER BY ser;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `sp_TotalProyCliente`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TotalProyCliente`(in par_codemp varchar(30), in par_ser varchar(30), in par_id_empresa varchar(30))
BEGIN
    SELECT COUNT(*) total FROM proys WHERE codemp = par_codemp AND ser = par_ser AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `sp_TotalVentasCliente`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_TotalVentasCliente`(in par_codemp varchar(45), in par_id_empresa varchar(30))
BEGIN
   SELECT COUNT(*) total FROM vtas where codemp = par_codemp and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `SP_ValidaConfiguracionCorreo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `SP_ValidaConfiguracionCorreo`(IN par_estac varchar(30) , IN par_id_empresa varchar(30))
BEGIN
   SELECT estac FROM corrselec WHERE estac = par_estac AND idempresa = par_id_empresa;
END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `subramos` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(30) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `estacion` varchar(30) NOT NULL,
  `sucursal` varchar(30) NOT NULL,
  `caja` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codigo` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `sucursal` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `nocaj` varchar(30) NOT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idempresa` varchar(30) NOT NULL,
  `codZona` varchar(30) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `tall` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `tallcolo` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `tall` varchar(30) NOT NULL,
  `alma` varchar(30) NOT NULL,
  `colo` varchar(30) NOT NULL,
  `exist` float DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `tars` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cli` varchar(30) NOT NULL,
  `tar` int(11) NOT NULL,
  `vta` int(11) DEFAULT '0',
  `pag` bit(1) NOT NULL,
  `loc` bit(1) NOT NULL,
  `exter` bit(1) NOT NULL,
  `prepag` bit(1) NOT NULL,
  `factuya` bit(1) NOT NULL,
  `ffactu` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `factur` bit(1) NOT NULL,
  `tarif` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cli` (`cli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `termarcamodelo` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `marc` varchar(30) NOT NULL,
  `model` varchar(30) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `marc` (`marc`),
  KEY `model` (`model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `terprodcompa` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(30) NOT NULL,
  `marc` varchar(30) NOT NULL,
  `model` varchar(30) NOT NULL,
  `rut` varchar(2048) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `marc` (`marc`),
  KEY `model` (`model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `tipactfij` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `tip` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `tip` (`tip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `tips` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `tipscamb` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `mon` varchar(30) NOT NULL,
  `tipcam` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `mon` (`mon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `traspas` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `prod` varchar(255) NOT NULL,
  `alma` varchar(255) NOT NULL,
  `concep` varchar(50) NOT NULL,
  `unid` varchar(30) NOT NULL,
  `cantsal` float NOT NULL,
  `almaa` varchar(30) NOT NULL,
  `cantent` float NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UsuarioResponsableTras` varchar(50) DEFAULT NULL,
  `lotePedimento` int(11) DEFAULT '0',
  `costo` decimal(22,6) DEFAULT '0.000000',
  `estado` varchar(35) DEFAULT NULL,
  `reporteSalida` varchar(35) DEFAULT NULL,
  `reporteEntrada` varchar(35) DEFAULT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `prod` (`prod`),
  KEY `alma` (`alma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `ubiad` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  UNIQUE KEY `cod_UNIQUE` (`cod`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `unids` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `clavesat` varchar(10) NOT NULL,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP PROCEDURE IF EXISTS `UPD_ActivaConfiguracion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ActivaConfiguracion`(in par_id_empresa varchar(30), in par_clasif varchar(45), in par_conf varchar(45))
BEGIN
   UPDATE confgral set val = 1 where conf = par_conf and clasif = par_clasif and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ActualizaBasdats`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ActualizaBasdats`(
in par_rutap varchar(500),
in par_nom varchar(255),
in par_metcost varchar(10),
in par_tel varchar(255),
in par_calle varchar(255),
in par_col varchar(255),
in par_CP varchar(20),
in par_ciu varchar(255),
in par_estad varchar(255),
in par_pai varchar(255),
in par_RFC varchar(21),
in par_corr varchar(100),
in par_pagweb varchar(255),
in par_noint varchar(21),
in par_pers varchar(2),
in par_noext varchar(21),
in par_id_empresa varchar(30),
in par_estac varchar(30),
in par_lugexp varchar(255),
in par_regfisc varchar(255),
in par_rutcer varchar(2045),
in par_rutkey varchar(2045),
in par_passcer varchar(1000),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_servOestac varchar(30),
in par_tipEstac varchar(30),
in par_plantilla varchar(100))
BEGIN
UPDATE basdats
SET
rutap = par_rutap,
nom = par_nom,
metcost = par_metcost,
tel = par_tel,
calle = par_calle,
col = par_col,
CP = par_CP,
ciu = par_ciu,
estad = par_estad,
pai = par_pai,
RFC = par_RFC,
corr = par_corr,
pagweb = par_pagweb,
noint = par_noint,
pers = par_pers,
noext = par_noext,
idempresa = par_id_empresa,
estac = par_estac,
lugexp = par_lugexp,
regfisc = par_regfisc,
rutcer = par_rutcer,
rutkey = par_rutkey,
passcer = par_passcer,
sucu = par_sucu,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
servOestac = par_servOestac,
tipEstac = par_tipEstac,
plantilla = par_plantilla;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ActualizaErPermiso`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ActualizaErPermiso`(
in par_id int(11) 
,in par_permisoConf bit(1) 
,in par_permisoCorreos bit(1) 
,in par_permisoDatosEmpresa bit(1) 
,in par_permisoSeries bit(1) 
,in par_permisoImpresoras bit(1) 
,in par_permisoCambiarIcono bit(1) 
,in par_permisoConfiguracionesGenerales bit(1) 
,in par_otorgaPermisosConfig bit(1) 
,in par_permisoUsuarios bit(1) 
,in par_permisoUsuariosDefinir bit(1) 
,in par_permisoUsuariosConectados bit(1) 
,in par_permisoUsuariosPermisos bit(1) 
,in par_permisoClaves bit(1) 
,in par_permisoReparar bit(1) 
,in par_permisoRepararErrores int(11) 
,in par_permisoRepararRestaurar bit(1) 
,in par_permisoBaseDatos bit(1) 
,in par_permisoBaseDatosConexiones bit(1) 
,in par_permisoBaseDatosArchivo bit(1) 
,in par_permisoReportes bit(1) 
,in par_permisoReportesUsuarios bit(1) 
,in par_permisoReportesRespaldos bit(1) 
,in par_permisoReportesLog bit(1) 
,in par_permisoReportesEstadistica bit(1) 
,in par_permisoRevocacion bit(1) 
,in par_permisoActivarSistema bit(1) 
,in par_otorgaPermisosSistema bit(1) 
,in par_permisoContabilidad bit(1) 
,in par_permisoConceptosNC bit(1) 
,in par_permisoCatalogoGarantias bit(1) 
,in par_permisoZonas bit(1) 
,in par_permisoGiros bit(1) 
,in par_permisoMonedas bit(1) 
,in par_permisoImpuestos bit(1) 
,in par_otorgaPermisosModulos bit(1) 
,in par_permisoCompras bit(1) 
,in par_permisoComprasCancelar bit(1) 
,in par_permisoComprasDevolucion bit(1) 
,in par_permisoComprasParcial bit(1) 
,in par_permisoComprasNuevo bit(1) 
,in par_permisoComprasNotCredito bit(1) 
,in par_permisoComprasVer bit(1) 
,in par_permisoComprasCargarArchivo bit(1) 
,in par_permisoComprasBorrarArchivo bit(1) 
,in par_permisoComprasRecibirOrden bit(1) 
,in par_otorgaPermisosCompras bit(1) 
,in par_permisoProvee bit(1) 
,in par_permisoProveeNuevo bit(1) 
,in par_permisoProveeModificar bit(1) 
,in par_permisoProveeVer bit(1) 
,in par_permisoProveeBorrar bit(1) 
,in par_otorgaPermisosProvee bit(1) 
,in par_permisoPrevio bit(1) 
,in par_permisoPrevioNueva bit(1) 
,in par_permisoPrevioAbrir bit(1) 
,in par_permisoPrevioVer bit(1) 
,in par_permisoPrevioCancelar bit(1) 
,in par_permisoPrevioSeries bit(1) 
,in par_permisoPrevioCompra bit(1) 
,in par_otorgaPermisosPrevio bit(1) 
,in par_permisoInventario bit(1) 
,in par_permisoProductos bit(1) 
,in par_permisoProductosNuevo bit(1) 
,in par_permisoProductosModificar bit(1) 
,in par_permisProductosBorrar bit(1) 
,in par_otorgaPermisosInventario bit(1) 
,in par_permisoClientes bit(1) 
,in par_permisoClientesNuevo bit(1) 
,in par_permisoClientesModificar bit(1) 
,in par_permisoClientesVer bit(1) 
,in par_permisoClientesBorrar bit(1) 
,in par_permisoClientesEnviar bit(1) 
,in par_otorgaPermisosClientes bit(1) 
,in par_permisoVentas bit(1) 
,in par_permisoVentasCancelar bit(1) 
,in par_permisoVentasDevolucion bit(1) 
,in par_permisoVentasParcial bit(1) 
,in par_permisoVentasNueva bit(1) 
,in par_permisoVentasNotCredito bit(1) 
,in par_permisoVentasVer bit(1) 
,in par_permisoVentasEnviar bit(1) 
,in par_permisoVentasTimbrar bit(1) 
,in par_permisoVentasEntregar bit(1) 
,in par_permisoVentasComprobar bit(1) 
,in par_permisoVentasAcuse bit(1) 
,in par_permisoVentasObtenerXml bit(1) 
,in par_permisoVentasFacturar bit(1) 
,in par_permisoVentasCargarArchivo bit(1) 
,in par_permisoVentasBorrarArchivo bit(1) 
,in par_otorgaPermisosVentas bit(1) 
,in par_permisoCotiza bit(1) 
,in par_permisoCotizaNueva bit(1) 
,in par_permisoCotizaAbrir bit(1) 
,in par_permisoCotizaVer bit(1) 
,in par_permisoCotizaCancelar bit(1) 
,in par_permisoCotizaReenviar bit(1) 
,in par_permisoCotizaVenta bit(1) 
,in par_otorgaPermisosCotiza bit(1) 
,in par_id_empresa varchar(30) 
,in par_permisoCxc bit(1) 
,in par_permisoPagoNuevo bit(1) 
,in par_permisoCancelarPago bit(1) 
,in par_otorgaPermisoCxc bit(1) 
,in par_permisProductosListaPrecio bit(1) 
,in par_permisProductosCargadoImagen bit(1))
BEGIN
UPDATE er_permisos 
SET 
permisoConf=par_permisoConf
,permisoCorreos=par_permisoCorreos
,permisoDatosEmpresa=par_permisoDatosEmpresa
,permisoSeries=par_permisoSeries
,permisoImpresoras=par_permisoImpresoras
,permisoCambiarIcono=par_permisoCambiarIcono
,permisoConfiguracionesGenerales=par_permisoConfiguracionesGenerales
,otorgaPermisosConfig=par_otorgaPermisosConfig
,permisoUsuarios=par_permisoUsuarios
,permisoUsuariosDefinir=par_permisoUsuariosDefinir
,permisoUsuariosConectados=par_permisoUsuariosConectados
,permisoUsuariosPermisos=par_permisoUsuariosPermisos
,permisoClaves=par_permisoClaves
,permisoReparar=par_permisoReparar
,permisoRepararErrores=par_permisoRepararErrores
,permisoRepararRestaurar=par_permisoRepararRestaurar
,permisoBaseDatos=par_permisoBaseDatos
,permisoBaseDatosConexiones=par_permisoBaseDatosConexiones
,permisoBaseDatosArchivo=par_permisoBaseDatosArchivo
,permisoReportes=par_permisoReportes
,permisoReportesUsuarios=par_permisoReportesUsuarios
,permisoReportesRespaldos=par_permisoReportesRespaldos
,permisoReportesLog=par_permisoReportesLog
,permisoReportesEstadistica=par_permisoReportesEstadistica
,permisoRevocacion=par_permisoRevocacion
,permisoActivarSistema=par_permisoActivarSistema
,otorgaPermisosSistema=par_otorgaPermisosSistema
,permisoContabilidad=par_permisoContabilidad
,permisoConceptosNC=par_permisoConceptosNC
,permisoCatalogoGarantias=par_permisoCatalogoGarantias
,permisoZonas=par_permisoZonas
,permisoGiros=par_permisoGiros
,permisoMonedas=par_permisoMonedas
,permisoImpuestos=par_permisoImpuestos
,otorgaPermisosModulos=par_otorgaPermisosModulos
,permisoCompras=par_permisoCompras
,permisoComprasCancelar=par_permisoComprasCancelar
,permisoComprasDevolucion=par_permisoComprasDevolucion
,permisoComprasParcial=par_permisoComprasParcial
,permisoComprasNuevo=par_permisoComprasNuevo
,permisoComprasNotCredito=par_permisoComprasNotCredito
,permisoComprasVer=par_permisoComprasVer
,permisoComprasCargarArchivo=par_permisoComprasCargarArchivo
,permisoComprasBorrarArchivo=par_permisoComprasBorrarArchivo
,permisoComprasRecibirOrden=par_permisoComprasRecibirOrden
,otorgaPermisosCompras=par_otorgaPermisosCompras
,permisoProvee=par_permisoProvee
,permisoProveeNuevo=par_permisoProveeNuevo
,permisoProveeModificar=par_permisoProveeModificar
,permisoProveeVer=par_permisoProveeVer
,permisoProveeBorrar=par_permisoProveeBorrar
,otorgaPermisosProvee=par_otorgaPermisosProvee
,permisoPrevio=par_permisoPrevio
,permisoPrevioNueva=par_permisoPrevioNueva
,permisoPrevioAbrir=par_permisoPrevioAbrir
,permisoPrevioVer=par_permisoPrevioVer
,permisoPrevioCancelar=par_permisoPrevioCancelar
,permisoPrevioSeries=par_permisoPrevioSeries
,permisoPrevioCompra=par_permisoPrevioCompra
,otorgaPermisosPrevio=par_otorgaPermisosPrevio
,permisoInventario=par_permisoInventario
,permisoProductos=par_permisoProductos
,permisoProductosNuevo=par_permisoProductosNuevo
,permisoProductosModificar=par_permisoProductosModificar
,permisProductosBorrar=par_permisProductosBorrar
,otorgaPermisosInventario=par_otorgaPermisosInventario
,permisoClientes=par_permisoClientes
,permisoClientesNuevo=par_permisoClientesNuevo
,permisoClientesModificar=par_permisoClientesModificar
,permisoClientesVer=par_permisoClientesVer
,permisoClientesBorrar=par_permisoClientesBorrar
,permisoClientesEnviar=par_permisoClientesEnviar
,otorgaPermisosclientes=par_otorgaPermisosclientes
,permisoVentas=par_permisoVentas
,permisoVentasCancelar=par_permisoVentasCancelar
,permisoVentasDevolucion=par_permisoVentasDevolucion
,permisoVentasParcial=par_permisoVentasParcial
,permisoVentasNueva=par_permisoVentasNueva
,permisoVentasNotCredito=par_permisoVentasNotCredito
,permisoVentasVer=par_permisoVentasVer
,permisoVentasEnviar=par_permisoVentasEnviar
,permisoVentasTimbrar=par_permisoVentasTimbrar
,permisoVentasEntregar=par_permisoVentasEntregar
,permisoVentasComprobar=par_permisoVentasComprobar
,permisoVentasAcuse=par_permisoVentasAcuse
,permisoVentasObtenerXml=par_permisoVentasObtenerXml
,permisoVentasFacturar=par_permisoVentasFacturar
,permisoVentasCargarArchivo=par_permisoVentasCargarArchivo
,permisoVentasBorrarArchivo=par_permisoVentasBorrarArchivo
,otorgaPermisosVentas=par_otorgaPermisosVentas
,permisoCotiza=par_permisoCotiza
,permisoCotizaNueva=par_permisoCotizaNueva
,permisoCotizaAbrir=par_permisoCotizaAbrir
,permisoCotizaVer=par_permisoCotizaVer
,permisoCotizaCancelar=par_permisoCotizaCancelar
,permisoCotizaReenviar=par_permisoCotizaReenviar
,permisoCotizaVenta=par_permisoCotizaVenta
,otorgaPermisosCotiza=par_otorgaPermisosCotiza
,permisProductosListaPrecio=par_permisProductosListaPrecio
,permisProductosCargadoImagen=par_permisProductosCargadoImagen
WHERE 
er_permisos.FKIdUsuario = par_id AND er_permisos.idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_AlmacenPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_AlmacenPorCodigo`(
in par_alma varchar(30),
in par_respon varchar(30),
in par_almadescrip varchar(255),
in par_dir1 varchar(255),
in par_dir2 varchar(255),
in par_dir3 varchar(255),
in par_actfij bit,
in par_id_empresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255) ,
in par_falt datetime,
in par_fmod datetime)
BEGIN
UPDATE empresax.almas
SET
respon = par_respon,
almadescrip = par_almadescrip,
dir1 = par_dir1,
dir2 = par_dir2,
dir3 = par_dir3,
actfij = par_actfij,
estac = par_estac,
sucu = par_sucu,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
falt = par_falt,
fmod = par_fmod
WHERE alma = par_alma and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_AlmacenPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_AlmacenPorId`(
in par_id int,
in par_alma varchar(30),
in par_respon varchar(30),
in par_almadescrip varchar(255),
in par_dir1 varchar(255),
in par_dir2 varchar(255),
in par_dir3 varchar(255),
in par_actfij bit,
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255) ,
in par_falt datetime,
in par_fmod datetime)
BEGIN
UPDATE empresax.almas
SET
alma = par_alma,
respon = par_respon,
almadescrip = par_almadescrip,
dir1 = par_dir1,
dir2 = par_dir2,
dir3 = par_dir3,
actfij = par_actfij,
idempresa = par_idempresa,
estac = par_estac,
sucu = par_sucu,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
falt = par_falt,
fmod = par_fmod
WHERE id_id = par_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_CambiaConfiguracion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_CambiaConfiguracion`(in par_id_empresa varchar(30), in par_clasif varchar(45), in par_conf varchar(45))
BEGIN
   UPDATE confgral set val = if(val=1,0,1) where clasif = par_clasif and conf = par_conf and idempresa = par_idempresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_Cliente`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Cliente`(
    IN par_id INT,
    IN `par_anio` VARCHAR(10),
	IN `par_banc` VARCHAR(10),
	IN `par_beneficiario` VARCHAR(30),
	IN `par_bloq` BIT,
	IN `par_bloqlimcred` BIT,
	IN `par_calle` VARCHAR(255),
	IN `par_cel` VARCHAR(255),
	IN `par_ciu` VARCHAR(255),
	IN `par_clasjera` VARCHAR(2048),
	IN `par_clavbanc` VARCHAR(255),
	IN `par_co1` VARCHAR(100),
	IN `par_co2` VARCHAR(100),
	IN `par_co3` VARCHAR(100),
	IN `par_codclas` VARCHAR(30),
	IN `par_codemp` VARCHAR(30),
	IN `par_codigo` VARCHAR(45),
	IN `par_col` VARCHAR(255),
	IN `par_CP` VARCHAR(20),
	IN `par_cta` VARCHAR(45),
	IN `par_ctaconta` VARCHAR(30),
	IN `par_ctapred` VARCHAR(100),
	IN `par_curp` VARCHAR(50),
	IN `par_deposit` FLOAT,
	IN `par_descu` FLOAT,
	IN `par_diacred` VARCHAR(21),
	IN `par_diapag` INT,
	IN `par_encall` VARCHAR(255),
	IN `par_encel` VARCHAR(255),
	IN `par_enciu` VARCHAR(255),
	IN `par_enco1` VARCHAR(100),
	IN `par_enco2` VARCHAR(100),
	IN `par_enco3` VARCHAR(100),
	IN `par_encol` VARCHAR(255),
	IN `par_encp` VARCHAR(20),
	IN `par_enemail` VARCHAR(100),
	IN `par_enestad` VARCHAR(255),
	IN `par_enlada` VARCHAR(10),
	IN `par_ennoext` VARCHAR(21),
	IN `par_ennoexten` VARCHAR(21),
	IN `par_ennoint` VARCHAR(21),
	IN `par_enpagweb` VARCHAR(255),
	IN `par_enpai` VARCHAR(255),
	IN `par_entel1` VARCHAR(255),
	IN `par_entel2` VARCHAR(255),
	IN `par_entel3` VARCHAR(255),
	IN `par_estac` VARCHAR(30),
	IN `par_estad` VARCHAR(255),
	IN `par_export` BIT,
	IN `par_exten` VARCHAR(20),
	IN `par_extr1` VARCHAR(255),
	IN `par_extr2` VARCHAR(255),
	IN `par_extr3` VARCHAR(255),
	IN `par_idempresa` VARCHAR(255),
	IN `par_lada` VARCHAR(10),
	IN `par_limtcred` FLOAT,
	IN `par_list` INT,
	IN `par_metpag` VARCHAR(45),
	IN `par_nocaj` VARCHAR(30),
	IN `par_noext` VARCHAR(100),
	IN `par_noint` VARCHAR(100),
	IN `par_nom` VARCHAR(255),
	IN `par_observ` VARCHAR(255),
	IN `par_otramon` BIT,
	IN `par_otramonc` BIT,
	IN `par_pags` VARCHAR(100),
	IN `par_pagweb1` VARCHAR(255),
	IN `par_pagweb2` VARCHAR(200),
	IN `par_pai` VARCHAR(255),
	IN `par_pers` VARCHAR(2),
	IN `par_revis` VARCHAR(100),
	IN `par_RFC` VARCHAR(21),
	IN `par_ser` VARCHAR(30),
	IN `par_sucu` VARCHAR(30),
	IN `par_tel` VARCHAR(255),
	IN `par_telper1` VARCHAR(255),
	IN `par_telper2` VARCHAR(255),
	IN `par_usocfdi` VARCHAR(10),
	IN `par_vend` VARCHAR(30)
    )
BEGIN
UPDATE emps
SET
anio = par_anio,
banc = par_banc,
beneficiario = par_beneficiario,
bloq = par_bloq,
bloqlimcred = par_bloqlimcred,
calle = par_calle,
cel = par_cel,
ciu = par_ciu,
clasjera = par_clasjera,
clavbanc = par_clavbanc,
co1 = par_co1,
co2 = par_co2,
co3 = par_co3,
codclas = par_codclas,
codemp = par_codemp,
codigo = par_codigo,
col = par_col,
CP = par_CP,
cta = par_cta,
ctaconta = par_ctaconta,
ctapred = par_ctapred,
curp = par_curp,
deposit = par_deposit,
descu = par_descu,
diacred = par_diacred,
diapag = par_diapag,
encall = par_encall,
encel = par_encel,
enciu = par_enciu,
enco1 = par_enco1,
enco2 = par_enco2,
enco3 = par_enco3,
encol = par_encol,
encp = par_encp,
enemail = par_enemail,
enestad = par_enestad,
enlada = par_enlada,
ennoext = par_ennoext,
ennoexten = par_ennoexten,
ennoint = par_ennoint,
enpagweb = par_enpagweb,
enpai = par_enpai,
entel1 = par_entel1,
entel2 = par_entel2,
entel3 = par_entel3,
estac = par_estac,
estad = par_estad,
export = par_export,
exten =  par_exten ,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
idempresa = par_idempresa,
lada = par_lada,
limtcred = par_limtcred,
list = par_list,
metpag = par_metpag,
nocaj = par_nocaj,
noext = par_noext,
noint = par_noint,
nom = par_nom,
observ = par_observ,
otramon = par_otramon,
otramonc = par_otramonc,
pags = par_pags,
pagweb1 = par_pagweb1,
pagweb2 = par_pagweb2,
pai = par_pai,
pers = par_pers,
revis = par_revis,
RFC = par_RFC,
ser = par_ser,
sucu = par_sucu,
tel = par_tel,
telper1 = par_telper1,
telper2 = par_telper2,
usocfdi = par_usocfdi,
vend = par_vend
WHERE id_id = par_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ClientePorSerCod`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ClientePorSerCod`(
    IN `par_ser` VARCHAR(30),
    IN `par_cod` VARCHAR(30),
    IN `par_anio` VARCHAR(10),
	IN `par_banc` VARCHAR(10),
	IN `par_beneficiario` VARCHAR(30),
    IN `par_bloq` BIT,
	IN `par_bloqlimcred` BIT,
	IN `par_calle` VARCHAR(255),
	IN `par_cel` VARCHAR(255),
	IN `par_ciu` VARCHAR(255),
	IN `par_clasjera` VARCHAR(2048),
	IN `par_clavbanc` VARCHAR(255),
	IN `par_co1` VARCHAR(100),
	IN `par_co2` VARCHAR(100),
	IN `par_co3` VARCHAR(100),
	IN `par_codclas` VARCHAR(30),
	IN `par_codemp` VARCHAR(30),
	IN `par_codigo` VARCHAR(45),
	IN `par_col` VARCHAR(255),
	IN `par_CP` VARCHAR(20),
	IN `par_cta` VARCHAR(45),
	IN `par_ctaconta` VARCHAR(30),
	IN `par_ctapred` VARCHAR(100),
	IN `par_curp` VARCHAR(50),
	IN `par_deposit` FLOAT,
	IN `par_descu` FLOAT,
	IN `par_diacred` VARCHAR(21),
	IN `par_diapag` INT,
	IN `par_encall` VARCHAR(255),
	IN `par_encel` VARCHAR(255),
	IN `par_enciu` VARCHAR(255),
	IN `par_enco1` VARCHAR(100),
	IN `par_enco2` VARCHAR(100),
	IN `par_enco3` VARCHAR(100),
	IN `par_encol` VARCHAR(255),
	IN `par_encp` VARCHAR(20),
	IN `par_enemail` VARCHAR(100),
	IN `par_enestad` VARCHAR(255),
	IN `par_enlada` VARCHAR(10),
	IN `par_ennoext` VARCHAR(21),
	IN `par_ennoexten` VARCHAR(21),
	IN `par_ennoint` VARCHAR(21),
	IN `par_enpagweb` VARCHAR(255),
	IN `par_enpai` VARCHAR(255),
	IN `par_entel1` VARCHAR(255),
	IN `par_entel2` VARCHAR(255),
	IN `par_entel3` VARCHAR(255),
	IN `par_estac` VARCHAR(30),
	IN `par_estad` VARCHAR(255),
    IN `par_export` BIT,
	IN `par_exten` VARCHAR(20),
	IN `par_extr1` VARCHAR(255),
	IN `par_extr2` VARCHAR(255),
	IN `par_extr3` VARCHAR(255),
	IN `par_id_empresa` VARCHAR(255),
	IN `par_lada` VARCHAR(10),
	IN `par_limtcred` FLOAT,
	IN `par_list` INT,
	IN `par_metpag` VARCHAR(45),
	IN `par_nocaj` VARCHAR(30),
	IN `par_noext` VARCHAR(100),
	IN `par_noint` VARCHAR(100),
	IN `par_nom` VARCHAR(255),
	IN `par_observ` VARCHAR(255),
    IN `par_otramon` BIT,
	IN `par_otramonc` BIT,
	IN `par_pags` VARCHAR(100),
	IN `par_pagweb1` VARCHAR(255),
	IN `par_pagweb2` VARCHAR(200),
	IN `par_pai` VARCHAR(255),
	IN `par_pers` VARCHAR(2),
	IN `par_revis` VARCHAR(100),
	IN `par_RFC` VARCHAR(21),
	IN `par_sucu` VARCHAR(30),
	IN `par_tel` VARCHAR(255),
	IN `par_telper1` VARCHAR(255),
	IN `par_telper2` VARCHAR(255),
	IN `par_usocfdi` VARCHAR(10),
	IN `par_vend` VARCHAR(30)
    )
BEGIN
UPDATE emps
SET
anio = par_anio,
banc = par_banc,
beneficiario = par_beneficiario,
bloq = par_bloq ,
bloqlimcred = par_bloqlimcred ,
calle = par_calle,
cel = par_cel,
ciu = par_ciu,
clasjera = par_clasjera,
clavbanc = par_clavbanc,
co1 = par_co1,
co2 = par_co2,
co3 = par_co3,
codclas = par_codclas,
codemp = par_codemp,
codigo = par_codigo,
col = par_col,
CP = par_CP,
cta = par_cta,
ctaconta = par_ctaconta,
ctapred = par_ctapred,
curp = par_curp,
deposit = par_deposit,
descu = par_descu,
diacred = par_diacred,
diapag = par_diapag,
encall = par_encall,
encel = par_encel,
enciu = par_enciu,
enco1 = par_enco1,
enco2 = par_enco2,
enco3 = par_enco3,
encol = par_encol,
encp = par_encp,
enemail = par_enemail,
enestad = par_enestad,
enlada = par_enlada,
ennoext = par_ennoext,
ennoexten = par_ennoexten,
ennoint = par_ennoint,
enpagweb = par_enpagweb,
enpai = par_enpai,
entel1 = par_entel1,
entel2 = par_entel2,
entel3 = par_entel3,
estac = par_estac,
estad = par_estad,
export = par_export ,
exten =  par_exten ,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
lada = par_lada,
limtcred = par_limtcred,
list = par_list,
metpag = par_metpag,
nocaj = par_nocaj,
noext = par_noext,
noint = par_noint,
nom = par_nom,
observ = par_observ,
otramon = par_otramon ,
otramonc = par_otramonc ,
pags = par_pags,
pagweb1 = par_pagweb1,
pagweb2 = par_pagweb2,
pai = par_pai,
pers = par_pers,
revis = par_revis,
RFC = par_RFC,
sucu = par_sucu,
tel = par_tel,
telper1 = par_telper1,
telper2 = par_telper2,
usocfdi = par_usocfdi,
vend = par_vend
WHERE ser = par_ser AND codemp = par_cod AND   
idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_Compras`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Compras`(
in par_prov varchar(30),
in par_ser varchar(30),
in par_nodoc varchar(50),
in par_estac varchar(30),
in par_fdoc date,
in par_subtot decimal(22,6),
in par_impue decimal(22,6),
in par_tot decimal(22,6),
in par_estado varchar(10),
in par_falt date,
in par_motiv varchar(255),
in par_nomprov varchar(255),
in par_fvenc date,
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_tip varchar(30),
in par_fent date,
in par_metpag varchar(42),
in par_cta varchar(42),
in par_monedaID int(11),
in par_tipcam decimal(22,6),
in par_codord varchar(30),
in par_archpdf bit,
in par_archxml bit,
in par_id_empresa varchar(30),
in par_total_traslado decimal(22,6),
in par_total_retencion decimal(22,6),
in par_tipcamnac decimal(22,6),
in par_codcomp varchar(30))
BEGIN
UPDATE comprs 
SET prov = par_prov,
ser = par_ser,
nodoc = par_nodoc,
estac = par_estac,
fdoc = par_fdoc,
subtot = par_subtot,
impue = par_impue,
tot = par_tot,
estado = par_estado,
falt = par_falt,
motiv = par_motiv,
nomprov = par_nomprov,
fvenc = par_fvenc,
sucu = par_sucu,
nocaj = par_nocaj,
tip = par_tip,
fent = par_fent,
metpag = par_metpag,
cta = par_cta,
monedaID = par_monedaID,
tipcam = par_tipcam,
codord = par_codord,
archpdf = par_archpdf,
archxml = par_archxml,
idempresa = par_id_empresa,
total_traslado = par_total_traslado,
total_retencion = par_total_retencion,
tipcamnac = par_tipcamnac 
WHERE codcomp = par_codcomp;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_Configuracion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Configuracion`(
in par_id_id int,
in par_clasif varchar(45),
in par_conf varchar(45),
in par_val int,
in par_nume float,
in par_idempresa  varchar(30),
in par_estac varchar(30),
in par_dia int,
in par_envia datetime,
in par_extr varchar(1000), 
in par_asun varchar(255),
in par_anio int,
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255))
BEGIN
UPDATE confgral
SET
clasif = par_clasif,
conf = par_conf,
val = par_val,
nume = par_nume,
fmod = now(),
idempresa = par_id_empresa,
estac = par_estac,
dia = par_dia,
envia = par_envia,
extr = par_extr,
asun = par_asun,
anio = par_anio,
sucu = par_sucu,
nocaj = par_no_caj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3
WHERE id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ConfiguracionExtra`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ConfiguracionExtra`(
in par_id_empresa varchar(30), 
in par_clasif varchar(45),  
in par_config varchar(45),
in par_extr varchar(1000), 
in par_nume float)
BEGIN
   UPDATE confgral 
   SET extr = par_extr,
   nume = par_nume,
   val = 1
   WHERE clasif = par_clasif AND conf = par_config;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS  `UPD_Correo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Correo`(
in par_srvsmtpsal varchar(50), 
in par_portsmtp int, 
in par_actslenlog bit, 
in par_usr varchar(61),
in par_pass varchar(255),
in par_corralter varchar(50),
in par_estac varchar(30),
in par_fmod datetime,
in par_asunfac varchar(255),
in par_asuncot varchar(255),
in par_asuncontra varchar(255),
in par_asunord varchar(255),
in par_asunrec1 varchar(255),
in par_asunrec2 varchar(255),
in par_asunrec3 varchar(255),
in par_cuerpfac varchar(255),
in par_cuerpcot varchar(255),
in par_cuerpcontra varchar(255),
in par_cuerpord varchar(255),
in par_cuerprec1 varchar(255),
in par_cuerprec2 varchar(255),
in par_cuerprec3 varchar(255),
in par_sucu varchar(255),
in par_nocaj varchar(30),
in par_estacglo varchar(30),
in par_id_id int,
in par_id_empresa varchar(30))
BEGIN
UPDATE corrselec SET 
srvsmtpsal = par_srvsmtpsal,
portsmtp = par_portsmtp,
actslenlog = par_actslenlog,
usr = par_usr,
pass = par_pass,
corralter = par_corralter,
estac = par_estac,
fmod = par_fmod,
asunfac = par_asunfac, 
asuncot = par_asuncot,
asuncontra = par_asuncontra,
asunord = par_asunord,
asunrec1 = par_asunrec1,
asunrec2 = par_asunrec2,
asunrec3 = par_asunrec3,
cuerpfac = par_cuerpfac,
cuerpcot = par_cuerpcot,
cuerpcontra = par_cuerpcontra,
cuerpord = par_cuerpord,
cuerprec1 = par_cuerprec1,
cuerprec2 = par_cuerprec2,
cuerprec3 = par_cuerprec3,
sucu = par_sucu,
nocaj = par_nocaj,
estacglo = par_estacglo
WHERE id_id = par_id_id AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS  `UPD_CorreoEncabezado`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_CorreoEncabezado`(
in par_usr varchar(61), 
in par_id_id int, 
in par_corralter varchar(50),
in par_estacglo varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_id_empresa varchar(30))
BEGIN
UPDATE corrselec SET 
usr              = par_usr,
corralter        = par_corralter,
fmod             = now(),
estacglo         = par_estacglo,
sucu             = par_sucu,
nocaj            = par_nocaj
WHERE id_id      = par_id_id AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_CuentasPorPagarNoRefer`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_CuentasPorPagarNoRefer`(
in par_norefer varchar(50),
in par_noser varchar(30),
in par_prov varchar(30),
in par_ser varchar(30),
in par_formpag varchar(30),
in par_conceppag varchar(30),
in par_monedaID int,
in par_tipcam decimal(22,6),
in par_comen	 varchar(500),
in par_subtot decimal(22,6),
in par_tot decimal(22,6),
in par_impue decimal(22,6),
in par_carg decimal(22,6),
in par_abon decimal(22,6),
in par_concep varchar(30),
in par_folbanc varchar(50),
in par_fvenc date,
in par_fdoc date,
in par_fmod date,
in par_fol int,
in par_id_empresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_cuentabanco varchar(30),
in par_estado varchar(30),
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255)
)
BEGIN
UPDATE `cxp`
SET
`norefer` = par_norefer,
`noser` = par_noser,
`prov` = par_prov,
`ser` = par_ser,
`formpag` = par_formpag,
`conceppag` = par_conceppag,
`monedaID` = par_monedaID,
`tipcam` = par_tipcam,
`comen` = par_comen,
`subtot` = par_subtot,
`tot` = par_tot,
`impue` = par_impue,
`carg` = par_carg,
`abon` = par_abon,
`concep` = par_concep,
`folbanc` = par_folbanc,
`fvenc` = par_fvenc,
`fdoc` = par_fdoc,
`falt` = par_falt,
`fmod` = par_fmod,
`fol` = par_fol,
`idempresa` = par_id_empresa,
`estac` = par_estac,
`sucu` = par_sucu,
`nocaj` = par_nocaj,
`export` = par_export,
`cuentabanco` = par_cuentabanco,
`estado` = par_estado,
`extr1` = par_extr1,
`extr2` = par_extr2,
`extr3` = par_extr3
WHERE `norefer` = par_norefer AND idpempresa = par_id_empresa;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_DesactivaConfiguraciones`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_DesactivaConfiguraciones`(in par_id_empresa varchar(30))
BEGIN
   UPDATE confgral set val = 0 where idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_EstacPorCodigo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_EstacPorCodigo`(
in par_id_empresa varchar(255),
in par_estac varchar(30), 
in par_ptovta bit,
in par_descu float,
in par_comi float,
in par_habdesc int,
in par_imptic varchar(255), 
in par_impfac varchar(255), 
in par_cort varchar(3),
in par_pass varchar(255), 
in par_estacglo varchar(30), 
in par_52m bit,
in par_calle varchar(255),
in par_nom varchar(255),
in par_col varchar(255),
in par_cp varchar(20),
in par_tel varchar(255),
in par_cel varchar(255),
in par_pai varchar(255),
in par_ciu varchar(255),
in par_esta varchar(255),
in par_noint varchar(255),
in par_noext varchar(2048),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_admcaj bit,
in par_vend bit,
in par_almacen varchar(50),
in par_correo varchar(255))
BEGIN
UPDATE estacs SET 
ptovta = par_ptovta,
descu = par_descu,
comi = par_comi,
habdesc = par_habdesc,
imptic = par_imptic, 
impfac = par_impfac, 
cort = par_cort,
pass = par_pass, 
estacglo = par_estacglo, 
`52m` = par_52m,
calle = par_calle,
nom = par_nom,
col = par_col,
cp = par_cp,
tel = par_tel,
cel = par_cel,
pai = par_pai,
ciu = par_ciu,
esta = par_esta ,
noint = par_noint ,
noext = par_noext ,
sucu = par_sucu ,
nocaj = par_nocaj ,
admcaj = par_admcaj,
vend = par_vend ,
almacen = par_almacen, 
correo = par_correo
WHERE estac = par_estac AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_EstadoVenta`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_EstadoVenta`(
in par_venta int,
in par_id_empresa varchar(30),
in par_estad varchar(10),
in par_motiv varchar(255),
in par_notcred varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_estac varchar(30)
)
BEGIN
UPDATE vtas SET 
estad        = par_estad,
motiv        = par_motiv,
notcred      = par_norcred,
sucu         = par_sucu,
nocaj        = par_nocaj, 
estac        = par_estac,
fmod         = now()
WHERE vta    = par_venta AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS  `UPD_Impuesto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Impuesto`(
in par_codimpue varchar(30),
in par_reten bit(1),
in par_impueval float,
in par_id_empresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(39),
in par_impuestoXML varchar(45))
BEGIN
UPDATE impues 
SET 
impuestoXML = par_impuestoXML, 
reten  = par_reten, 
impueval  = par_impueval, 
fmod = now(), 
estac = par_estac, 
sucu = par_sucu, 
nocaj = par_nocaj 
WHERE 
codimpue = par_codimpue
AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_IncrementaConsecutivo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_IncrementaConsecutivo`(
in par_id_empresa varchar(30), 
in par_sucu varchar(30), 
in par_nocaj varchar(30),
in par_tip varchar(10),
in par_ser varchar(30)
)
BEGIN
UPDATE consecs SET
consec       = consec + 1,
sucu         = par_sucu,
nocaj        = par_nocaj
WHERE tip    = par_tip 
AND ser = par_ser 
AND idempresa = par_id_empresa;
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS `UPD_IngresoEncabezadoPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_IngresoEncabezadoPorId`(
in par_id_id int,
in par_alma varchar(255),
in par_concep varchar(50),
in par_canttotal decimal(22,6),
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_entsal bit,
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_falt date,
in par_noser varchar(30),
in par_norefer varchar(30))
BEGIN
UPDATE ingresos_encab
SET
alma = par_alma ,
concep = par_concep,
canttotal = par_canttotal,
idempresa = par_idempresa,
estac = par_estac,
sucu = par_sucu,
entsal = par_entsal,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
falt = par_falt,
noser = par_noser,
norefer = par_norefer
WHERE id_id = par_id_id;

END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_IngresoEncabezadoPorSerie`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_IngresoEncabezadoPorSerie`(
in par_alma varchar(255),
in par_concep varchar(50),
in par_canttotal decimal(22,6),
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_entsal bit,
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_falt date,
in par_noser varchar(30),
in par_norefer varchar(30)
)
BEGIN
UPDATE ingresos_encab
SET
alma = par_alma ,
concep = par_concep,
canttotal = par_canttotal,
idempresa = par_idempresa,
estac = par_estac,
sucu = par_sucu,
entsal = par_entsal,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
falt = par_falt
WHERE noser = par_noser AND norefer = par_norefer;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_IngresPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_IngresPorId`(
in par_id_id int,
in par_idIngresCab int,
in par_prod varchar(255),
in par_alma varchar(255),
in par_unid varchar(255),
in par_concep varchar(50),
in par_cant float,
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu  varchar(30),
in par_entsal bit,
in par_nocaj  varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_activo varchar(45),
in par_falt date,
in par_costo varchar(50),
in par_cantsal decimal(22,6),
in par_tipcamnac decimal(22,6),
in par_pedimento varchar(30),
in par_lote varchar(45),
in par_caducidad date
)
BEGIN
UPDATE ingres 
SET
idIngresCab = par_idIngresCab,
prod = par_prod,
alma = par_alma,
unid = par_unid,
concep = par_concep,
cant = par_cant,
idempresa = par_idempresa,
estac = par_estac,
sucu = par_sucu,
entsal = par_entsal,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
activo = par_activo,
falt = par_falt,
costo = par_costo,
cantsal = par_cantsal,
tipcamnac = par_tipcamnac,
pedimento = par_pedimento,
lote = par_lote,
caducidad = par_caducidad
WHERE id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_LiberarPedido`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_LiberarPedido`(in par_venta int, in par_id_empresa varchar(30))
BEGIN
 UPDATE pedidos SET vta = 0,  estad = 'PE' 
 WHERE vta  = par_venta AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_PartidaDevolucion`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_PartidaDevolucion`(in par_id_partida int, in par_id_empresa varchar(30), in par_cantidad decimal(22,6))
BEGIN
	UPDATE partvta SET devs = devs - par_cantidad  
    WHERE id_id  = par_id_partida
    AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_Producto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Producto`(
    IN par_idproducto INT,
    IN `par_alma` VARCHAR(30),
	IN `par_anaq` VARCHAR(30),
	IN `par_bajcost` INT,
	IN `par_clavesat` VARCHAR(25),
	IN `par_codubi` VARCHAR(30),
	IN `par_comenser` VARCHAR(600),
	IN `par_compue` INT,
	IN `par_cost` FLOAT,
	IN `par_costre` FLOAT,
	IN `par_descrip` VARCHAR(2100),
	IN `par_descripcort` VARCHAR(255),
	IN `par_estac` VARCHAR(30),
	IN `par_estaccrea` INT,
	IN `par_esvta` INT,
	IN `par_exist` FLOAT,
	IN `par_export` BIT,
	IN `par_extr1` VARCHAR(255),
	IN `par_extr2` VARCHAR(255),
	IN `par_extr3` VARCHAR(255),
	IN `par_idempresa` VARCHAR(30),
	IN `par_impue` VARCHAR(30),
	IN `par_infor` VARCHAR(255),
	IN `par_invent` INT,
	IN `par_lote` VARCHAR(30),
	IN `par_lotped` BIT,
	IN `par_lug` VARCHAR(30),
	IN `par_max` INT,
	IN `par_metcost` VARCHAR(10),
	IN `par_min` INT,
	IN `par_nocaj` VARCHAR(30),
	IN `par_noser` VARCHAR(30),
	IN `par_pedimen` VARCHAR(30),
	IN `par_pesman` FLOAT,
	IN `par_prelist1` FLOAT,
	IN `par_prelist10` FLOAT,
	IN `par_prelist2` FLOAT,
	IN `par_prelist3` FLOAT,
	IN `par_prelist4` FLOAT,
	IN `par_prelist5` FLOAT,
	IN `par_prelist6` FLOAT,
	IN `par_prelist7` FLOAT,
	IN `par_prelist8` FLOAT,
	IN `par_prelist9` FLOAT,
	IN `par_prod` VARCHAR(255),
	IN `par_rutimg` VARCHAR(500),
	IN `par_servi` BIT,
	IN `par_solmaxmin` INT,
	IN `par_solser` BIT,
	IN `par_sucu` VARCHAR(30),
	IN `par_unid` VARCHAR(30),
	IN `par_utilvta1` FLOAT,
	IN `par_utilvta10` FLOAT,
	IN `par_utilvta2` FLOAT,
	IN `par_utilvta3` FLOAT,
	IN `par_utilvta4` FLOAT,
	IN `par_utilvta5` FLOAT,
	IN `par_utilvta6` FLOAT,
	IN `par_utilvta7` FLOAT,
	IN `par_utilvta8` FLOAT,
	IN `par_utilvta9` FLOAT
	)
BEGIN
UPDATE prods
SET
alma = par_alma
,anaq = par_anaq
,bajcost = par_bajcost
,clavesat = par_clavesat
,codubi = par_codubi
,comenser = par_comenser
,compue = par_compue
,cost = par_cost
,costre = par_costre
,descrip =  par_descrip 
,descripcort = par_descripcort
,estac = par_estac
,estaccrea = par_estaccrea
,esvta = par_esvta
,exist = par_exist
,export = par_export
,extr1 = par_extr1
,extr2 = par_extr2
,extr3 = par_extr3
,idempresa = par_idempresa
,impue = par_impue
,infor = par_infor
,invent = par_invent
,lote = par_lote
,lotped = par_lotped
,lug = par_lug
,max = par_max
,metcost = par_metcost
,min = par_min
,nocaj = par_nocaj
,noser =  par_noser 
,pedimen = par_pedimen
,pesman = par_pesman
,prelist1 = par_prelist1
,prelist10 = par_prelist10
,prelist2 = par_prelist2
,prelist3 = par_prelist3
,prelist4 = par_prelist4
,prelist5 = par_prelist5
,prelist6 = par_prelist6
,prelist7 = par_prelist7
,prelist8 = par_prelist8
,prelist9 = par_prelist9
,prod = par_prod
,rutimg = par_rutimg
,servi = par_servi
,solmaxmin =  par_solmaxmin 
,solser = par_solser
,sucu = par_sucu
,unid = par_unid
,utilvta1 = par_utilvta1
,utilvta10 = par_utilvta10
,utilvta2 = par_utilvta2
,utilvta3 = par_utilvta3
,utilvta4 = par_utilvta4
,utilvta5 = par_utilvta5
,utilvta6 = par_utilvta6
,utilvta7 = par_utilvta7
,utilvta8 = par_utilvta8
,utilvta9 = par_utilvta9
WHERE id_id = par_idProducto;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ProductoBajoCosto`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ProductoBajoCosto`(in par_id_empresa varchar(30), in par_sucu varchar(30), in par_nocaj varchar(30), in par_bajo_costo int)
BEGIN
UPDATE prods SET
sucu         = par_sucu,
nocaj        = par_nocaj,
bajcost      = par_bajo_costo
WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ProductoPorProd`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ProductoPorProd`(
IN `par_alma` VARCHAR(30),
	IN `par_anaq` VARCHAR(30),
	IN `par_bajcost` INT,
	IN `par_clavesat` VARCHAR(25),
	IN `par_codubi` VARCHAR(30),
	IN `par_comenser` VARCHAR(600),
	IN `par_compue` INT,
	IN `par_cost` FLOAT,
	IN `par_costre` FLOAT,
	IN `par_descrip` VARCHAR(2100),
	IN `par_descripcort` VARCHAR(255),
    IN `par_descprov` VARCHAR(100),
	IN `par_estac` VARCHAR(300),
	IN `par_estaccrea` VARCHAR(300),
	IN `par_esvta` INT,
	IN `par_exist` FLOAT,
	IN `par_export` BIT,
	IN `par_extr1` VARCHAR(255),
	IN `par_extr2` VARCHAR(255),
	IN `par_extr3` VARCHAR(255),
	IN `par_id_empresa` VARCHAR(30),
	IN `par_impue` VARCHAR(30),
	IN `par_infor` VARCHAR(255),
	IN `par_invent` INT,
	IN `par_lote` VARCHAR(30),
	IN `par_lotped` BIT,
	IN `par_lug` VARCHAR(30),
	IN `par_max` INT,
	IN `par_metcost` VARCHAR(10),
	IN `par_min` INT,
	IN `par_nocaj` VARCHAR(30),
	IN `par_noser` VARCHAR(30),
	IN `par_pedimen` VARCHAR(30),
	IN `par_pesman` FLOAT,
	IN `par_prelist1` FLOAT,
	IN `par_prelist10` FLOAT,
	IN `par_prelist2` FLOAT,
	IN `par_prelist3` FLOAT,
	IN `par_prelist4` FLOAT,
	IN `par_prelist5` FLOAT,
	IN `par_prelist6` FLOAT,
	IN `par_prelist7` FLOAT,
	IN `par_prelist8` FLOAT,
	IN `par_prelist9` FLOAT,
	IN `par_prodop1` VARCHAR(500),
    IN `par_prodop2` VARCHAR(500),
    IN `par_provop1` VARCHAR(30),
    IN `par_provop2` VARCHAR(30),
    IN `par_provprincipal` INT,
	IN `par_rutimg` VARCHAR(500),
	IN `par_servi` BIT,
	IN `par_solmaxmin` INT,
	IN `par_solser` BIT,
	IN `par_sucu` VARCHAR(30),
	IN `par_unid` VARCHAR(30),
	IN `par_utilvta1` FLOAT,
	IN `par_utilvta10` FLOAT,
	IN `par_utilvta2` FLOAT,
	IN `par_utilvta3` FLOAT,
	IN `par_utilvta4` FLOAT,
	IN `par_utilvta5` FLOAT,
	IN `par_utilvta6` FLOAT,
	IN `par_utilvta7` FLOAT,
	IN `par_utilvta8` FLOAT,
	IN `par_utilvta9` FLOAT,
    IN `par_id_garan` INT,
    IN `par_id_lin` INT,
    IN `par_id_tip` INT,
    IN `par_id_marc` INT,
    IN `par_id_mode` INT,
    IN `par_id_fab` INT,
    IN `par_id_colo` INT,
    IN `par_id_pes` INT,
    IN `par_id_unid` INT,
    IN `par_id_lug` INT,
    IN `par_id_alma` INT,
	IN `par_prod` VARCHAR(255)
	)
BEGIN
UPDATE prods
SET
alma = par_alma,
anaq = par_anaq,
bajcost = par_bajcost,
clavesat = par_clavesat,
codubi = par_codubi,
comenser = par_comenser,
compue = par_compue,
cost = par_cost,
costre = par_costre,
descrip = par_descrip,
descripcort = par_descripcort,
descprov = par_descprov,
estac = par_estac,
estaccrea = par_estaccrea,
esvta = par_esvta,
exist = par_exist,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
idempresa = par_id_empresa,
impue = par_impue,
infor = par_infor,
invent = par_invent,
lote = par_lote,
lotped = par_lotped,
lug = par_lug,
max = par_max,
metcost = par_metcost,
min = par_min,
nocaj = par_nocaj,
noser = par_noser,
pedimen = par_pedimen,
pesman = par_pesman,
prelist1 = par_prelist1,
prelist10 = par_prelist10,
prelist2 = par_prelist2,
prelist3 = par_prelist3,
prelist4 = par_prelist4,
prelist5 = par_prelist5,
prelist6 = par_prelist6,
prelist7 = par_prelist7,
prelist8 = par_prelist8,
prelist9 = par_prelist9,
prodop1 = par_prodop1,
prodop2 = par_prodop2,
prodop1 = par_provop1,
prodop2 = par_provop2,
provprincipal = par_provprincipal,
rutimg = par_rutimg,
servi = par_servi,
solmaxmin = par_solmaxmin,
solser = par_solser,
sucu = par_sucu,
unid = par_unid,
utilvta1 = par_utilvta1,
utilvta10 = par_utilvta10,
utilvta2 = par_utilvta2,
utilvta3 = par_utilvta3,
utilvta4 = par_utilvta4,
utilvta5 = par_utilvta5,
utilvta6 = par_utilvta6,
utilvta7 = par_utilvta7,
utilvta8 = par_utilvta8,
utilvta9 = par_utilvta9,
id_garan = par_id_garan,
id_lin = par_id_lin,
id_tip = par_id_tip,
id_marc = par_id_marc,
id_mode = par_id_mode,
id_fab = par_id_fab,
id_colo = par_id_colo,
id_pes = par_id_pes,
id_unid = par_id_unid,
id_lug = par_id_lug,
id_alma = par_id_alma
WHERE prod = par_prod and idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ProductoSolicitaMaxMin`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ProductoSolicitaMaxMin`(in par_id_empresa varchar(30), in par_sucu varchar(30), in par_nocaj varchar(30), in par_solmaxmin int)
BEGIN
   UPDATE prods SET
   sucu         = par_sucu,
   nocaj        = par_nocaj,
   solmaxmin    = par_solmaxmin
   WHERE idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ProveedorPorId`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ProveedorPorId`(
in par_id_id int,
in par_prov varchar(30),
in par_ser varchar(30),
in par_codclas varchar(30),
in par_zon varchar(30),
in par_giro varchar(30),
in par_tentre varchar(255),
in par_rubr varchar(30),
in par_banc varchar(30),
in par_clavbanc varchar(255),
in par_lada varchar(10),
in par_metpag varchar(45),
in par_cta varchar(45),
in par_enlada varchar(10),
in par_nom varchar(255),
in par_tel varchar(255),
in par_entel varchar(255),
in par_cel varchar(255),
in par_encel varchar(255),
in par_clasjera varchar(2048),
in par_exten varchar(20),
in par_enexten varchar(255),
in par_calle varchar(255),
in par_encalle varchar(255),
in par_col varchar(255),
in par_encol varchar(255),
in par_cp varchar(20),
in par_encp varchar(20),
in par_ennoint varchar(100),
in par_noint varchar(100),
in par_noext varchar(100),
in par_ennoext varchar(100),
in par_ciu varchar(255),
in par_enciu varchar(255),
in par_estad varchar(255),
in par_enestad varchar(255),
in par_otramon bit(1),
in par_otramonc bit(1),
in par_bloq bit(1),
in par_ctaconta varchar(30),
in par_revis varchar(100),
in par_pags varchar(100),
in par_pais varchar(255),
in par_enpais varchar(255),
in par_rfc varchar(21),
in par_descu float,
in par_diacred varchar(21),
in par_limcred float,
in par_bloqlimcred bit(1),
in par_co1 varchar(100),
in par_enco1 varchar(100),
in par_co2 varchar(100),
in par_enco2 varchar(100),
in par_co3 varchar(100),
in par_enco3 varchar(100),
in par_pagweb1 varchar(255),
in par_pagweb2 varchar(255),
in par_eje1 varchar(255),
in par_telper1 varchar(255),
in par_entelper1 varchar(255),
in par_telper2 varchar(255),
in par_entelper2 varchar(255),
in par_eje2 varchar(255),
in par_telper21 varchar(255),
in par_telper22 varchar(255),
in par_observ varchar(255),
in par_pers varchar(2),
in par_contac3 varchar(255),
in par_telcon3 varchar(255),
in par_telper3 varchar(255),
in par_telper33 varchar(255),
in par_contac4 varchar(255),
in par_telcon4 varchar(255),
in par_telper4 varchar(255),
in par_telper44 varchar(255),
in par_contac5 varchar(255),
in par_telcon5 varchar(255),
in par_telper5 varchar(255),
in par_telper55 varchar(255),
in par_contac6 varchar(255),
in par_telcon6 varchar(255),
in par_telper6 varchar(255),
in par_telper66 varchar(255),
in par_contac7 varchar(255),
in par_telcon7 varchar(255),
in par_telper7 varchar(255),
in par_telper77 varchar(255),
in par_contac8 varchar(255),
in par_telcon8 varchar(255),
in par_telper8 varchar(255),
in par_telper88 varchar(255),
in par_contac9 varchar(255),
in par_telcon9 varchar(255),
in par_telper9 varchar(255),
in par_telper99 varchar(255),
in par_contac10 varchar(255),
in par_telcon10 varchar(255),
in par_telper10 varchar(255),
in par_telper100 varchar(255),
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit(1),
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_beneficiario varchar(255))
BEGIN
UPDATE provs
SET 
prov = par_prov,
ser = par_ser,
codclas = par_codclas,
zon = par_zon,
giro = par_giro,
tentre = par_tentre,
rubr = par_rubr,
banc = par_banc,
clavbanc = par_clavbanc,
lada = par_lada,
metpag = par_metpag,
cta = par_cta,
enlada = par_enlada,
nom = par_nom,
tel = par_tel,
entel = par_entel,
cel = par_cel,
encel = par_encel,
clasjera = par_clasjera,
exten = par_exten,
enexten = par_enexten,
calle = par_calle,
encalle = par_encalle,
col = par_col,
encol = par_encol,
cp = par_cp,
encp = par_encp,
ennoint = par_ennoint,
noint = par_noint,
noext = par_noext,
ennoext = par_ennoext,
ciu = par_ciu,
enciu = par_enciu,
estad = par_estad,
enestad = par_enestad,
otramon = par_otramon,
otramonc = par_otramonc,
bloq = par_bloq,
ctaconta = par_ctaconta,
revis = par_revis,
pags = par_pags,
pais = par_pais,
enpais = par_enpais,
rfc = par_rfc,
descu = par_descu,
diacred = par_diacred,
limcred = par_limcred,
bloqlimcred = par_bloqlimcred,
co1 = par_co1,
enco1 = par_enco1,
co2 = par_co2,
enco2 = par_enco2,
co3 = par_co3,
enco3 = par_enco3,
pagweb1 = par_pagweb1,
pagweb2 = par_pagweb2,
eje1 = par_eje1,
telper1 = par_telper1,
entelper1 = par_entelper1,
telper2 = par_telper2,
entelper2 = par_enteper2,
eje2 = par_eje2,
telper21 = par_telper21,
telper22 = par_telper22,
observ = par_observ,
pers = par_pers,
contac3 = par_contac3,
telcon3 = par_telcon3,
telper3 = par_telper3,
telper33 = par_telper33,
contac4 = par_contac4,
telcon4 = par_telcon4,
telper4 = par_telper4,
telper44 = par_telper44,
contac5 = par_contac5,
telcon5 = par_telcon5,
telper5 = par_telper5,
telper55 = per_telper55,
contac6 = par_contac6,
telcon6 = par_telcon6,
telper6 = par_telper6,
telper66 = par_telper66,
contac7 = par_contac7,
telcon7 = par_telcon7,
telper7 = par_telper7,
telper77 = par_telper77,
contac8 = par_contac8,
telcon8 = par_telcon8,
telper8 = par_telper8,
telper88 = par_telper88,
contac9 = par_contac9,
telcon9 = par_telcon9,
telper9 = par_telper9,
telper99 = par_telper99,
contac10 = par_contac10,
telcon10 = par_telcon10,
telper10 = par_telper10,
telper100 = par_telper100,
idempresa = par_idempresa,
estac = par_estac,
sucu = par_sucu,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
beneficiario = par_beneficiario 
WHERE id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_ProveedorPorProv`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_ProveedorPorProv`(
in par_prov varchar(30),
in par_ser varchar(30),
in par_codclas varchar(30),
in par_zon varchar(30),
in par_giro varchar(30),
in par_tentre varchar(255),
in par_rubr varchar(30),
in par_banc varchar(30),
in par_clavbanc varchar(255),
in par_lada varchar(10),
in par_metpag varchar(45),
in par_cta varchar(45),
in par_enlada varchar(10),
in par_nom varchar(255),
in par_tel varchar(255),
in par_entel varchar(255),
in par_cel varchar(255),
in par_encel varchar(255),
in par_clasjera varchar(2048),
in par_exten varchar(20),
in par_enexten varchar(255),
in par_calle varchar(255),
in par_encalle varchar(255),
in par_col varchar(255),
in par_encol varchar(255),
in par_cp varchar(20),
in par_encp varchar(20),
in par_ennoint varchar(100),
in par_noint varchar(100),
in par_noext varchar(100),
in par_ennoext varchar(100),
in par_ciu varchar(255),
in par_enciu varchar(255),
in par_estad varchar(255),
in par_enestad varchar(255),
in par_otramon bit(1),
in par_otramonc bit(1),
in par_bloq bit(1),
in par_ctaconta varchar(30),
in par_revis varchar(100),
in par_pags varchar(100),
in par_pais varchar(255),
in par_enpais varchar(255),
in par_rfc varchar(21),
in par_descu float,
in par_diacred varchar(21),
in par_limcred float,
in par_bloqlimcred bit(1),
in par_co1 varchar(100),
in par_enco1 varchar(100),
in par_co2 varchar(100),
in par_enco2 varchar(100),
in par_co3 varchar(100),
in par_enco3 varchar(100),
in par_pagweb1 varchar(255),
in par_pagweb2 varchar(255),
in par_eje1 varchar(255),
in par_telper1 varchar(255),
in par_entelper1 varchar(255),
in par_telper2 varchar(255),
in par_entelper2 varchar(255),
in par_eje2 varchar(255),
in par_telper21 varchar(255),
in par_telper22 varchar(255),
in par_observ varchar(255),
in par_pers varchar(2),
in par_contac3 varchar(255),
in par_telcon3 varchar(255),
in par_telper3 varchar(255),
in par_telper33 varchar(255),
in par_contac4 varchar(255),
in par_telcon4 varchar(255),
in par_telper4 varchar(255),
in par_telper44 varchar(255),
in par_contac5 varchar(255),
in par_telcon5 varchar(255),
in par_telper5 varchar(255),
in par_telper55 varchar(255),
in par_contac6 varchar(255),
in par_telcon6 varchar(255),
in par_telper6 varchar(255),
in par_telper66 varchar(255),
in par_contac7 varchar(255),
in par_telcon7 varchar(255),
in par_telper7 varchar(255),
in par_telper77 varchar(255),
in par_contac8 varchar(255),
in par_telcon8 varchar(255),
in par_telper8 varchar(255),
in par_telper88 varchar(255),
in par_contac9 varchar(255),
in par_telcon9 varchar(255),
in par_telper9 varchar(255),
in par_telper99 varchar(255),
in par_contac10 varchar(255),
in par_telcon10 varchar(255),
in par_telper10 varchar(255),
in par_telper100 varchar(255),
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit(1),
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_beneficiario varchar(255))
BEGIN
UPDATE provs
SET 
ser = par_ser,
codclas = par_codclas,
zon = par_zon,
giro = par_giro,
tentre = par_tentre,
rubr = par_rubr,
banc = par_banc,
clavbanc = par_clavbanc,
lada = par_lada,
metpag = par_metpag,
cta = par_cta,
enlada = par_enlada,
nom = par_nom,
tel = par_tel,
entel = par_entel,
cel = par_cel,
encel = par_encel,
clasjera = par_clasjera,
exten = par_exten,
enexten = par_enexten,
calle = par_calle,
encalle = par_encalle,
col = par_col,
encol = par_encol,
cp = par_cp,
encp = par_encp,
ennoint = par_ennoint,
noint = par_noint,
noext = par_noext,
ennoext = par_ennoext,
ciu = par_ciu,
enciu = par_enciu,
estad = par_estad,
enestad = par_enestad,
otramon = par_otramon,
otramonc = par_otramonc,
bloq = par_bloq,
ctaconta = par_ctaconta,
revis = par_revis,
pags = par_pags,
pais = par_pais,
enpais = par_enpais,
rfc = par_rfc,
descu = par_descu,
diacred = par_diacred,
limcred = par_limcred,
bloqlimcred = par_bloqlimcred,
co1 = par_co1,
enco1 = par_enco1,
co2 = par_co2,
enco2 = par_enco2,
co3 = par_co3,
enco3 = par_enco3,
pagweb1 = par_pagweb1,
pagweb2 = par_pagweb2,
eje1 = par_eje1,
telper1 = par_telper1,
entelper1 = par_entelper1,
telper2 = par_telper2,
entelper2 = par_entelper2,
eje2 = par_eje2,
telper21 = par_telper21,
telper22 = par_telper22,
observ = par_observ,
pers = par_pers,
contac3 = par_contac3,
telcon3 = par_telcon3,
telper3 = par_telper3,
telper33 = par_telper33,
contac4 = par_contac4,
telcon4 = par_telcon4,
telper4 = par_telper4,
telper44 = par_telper44,
contac5 = par_contac5,
telcon5 = par_telcon5,
telper5 = par_telper5,
telper55 = par_telper55,
contac6 = par_contac6,
telcon6 = par_telcon6,
telper6 = par_telper6,
telper66 = par_telper66,
contac7 = par_contac7,
telcon7 = par_telcon7,
telper7 = par_telper7,
telper77 = par_telper77,
contac8 = par_contac8,
telcon8 = par_telcon8,
telper8 = par_telper8,
telper88 = par_telper88,
contac9 = par_contac9,
telcon9 = par_telcon9,
telper9 = par_telper9,
telper99 = par_telper99,
contac10 = par_contac10,
telcon10 = par_telcon10,
telper10 = par_telper10,
telper100 = par_telper100,
idempresa = par_idempresa,
estac = par_estac,
sucu = par_sucu,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
beneficiario = par_beneficiario 
WHERE CONCAT(ser,prov) = par_prov;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_Traspaso`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Traspaso`(
in par_id_id int,
in par_prod varchar(255),
in par_alma varchar(255),
in par_concep varchar(50),
in par_unid varchar(30),
in par_cantsal float,
in par_almaa varchar(30),
in par_cantent float,
in par_id_empresa varchar(30),
in par_estac varchar(30),
in par_sucu varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_UsuarioResponsableTras varchar(50),
in par_lotePedimento int,
in par_costo decimal(22,6),
in par_estado varchar(35),
in par_reporteSalida varchar(35), 
in par_reporteEntrada varchar(35)
)
BEGIN
UPDATE traspas
SET
prod = par_prod,
alma = par_alma,
concep = par_concep,
unid = par_unid,
cantsal = par_cantsal,
almaa = par_almaa,
cantent = par_cantent,
idempresa = par_id_empresa,
estac = par_estac,
sucu = par_sucu,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
UsuarioResponsableTras = par_UsuarioResponsableTras,
lotePedimento = par_lotePedimento,
costo = par_costo,
estado = par_estado,
reporteSalida = par_reporteSalida,
reporteEntrada = par_reporteEntrada
WHERE id_id = par_id_id;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_Venta`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_Venta`(
in par_vta int,
in par_norefer varchar(30),
in par_noser varchar(30),
in par_mon int,
in par_vend varchar(30),
in par_codcot varchar(30),
in par_folfisc varchar(100),
in par_transid varchar(100),
in par_sell varchar(1000),
in par_sellsat varchar(1000),
in par_certsat varchar(1000),
in par_lugexp varchar(100),
in par_regfisc varchar(255),
in par_cadori varchar(2000),
in par_cort varchar(5),
in par_referencia varchar(255), 
in par_formpag varchar(30),
in par_nocort int,
in par_venta_origen int,
in par_cierr int,
in par_vtadevp int,
in par_ptovta bit,
in par_catgral varchar(500),
in par_factu bit,
in par_tipcam float,
in par_total_traslado float,
in par_total_retencion float,
in par_tipdoc varchar(30),
in par_notcred varchar(30),
in par_notcredpag varchar(250),
in par_impnotcred float,
in par_totdescu float,
in par_totcost float,
in par_totcostprom float,
in par_totueps float,
in par_totpeps float,
in par_codemp varchar(30),
in par_ser varchar(30),
in par_metpag varchar(42),
in par_cta varchar(42),
in par_subtot float,
in par_impue float,
in par_tot float,
in par_tic int,
in par_estad varchar(10),
in par_motiv varchar(255),
in par_observ varchar(1000),
in par_timbr bit,
in par_idempresa varchar(30),
in par_estac varchar(30),
in par_sucu  varchar(30),
in par_nocaj varchar(30),
in par_export bit,
in par_extr1 varchar(255),
in par_extr2 varchar(255),
in par_extr3 varchar(255),
in par_vtaRef int, 
in par_usocfdi varchar(5), 
in par_tiporelacion varchar(5), 
in par_activo varchar(10) ,
in par_subramo varchar(10), 
in par_sector varchar(10), 
in par_id_tipodoc int, 
in par_id_emp int)
BEGIN
UPDATE vtas 
SET 
norefer = par_norefer,
noser = par_noser,
mon = par_mon,
vend = par_vend,
codcot = par_codcot,
folfisc = par_folfisc,
transid = par_transid,
sell = par_sell,
sellsat = par_sellsat,
certsat = par_certsat,
lugexp = par_lugexp,
regfisc = par_regfisc,
cadori = par_cadori,
cort = par_cort,
referencia = par_referencia,
formag = par_formpag,
nocort = par_nocort,
venta_origen = par_venta_origen,
cierr = par_cierr,
vtadevp = par_vtadevp,
ptovta = par_ptovta,
catgral = par_catgral,
factu = par_factu,
tipcam = par_tipcam,
total_traslado = par_total_traslado,
total_retencion = par_total_retencion,
tipdoc = par_tipdoc,
notcred = par_notcred,
notcredpag = par_notcredpag,
impnotcred = par_impnotcred,
totdescu = par_totdescu,
totcost = par_totcost,
totcostprom = par_totcostprom,
totueps = par_totueps,
totpeps = par_totpeps,
codemp = par_codemp,
ser = par_ser,
metpag = par_metpag,
cta = par_cta,
subtot = par_subtot,
impue = par_impue,
tot = par_tot,
tic = par_tic,
estad = par_estad,
motiv = par_motiv,
observ = par_observ,
timbr = par_timbr,
idempresa = par_idempresa,
estac = par_estac,
sucu = par_sucu,
nocaj = par_nocaj,
export = par_export,
extr1 = par_extr1,
extr2 = par_extr2,
extr3 = par_extr3,
vtaRef = par_vtaRef, 
usocfdi = par_usocfdi, 
tiporelacion = par_tiporelacion, 
activo = par_activo,
subramo = par_subramo,
sector = par_sector, 
tipodoc = par_id_tipodoc, 
id_emp = par_id_emp
where vta = par_vta;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_VentaLiberaRemision`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_VentaLiberaRemision`(in par_venta int, in par_id_empresa varchar(30))
BEGIN
	UPDATE vtas SET vtaRef = 0,  estad = 'PE' 
    WHERE vtaRef = par_venta AND idempresa = par_id_empresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `UPD_VentaPorVentaOrigen`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `UPD_VentaPorVentaOrigen`(in par_venta_origen int)
BEGIN
UPDATE vtas 
SET
estad = 'CO',
venta_origen = 0,
factu = 0
where venta_origen = par_venta_origen;
END//
DELIMITER ;

CREATE TABLE IF NOT EXISTS `usuarioserie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) DEFAULT NULL,
  `idserie` int(11) DEFAULT NULL,
  `idempresa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `viats` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `viat` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `viat` (`viat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `viatspro` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `codpro` varchar(30) NOT NULL,
  `codviat` varchar(30) NOT NULL,
  `pag` varchar(30) DEFAULT '',
  `nomper` varchar(255) DEFAULT '',
  `imp` double DEFAULT '0',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `f_de` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `f_a` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `codpro` (`codpro`),
  KEY `codviat` (`codviat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `vtas` (
  `vta` int(11) NOT NULL AUTO_INCREMENT,
  `norefer` varchar(30) NOT NULL,
  `noser` varchar(30) NOT NULL,
  `monedaID` int(11) NOT NULL DEFAULT '0',
  `vend` varchar(30) NOT NULL,
  `codcot` varchar(30) DEFAULT '',
  `folfisc` varchar(100) DEFAULT '',
  `transid` varchar(100) DEFAULT '',
  `sell` varchar(1000) DEFAULT '',
  `sellsat` varchar(1000) DEFAULT '',
  `certsat` varchar(1000) DEFAULT '',
  `lugexp` varchar(100) DEFAULT '',
  `regfisc` varchar(255) DEFAULT '',
  `cadori` varchar(2000) DEFAULT '',
  `cort` varchar(5) DEFAULT 'N',
  `formpag` varchar(30) NOT NULL,
  `nocort` int(11) DEFAULT '0',
  `venta_origen` int(11) DEFAULT '0',
  `cierr` int(11) DEFAULT '0',
  `vtadevp` int(11) DEFAULT '0',
  `ptovta` bit(1) DEFAULT b'0',
  `catgral` varchar(500) DEFAULT '',
  `factu` bit(1) DEFAULT b'0',
  `tipcam` decimal(22,6) NOT NULL,
  `tipcamnac` decimal(22,6) NOT NULL DEFAULT '0.000000',
  `total_traslado` decimal(22,6) DEFAULT '0.000000',
  `total_retencion` decimal(22,6) DEFAULT '0.000000',
  `tipdoc` varchar(30) NOT NULL,
  `notcred` varchar(30) DEFAULT '',
  `notcredpag` varchar(250) DEFAULT '',
  `impnotcred` decimal(22,6) DEFAULT '0.000000',
  `totdescu` decimal(22,6) DEFAULT '0.000000',
  `totcost` decimal(22,6) NOT NULL,
  `totcostprom` decimal(22,6) DEFAULT '0.000000',
  `totueps` decimal(22,6) DEFAULT '0.000000',
  `totpeps` decimal(22,6) DEFAULT '0.000000',
  `codemp` varchar(45) NOT NULL,
  `ser` varchar(30) NOT NULL,
  `metpag` varchar(42) NOT NULL,
  `cta` varchar(42) NOT NULL,
  `femi` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fent` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `subtot` decimal(22,6) NOT NULL,
  `impue` decimal(22,6) NOT NULL,
  `tot` decimal(22,6) NOT NULL,
  `tic` int(11) NOT NULL,
  `estad` varchar(10) NOT NULL,
  `motiv` varchar(255) NOT NULL,
  `observ` varchar(1000) NOT NULL,
  `timbr` bit(1) NOT NULL,
  `autrecibde` varchar(255) DEFAULT '',
  `autmarc` varchar(255) DEFAULT '',
  `autmod` varchar(255) DEFAULT '',
  `autcolo` varchar(100) DEFAULT '',
  `autplacs` varchar(255) DEFAULT '',
  `autnom` varchar(255) DEFAULT '',
  `auttarcirc` varchar(255) DEFAULT '',
  `autnumlic` varchar(255) DEFAULT '',
  `auttel` varchar(255) DEFAULT '',
  `autdirpart` varchar(255) DEFAULT '',
  `autdirofi` varchar(255) DEFAULT '',
  `auttelofi` varchar(255) DEFAULT '',
  `autimpo` decimal(22,6) DEFAULT '0.000000',
  `autmotiv` varchar(255) DEFAULT '',
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT '',
  `extr2` varchar(255) DEFAULT '',
  `extr3` varchar(255) DEFAULT '',
  `fvenc` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `usocfdi` varchar(5) NOT NULL,
  `tiporelacion` varchar(5) NOT NULL DEFAULT '',
  `activo` varchar(10) NOT NULL DEFAULT '',
  `subramo` varchar(10) NOT NULL DEFAULT '',
  `sector` varchar(10) NOT NULL DEFAULT '',
  `vtaRef` int(11) DEFAULT '0',
  `id_tipodoc` int(11) NOT NULL DEFAULT '0',
  `id_emp` int(11) DEFAULT '0',
  `referencia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vta`),
  KEY `norefer` (`norefer`),
  KEY `noser` (`noser`),
  KEY `monedaid` (`monedaID`),
  KEY `cliente` (`codemp`,`idempresa`),
  KEY `tipodocumento` (`tipdoc`),
  KEY `ix_norefer` (`idempresa`,`codemp`,`tipdoc`,`norefer`),
  KEY `ix_ventarelacion` (`vtaRef`,`idempresa`),
  KEY `ix_noser` (`idempresa`,`codemp`,`tipdoc`,`noser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `zona` (
  `id_id` int(11) NOT NULL AUTO_INCREMENT,
  `cod` varchar(30) NOT NULL,
  `descrip` varchar(255) NOT NULL,
  `idempresa` varchar(30) NOT NULL,
  `estac` varchar(30) NOT NULL,
  `sucu` varchar(30) NOT NULL,
  `nocaj` varchar(30) NOT NULL,
  `export` bit(1) DEFAULT b'0',
  `extr1` varchar(255) DEFAULT NULL,
  `extr2` varchar(255) DEFAULT NULL,
  `extr3` varchar(255) DEFAULT NULL,
  `falt` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fmod` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_id`),
  UNIQUE KEY `id_id_UNIQUE` (`id_id`),
  KEY `cod` (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `emps_BEFORE_INSERT` BEFORE INSERT ON `emps` FOR EACH ROW BEGIN
SET new.codigo = CONCAT(new.ser,new.codemp);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `provs_BEFORE_INSERT` BEFORE INSERT ON `provs` FOR EACH ROW BEGIN
SET new.codigo = CONCAT(new.ser,new.prov);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

DROP PROCEDURE IF EXISTS `CargaHistorico_ExistenciaPorAlmacen`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CargaHistorico_ExistenciaPorAlmacen`()
BEGIN
#Buscar el corte del dia
SET @fecha = date_format(now(), '%Y-%m-%d');
SET @corte = (SELECT idCorte FROM cortes where dia = @fecha AND hora = 0);

#Agregar datos para el corte
CALL Historico_ExistenciaPorAlmacen(@corte);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `CargaHistorico_CXCAntiguedadDeSaldo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CargaHistorico_CXCAntiguedadDeSaldo`()
BEGIN
#Buscar el corte del dia
SET @fecha = date_format(now(), '%Y-%m-%d');
SET @corte = (SELECT idCorte FROM cortes where dia = @fecha AND hora = 0);

#Agregar datos para el corte
CALL Historico_CXCAntiguedadDeSaldo(@corte);
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `Historico_ExistenciaPorAlmacen`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Historico_ExistenciaPorAlmacen`(in par_corte int)
BEGIN
DELETE FROM hist_existenciaporalmacen where idCorte = par_corte;

INSERT INTO hist_existenciaporalmacen
SELECT DISTINCT
par_corte as idCorte, 
existalma.idempresa,
existalma.PROD,
prods.descrip, 
ifnull(unid,'') unid, 
existalma.ALMA,
clasjera,
codmed,
prods.CODUBI,
prods.ANAQ,
lug,
lin,
marc,
prods.IMPUE,
codext,
existalma.EXIST AS exist
FROM existalma 
LEFT OUTER JOIN prods ON prods.PROD = existalma.PROD  AND prods.idempresa = existalma.idempresa
LEFT OUTER JOIN almas ON almas.ALMA = existalma.ALMA  AND almas.idempresa = existalma.idempresa;
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS `Historico_CXCAntiguedadDeSaldo`;

DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `Historico_CXCAntiguedadDeSaldo`(in par_corte int)
BEGIN

DELETE FROM hist_antiguedaddesaldo where idCorte = par_corte;

INSERT INTO hist_antiguedaddesaldo(idCorte, nom,codemp,ven,Anti15, Anti30, Anti45,Anti45Mas)
SELECT par_corte as idCorte, ifnull(emps.nom,'') nom, b.codemp, ven, Anti15, Anti30, Anti45, Anti45Mas  FROM (
SELECT 
IFNULL(a.CODEMP,'') AS codemp,
idempresa,
IFNULL(SUM(CASE WHEN carg > abon AND diasvenc >= 0 THEN carg ELSE 0 END),0)-IFNULL(SUM(CASE WHEN carg > abon AND diasvenc >= 0 THEN abon ELSE 0 END),0) AS ven, 
IFNULL(SUM(CASE WHEN carg > abon AND diasvenc <= 15 AND diasvenc >= 0 THEN carg ELSE 0 END),0)-IFNULL(SUM(CASE WHEN carg > abon AND diasvenc <= 15 AND diasvenc >= 0 THEN abon ELSE 0 END),0) AS Anti15,
IFNULL(SUM(CASE WHEN carg > abon AND diasvenc <= 30 AND diasvenc >= 16 THEN carg ELSE 0 END),0)-IFNULL(SUM(CASE WHEN carg > abon AND diasvenc <= 30 AND diasvenc >= 16 THEN abon ELSE 0 END),0) AS Anti30,
IFNULL(SUM(CASE WHEN carg > abon AND diasvenc <= 45 AND diasvenc >= 31 THEN carg ELSE 0 END),0)-IFNULL(SUM(CASE WHEN carg > abon AND diasvenc <= 45 AND diasvenc >= 31 THEN abon ELSE 0 END),0) AS Anti45,
IFNULL(SUM(CASE WHEN carg > abon AND diasvenc >= 46 THEN carg ELSE 0 END),0)-IFNULL(SUM(CASE WHEN carg > abon AND diasvenc >= 46 THEN abon ELSE 0 END),0) AS Anti45Mas
FROM
(
SELECT 
empre AS codemp,
idempresa AS idempresa,
DATEDIFF(DATE(NOW()), DATE(fvenc)) as diasvenc,
sum(carg) AS carg,
sum(abon) AS abon
FROM cxc 
WHERE 
concep in ('FAC','TIK')
GROUP BY empre, idempresa,diasvenc) a GROUP BY a.codemp,a.idempresa) b
LEFT OUTER JOIN emps ON b.codemp = emps.codigo and b.idempresa = emps.idempresa 
WHERE ven > 0;

END//
DELIMITER ;


DROP TABLE IF EXISTS `vw_encabezadoclientes`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_encabezadoclientes` AS select `emps`.`codemp` AS `codemp`,`emps`.`ser` AS `ser`,`emps`.`nom` AS `nom`,`emps`.`idempresa` AS `idempresa`,`emps`.`tel` AS `tel`,`emps`.`telper1` AS `telper1`,`emps`.`telper2` AS `telper2`,`emps`.`calle` AS `calle`,`emps`.`col` AS `col`,`emps`.`CP` AS `CP`,`emps`.`ciu` AS `ciu`,`emps`.`estad` AS `estad`,`emps`.`RFC` AS `RFC`,`emps`.`descu` AS `descu`,`emps`.`co1` AS `co1`,`emps`.`co2` AS `co2`,`emps`.`co3` AS `co3`,`emps`.`pagweb1` AS `pagweb1`,`emps`.`pagweb2` AS `pagweb2`,`emps`.`observ` AS `observ`,`emps`.`noint` AS `noint`,`emps`.`noext` AS `noext`,`emps`.`diacred` AS `diacred`,`emps`.`limtcred` AS `limtcred`,`emps`.`falt` AS `falt`,`emps`.`fmod` AS `fmod`,`emps`.`contact2` AS `contact2`,`emps`.`puest2` AS `puest2` from `emps`;

DROP TABLE IF EXISTS `vw_encabezadoventas`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_encabezadoventas` AS select `vtas`.`cadori` AS `cadori`,`vtas`.`catgral` AS `catgral`,`vtas`.`certsat` AS `certsat`,`vtas`.`cierr` AS `cierr`,`vtas`.`codemp` AS `codemp`,`vtas`.`cort` AS `cort`,`vtas`.`estac` AS `estac`,`vtas`.`cta` AS `cta`,`vtas`.`estad` AS `estad`,`vtas`.`export` AS `export`,`vtas`.`extr1` AS `extr1`,`vtas`.`extr2` AS `extr2`,`vtas`.`extr3` AS `extr3`,`vtas`.`factu` AS `factu`,`vtas`.`falt` AS `falt`,`vtas`.`femi` AS `femi`,`vtas`.`fent` AS `fent`,`vtas`.`fmod` AS `fmod`,`vtas`.`folfisc` AS `folfisc`,`vtas`.`formpag` AS `formpag`,`vtas`.`fvenc` AS `fvenc`,`vtas`.`idempresa` AS `idempresa`,`vtas`.`impnotcred` AS `impnotcred`,`vtas`.`impue` AS `impue`,`vtas`.`lugexp` AS `lugexp`,`vtas`.`metpag` AS `metpag`,`vtas`.`monedaID` AS `monedaID`,`vtas`.`motiv` AS `motiv`,`vtas`.`nocaj` AS `nocaj`,`vtas`.`nocort` AS `nocort`,`vtas`.`norefer` AS `norefer`,`vtas`.`noser` AS `noser`,`vtas`.`notcred` AS `notcred`,`vtas`.`notcredpag` AS `notcredpag`,`vtas`.`observ` AS `observ`,`vtas`.`ptovta` AS `ptovta`,`vtas`.`regfisc` AS `regfisc`,`vtas`.`sell` AS `sell`,`vtas`.`sellsat` AS `sellsat`,`vtas`.`ser` AS `ser`,`vtas`.`subtot` AS `subtot`,`vtas`.`sucu` AS `sucu`,`vtas`.`tic` AS `tic`,`vtas`.`timbr` AS `timbr`,`vtas`.`tipcam` AS `tipcam`,`vtas`.`tipdoc` AS `tipdoc`,`vtas`.`tot` AS `tot`,`vtas`.`total_retencion` AS `total_retencion`,`vtas`.`total_traslado` AS `total_traslado`,`vtas`.`totcost` AS `totcost`,`vtas`.`totcostprom` AS `totcostprom`,`vtas`.`totdescu` AS `totdescu`,`vtas`.`totpeps` AS `totpeps`,`vtas`.`totueps` AS `totueps`,`vtas`.`transid` AS `transid`,`vtas`.`vend` AS `vend`,`vtas`.`venta_origen` AS `venta_origen`,`vtas`.`vtadevp` AS `vtadevp`,`vtas`.`vta` AS `vta`,`mons`.`mon` AS `mon`,`cc`.`codcot` AS `codcot2`,`e`.`nom` AS `nom` from ((((`vtas` left join `emps` on(((`vtas`.`codemp` = `emps`.`codigo`) and (`emps`.`idempresa` = `vtas`.`idempresa`)))) left join `mons` on(((`vtas`.`monedaID` = `mons`.`id_id`) and (`mons`.`idempresa` = `vtas`.`idempresa`)))) left join (select `cots`.`codcot` AS `codcot`,`cots`.`idempresa` AS `idempresa`,`cots`.`vta` AS `vta` from `cots`) `cc` on(((`vtas`.`vta` = `cc`.`vta`) and (`vtas`.`idempresa` = `cc`.`idempresa`)))) left join (select `estacs`.`idempresa` AS `idempresa`,`estacs`.`estac` AS `estac`,`estacs`.`nom` AS `nom` from `estacs`) `e` on(((`e`.`idempresa` = `vtas`.`idempresa`) and (`e`.`estac` = `vtas`.`estac`))));

DROP TABLE IF EXISTS `vw_filtroencabezadoventas`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vw_filtroencabezadoventas` AS select `vtas`.`codemp` AS `codemp`,`vtas`.`estad` AS `estad`,`vtas`.`factu` AS `factu`,`vtas`.`femi` AS `femi`,`vtas`.`idempresa` AS `idempresa`,`vtas`.`norefer` AS `norefer`,`vtas`.`noser` AS `noser`,`vtas`.`tipdoc` AS `tipdoc`,`vtas`.`vta` AS `vta`,`e`.`nom` AS `nom` from ((`vtas` left join `emps` on(((`vtas`.`codemp` = `emps`.`codigo`) and (`emps`.`idempresa` = `vtas`.`idempresa`)))) left join (select `estacs`.`idempresa` AS `idempresa`,`estacs`.`estac` AS `estac`,`estacs`.`nom` AS `nom` from `estacs`) `e` on(((`e`.`idempresa` = `vtas`.`idempresa`) and (`e`.`estac` = `vtas`.`estac`))));

CREATE EVENT ev_CXCAntiguedadDeSaldo
ON SCHEDULE 
    EVERY 1 DAY
    STARTS str_to_date( date_format(now(), '%Y%m%d 0100'), '%Y%m%d %H%i' ) 
DO 
CALL CargaHistorico_CXCAntiguedadDeSaldo;

CREATE EVENT ev_ExistenciaPorAlmacen
ON SCHEDULE 
    EVERY 1 DAY
    STARTS str_to_date( date_format(now(), '%Y%m%d 0200'), '%Y%m%d %H%i' ) 
DO 
CALL CargaHistorico_ExistenciaPorAlmacen;

DROP procedure IF EXISTS `SEL_AlmacenPorAlma`;

DELIMITER $$

CREATE PROCEDURE `SEL_AlmacenPorAlma` (
in par_alma varchar(30),
in par_idempresa varchar(30))
BEGIN
  select id_id, alma, respon, almadescrip, dir1, dir2, dir3, actfij, idempresa, estac, sucu, nocaj, export, extr1, extr2, extr3, falt, fmod
    from almas
    where alma = par_alma and idempresa = par_idempresa;
END$$

DELIMITER ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
