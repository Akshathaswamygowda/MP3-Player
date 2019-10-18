-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: projectmp3
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `library`
--

DROP TABLE IF EXISTS `library`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `library` (
  `Title` varchar(45) NOT NULL,
  `Album` varchar(45) NOT NULL,
  `Artist` varchar(45) NOT NULL,
  `Year` varchar(45) NOT NULL,
  `Genre` varchar(45) DEFAULT NULL,
  `Comment` varchar(255) DEFAULT NULL,
  `Path` varchar(128) NOT NULL,
  `Playlists` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `library`
--

LOCK TABLES `library` WRITE;
/*!40000 ALTER TABLE `library` DISABLE KEYS */;
INSERT INTO `library` VALUES ('Besabriyaan -  DownloadMing.SE','M.S. Dhoni (2016)','Armaan Malik','2016','Unknown','DownloadMing.SE','C:\\Users\\karth\\Music\\01 - Besabriyaan - DownloadMing.SE (1).mp3',NULL),('Earthquake (Explicit Edit)','The Official UK Top 40 Singles','Labrinth Feat Tinie Tempah','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\04 Labrinth Feat Tinie Tempah - Earthquake (Explicit Edit).mp3',NULL),('Good Feeling','The Official UK Top 40 Singles','Flo Rida','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\02 Flo Rida - Good Feeling.mp3',NULL),('Gotta Be You','The Official UK Top 40 Singles','One Direction','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\03 One Direction - Gotta Be You.mp3',NULL),('It Will Rain','The Official UK Top 40 Singles','Bruno Mars','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\17 Bruno Mars - It Will Rain.mp3',NULL),('Jar Of Hearts','The Official UK Top 40 Singles','Christina Perri','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\10 Christina Perri - Jar Of Hearts.mp3',NULL),('Kar Gayi Chull -  DownloadMing','Kapoor and Sons (2016)','Badshah, Amaal Mallik, Fazilpu','2016','Unknown','DownloadMing.SE','C:\\Users\\karth\\Music\\01 - Kar Gayi Chull - DownloadMing.SE.mp3',NULL),('Lego House','The Official UK Top 40 Singles','Ed Sheeran','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\05 Ed Sheeran - Lego House.mp3',NULL),('Marry The Night','The Official UK Top 40 Singles','Lady Gaga','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\18 Lady Gaga - Marry The Night.mp3',NULL),('Me Without You','The Official UK Top 40 Singles','Loick Essien','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\22 Loick Essien - Me Without You.mp3',NULL),('Moves Like Jagger','The Official UK Top 40 Singles','Maroon 5 Feat Christina Aguile','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\07 Maroon 5 Feat Christina Aguilera - Moves Like Jagger.mp3',NULL),('Mr Know It All','The Official UK Top 40 Singles','Kelly Clarkson','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\21 Kelly Clarkson - Mr Know It All.mp3',NULL),('My Heart Takes Over','The Official UK Top 40 Singles','The Saturdays','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\15 The Saturdays - My Heart Takes Over.mp3',NULL),('Paradise','The Official UK Top 40 Singles','Coldplay','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\13 Coldplay - Paradise.mp3',NULL),('Read All About It (Explicit Ed','The Official UK Top 40 Singles','Professor Green Feat Emeli San','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\09 Professor Green Feat Emeli Sande - Read All About It (Explicit Edit).mp3',NULL),('Sexy And I Know It','The Official UK Top 40 Singles','LMFAO','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\11 LMFAO - Sexy And I Know It.mp3',NULL),('Shake It Out','The Official UK Top 40 Singles','Florence And The Machine','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\23 Florence And The Machine - Shake It Out.mp3',NULL),('Shatamanam Bhavati [www.AtoZmp','Shatamanam Bhavati (2016)','K. S. Chithra, Vijay Yesudas','2016','Unknown','','C:\\Users\\karth\\Music\\02 - Shatamanam Bhavati [www.AtoZmp3.in].mp3',NULL),('Shoot the Kuruvi - isaimini.co','Jil Jung Juk','Anirudh, Siddharth & Datho Rad','2015','Unknown','isaimini.com','C:\\Users\\karth\\Music\\Shoot the Kuruvi.mp3',NULL),('Take A Chance On Me','The Official UK Top 40 Singles','JLS','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\08 JLS - Take A Chance On Me.mp3',NULL),('Take Care (Explicit Edit)','The Official UK Top 40 Singles','Drake Feat Rihanna','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\12 Drake Feat Rihanna - Take Care (Explicit Edit).mp3',NULL),('Teardrop','The Official UK Top 40 Singles','The Collective','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\24 The Collective - Teardrop.mp3',NULL),('The A Team','The Official UK Top 40 Singles','Ed Sheeran','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\26 Ed Sheeran - The A Team.mp3',NULL),('Video Games','The Official UK Top 40 Singles','Lana Del Ray','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\19 Lana Del Ray - Video Games.mp3',NULL),('We Found Love','The Official UK Top 40 Singles','Rihanna Feat Calvin Harris','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\01 Rihanna Feat Calvin Harris - We Found Love.mp3',NULL),('What Do You Take Me For','The Official UK Top 40 Singles','Pixie Lott Feat Pusha T','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\20 Pixie Lott Feat Pusha T - What Do You Take Me For.mp3',NULL),('What Makes You Beautiful','The Official UK Top 40 Singles','One Direction','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\25 One Direction - What Makes You Beautiful.mp3',NULL),('Wherever You Will Go','The Official UK Top 40 Singles','Charlene Soraia','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\14 Charlene Soraia - Wherever You Will Go.mp3',NULL),('With Ur Love','The Official UK Top 40 Singles','Cher Lloyd Feat Mike Posner','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\16 Cher Lloyd Feat Mike Posner - With Ur Love.mp3',NULL),('Without You','The Official UK Top 40 Singles','David Guetta Feat Usher','2011','Pop','www.oldskoolscouse.co.uk','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\06 David Guetta Feat Usher - Without You.mp3',NULL);
/*!40000 ALTER TABLE `library` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlists`
--

DROP TABLE IF EXISTS `playlists`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `playlists` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlists`
--

LOCK TABLES `playlists` WRITE;
/*!40000 ALTER TABLE `playlists` DISABLE KEYS */;
INSERT INTO `playlists` VALUES ('fdvfv');
/*!40000 ALTER TABLE `playlists` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recent`
--

DROP TABLE IF EXISTS `recent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `recent` (
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recent`
--

LOCK TABLES `recent` WRITE;
/*!40000 ALTER TABLE `recent` DISABLE KEYS */;
INSERT INTO `recent` VALUES ('Besabriyaan -  DownloadMing.SE','C:\\Users\\karth\\Music\\01 - Besabriyaan - DownloadMing.SE (1).mp3'),('Kar Gayi Chull -  DownloadMing','C:\\Users\\karth\\Music\\01 - Kar Gayi Chull - DownloadMing.SE.mp3'),('Good Feeling','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\02 Flo Rida - Good Feeling.mp3'),('Gotta Be You','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\03 One Direction - Gotta Be You.mp3'),('Earthquake (Explicit Edit)','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\04 Labrinth Feat Tinie Tempah - Earthquake (Explicit Edit).mp3'),('Moves Like Jagger','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\07 Maroon 5 Feat Christina Aguilera - Moves Like Jagger.mp3'),('Jar Of Hearts','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\10 Christina Perri - Jar Of Hearts.mp3'),('It Will Rain','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\17 Bruno Mars - It Will Rain.mp3'),('Me Without You','C:\\Users\\karth\\Music\\The Official UK Top 40 2011\\22 Loick Essien - Me Without You.mp3');
/*!40000 ALTER TABLE `recent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spl`
--

DROP TABLE IF EXISTS `spl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `spl` (
  `playist` varchar(255) NOT NULL,
  `song` varchar(255) NOT NULL,
  PRIMARY KEY (`playist`,`song`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spl`
--

LOCK TABLES `spl` WRITE;
/*!40000 ALTER TABLE `spl` DISABLE KEYS */;
INSERT INTO `spl` VALUES ('fdvfv','C:\\Users\\karth\\Music\\01 - Kar Gayi Chull - DownloadMing.SE.mp3');
/*!40000 ALTER TABLE `spl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table1`
--

DROP TABLE IF EXISTS `table1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `table1` (
  `Album` varchar(45) NOT NULL,
  `Artist` varchar(45) DEFAULT NULL,
  `Year` varchar(45) DEFAULT NULL,
  `Genre` varchar(45) DEFAULT NULL,
  `Comment` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table1`
--

LOCK TABLES `table1` WRITE;
/*!40000 ALTER TABLE `table1` DISABLE KEYS */;
INSERT INTO `table1` VALUES ('true','false','true','true','true');
/*!40000 ALTER TABLE `table1` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-12 11:54:47
