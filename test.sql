-- MySQL dump 10.13  Distrib 5.5.53, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.53-0ubuntu0.14.04.1

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
-- Table structure for table `mycloud_user`
--

DROP TABLE IF EXISTS `mycloud_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mycloud_user` (
  `account` varchar(20) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` int(11) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mycloud_user`
--

LOCK TABLES `mycloud_user` WRITE;
/*!40000 ALTER TABLE `mycloud_user` DISABLE KEYS */;
INSERT INTO `mycloud_user` VALUES ('admin','管理员','10041104',3,'2014-10-24 15:34:30','2014-10-24 15:34:30'),('teacher','注册用','10041104',2,'2016-03-11 21:18:46','2016-03-11 21:18:46');
/*!40000 ALTER TABLE `mycloud_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `other_datasource_meta`
--

DROP TABLE IF EXISTS `other_datasource_meta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `other_datasource_meta` (
  `datasource_name` varchar(45) NOT NULL,
  `database_ip` varchar(45) NOT NULL,
  `database_port` varchar(45) NOT NULL,
  `database_name` varchar(45) NOT NULL,
  `database_username` varchar(45) NOT NULL,
  `database_password` varchar(45) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`datasource_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `other_datasource_meta`
--

LOCK TABLES `other_datasource_meta` WRITE;
/*!40000 ALTER TABLE `other_datasource_meta` DISABLE KEYS */;
INSERT INTO `other_datasource_meta` VALUES ('testbackup','127.0.0.1','3306','testbackup','root','123456','2016-12-18 00:00:00','2016-12-18 00:00:00');
/*!40000 ALTER TABLE `other_datasource_meta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-18 14:09:54
