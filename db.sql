-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.5.45-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных products
CREATE DATABASE IF NOT EXISTS `products` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `products`;


-- Дамп структуры для таблица products.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `img` varchar(100) NOT NULL DEFAULT 'noimg.jpg',
  `price` double NOT NULL,
  `status` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы products.product: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `name`, `description`, `img`, `price`, `status`) VALUES
	(1, 'Монитор SyncMaster', 'Разрешение: 17"\r\nУгол обзора: 170', '1.jpg', 6500, b'0'),
	(2, 'Монитор SyncMaster', 'Разрешение: 15"\nУгол обзора: 170', 'noimg.jpg', 6500, b'0'),
	(4, 'Dell UltraSharp UP2516D', 'монитор Dell UltraSharp UP2516D, 2560x1440, HDMI, DP, miniDP, 6ms, IPS, серебристо-черный', 'noimg.jpg', 34990, b'1'),
	(5, 'Samsung S22E310HY ', 'Samsung S20D300NH - это замечательный монитор с диагональю экрана 19.5 дюйма. Изделие состоит из высококачественных и надежных материалов. Модель обладает длительным сроком эксплуатации и имеет современный дизайн.', '3.jpg', 6099, b'1'),
	(6, 'Монитор DEXP M182', 'Монитор DEXP 18.5" M182 отлично подходит для офиса, в нем нет ничего лишнего. Максимально лаконичный дизайн и матрица на технологии TN', '4.jpg', 5019, b'1');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
