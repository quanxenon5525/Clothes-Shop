-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: finalproject
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id_brand` int NOT NULL AUTO_INCREMENT,
  `brandName` varchar(150) DEFAULT NULL,
  `active` int DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_brand`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (8,'Fear Of God',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652766871002-fog.jpg?alt=media&token=6d83bc32-f8d5-44f4-baca-bee63415c8ad'),(9,'Adidas',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652766935917-adidas.jpg?alt=media&token=c75ddc43-d705-456b-8b6f-d1d966488c6f'),(10,'BoBui',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652766996500-bobui.png?alt=media&token=6abd37a3-e0ee-4381-adb9-6ffbd8427d1a'),(11,'Louis Vuitton',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652767015675-LV.jpg?alt=media&token=9f60994d-2805-4c37-ae9a-8f7ba4e1ff78'),(12,'Nike',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652767053725-nike.jpg?alt=media&token=319f02d9-c421-4e7a-b58a-d26f4d77408c'),(13,'Tredx',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652767074343-tredx.jpg?alt=media&token=43108235-fee8-4ab8-9cbc-95732616ab67'),(15,'Yezzy',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652767176384-yezzy.jpg?alt=media&token=5e418fe6-af37-41df-b9f8-6b7f7ffeb8d1'),(16,'MOSCHINO',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652785531045-80b9f7bb3e65b4d6a99e9b14aec89ae1.jpg?alt=media&token=b8fa3b7e-50cf-43de-a53d-c856a89de337'),(17,'A Bathing Bape',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652785588633-pasted_image_0.jpg?alt=media&token=95b87411-3711-40e8-9383-519515ba1eb9'),(18,'a',1,'https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652883251789-Screenshot%202022-05-18%20193705.png?alt=media&token=b4dbb989-3a8b-440d-a412-11acfeb98805');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-18 21:24:25
