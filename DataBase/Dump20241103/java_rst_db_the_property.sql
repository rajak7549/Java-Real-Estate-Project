-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: java_rst_db
-- ------------------------------------------------------
-- Server version	8.0.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `the_property`
--

DROP TABLE IF EXISTS `the_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `the_property` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` int DEFAULT NULL,
  `square_feet` int DEFAULT NULL,
  `ownerId` int DEFAULT NULL,
  `price` varchar(20) DEFAULT NULL,
  `address` text,
  `bedrooms` int DEFAULT NULL,
  `bathrooms` int DEFAULT NULL,
  `age` int DEFAULT NULL,
  `balcone` tinyint(1) DEFAULT '0',
  `pool` tinyint(1) DEFAULT '0',
  `backyard` tinyint(1) DEFAULT '0',
  `garage` tinyint(1) DEFAULT '0',
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the_property`
--

LOCK TABLES `the_property` WRITE;
/*!40000 ALTER TABLE `the_property` DISABLE KEYS */;
INSERT INTO `the_property` VALUES (1,4,400,1,'99999','in the sun 	',77,8,888,1,1,1,1,'This is the best house in the near sun '),(2,8,8888888,2,'8989898','address here',60,6,3,0,1,0,1,'description here'),(3,5,403,2,'98888','in the sun from the east',7,2,3,1,0,1,0,'This is the best house in the near sun  and ocean '),(4,8,2222,4,'454545','asdasd',1,1,1,0,1,0,1,'asda');
/*!40000 ALTER TABLE `the_property` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-03 14:56:58
