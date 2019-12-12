/*
Navicat MySQL Data Transfer

Source Server         : hostgator
Source Server Version : 50641
Source Host           : br538.hostgator.com.br:3306
Source Database       : alexa577_trabalhoJava

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-12-12 02:23:19
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `aluno`
-- ----------------------------
DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
`matricula`  int(11) NOT NULL AUTO_INCREMENT ,
`nome`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`cpf`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`email`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`telefone`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`senha`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
`nota`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`matricula`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=2019765766

;

-- ----------------------------
-- Records of aluno
-- ----------------------------
BEGIN;
INSERT INTO aluno VALUES ('1', 'admin', '982 . 739 . 428 - 37', 'admin', '( 33 ) 33333 - 3333', '1234', '8'), ('12345', 'jorge', '019 . 199 . 131 - 93', 'jorge@jorge', '( 51 ) 49234 - 2342', '123', null), ('2019001', 'Rosângela Adriana de Paula', '634 . 571 . 732 - 06', 'rosangelapaula@gmail.com', '( 51 ) 99311 - 9672', '1234', null), ('2019002', 'Yago Jorge Ruan Figueiredo', '019 . 183 . 130 - 16', 'yagofigueiredo@gmail.com', '( 51 ) 99793 - 2748', '1234', null), ('2019003', 'Luan Kauê Gael Freitas', '610 . 138 . 850 - 66', 'luanfreitas@gmail.com', '( 51 ) 99616 - 4493', '1234', null), ('2019004', 'Nina Adriana de Paula', '008 . 170 . 000 - 89', 'ninapaula@gmail.com', '( 51 ) 99919 - 4193', '1234', null), ('2019005', 'Marina Alana Oliveira', '386 . 523 . 190 - 06', 'marinaoliveira@gmail.com', '( 51 ) 98283 - 4006', '1234', null), ('2019006', 'Esther Eduarda Luzia Peixoto', '341 . 348 . 580 - 62', 'estherpeixoto@gmail.com', '( 53 ) 98739 - 6341', '1234', null), ('2019007', 'Márcia Aparecida Lima', '852 . 457 . 680 - 46', 'marcialima@gmail.com', '( 53 ) 98116 - 5997', '1234', null), ('2019008', 'Leonardo Nelson Marcos Campos', '281 . 417 . 230 - 14', 'leonardocampos@gmail.com', '( 51 ) 99128 - 5901', '1234', null), ('2019009', 'Luciana Silvana Fernandes', '372 . 374 . 110 - 04', 'lucianafernandes@gmail.com', '( 51 ) 99617 - 8810', '1234', null), ('2019010', 'Carlos Eduardo Theo Mário da Cunha', '272 . 397 . 800 - 15', 'carloscunha@gmail.com', '( 53 ) 99661 - 5512', '1234', null);
COMMIT;

-- ----------------------------
-- Table structure for `area_interesse`
-- ----------------------------
DROP TABLE IF EXISTS `area_interesse`;
CREATE TABLE `area_interesse` (
`id_area_interesse`  int(11) NOT NULL AUTO_INCREMENT ,
`nome`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
PRIMARY KEY (`id_area_interesse`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=36

;

-- ----------------------------
-- Records of area_interesse
-- ----------------------------
BEGIN;
INSERT INTO area_interesse VALUES ('1', 'Python'), ('2', 'JavaScript'), ('3', 'Java'), ('4', 'PHP'), ('5', 'C#'), ('6', 'HTML'), ('7', 'CSS'), ('8', 'C'), ('9', 'Desenvolvimento Android'), ('10', 'Desenvolvimento iOS'), ('11', 'Banco de dados'), ('12', 'Estrutura de dados'), ('13', 'Machine Learning'), ('14', 'Desenvolvimento de Games'), ('15', 'Data Science');
COMMIT;

-- ----------------------------
-- Table structure for `professor`
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
`id_professor`  int(11) NOT NULL AUTO_INCREMENT ,
`nome`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`email`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`conta_banca`  int(11) NULL DEFAULT NULL ,
`senha`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
`conta_orientador`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id_professor`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=15

;

-- ----------------------------
-- Records of professor
-- ----------------------------
BEGIN;
INSERT INTO professor VALUES ('1', 'Daniel Cauê Enrico Figueiredo', 'danielcaueenricofigueiredo_@officetectecnologia.com.br', '1', '1234', '1'), ('2', 'Antonella Sophia Jéssica Moura', 'asj@gmail.com', '5', '1234', null), ('3', 'Osvaldo Heitor Cavalcanti', 'osvaldoheitorcavalcanti_@i9pneus.com.br', '0', '1234', null), ('4', 'Francisco Silva', 'fs@gmail.com', '1', '1234', '4'), ('5', 'Marcelo Silva', 'marcelo@gmail.com', '1', '1234', null), ('8', 'admin', 'admin', '1', 'admin', '5');
COMMIT;

-- ----------------------------
-- Table structure for `professor_area_interesse`
-- ----------------------------
DROP TABLE IF EXISTS `professor_area_interesse`;
CREATE TABLE `professor_area_interesse` (
`professor_id`  int(11) NOT NULL DEFAULT 0 ,
`area_interesse_id`  int(11) NOT NULL DEFAULT 0 ,
PRIMARY KEY (`professor_id`, `area_interesse_id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_unicode_ci

;

-- ----------------------------
-- Records of professor_area_interesse
-- ----------------------------
BEGIN;
INSERT INTO professor_area_interesse VALUES ('1', '15'), ('4', '4'), ('4', '13'), ('4', '15'), ('8', '1'), ('8', '10'), ('8', '11'), ('8', '15'), ('11', '2'), ('11', '4'), ('11', '14'), ('14', '2'), ('14', '4'), ('14', '6'), ('14', '7'), ('14', '11');
COMMIT;

-- ----------------------------
-- Table structure for `proposta`
-- ----------------------------
DROP TABLE IF EXISTS `proposta`;
CREATE TABLE `proposta` (
`id_proposta`  int(11) NOT NULL AUTO_INCREMENT ,
`matricula`  int(11) NULL DEFAULT NULL ,
`id_area_interesse`  int(11) NOT NULL ,
`id_professor`  int(11) NOT NULL ,
`titulo`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`descricao`  varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL ,
`status`  varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`banca1`  int(11) NULL DEFAULT NULL ,
`banca2`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id_proposta`),
FOREIGN KEY (`matricula`) REFERENCES `aluno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (`id_area_interesse`) REFERENCES `area_interesse` (`id_area_interesse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci
AUTO_INCREMENT=67

;

-- ----------------------------
-- Records of proposta
-- ----------------------------
BEGIN;
INSERT INTO proposta VALUES ('52', null, '1', '8', 'proposta 1', 'proposta 1 - Python', 'Em aberto', null, null), ('53', null, '2', '8', 'proposta 2', 'proposta 2 - JavaScript', 'Em aberto', null, null), ('54', null, '3', '8', 'Proposta 3', 'Proposta 3 - Java', 'Em aberto', null, null), ('55', '1', '4', '8', 'Proposta 4', 'proposta 4 - PHP', 'Aprovado', null, null), ('57', null, '4', '8', 'Proposta 5', 'Proposta 5 - PHP', 'Em aberto', null, null), ('64', null, '4', '4', 'Análise do tempo de resposta para teste de desempenho em aplicações  web', 'A atividade de teste é geralmente bastante onerosa, isso ocorre porque boa parte dessas atividades são executadas manualmente. Para melhorar\nisto, Model-Based Testing', 'Em aberto', null, null), ('65', null, '15', '4', 'Usando Data Science no combate a Fraudes', 'Fraude não é um fenômeno apenas da nossa sociedade moderna. Ao longo da história, a humanidade tem se especializado em ações fraudulentas. Entretanto, nunca tivemos tantas ferramentas como', 'Em aberto', null, null), ('66', null, '11', '4', 'Desenvolvimento de aplicação para análise de dados', 'Este trabalho visa conceituar o leitor acerca da abordagem conhecida como Data\nScience, que é definida como a área da computação responsável pela coleta de dados,\nanálise de informações e tomada...', 'Em aberto', null, null);
COMMIT;

-- ----------------------------
-- Auto increment value for `aluno`
-- ----------------------------
ALTER TABLE `aluno` AUTO_INCREMENT=2019765766;

-- ----------------------------
-- Auto increment value for `area_interesse`
-- ----------------------------
ALTER TABLE `area_interesse` AUTO_INCREMENT=36;

-- ----------------------------
-- Auto increment value for `professor`
-- ----------------------------
ALTER TABLE `professor` AUTO_INCREMENT=15;

-- ----------------------------
-- Indexes structure for table `professor_area_interesse`
-- ----------------------------
CREATE INDEX `fk_area_interesse` ON `professor_area_interesse`(`area_interesse_id`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table `proposta`
-- ----------------------------
CREATE INDEX `proposta_area_interesse_fk` ON `proposta`(`id_area_interesse`) USING BTREE ;
CREATE INDEX `proposta_aluno_fk` ON `proposta`(`matricula`) USING BTREE ;
CREATE INDEX `proposta_professor_fk` ON `proposta`(`id_professor`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `proposta`
-- ----------------------------
ALTER TABLE `proposta` AUTO_INCREMENT=67;
