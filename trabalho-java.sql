-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Nov-2019 às 02:07
-- Versão do servidor: 10.4.8-MariaDB
-- versão do PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `trabalho-java`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(30) DEFAULT '',
  `email` varchar(100) NOT NULL,
  `telefone` varchar(30) NOT NULL,
  `perfil` varchar(30) NOT NULL,
  `senha` varchar(30) DEFAULT NULL,
  `proposta` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`matricula`, `nome`, `cpf`, `email`, `telefone`, `perfil`, `senha`, `proposta`) VALUES
(1, 'Alexandre Silva Lima', '935 . 808 . 430 - 87', 'limaalexguitar@gmail.com', '( 51 ) 98562 - 5609', 'Aluno', '1234', 'Em aberto'),
(5, 'Sofia Gomes Lima', '098 . 879 . 678 - 75', 'sofiagomes@gmail.com', '( 51 ) 98562 - 5609', 'Aluno', '1234', 'Em aberto'),
(723, 'Tucstênio', '827 . 389 . 283 - 74', 'tucstenio@gmail.com', '( 82 ) 73928 - 7394', 'Aluno', '1234', 'Em aberto'),
(876, 'Laura', '985 . 234 . 298 - 27', 'laura@gmail.com', '( 98 ) 76987 - 6987', 'Aluno', '1234', 'Em aberto'),
(9876, 'admin', '987 . 698 . 769 - 87', 'admin@admin', '( 51 ) 98769 - 8768', 'Aluno', '1234', 'Em aberto'),
(675675, 'Helamã Vieira', '727 . 364 . 827 - 36', 'ajsdhf@askdjkf.com', '( 76 ) 87687 - 6876', 'Aluno', '', 'Em aberto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `area_interesse`
--

CREATE TABLE `area_interesse` (
  `id_area_interesse` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `banca`
--

CREATE TABLE `banca` (
  `id_professor` int(11) NOT NULL,
  `id_proposta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `id_professor` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `count_banca` int(11) NOT NULL,
  `senha` varchar(30) DEFAULT NULL,
  `perfil` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`id_professor`, `nome`, `email`, `count_banca`, `senha`, `perfil`) VALUES
(1, 'Daniel Cauê Enrico Figueiredo', 'danielcaueenricofigueiredo_@officetectecnologia.com.br', 0, '1234', 'Professor'),
(2, 'Antonella Sophia Jéssica Moura', 'aantonellasophiajessicamoura@advocaciand.adv.br', 0, NULL, 'Professor'),
(3, 'Osvaldo Heitor Cavalcanti', 'osvaldoheitorcavalcanti_@i9pneus.com.br', 0, '1234', 'Professor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `proposta`
--

CREATE TABLE `proposta` (
  `id_proposta` int(11) NOT NULL,
  `matricula` int(11) NOT NULL,
  `id_area_interesse` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `descricao` varchar(256) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`matricula`);

--
-- Índices para tabela `area_interesse`
--
ALTER TABLE `area_interesse`
  ADD PRIMARY KEY (`id_area_interesse`);

--
-- Índices para tabela `banca`
--
ALTER TABLE `banca`
  ADD PRIMARY KEY (`id_professor`,`id_proposta`),
  ADD KEY `banca_proposta_fk` (`id_proposta`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id_professor`);

--
-- Índices para tabela `proposta`
--
ALTER TABLE `proposta`
  ADD PRIMARY KEY (`id_proposta`),
  ADD KEY `proposta_area_interesse_fk` (`id_area_interesse`),
  ADD KEY `proposta_aluno_fk` (`matricula`),
  ADD KEY `proposta_professor_fk` (`id_professor`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2019765766;

--
-- AUTO_INCREMENT de tabela `area_interesse`
--
ALTER TABLE `area_interesse`
  MODIFY `id_area_interesse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `id_professor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `proposta`
--
ALTER TABLE `proposta`
  MODIFY `id_proposta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `banca`
--
ALTER TABLE `banca`
  ADD CONSTRAINT `banca_professor_fk` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `banca_proposta_fk` FOREIGN KEY (`id_proposta`) REFERENCES `proposta` (`id_proposta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `proposta`
--
ALTER TABLE `proposta`
  ADD CONSTRAINT `proposta_aluno_fk` FOREIGN KEY (`matricula`) REFERENCES `aluno` (`matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `proposta_interesse_fk` FOREIGN KEY (`id_area_interesse`) REFERENCES `area_interesse` (`id_area_interesse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `proposta_professor_fk` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
