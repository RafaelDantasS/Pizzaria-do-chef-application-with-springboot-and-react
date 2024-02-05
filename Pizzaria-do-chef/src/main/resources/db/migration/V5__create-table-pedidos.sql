CREATE TABLE IF NOT EXISTS `pedidos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `person_name` varchar(255)  not NULL,
   `tel_number` varchar(20)  not NULL,
  `pizzas` varchar(255)  not NULL,
  `bebidas` varchar(255) DEFAULT NULL,
  `total` double not NULL,
  `data` varchar(255)  not NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;