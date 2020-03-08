-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: abcbank
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `account_id` varchar(45) NOT NULL,
  `account_name` varchar(45) DEFAULT NULL,
  `account_address` varchar(100) NOT NULL,
  `email_id` varchar(55) NOT NULL,
  `mobile_number` varchar(55) NOT NULL,
  `account_type` varchar(45) NOT NULL,
  `date_open` datetime DEFAULT NULL,
  `date_closed` datetime DEFAULT NULL,
  `account_status` varchar(45) NOT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('1234565465','Sam Kat','Dallas, Texas','samkat@test.com','1234567890','Checking','2020-01-03 00:00:00',NULL,'Active'),('1246742345','Dia Kanna','Miami, Florida','diakana@gmail.com','435435321','Checking','2017-10-17 00:00:00',NULL,'Active'),('15434543534','Ria Mann','Santa Clara, California','riamann@gmail.com','4234245534','Savings','2012-12-04 00:00:00',NULL,'Active'),('345323445456','Sam Kat','Dallas, Texas','samkat@test.com','23432433','Savings','2020-02-16 00:00:00',NULL,'Active'),('3454546567','Dia Kanna','Miami, Florida','diakana@gmail.com','435435321','Savings','2010-12-12 00:00:00','2019-12-25 00:00:00','Closed'),('567564533','Ria Mann','Santa Clara, California','riamann@gmail.com','4234245534','Loan','2014-10-04 00:00:00',NULL,'Active');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-08 15:19:30
