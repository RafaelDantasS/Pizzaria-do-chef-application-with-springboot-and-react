CREATE TABLE IF NOT EXISTS `bebida_pedido`(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`quant` INT NOT NULL,
`price` decimal(65,2) NOT NULL,
`cliente_id` BIGINT,
FOREIGN KEY (cliente_id) REFERENCES cliente(id),
PRIMARY KEY (`id`)
);