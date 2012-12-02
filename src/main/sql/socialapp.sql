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
  `mapX` varchar(255) DEFAULT NULL,
  `mapY` varchar(255) DEFAULT NULL,
  `ratio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conflicto`
--

LOCK TABLES `conflicto` WRITE;
/*!40000 ALTER TABLE `conflicto` DISABLE KEYS */;
INSERT INTO `conflicto` VALUES (5,'Bloqueo con petardos',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2012-12-01 18:26:01','6 de Agosto',NULL,NULL,NULL);
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
  `mapX` varchar(255) DEFAULT NULL,
  `mapY` varchar(255) DEFAULT NULL,
  `ratio` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rutahito`
--

LOCK TABLES `rutahito` WRITE;
/*!40000 ALTER TABLE `rutahito` DISABLE KEYS */;
INSERT INTO `rutahito` VALUES (1,'6 de Agosto','Zona Central',NULL,NULL,NULL),(2,'6 de Marzo (El Alto)','Zona Norte',NULL,NULL,NULL),(3,'Autoista','Zona Norte',NULL,NULL,NULL),(4,'Av. Bolivia (El Alto)','Zona Norte',NULL,NULL,NULL),(5,'Calle 8 de Calacoto','Zona Sur',NULL,NULL,NULL),(6,'Camacho','Zona Central',NULL,NULL,NULL),(7,'Ceja (El Alto)','Zona Norte',NULL,NULL,NULL),(8,'Cerveceria','Zona Norte',NULL,NULL,NULL),(9,'Ex tranca Rio Seco (El Alto)','Zona Norte',NULL,NULL,NULL),(10,'Mariscal Santa Cruz','Zona Central',NULL,NULL,NULL),(11,'Montes','Zona Norte',NULL,NULL,NULL),(12,'Obrajes calle 17','Zona Sur',NULL,NULL,NULL),(13,'Perez Velasco','Zona Central',NULL,NULL,NULL),(14,'Plaza Avaroa','Zona Central',NULL,NULL,NULL),(15,'Plaza Murillo','Zona Central',NULL,NULL,NULL),(16,'Plza Isabel laCatolica','Zona Central',NULL,NULL,NULL),(17,'Prado','Zona Central',NULL,NULL,NULL),(18,'San Miguel ','Zona Sur',NULL,NULL,NULL),(19,'Santa Vera Cruz (El Alto)','Zona Norte',NULL,NULL,NULL),(20,'Zencata (El Alto)','Zona Norte',NULL,NULL,NULL);
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-01 18:32:40
