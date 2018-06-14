-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Jun-2018 às 02:56
-- Versão do servidor: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projetopoo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dataNascimento` varchar(10) NOT NULL,
  `telefone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `sexo`, `cpf`, `endereco`, `email`, `dataNascimento`, `telefone`) VALUES
(1, 'Leonardo', 'M', '333', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(52, 'Leonardo', 'M', '3773', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(53, 'Leonardo', 'M', '3773', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(54, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(55, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(56, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(57, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(58, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(59, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(60, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(61, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885'),
(62, 'Leonardo', 'M', '555', 'Avenida Boa Viagem, 1000', 'leonardogm16@gmail.com', '30/10/1990', '81997724885');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL,
  `cnpj` int(14) NOT NULL,
  `razaoSocial` varchar(100) NOT NULL,
  `nomeFantasia` varchar(100) NOT NULL,
  `contato` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `cnpj`, `razaoSocial`, `nomeFantasia`, `contato`, `email`, `telefone`, `status`) VALUES
(1, 2147483647, 'razãot', 'fantasiat', 'contatot', 'emailt', 'telefonet', b'1'),
(2, 2147483647, 'razãot', 'fantasiat', 'contatot', 'emailt', 'telefonet', b'1'),
(3, 2147483647, 'razãot', 'fantasiat', 'contatot', 'emailt', 'telefonet', b'1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `funcao` varchar(50) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `departamento` varchar(50) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `dataNascimento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `funcao`, `cpf`, `sexo`, `telefone`, `departamento`, `status`, `dataNascimento`) VALUES
(1, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(2, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(3, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(4, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(5, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(6, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(7, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(8, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(9, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980'),
(10, 'Pedro', 'vendedor', '22333444', 'M', '99992222', 'vendas', NULL, '03/01/1980');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `descricao` varchar(100) NOT NULL,
  `valorProduto` int(100) NOT NULL,
  `quantidade` int(255) DEFAULT NULL,
  `status` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `descricao`, `valorProduto`, `quantidade`, `status`) VALUES
(1, 'agua', 5, 1000, b'1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `idVenda` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `valorTotal` int(100) NOT NULL,
  `dataVenda` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`idVenda`, `idUsuario`, `idCliente`, `idFuncionario`, `idProduto`, `valorTotal`, `dataVenda`) VALUES
(1, 1, 1, 1, 1, 120, '0000-00-00'),
(2, 1, 1, 1, 1, 1040, '0000-00-00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendaproduto`
--

CREATE TABLE `vendaproduto` (
  `idVenda` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- Indexes for table `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`idVenda`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `venda`
--
ALTER TABLE `venda`
  MODIFY `idVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
