CREATE TABLE IF NOT EXISTS `cliente`(
`id` BIGINT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(255) NOT NULL,
`tel` VARCHAR(255) NOT NULL,
`adress` VARCHAR(255) NOT NULL,
`cep` VARCHAR(255) NOT NULL,
PRIMARY KEY (`id`)
);