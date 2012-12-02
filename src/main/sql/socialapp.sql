-- MySQL dump 10.13  Distrib 5.1.61, for apple-darwin10.3.0 (i386)
--
-- Host: localhost    Database: socialapp
-- ------------------------------------------------------
-- Server version	5.1.61-log

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
  `id` bigint(20) NOT NULL,
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
  `mapX` varchar(255) DEFAULT NULL,
  `mapY` varchar(255) DEFAULT NULL,
  `ratio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conflicto`
--

LOCK TABLES `conflicto` WRITE;
/*!40000 ALTER TABLE `conflicto` DISABLE KEYS */;
INSERT INTO `conflicto` VALUES (1,'z Exigen  la conclusión de las obras viales, puesto que tendrían  un retraso de 60 dias ','Comerciantes de la calle Zoilo Flores','Alcaldía de La Paz','Indígena (organización matriz)',1,'z Exigen  la conclusión de las obras viales, puesto que tendrían  un retraso de 60 dias ',NULL,'2012-11-10 00:00:00',NULL,NULL,'Protestan por segundo dia','3.0',NULL,'continua','Cambio','2012-11-01',NULL,'0000-00-00 00:00:00','',NULL,NULL,NULL);
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
-- Table structure for table `rutaHito`
--

DROP TABLE IF EXISTS `rutaHito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rutaHito` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `zone` varchar(255) DEFAULT NULL,
  `mapX` varchar(255) DEFAULT NULL,
  `mapY` varchar(255) DEFAULT NULL,
  `ratio` varchar(255) DEFAULT NULL,
  `zoom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutaHito`
--

LOCK TABLES `rutaHito` WRITE;
/*!40000 ALTER TABLE `rutaHito` DISABLE KEYS */;
INSERT INTO `rutaHito` VALUES (1,'6 de Agosto','Zona Central','-16.510244','-68.125105','5','15'),(2,'6 de Marzo (El Alto)','Zona Norte','-16.506253','-68.163611','5','12'),(3,'Autopista','Zona Norte','-16.496748','-68.16433','5','12'),(4,'Av. Bolivia (El Alto)','Zona Norte','-16.514626','-68.218124','5','15'),(5,'Calle 8 de Calacoto','Zona Sur','-16.541333','-68.091481','5','12'),(6,'Camacho','Zona Central','-16.499381','-68.133302','5','12'),(7,'Ceja (El Alto)','Zona Norte','-16.503507','-68.16206','5','15'),(8,'Cerveceria','Zona Norte','-16.488528','-68.143998','5','12'),(9,'Ex tranca Rio Seco (El Alto)','Zona Norte','-16.544721','-68.214455','5','12'),(10,'Mariscal Santa Cruz','Zona Central','-16.496851','-68.13630','5','12'),(11,'Montes','Zona Norte','-16.491687','-68.138344','5','12'),(12,'Obrajes calle 17','Zona Sur','-16.529664','-68.091481','5','16'),(13,'Perez Velasco','Zona Central','-16.496331','-68.136569','5','12'),(14,'Plaza Avaroa','Zona Central','-16.51063','-68.12672','5','12'),(15,'Plaza Murillo','Zona Central','-16.495735','-68.133565','5','12'),(16,'Plza Isabel laCatolica','Zona Central','-16.509036','-68.124402','5','15'),(17,'Prado','Zona Central','-16.502329','-68.132588','5','12'),(18,'San Miguel ','Zona Sur','-16.539132','-68.078075','5','15'),(19,'Santa Vera Cruz (El Alto)','Zona Norte','-16.544721','-68.214455','5','12'),(20,'Senkata (El Alto)','Zona Norte','-16.499958','-68.13858','5','12');
/*!40000 ALTER TABLE `rutaHito` ENABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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
  `p3` bigint(20) DEFAULT NULL,
  `p4` bigint(20) DEFAULT NULL,
  `p5` bigint(20) DEFAULT NULL,
  `p6` bigint(20) DEFAULT NULL,
  `p7` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userroute`
--

LOCK TABLES `userroute` WRITE;
/*!40000 ALTER TABLE `userroute` DISABLE KEYS */;
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

-- Dump completed on 2012-12-02  1:30:41
