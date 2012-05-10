-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 10, 2012 at 03:02 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `warehouse`
--

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE IF NOT EXISTS `branch` (
  `idBranch` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `zip` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idBranch`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`idBranch`, `name`, `address`, `city`, `state`, `zip`, `phone`, `fax`) VALUES
(1, 'Branch1', '123 Second Street', 'Rochester', 'NY', '14623', '8489923412', '8489923345'),
(2, 'Branch2', '456 Community Street', 'West Henrietta', 'NY', '14586', '8488273456', '8486673429');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `idItem` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `quantityInStock` int(11) DEFAULT NULL,
  `cost` decimal(10,0) DEFAULT NULL,
  `unitType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idItem`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`idItem`, `name`, `quantityInStock`, `cost`, `unitType`) VALUES
(1, 'Pepperoni', 100, 20, 'kilograms'),
(2, 'Cheese', 100, 10, 'kilograms'),
(3, 'Oil', 100, 2, 'kilograms'),
(4, 'Egg', 100, 3, 'dozens'),
(5, 'Dough', 100, 5, 'kilograms'),
(6, 'Bacon', 100, 10, 'kilograms'),
(7, 'Tuna', 100, 50, 'kilograms'),
(8, 'Milk', 100, 2, 'liters'),
(9, 'Italian Susage', 10000, 10, 'grams');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `idLogin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `accesstype` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLogin`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`idLogin`, `username`, `password`, `accesstype`) VALUES
(1, 'owner', 'owner', 'admin'),
(2, 'branch1', 'branch1', 'branch'),
(3, 'branch2', 'branch2', 'branch'),
(4, 'Cashier', 'Cashier', 'cashier'),
(5, 'Warehouse', 'Warehouse', 'warehouse');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `idOrder` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `cost` varchar(45) DEFAULT NULL,
  `idBranch` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrder`),
  KEY `idBranchFK` (`idBranch`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`idOrder`, `date`, `cost`, `idBranch`) VALUES
(1, '2011-01-01 08:20:08', '170', 1),
(2, '2011-01-01 14:19:38', '42.2', 2),
(3, '2011-05-05 09:55:28', '100', 1),
(4, '2011-05-05 05:26:53', '520', 2);

-- --------------------------------------------------------

--
-- Table structure for table `order_item`
--

CREATE TABLE IF NOT EXISTS `order_item` (
  `idOrder` int(11) NOT NULL AUTO_INCREMENT,
  `idItem` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOrder`,`idItem`),
  KEY `idOrderFK` (`idOrder`),
  KEY `idItemFK` (`idItem`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `order_item`
--

INSERT INTO `order_item` (`idOrder`, `idItem`, `quantity`) VALUES
(1, 1, 3),
(1, 2, 10),
(1, 3, 5),
(2, 3, 600),
(2, 4, 12),
(2, 9, 500),
(3, 5, 10),
(3, 6, 5),
(4, 7, 10),
(4, 8, 10);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `idBranchFK` FOREIGN KEY (`idBranch`) REFERENCES `branch` (`idBranch`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `order_item`
--
ALTER TABLE `order_item`
  ADD CONSTRAINT `idOrderFK` FOREIGN KEY (`idOrder`) REFERENCES `order` (`idOrder`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `idItemFK` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
