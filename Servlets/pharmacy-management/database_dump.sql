-- MySQL dump 10.17  Distrib 10.3.16-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: zoho_pharma
-- ------------------------------------------------------
-- Server version	10.3.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medicines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text DEFAULT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
INSERT INTO `medicines` VALUES (1,'Cheston Cold Tablet','Cheston Cold Tablet is generally prescribed in the treatment of allergic rhinitis, symptoms such as runny or stuffy nose, sneezing, itchy, swelling, and watery eyes, etc',10.50,2),(2,'Cetirizine 5 MG','It is used to used to relieve mild to moderate pain and to reduce fever.',40.00,16),(3,'Paracetamol','Paracetamol, also known as acetaminophen, is a medication used to treat fever and mild to moderate pain.',100.00,4),(4,'Acetaminophen','Acetaminophen is used to treat mild to moderate and pain, to treat moderate to severe pain in conjunction with opiates, or to reduce fever.',123.00,564),(5,'Aricept','Aricept (donepezil) improves the function of nerve cells in the brain. It works by preventing the breakdown of a chemical called acetylcholine.',23.00,886),(6,'Azilect','Azilect is used to treat symptoms of Parkinson\'s disease (stiffness, tremors, spasms, poor muscle control).',97.00,65),(7,'Ayr Saline (nasal)','Ayr Saline (for use in the nose) is used to treat stuffy nose, post-nasal drip, dryness inside your nose and nasal passages, or nasal irritation caused by colds, flu, allergies, or pollutants.',32.50,655),(8,'Cabenuva ','The Cabenuva injection kit contains cabotegravir and rilpivirine is separate single-dose vials.',12.50,50),(9,'Ganciclovir ','Ganciclovir for Injection, USP is indicated for the treatment of cytomegalovirus (CMV) retinitis in immunocompromised adult patients.',13.50,52),(10,'Gvoke','Gvoke (glucagon) is a hormone that increases blood sugar levels. Gvoke is used to treat hypoglycemia (low blood sugar).',46.50,78),(11,'Ultomiris','Ultomiris (ravulizumab) is a monoclonal antibody. Monoclonal antibodies are man-made antibodies that fight antigens (harmful substances) in the body.',64.50,85),(12,'Medrol','Medrol is a steroid that prevents the release of substances in the body that cause inflammation.',90.50,24),(13,'Glucovita Bolts','These are healthy and tasty energy tablets with glucose and iron which gives instant energy for body and brain.',10.00,12);
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` text DEFAULT NULL,
  `isRead` tinyint(1) NOT NULL DEFAULT 0,
  `isAction` tinyint(1) DEFAULT 0,
  `reportId` int(11) NOT NULL,
  `sentAt` timestamp NOT NULL DEFAULT current_timestamp(),
  `fromUserId` int(11) NOT NULL,
  `toUserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reportId` (`reportId`),
  KEY `messages_fromUserId` (`fromUserId`),
  KEY `messages_toUserId` (`toUserId`),
  CONSTRAINT `messages_fromUserId` FOREIGN KEY (`fromUserId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `messages_ibfk_3` FOREIGN KEY (`reportId`) REFERENCES `reports` (`id`),
  CONSTRAINT `messages_toUserId` FOREIGN KEY (`toUserId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (1,'Hey there! I have a complaint',0,0,2,'2022-04-18 05:53:39',3,1),(2,'I am owner',1,0,1,'2022-04-19 05:16:26',1,3),(3,'Again I am owner',1,0,1,'2022-04-19 05:16:26',1,3),(4,'I am from Owner',1,0,1,'2022-04-19 05:39:26',1,3),(5,'I am again from Owner',1,0,2,'2022-04-19 05:40:54',1,3);
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_last_update_reports` AFTER INSERT ON `messages` FOR EACH ROW BEGIN

UPDATE reports SET lastUpdatedAt=CURRENT_TIMESTAMP() WHERE id = NEW.reportId;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `startTime` timestamp NULL DEFAULT NULL,
  `endTime` timestamp NULL DEFAULT NULL,
  `discount` decimal(8,5) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `check_date_difference` CHECK (`endTime` >= `startTime`),
  CONSTRAINT `discount` CHECK (`discount` <= 100 and `discount` >= 0)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
INSERT INTO `offers` VALUES (15,'Diwali','2022-04-18 06:01:00','2022-04-19 06:01:00',40.00000);
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(8) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `medicineId` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` decimal(10,3) NOT NULL,
  `medicineName` varchar(100) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp(),
  `updatedAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` enum('COMPLETED','PENDING','CANCELLED','RETURN_REQUESTED','RETURN_COMPLETED','RETURN_DECLINED') DEFAULT 'PENDING',
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `medicineId` (`medicineId`),
  KEY `status` (`status`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`medicineId`) REFERENCES `medicines` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (72,'20OHSNG',3,1,4,42.000,'Cheston Cold Tablet','2022-04-17 16:54:43','2022-04-18 05:58:32','RETURN_COMPLETED'),(73,'31XJALO',3,1,3,31.500,'Cheston Cold Tablet','2022-04-18 05:56:58','2022-04-18 05:57:40','CANCELLED'),(74,'52NRBIE',3,1,3,31.500,'Cheston Cold Tablet','2022-04-18 05:57:51','2022-04-18 05:58:30','RETURN_DECLINED'),(75,'50NDSLC',3,1,1,10.500,'Cheston Cold Tablet','2022-04-18 05:59:20','2022-04-18 05:59:29','COMPLETED'),(76,'42ESKKX',3,3,18,1800.000,'Paracetamol','2022-04-18 05:59:53','2022-04-18 15:34:04','RETURN_REQUESTED'),(77,'53STYJR',3,1,4,25.200,'Cheston Cold Tablet','2022-04-18 06:01:21','2022-04-18 09:52:48','RETURN_COMPLETED'),(78,'96OYWJU',3,1,3,18.900,'Cheston Cold Tablet','2022-04-18 09:51:49','2022-04-18 09:52:07','COMPLETED'),(79,'99OUKMK',3,1,1,6.300,'Cheston Cold Tablet','2022-04-18 09:53:29','2022-04-19 04:45:40','COMPLETED'),(80,'12RBYOY',3,6,1,58.200,'Azilect','2022-04-18 14:50:20','2022-04-18 15:34:01','CANCELLED');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `status` enum('REOPENED','OPENED','CLOSED') DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `lastUpdatedAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `reports_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (1,3,'CLOSED','Medicine Seal is opened','2022-04-19 05:39:32'),(2,3,'OPENED','Dosage is wrong','2022-04-19 05:40:57');
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `isAdmin` tinyint(1) DEFAULT 0,
  `lastSeenAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Shri Hari L','shrihari689','1267e102030132aa90b9cb2e4b6576404790c30fd84da5ef725094b7016872c4',1,'2022-04-15 10:19:06'),(3,'Kathir','kathir123','-38d321c8c1fd28fa1ad403974d214bf0fc0aae176f318a92d868334c03a751b',0,'2022-04-15 10:19:06'),(4,'Siva','sivadharaneesh','47047f57dfbf7d872f101c350acf1a8497b17384c95ba929da111e224be1355a',0,'2022-04-15 10:19:06');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-20 12:31:46
