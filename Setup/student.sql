-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 20, 2014 at 07:34 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `e_wallet`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `bits_id` char(12) NOT NULL,
  `password` varchar(100) NOT NULL,
  `pin` char(4) NOT NULL DEFAULT '0000',
  `ewbalance` int(11) NOT NULL DEFAULT '0',
  `credit_avail` int(11) NOT NULL DEFAULT '5000',
  `swdbalance` int(11) NOT NULL DEFAULT '10000',
  `lb` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`bits_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `name`, `bits_id`, `password`, `pin`, `ewbalance`, `credit_avail`, `swdbalance`, `lb`) VALUES
(6, 'Shreyash', '1111', 'e2fc714c4727ee9395f324cd2e7f331f', '1234', 234, 6000, 766, 0),
(9, 'Prafful', '9999', 'd56047f41b82b810bd3f98891e481d0f', '1234', 5000, 5000, 5000, 0),
(10, 'Anubhav', '2011', '7694f4a66316e53c8cdd9d9954bd611d', '1234', 5100, 4850, 0, 0),
(11, 'soumyaraj', '9099', 'e2fc714c4727ee9395f324cd2e7f331f', '9900', 0, 5000, 10000, 0),
(12, 'abcbc', '566778', 'e2fc714c4727ee9395f324cd2e7f331f', '1234', 0, 5000, 10000, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
