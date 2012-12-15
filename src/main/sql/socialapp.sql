-- MySQL dump 10.13  Distrib 5.5.28, for Win32 (x86)
--
-- Host: localhost    Database: socialapp
-- ------------------------------------------------------
-- Server version	5.5.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'La Paz'),(2,'Cochabamba'),(3,'Santa Cruz'),(4,'Beni'),(5,'Chuquisaca'),(6,'Oruro'),(7,'Pando'),(8,'Potosí'),(9,'Tarija'),(10,'El Alto');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conflicto`
--

DROP TABLE IF EXISTS `conflicto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conflicto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `actorDemandante` varchar(255) DEFAULT NULL,
  `actorDemandado` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  `localidad` bigint(20) DEFAULT NULL,
  `demanda` varchar(255) DEFAULT NULL,
  `sumary` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `ambito` varchar(255) DEFAULT NULL,
  `alcance` varchar(255) DEFAULT NULL,
  `medidaPresion` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `situacion` varchar(255) DEFAULT NULL,
  `fuente` varchar(255) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `hora` datetime NOT NULL,
  `lugar` varchar(120) NOT NULL,
  `mapX` float DEFAULT NULL,
  `mapY` float DEFAULT NULL,
  `ratio` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `hitoId` bigint(20) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conflicto`
--

LOCK TABLES `conflicto` WRITE;
/*!40000 ALTER TABLE `conflicto` DISABLE KEYS */;
INSERT INTO `conflicto` VALUES (16,'Plza Isabel laCatolica',NULL,NULL,NULL,NULL,'Comunarios de Mecapaca demandan terrenos para vivir y justifican el avasallamiento en esta ciudad.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-12-08 06:59:41','Plza Isabel laCatolica',-16.509,-68.1244,5,'La Paz',16,'Zona Central'),(18,'Plaza Murillo',NULL,NULL,NULL,NULL,'Trabajadores de Aerosur rechazan a la intervencion de la empresa.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-12-08 07:12:47','Plaza Murillo',-16.4957,-68.1336,5,'La Paz',15,'Zona Central'),(19,'Ceja',NULL,NULL,NULL,NULL,'Pobladores de Laja exigen el mejoramiento de caminos y el asfaltado de la via Avircato.',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-12-08 07:14:29','Ceja',-16.5035,-68.1621,5,'El Alto',7,'Zona Norte');
/*!40000 ALTER TABLE `conflicto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidad`
--

DROP TABLE IF EXISTS `localidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidad` (
  `id` double NOT NULL,
  `provinceId` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidad`
--

LOCK TABLES `localidad` WRITE;
/*!40000 ALTER TABLE `localidad` DISABLE KEYS */;
INSERT INTO `localidad` VALUES (1,1,'La Paz');
/*!40000 ALTER TABLE `localidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id` double NOT NULL,
  `cityId` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES (1,1,'Murillo');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rutahito`
--

DROP TABLE IF EXISTS `rutahito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutahito` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  `mapX` float DEFAULT NULL,
  `mapY` float DEFAULT NULL,
  `ratio` int(11) DEFAULT NULL,
  `zoom` int(11) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutahito`
--

LOCK TABLES `rutahito` WRITE;
/*!40000 ALTER TABLE `rutahito` DISABLE KEYS */;
INSERT INTO `rutahito` VALUES (1,'6 de Agosto','Zona Central',-16.5102,-68.1251,5,15,'La Paz'),(2,'6 de Marzo','Zona Norte',-16.5063,-68.1636,5,12,'El Alto'),(3,'Autopista','Zona Norte',-16.4967,-68.1643,5,12,'La Paz'),(4,'Av. Bolivia','Zona Norte',-16.5146,-68.2181,5,15,'El Alto'),(5,'Calle 8 de Calacoto','Zona Sur',-16.5413,-68.0915,5,12,'La Paz'),(6,'Camacho','Zona Central',-16.4994,-68.1333,5,12,'La Paz'),(7,'Ceja','Zona Norte',-16.5035,-68.1621,5,15,'El Alto'),(8,'Cerveceria','Zona Norte',-16.4885,-68.144,5,12,'La Paz'),(9,'Ex tranca Rio Seco','Zona Norte',-16.5447,-68.2145,5,12,'El Alto'),(10,'Mariscal Santa Cruz','Zona Central',-16.4969,-68.1363,5,12,'La Paz'),(11,'Montes','Zona Norte',-16.4917,-68.1383,5,12,'La Paz'),(12,'Obrajes calle 17','Zona Sur',-16.5297,-68.0915,5,16,'La Paz'),(13,'Perez Velasco','Zona Central',-16.4963,-68.1366,5,12,'La Paz'),(14,'Plaza Avaroa','Zona Central',-16.5106,-68.1267,5,12,'La Paz'),(15,'Plaza Murillo','Zona Central',-16.4957,-68.1336,5,12,'La Paz'),(16,'Plza Isabel laCatolica','Zona Central',-16.509,-68.1244,5,15,'La Paz'),(17,'Prado','Zona Central',-16.5023,-68.1326,5,12,'La Paz'),(18,'San Miguel ','Zona Sur',-16.5391,-68.0781,5,15,'La Paz'),(19,'Santa Vera Cruz','Zona Norte',-16.5447,-68.2145,5,12,'El Alto'),(20,'Senkata','Zona Norte',-16.5,-68.1386,5,12,'El Alto');
/*!40000 ALTER TABLE `rutahito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipology`
--

DROP TABLE IF EXISTS `tipology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipology` (
  `id` double NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipology`
--

LOCK TABLES `tipology` WRITE;
/*!40000 ALTER TABLE `tipology` DISABLE KEYS */;
INSERT INTO `tipology` VALUES (1,'Cuestionamiento y/o reconocimiento de autoridad'),(2,'Derechos humanos'),(3,'Gestión administrativa'),(4,'Gestión del espacio urbano'),(5,'Ideológico/político'),(6,'Incumplimiento de convenios'),(7,'Laboral/salarial'),(8,'Leyes/medidas legales'),(9,'Límites político-administrativos'),(10,'Medidas económicas/situación económica'),(11,'Prestación de servicios públicos'),(12,'Recursos naturales y medio ambiente'),(13,'Seguridad ciudadana'),(14,'Tierra'),(15,'Valores/creencias/identidad'),(16,'Vivienda'),(17,'Otro');
/*!40000 ALTER TABLE `tipology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `mobile` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `tweeter` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sendByEmail` tinyint(1) DEFAULT NULL,
  `sendByMobile` tinyint(1) DEFAULT NULL,
  `sendByTweeter` tinyint(1) DEFAULT NULL,
  `username` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `authentication` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Milton Loayza','milton.loayza@gmail.com','123','76775306','@miltonloayza',1,1,1,'milton.loayza@gmail.com',NULL),(2,NULL,'rhuanca@gmail.com','ed7eaa3990e7cc091588d8cb0393194be6665fee',NULL,NULL,NULL,NULL,NULL,'rhuanca@gmail.com','USER_PASSWORD');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userroute`
--

DROP TABLE IF EXISTS `userroute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userroute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `p1` bigint(20) DEFAULT NULL,
  `p2` bigint(20) DEFAULT NULL,
  `alertType` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `googleRoute` varchar(10000) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroute`
--

LOCK TABLES `userroute` WRITE;
/*!40000 ALTER TABLE `userroute` DISABLE KEYS */;
INSERT INTO `userroute` VALUES (6,2,19,10,'R','{\"start\":{\"lat\":-16.54484,\"lng\":-68.21438},\"end\":{\"lat\":-16.49693,\"lng\":-68.13637},\"points\":[[-16.54471,-68.2142],[-16.54291,-68.21578],[-16.52968,-68.19601999999998],[-16.53461,-68.19078999999999],[-16.51633,-68.16687999999999],[-16.50322000000001,-68.16254000000004],[-16.4922,-68.1379],[-16.49637,-68.13662]]}');
/*!40000 ALTER TABLE `userroute` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-08  7:30:05
