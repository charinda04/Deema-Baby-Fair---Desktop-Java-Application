-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2017 at 04:13 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `deemababyfair`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `Emp_ID` varchar(10) NOT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Last_Name` varchar(30) NOT NULL,
  `Gender` varchar(1) NOT NULL,
  `DOB` date NOT NULL,
  `Age` int(2) NOT NULL,
  `NIC_No` varchar(10) NOT NULL,
  `Contact_No` int(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Salary` int(10) NOT NULL,
  `Password` int(20) NOT NULL,
  `Is_A_Admin` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Emp_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`Emp_ID`, `First_Name`, `Last_Name`, `Gender`, `DOB`, `Age`, `NIC_No`, `Contact_No`, `Address`, `Salary`, `Password`, `Is_A_Admin`) VALUES
('admin', 'Danul ', 'Kudagama', 'M', '1985-01-11', 32, '856547895V', 771235986, 'No. 6, “Deema Baby Fair” Mawanella Road, Rambukkan', 0, 1111, 1),
('E1', 'Charinda', 'Dissanayake', 'M', '1994-08-27', 22, '942401906V', 775864868, '238/A, Franklands Estate, Veyangoda', 30000, 2222, 0),
('E2', 'Rasitha', 'Gamage', 'M', '1994-02-09', 23, '946231478V', 776321457, '111/A, Gregory Road, Kottawa', 25000, 3333, 0),
('E3', 'fdsdf', 'sfsd', 'M', '2017-01-07', 0, '46', 345345, 'rtret', 3434, 2423, 0);

-- --------------------------------------------------------

--
-- Table structure for table `employee_salary`
--

CREATE TABLE IF NOT EXISTS `employee_salary` (
  `Emp_ID` varchar(10) NOT NULL,
  `Month` int(10) NOT NULL,
  `Year` int(10) NOT NULL,
  `Bonus` double NOT NULL,
  PRIMARY KEY (`Emp_ID`,`Month`,`Year`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_salary`
--

INSERT INTO `employee_salary` (`Emp_ID`, `Month`, `Year`, `Bonus`) VALUES
('admin', 1, 2017, 400),
('E1', 1, 2017, 300),
('E2', 1, 2017, 0);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE IF NOT EXISTS `order` (
  `Order_ID` varchar(10) NOT NULL,
  `Order_Date` date NOT NULL,
  `Payment_Status` varchar(10) NOT NULL,
  `Due_Date` date NOT NULL,
  `Discount_Recieved` double NOT NULL,
  `Sup_ID` varchar(10) NOT NULL,
  `Receive_Status` int(1) DEFAULT '0',
  PRIMARY KEY (`Order_ID`),
  KEY `Sup_ID` (`Sup_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_ID`, `Order_Date`, `Payment_Status`, `Due_Date`, `Discount_Recieved`, `Sup_ID`, `Receive_Status`) VALUES
('O1', '2017-01-01', 'Paid', '2017-01-12', 0, 'S1', 1),
('O2', '2017-01-01', 'Not Paid', '2017-01-11', 0, 'S1', 0),
('O3', '2017-01-01', 'Paid', '2017-01-31', 0, 'S1', 1),
('O4', '2017-01-01', 'Paid', '2017-01-25', 0, 'S1', 1),
('O5', '2017-01-01', 'Paid', '2017-01-11', 10, 'S1', 0);

-- --------------------------------------------------------

--
-- Table structure for table `order_product`
--

CREATE TABLE IF NOT EXISTS `order_product` (
  `Order_ID` varchar(10) NOT NULL,
  `Pro_ID` varchar(10) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `Unit_Price` double NOT NULL,
  `Expiriy_Date` date DEFAULT NULL,
  PRIMARY KEY (`Order_ID`,`Pro_ID`),
  KEY `Order_ID` (`Order_ID`,`Pro_ID`),
  KEY `order_product_fk2` (`Pro_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_product`
--

INSERT INTO `order_product` (`Order_ID`, `Pro_ID`, `Quantity`, `Unit_Price`, `Expiriy_Date`) VALUES
('O1', 'P1', 50, 50, '2017-01-28'),
('O1', 'P2', 50, 45, NULL),
('O2', 'P1', 30, 30, NULL),
('O2', 'P2', 30, 30, '2017-01-27'),
('O3', 'P1', 50, 50, NULL),
('O3', 'P2', 50, 40, '2017-01-27'),
('O4', 'P1', 10, 50, '2017-01-19'),
('O4', 'P2', 10, 45, NULL),
('O5', 'P3', 100, 20, '2017-01-30');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `Pro_ID` varchar(10) NOT NULL,
  `Product_Name` varchar(20) NOT NULL,
  `Quantity` int(10) DEFAULT '0',
  `Unit_Price` double DEFAULT '0',
  `Discount` double DEFAULT '0',
  PRIMARY KEY (`Pro_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`Pro_ID`, `Product_Name`, `Quantity`, `Unit_Price`, `Discount`) VALUES
('P1', 'Kohoba Baby Soap', 30, 55, 0),
('P2', 'Pears Baby', 45, 50, 0),
('P3', 'Baby Diper', 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `rejected_orders`
--

CREATE TABLE IF NOT EXISTS `rejected_orders` (
  `Pro_ID` varchar(10) NOT NULL,
  `Order_ID` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `Discription` varchar(50) NOT NULL,
  `Quantity` int(11) NOT NULL,
  PRIMARY KEY (`Pro_ID`,`Order_ID`),
  KEY `Pro_ID` (`Pro_ID`,`Order_ID`),
  KEY `reject_orders_fk2` (`Order_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rejected_orders`
--

INSERT INTO `rejected_orders` (`Pro_ID`, `Order_ID`, `Date`, `Discription`, `Quantity`) VALUES
('P1', 'O2', '2017-01-01', 'Expired', 30),
('P2', 'O2', '2017-01-01', 'Expired', 30),
('P3', 'O5', '2017-01-01', 'Faulty Product', 100);

-- --------------------------------------------------------

--
-- Table structure for table `returned_sales`
--

CREATE TABLE IF NOT EXISTS `returned_sales` (
  `Pro_ID` varchar(10) NOT NULL,
  `Sales_ID` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `Discription` varchar(50) NOT NULL,
  `Quantity` int(10) NOT NULL,
  PRIMARY KEY (`Pro_ID`,`Sales_ID`),
  KEY `returned_sales_fk2` (`Sales_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `returned_sales`
--

INSERT INTO `returned_sales` (`Pro_ID`, `Sales_ID`, `Date`, `Discription`, `Quantity`) VALUES
('P1', 'S1', '2017-01-01', 'Faulty Product', 1),
('P1', 'S7', '2017-01-01', 'Broken Seal', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `Sales_ID` varchar(10) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Emp_ID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Sales_ID`),
  KEY `Emp_ID` (`Emp_ID`),
  KEY `Emp_ID_2` (`Emp_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`Sales_ID`, `Date`, `Time`, `Emp_ID`) VALUES
('S1', '2017-01-01', '15:03:05', 'admin'),
('S2', '2017-01-01', '15:05:19', 'admin'),
('S3', '2017-01-01', '15:12:39', 'admin'),
('S4', '2017-01-01', '15:15:48', 'admin'),
('S5', '2017-01-01', '18:49:59', 'E1'),
('S6', '2017-01-01', '18:51:56', 'E1'),
('S7', '2017-01-01', '20:21:19', 'E1');

-- --------------------------------------------------------

--
-- Table structure for table `sales_product`
--

CREATE TABLE IF NOT EXISTS `sales_product` (
  `Sales_ID` varchar(10) NOT NULL,
  `Pro_ID` varchar(10) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `Unit_Price` double NOT NULL,
  `Discount_Given` double NOT NULL,
  PRIMARY KEY (`Sales_ID`,`Pro_ID`),
  KEY `Sales_ID` (`Sales_ID`,`Pro_ID`),
  KEY `sales_product_fk2` (`Pro_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales_product`
--

INSERT INTO `sales_product` (`Sales_ID`, `Pro_ID`, `Quantity`, `Unit_Price`, `Discount_Given`) VALUES
('S1', 'P1', 1, 55, 0),
('S1', 'P2', 1, 50, 0),
('S2', 'P1', 1, 55, 0),
('S2', 'P2', 1, 50, 0),
('S3', 'P1', 1, 55, 0),
('S3', 'P2', 1, 50, 0),
('S4', 'P1', 1, 55, 0),
('S4', 'P2', 1, 50, 0),
('S5', 'P1', 1, 55, 0),
('S5', 'P2', 1, 50, 0),
('S6', 'P1', 1, 55, 0),
('S6', 'P2', 1, 50, 0),
('S7', 'P1', 1, 55, 0),
('S7', 'P2', 1, 50, 0);

-- --------------------------------------------------------

--
-- Table structure for table `store`
--

CREATE TABLE IF NOT EXISTS `store` (
  `Compartment_ID` varchar(10) NOT NULL,
  `Quantity` int(10) NOT NULL,
  `Pro_ID` varchar(10) NOT NULL,
  PRIMARY KEY (`Compartment_ID`),
  KEY `Pro_ID` (`Pro_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `store`
--

INSERT INTO `store` (`Compartment_ID`, `Quantity`, `Pro_ID`) VALUES
('C1', 33, 'P1'),
('C2', 88, 'P2');

-- --------------------------------------------------------

--
-- Table structure for table `store_history`
--

CREATE TABLE IF NOT EXISTS `store_history` (
  `Compartment_ID` varchar(10) NOT NULL,
  `Pro_ID` varchar(10) NOT NULL,
  `Action` text NOT NULL,
  `Previous_Quantity` int(11) NOT NULL,
  `New_Quantity` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Emp_ID` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Compartment_ID`,`Date`,`Time`),
  KEY `Compartment_ID` (`Compartment_ID`,`Pro_ID`),
  KEY `Pro_ID` (`Pro_ID`),
  KEY `Emp_ID` (`Emp_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `store_history`
--

INSERT INTO `store_history` (`Compartment_ID`, `Pro_ID`, `Action`, `Previous_Quantity`, `New_Quantity`, `Date`, `Time`, `Emp_ID`) VALUES
('C1', 'P1', 'Add', 0, 50, '2017-01-01', '14:47:36', 'admin'),
('C1', 'P1', 'Quantity Decreased', 50, 20, '2017-01-01', '14:50:12', 'Not_found'),
('C1', 'P1', 'Quantity Decreased', 20, 19, '2017-01-01', '14:58:22', 'admin'),
('C1', 'P1', 'Quantity Decreased', 19, 17, '2017-01-01', '15:01:27', 'admin'),
('C1', 'P1', 'Quantity Decreased', 17, 2, '2017-01-01', '15:01:40', 'admin'),
('C1', 'P1', 'Add', 10, 62, '2017-01-01', '19:56:38', 'E1'),
('C1', 'P1', 'Quantity Decreased', 62, 42, '2017-01-01', '20:02:41', 'E1'),
('C1', 'P1', 'Quantity Decreased', 42, 22, '2017-01-01', '20:05:52', 'E1'),
('C1', 'P1', 'Quantity Increased', 22, 33, '2017-01-01', '20:08:07', 'E1'),
('C2', 'P2', 'Add', 0, 50, '2017-01-01', '14:47:36', 'admin'),
('C2', 'P2', 'Quantity Decreased', 50, 30, '2017-01-01', '14:51:12', 'Not_found'),
('C2', 'P2', 'Quantity Decreased', 30, 28, '2017-01-01', '15:01:08', 'admin'),
('C2', 'P2', 'Add', 10, 88, '2017-01-01', '19:56:38', 'E1');

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `Sup_ID` varchar(10) NOT NULL,
  `Sup_Name` varchar(50) NOT NULL,
  `Contact_No` int(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  PRIMARY KEY (`Sup_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`Sup_ID`, `Sup_Name`, `Contact_No`, `Address`) VALUES
('S1', 'Dian Jayasuriya', 773214569, '22/A, John Road, Colombo 03');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee_salary`
--
ALTER TABLE `employee_salary`
  ADD CONSTRAINT `emploee_salary_fk` FOREIGN KEY (`Emp_ID`) REFERENCES `employee` (`Emp_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_supplier_fk` FOREIGN KEY (`Sup_ID`) REFERENCES `supplier` (`Sup_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_product`
--
ALTER TABLE `order_product`
  ADD CONSTRAINT `order_product_fk1` FOREIGN KEY (`Order_ID`) REFERENCES `order` (`Order_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `order_product_fk2` FOREIGN KEY (`Pro_ID`) REFERENCES `products` (`Pro_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rejected_orders`
--
ALTER TABLE `rejected_orders`
  ADD CONSTRAINT `reject_orders_fk1` FOREIGN KEY (`Pro_ID`) REFERENCES `products` (`Pro_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reject_orders_fk2` FOREIGN KEY (`Order_ID`) REFERENCES `order` (`Order_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `returned_sales`
--
ALTER TABLE `returned_sales`
  ADD CONSTRAINT `returned_sales_fk1` FOREIGN KEY (`Pro_ID`) REFERENCES `products` (`Pro_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `returned_sales_fk2` FOREIGN KEY (`Sales_ID`) REFERENCES `sales` (`Sales_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `employee_sales_fk` FOREIGN KEY (`Emp_ID`) REFERENCES `employee` (`Emp_ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `sales_product`
--
ALTER TABLE `sales_product`
  ADD CONSTRAINT `sales_product_fk1` FOREIGN KEY (`Sales_ID`) REFERENCES `sales` (`Sales_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sales_product_fk2` FOREIGN KEY (`Pro_ID`) REFERENCES `products` (`Pro_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `store`
--
ALTER TABLE `store`
  ADD CONSTRAINT `store_product_fk` FOREIGN KEY (`Pro_ID`) REFERENCES `products` (`Pro_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
