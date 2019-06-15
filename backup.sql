/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

DROP DATABASE IF EXISTS `platenumber`;
CREATE DATABASE IF NOT EXISTS `platenumber` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `platenumber`;

DROP TABLE IF EXISTS `day`;
CREATE TABLE IF NOT EXISTS `day` (
  `idDay` int(11) NOT NULL,
  `nameDay` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idDay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `day` DISABLE KEYS */;
INSERT INTO `day` (`idDay`, `nameDay`) VALUES
	(1, 'Sunday'),
	(2, 'Monday'),
	(3, 'Tuesday'),
	(4, 'Wednesday'),
	(5, 'Thursday'),
	(6, 'Friday'),
	(7, 'Saturday');
/*!40000 ALTER TABLE `day` ENABLE KEYS */;

DROP TABLE IF EXISTS `restrictionaday`;
CREATE TABLE IF NOT EXISTS `restrictionaday` (
  `idRestriction` int(11) NOT NULL,
  `idDay` int(11) DEFAULT NULL,
  `numberPlate` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRestriction`),
  KEY `FK_RestrictionaDay_day` (`idDay`),
  CONSTRAINT `FK_RestrictionaDay_day` FOREIGN KEY (`idDay`) REFERENCES `day` (`idDay`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `restrictionaday` DISABLE KEYS */;
INSERT INTO `restrictionaday` (`idRestriction`, `idDay`, `numberPlate`) VALUES
	(1, 2, 1),
	(2, 2, 2),
	(3, 3, 3),
	(4, 3, 4),
	(5, 4, 5),
	(6, 4, 6),
	(7, 5, 7),
	(8, 5, 8),
	(9, 6, 9),
	(10, 6, 0);
/*!40000 ALTER TABLE `restrictionaday` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
