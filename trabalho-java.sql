/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : trabalho-java

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-11-23 16:46:21
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `aluno`
-- ----------------------------
DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(30) DEFAULT '',
  `email` varchar(100) NOT NULL,
  `telefone` varchar(30) NOT NULL,
  `perfil` varchar(30) NOT NULL,
  `senha` varchar(30) DEFAULT NULL,
  `proposta` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of aluno
-- ----------------------------
INSERT INTO aluno VALUES ('1', 'Alexandre Silva Lima', '935 . 808 . 430 - 87', 'limaalexguitar@gmail.com', '( 51 ) 98562 - 5609', 'Aluno', '', 'Em aberto');
INSERT INTO aluno VALUES ('2', 'joao', '123 . 445 . 669 - 09', 'lia@alsk.com', '( 87 ) 82939 - 4872', 'Aluno', '', 'Em aberto');
INSERT INTO aluno VALUES ('4', 'Sofia', '935 . 808 . 430 - 87', 'limaalexguitar@gmail.com', '( 51 ) 98562 - 5609', 'Em aberto', '', 'Aluno');

-- ----------------------------
-- Table structure for `area_interesse`
-- ----------------------------
DROP TABLE IF EXISTS `area_interesse`;
CREATE TABLE `area_interesse` (
  `id_area_interesse` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`id_area_interesse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of area_interesse
-- ----------------------------

-- ----------------------------
-- Table structure for `banca`
-- ----------------------------
DROP TABLE IF EXISTS `banca`;
CREATE TABLE `banca` (
  `id_professor` int(11) NOT NULL,
  `id_proposta` int(11) NOT NULL,
  PRIMARY KEY (`id_professor`,`id_proposta`),
  KEY `banca_proposta_fk` (`id_proposta`),
  CONSTRAINT `banca_professor_fk` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `banca_proposta_fk` FOREIGN KEY (`id_proposta`) REFERENCES `proposta` (`id_proposta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of banca
-- ----------------------------

-- ----------------------------
-- Table structure for `professor`
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
  `id_professor` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `count_banca` int(11) NOT NULL,
  `senha` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_professor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of professor
-- ----------------------------

-- ----------------------------
-- Table structure for `proposta`
-- ----------------------------
DROP TABLE IF EXISTS `proposta`;
CREATE TABLE `proposta` (
  `id_proposta` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` int(11) NOT NULL,
  `id_area_interesse` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descricao` varchar(256) NOT NULL,
  `status` varchar(30) NOT NULL,
  PRIMARY KEY (`id_proposta`),
  KEY `proposta_area_interesse_fk` (`id_area_interesse`),
  KEY `proposta_aluno_fk` (`matricula`),
  KEY `proposta_professor_fk` (`id_professor`),
  CONSTRAINT `proposta_aluno_fk` FOREIGN KEY (`matricula`) REFERENCES `aluno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `proposta_interesse_fk` FOREIGN KEY (`id_area_interesse`) REFERENCES `area_interesse` (`id_area_interesse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `proposta_professor_fk` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of proposta
-- ----------------------------
