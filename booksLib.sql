-- MySQL dump 10.15  Distrib 10.0.25-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: booksLib
-- ------------------------------------------------------
-- Server version	10.0.25-MariaDB

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `release` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Spring MVC: Beginner\'s Guide','Amuthan G',2014),(2,'Getting started with Spring Framework','J. Sharma, Ashish Sarin',2012),(3,'Spring in Action (3rd Edition)','Craig Walls',2011),(4,'Spring in Practice','Willie Wheeler, Joshua White',2013),(5,'Pro Spring 3','Clarence Ho, Rob Harrop',2012),(6,'Spring Integration in Action','Mark Fisher, Jonas Partner, Marius Bogoevici, Iwein Fuld',2012),(7,'Spring Batch in Action','Arnaud Cogoluegnes, Thierry Templier, Gary Gregory, Olivier Bazoud',2011),(8,'Spring Web Services 2 Cookbook','Hamidreza Sattari, Shameer Kunjumohamed',2012),(9,'Spring 4 for Developing Enterprise Applications','Henry H. Liu',2012),(10,'Spring Recipes: A Problem-Solution Approach 3rd ed. Edition','Daniel Rubio, Josh Long, Gary Mak, Marten Deinum',2014),(11,'Learning Spring Boot','Greg L. Turnquist',2014);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuances`
--

DROP TABLE IF EXISTS `issuances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issuances` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `issuance` date NOT NULL,
  `returnTo` date NOT NULL,
  `returnDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_issuances_2_idx` (`book_id`),
  KEY `fk_issuances_1_idx` (`user_id`),
  CONSTRAINT `fk_issuances_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_issuances_2` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuances`
--

LOCK TABLES `issuances` WRITE;
/*!40000 ALTER TABLE `issuances` DISABLE KEYS */;
INSERT INTO `issuances` VALUES (1,1,1,'2016-08-10','2016-08-10',NULL),(2,1,4,'2016-08-10','2016-09-10',NULL),(3,2,3,'2016-08-10','2016-09-10','2016-09-01'),(5,1,11,'2016-08-10','2016-09-10',NULL),(6,1,10,'2016-08-15','2016-09-10','2016-09-10'),(7,2,5,'2016-08-12','2016-09-10','2016-09-10'),(8,2,7,'2016-08-12','2016-09-10',NULL),(9,3,8,'2016-08-12','2016-09-10',NULL);
/*!40000 ALTER TABLE `issuances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(30) NOT NULL,
  `age` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Krysta Danielsen',23),(2,'Alane Eckley',25),(3,'Jeremy Wagar',27),(4,'Shelba Purington',29),(5,'Iluminada Overby',31),(6,'Laurice Mcferron',34),(7,'Delmer Rowell',36),(8,'Lashunda Latimer',21),(9,'Elden Merrit',20),(10,'Luisa Savell',24),(11,'Gary Mackowiak',26),(12,'Russell Leader',28),(13,'Nakia Leahy',30),(14,'Kimi Godbolt',32),(15,'Corliss Hild',35),(16,'Mandi Uphoff',33),(17,'Yoshiko Boettcher',37),(18,'Meghann Grindstaff',39),(19,'Rheba Nickels',22),(20,'Dione Newlin',38);
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

-- Dump completed on 2016-08-11 12:36:48
