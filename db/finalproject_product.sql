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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `product_Name` varchar(150) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `id_brand` int DEFAULT NULL,
  `id_category` int DEFAULT NULL,
  `active` int DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `img` varchar(1500) DEFAULT NULL,
  `decribe` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (7,'MOSCHINO T-SHIRT',3400000,16,5,1,'white','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652785391530-1_d4d96bb1-f07c-44d1-8eeb-81d8c4d0109f.jpg?alt=media&token=d7206052-5b65-4dd2-9309-5709f1b99019','Phù hợp thường xuyên\r\nCổ có gân\r\nTay áo ngắn\r\n- MOSCHINO T-SHIRT  đến từ thương hiệu Moschino nổi tiếng của Ý. Đây được cho là sản phẩm đang nhận được sự yêu thích của giới trẻ hiện nay.\r\n\r\n- Thiết kế với fom dáng rộng rãi, áo phù hợp để diện cho mọi hoạt động thường ngày và kết hợp với nhiều loại trang phục khác nhau. Điểm nhấn của chiếc áo nằm ở biểu tượng logo thương hiệu được in nổi bên ngực phải.'),(8,'BUBBLE SUPREME',12321,9,9,1,'hehe','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652790836373-pasted_image_0.jpg?alt=media&token=626f6bf3-309b-4f3b-be8e-e30a034496ca','asdsa'),(9,'MOSCHINO LOOP',3000000,16,10,1,'WHITE','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652864277494-MOSCHINO22.png?alt=media&token=c9496f96-c4fd-48ea-9e61-191f24357bcb','CHEAP'),(10,'MOSCHINO DOLLAR',3500000,16,10,1,'BLACK','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652864473349-MOSCHINODOLLAR.png?alt=media&token=5e32b7eb-adf4-4728-b3e6-172c4b9a6a59','GOOD'),(11,'MOSCHINO',2999999,16,10,1,'BLACK/RED','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652864689398-dacula.png?alt=media&token=e813924f-35e4-4dd6-8d5a-282abfc0748f','HALLOWEEN'),(12,'BAPE TEE CAMO',3450000,17,10,1,'CAMO','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652864962496-bapetee.png?alt=media&token=c2fe2ae2-c1b6-441a-8529-68fa5f811910','SHARK DESIGN'),(13,'BAPE JACKET 2 FACE',12500000,17,3,1,'BLACK / WHITE','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652865158369-BAPEJACKET.png?alt=media&token=490f70ff-d926-4a57-809f-913f7c4dd4ad','..'),(14,'BOBUI ANGLE',500000,10,10,1,'BLACK / RED','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652865321413-bobui.png?alt=media&token=f6e9c5cc-bfff-4aff-b4b6-cbd07590fd72','SAINT OF LOVE'),(15,'BOBUI GREY ',450000,10,10,1,'GREY','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652865453829-BOBUIXMA.png?alt=media&token=af3b1310-7200-4c9a-873a-5c641d3b0738','simple but good'),(16,'AIR JORDAN 1 CHILE MID',4900000,12,2,1,'BLACK/WHITE/RED','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652865691740-jordanchile.png?alt=media&token=2884e281-366b-4239-8471-8127837f01b3','COOL'),(17,'JORDAN 1 HIGH ZOOM AIR CMFT PSG PARIS SAINT-GERMAIN',7800000,12,2,1,'MUTILCOLOR','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652865903540-jordanmulti.png?alt=media&token=884fbed3-8646-4bb1-a3f0-cb3d7d352c98','RARE'),(18,'WORKWEAR SHIRT',23000000,11,3,1,'FADE COLOR','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652866071317-LV1.png?alt=media&token=8c9c20bf-6440-4081-af97-e2bfeeed0924','LUXURY'),(19,'LVXNBA FRONT-AND-BACK LETTERS PRINT T-SHIRT',12500000,11,10,1,'WHITE','https://firebasestorage.googleapis.com/v0/b/upload-fc579.appspot.com/o/1652866284430-LV2.png?alt=media&token=5b772940-3adb-4173-97ca-b2b25125bc79','LUXURY');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
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
