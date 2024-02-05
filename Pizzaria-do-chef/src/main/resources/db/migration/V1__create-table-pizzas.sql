CREATE TABLE IF NOT EXISTS `pizza` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descripition` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;