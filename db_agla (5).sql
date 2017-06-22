-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-06-2017 a las 12:03:28
-- Versión del servidor: 10.1.19-MariaDB
-- Versión de PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_agla`
--
CREATE DATABASE IF NOT EXISTS `db_agla` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `db_agla`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencia`
--

DROP TABLE IF EXISTS `licencia`;
CREATE TABLE IF NOT EXISTS `licencia` (
  `REF_CATASTRAL` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `TIPO_SUELO` enum('URBANO','RURAL') COLLATE utf8_spanish_ci NOT NULL,
  `EMPLAZAMIENTO` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `ACTIVIDAD` enum('SUELO CALIFICADO COMO INDUSTRIAL','SUELO URBANO NO CALIFICADO COMO INDUSTRIAL','CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS','SEGUROS, CAJA DE PENSIONES','BARES, CAFETERIAS, RESTAURANTES','SALONES RECREATIVOS Y DE JUEGO','ESTABLECIMIENTOS, SECTOR ALIMENTICIO','HOTELES,HOSTALES Y PENSIONES','TERRAZAS DE VERANO','GASOLINERAS') COLLATE utf8_spanish_ci NOT NULL,
  `MEMORIA_ACTIVIDAD` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `PLANOS_LOCAL` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_OBRA` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `CERTIFICADO_TECNICO1` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `CERTIFICADO_COLEGIO_OFICIAL2` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `DNI_titular` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `FechaSolicitud` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `FechaInicioActividad` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `EstadoLicencia` enum('EN TRAMITE','DENEGADA','ACEPTADA','ARCHIVADA') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'EN TRAMITE',
  `DescripcionActividad` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`REF_CATASTRAL`),
  UNIQUE KEY `REF_CATASTRAL` (`REF_CATASTRAL`),
  UNIQUE KEY `REF_CATASTRAL_2` (`REF_CATASTRAL`),
  KEY `DNI_titular` (`DNI_titular`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `licencia`
--

INSERT INTO `licencia` (`REF_CATASTRAL`, `TIPO_SUELO`, `EMPLAZAMIENTO`, `ACTIVIDAD`, `MEMORIA_ACTIVIDAD`, `PLANOS_LOCAL`, `FOTOCOPIA_OBRA`, `CERTIFICADO_TECNICO1`, `CERTIFICADO_COLEGIO_OFICIAL2`, `DNI_titular`, `FechaSolicitud`, `FechaInicioActividad`, `EstadoLicencia`, `DescripcionActividad`) VALUES
('111', 'RURAL', 'CALLE', 'BARES, CAFETERIAS, RESTAURANTES', 'SI', 'NO', 'SI', 'NO', 'SI', '987453C', '14/06/2017', '08/06/2017', 'ACEPTADA', 'LICENCIA PARA BAR IRLANDÉS.'),
('3234', 'URBANO', 'PLAZA', 'CAJAS DE AHORROS,BANCOS, ENTIDADES FINANCIERAS', 'NO', 'SI', 'NO', 'SI', 'NO', '345678G', '11/06/2017', '18/06/2017', 'DENEGADA', 'JORGEEE'),
('33333', 'URBANO', 'LUENA', 'SUELO URBANO NO CALIFICADO COMO INDUSTRIAL', 'SI', 'NO', 'SI', 'SI', 'SI', '876543WF', '09/06/2017', '08/06/2017', 'DENEGADA', 'JHGFC'),
('8888', 'RURAL', 'CALLE BLANCO', 'SUELO URBANO NO CALIFICADO COMO INDUSTRIAL', 'SI', 'SI', 'NO', 'SI', 'SI', '5675443F', '08/06/2017', '17/06/2017', 'ACEPTADA', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `modificaciones`
--

DROP TABLE IF EXISTS `modificaciones`;
CREATE TABLE IF NOT EXISTS `modificaciones` (
  `AntiguoTitular` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `FechaAntiguoTitular` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `NuevoTitular` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `FechaNuevoTitular` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LICENCIAANT` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `ESCRITURAS` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `NUMEXPEDIENTE` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `PLANOS` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `REGISTRO` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `REGISTRO` (`REGISTRO`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `modificaciones`
--

INSERT INTO `modificaciones` (`AntiguoTitular`, `FechaAntiguoTitular`, `NuevoTitular`, `FechaNuevoTitular`, `id`, `LICENCIAANT`, `ESCRITURAS`, `NUMEXPEDIENTE`, `PLANOS`, `REGISTRO`) VALUES
('345678G', '', '345678G', 'Sun Jun 11 20:33:25 CEST 2017', 34, 'NO', 'NO', 'NO', 'NO', 34),
('345678G', '', '345678G', 'Sun Jun 11 20:38:35 CEST 2017', 35, 'SI', 'SI', 'NO', 'SI', 34),
('987453C', '', '987453C', 'Sun Jun 11 20:39:07 CEST 2017', 36, 'NO', 'NO', 'SI', 'SI', 33),
('987453C', '', '987453C', 'Sun Jun 11 20:40:02 CEST 2017', 37, 'SI', 'NO', 'NO', 'SI', 33),
('345678G', '', '345678G', 'Sun Jun 11 21:58:48 CEST 2017', 38, 'NO', 'NO', 'NO', 'NO', 34),
('345678G', '', '345678G', '11/06/2017', 39, 'NO', 'NO', 'NO', 'NO', 34),
('345678G', '18/06/2017', '345678G', '15/06/2017', 40, 'NO', 'NO', 'NO', 'NO', 34),
('987453C', '', '987453C', '15/06/2017', 41, 'SI', 'SI', 'SI', 'NO', 33),
('345678G', '18/06/2017', '345678G', '15/06/2017', 42, 'NO', 'NO', 'NO', 'NO', 34);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representante`
--

DROP TABLE IF EXISTS `representante`;
CREATE TABLE IF NOT EXISTS `representante` (
  `CIF_NIF_NIE` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `REGISTRO` int(11) NOT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `APELLIDOS` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `MUNICIPIO` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `COD_POSTAL` int(5) NOT NULL,
  `DIRECCION` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `TELF_MOVIL` int(22) NOT NULL,
  `TELF_FIJO` int(22) NOT NULL,
  `EMAIL` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`CIF_NIF_NIE`),
  KEY `REGISTRO` (`REGISTRO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `representante`
--

INSERT INTO `representante` (`CIF_NIF_NIE`, `REGISTRO`, `NOMBRE`, `APELLIDOS`, `MUNICIPIO`, `COD_POSTAL`, `DIRECCION`, `TELF_MOVIL`, `TELF_FIJO`, `EMAIL`) VALUES
('34567F', 33, 'taysir', 'al-shareef', 'valdemoro', 0, 'valdemoro', 45678, 0, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titular`
--

DROP TABLE IF EXISTS `titular`;
CREATE TABLE IF NOT EXISTS `titular` (
  `CIF_NIF_NIE` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `REGISTRO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `APELLIDOS` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `MUNICIPIO` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `COD_POSTAL` int(5) DEFAULT NULL,
  `DIRECCION` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `TELEFONO_MOVIL` int(22) NOT NULL,
  `TELEFONO_FIJO` int(22) DEFAULT NULL,
  `EMAIL` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TIPO_SOLICITANTE` enum('FISICA','JURIDICA') COLLATE utf8_spanish_ci NOT NULL,
  `FOTOCOPIA_DNI_CIF_NIE` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOGRAFIAS` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_ACTIVIDAD` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_ESCRITURAS` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `JUSTIFICANTE_PAGO` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `FOTOCOPIA_OTROS` enum('SI','NO') COLLATE utf8_spanish_ci NOT NULL DEFAULT 'NO',
  `RAZON_SOCIAL` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FAX` int(11) NOT NULL,
  PRIMARY KEY (`CIF_NIF_NIE`),
  UNIQUE KEY `REGISTRO` (`REGISTRO`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `titular`
--

INSERT INTO `titular` (`CIF_NIF_NIE`, `REGISTRO`, `NOMBRE`, `APELLIDOS`, `MUNICIPIO`, `COD_POSTAL`, `DIRECCION`, `TELEFONO_MOVIL`, `TELEFONO_FIJO`, `EMAIL`, `TIPO_SOLICITANTE`, `FOTOCOPIA_DNI_CIF_NIE`, `FOTOGRAFIAS`, `FOTOCOPIA_ACTIVIDAD`, `FOTOCOPIA_ESCRITURAS`, `JUSTIFICANTE_PAGO`, `FOTOCOPIA_OTROS`, `RAZON_SOCIAL`, `FAX`) VALUES
('345678G', 34, 'HGVC', 'PINERO', 'VALDEMORO', 34566, 'MOLINILLOS 23', 0, 0, '', 'FISICA', 'SI', 'SI', 'NO', 'NO', 'SI', 'SI', NULL, 0),
('5675443F', 37, 'JESUS', 'ARLON', 'LOGROÑO', 27865, 'CALLE EMBRIORI 33', 0, 0, '', 'FISICA', 'SI', 'SI', 'SI', 'NO', 'NO', 'NO', NULL, 0),
('654645654G', 36, 'XCVC', 'CVC', 'FGCDX', 0, 'XDFVCX', 0, 0, '', 'FISICA', 'SI', 'SI', 'NO', 'NO', 'NO', 'NO', NULL, 0),
('876543WF', 35, 'MANUEH', 'DFGH', 'DFGH', 0, 'HGFDX', 0, 0, '', 'FISICA', 'SI', 'NO', 'NO', 'SI', 'SI', 'SI', NULL, 0),
('987453C', 33, NULL, NULL, 'LAS MATAS', 29440, 'PARQUE EMPRESARIAL EUROPA', 0, 916764523, 'UTAD@GMAIL.COM', 'JURIDICA', 'SI', 'SI', 'NO', 'SI', 'NO', 'SI', 'SNE', 0);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `licencia`
--
ALTER TABLE `licencia`
  ADD CONSTRAINT `licencia_ibfk_1` FOREIGN KEY (`DNI_titular`) REFERENCES `titular` (`CIF_NIF_NIE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `modificaciones`
--
ALTER TABLE `modificaciones`
  ADD CONSTRAINT `modificaciones_ibfk_1` FOREIGN KEY (`REGISTRO`) REFERENCES `titular` (`REGISTRO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `representante`
--
ALTER TABLE `representante`
  ADD CONSTRAINT `representante_ibfk_1` FOREIGN KEY (`REGISTRO`) REFERENCES `titular` (`REGISTRO`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para licencia
--

--
-- Metadatos para modificaciones
--

--
-- Metadatos para representante
--

--
-- Metadatos para titular
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'db_agla', 'titular', '{"sorted_col":"`FOTOCOPIA_DNI_CIF_NIE` ASC"}', '2017-06-09 07:20:38');

--
-- Metadatos para db_agla
--

--
-- Volcado de datos para la tabla `pma__pdf_pages`
--

INSERT INTO `pma__pdf_pages` (`db_name`, `page_descr`) VALUES
('db_agla', 'pag1');

SET @LAST_PAGE = LAST_INSERT_ID();

--
-- Volcado de datos para la tabla `pma__table_coords`
--

INSERT INTO `pma__table_coords` (`db_name`, `table_name`, `pdf_page_number`, `x`, `y`) VALUES
('db_agla', 'licencia', @LAST_PAGE, 542, 11),
('db_agla', 'titular', @LAST_PAGE, 57, 15);

--
-- Volcado de datos para la tabla `pma__pdf_pages`
--

INSERT INTO `pma__pdf_pages` (`db_name`, `page_descr`) VALUES
('db_agla', 'pag1');

SET @LAST_PAGE = LAST_INSERT_ID();

--
-- Volcado de datos para la tabla `pma__table_coords`
--

INSERT INTO `pma__table_coords` (`db_name`, `table_name`, `pdf_page_number`, `x`, `y`) VALUES
('db_agla', 'licencia', @LAST_PAGE, 30, 492),
('db_agla', 'modificaciones', @LAST_PAGE, 511, 33),
('db_agla', 'titular', @LAST_PAGE, 425, 374);

--
-- Volcado de datos para la tabla `pma__pdf_pages`
--

INSERT INTO `pma__pdf_pages` (`db_name`, `page_descr`) VALUES
('db_agla', 'pag2');

SET @LAST_PAGE = LAST_INSERT_ID();

--
-- Volcado de datos para la tabla `pma__table_coords`
--

INSERT INTO `pma__table_coords` (`db_name`, `table_name`, `pdf_page_number`, `x`, `y`) VALUES
('db_agla', 'licencia', @LAST_PAGE, 518, 101),
('db_agla', 'modificaciones', @LAST_PAGE, 647, 477),
('db_agla', 'representante', @LAST_PAGE, 411, 519),
('db_agla', 'titular', @LAST_PAGE, 63, 83);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
