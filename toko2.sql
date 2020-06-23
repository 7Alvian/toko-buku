-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2019 at 10:14 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toko`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `id_buku` varchar(20) NOT NULL,
  `penulis` varchar(20) NOT NULL,
  `judul` varchar(20) NOT NULL,
  `stok` int(10) NOT NULL,
  `penerbit` varchar(20) NOT NULL,
  `harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `id_distributor` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `alamat` text NOT NULL,
  `id_buku` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan_data_buku`
-- (See below for the actual view)
--
CREATE TABLE `laporan_data_buku` (
`id_buku` varchar(20)
,`nama` varchar(20)
,`stok` int(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `laporan_data_buku1`
-- (See below for the actual view)
--
CREATE TABLE `laporan_data_buku1` (
`id_buku` varchar(20)
,`nama` varchar(20)
,`stok` int(10)
);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('admin', 'rahasia'),
('kasir', 'rahasia');

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

CREATE TABLE `penerbit` (
  `id_penerbit` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `alamat` varchar(20) NOT NULL,
  `id_buku` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id_transaksi` varchar(20) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `penjualan1`
--

CREATE TABLE `penjualan1` (
  `id_transaksi` varchar(20) NOT NULL,
  `id_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `tanggal` varchar(20) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `harga` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_penerimaan`
--

CREATE TABLE `transaksi_penerimaan` (
  `id_transaksi` varchar(20) NOT NULL,
  `id_distributor` varchar(20) NOT NULL,
  `id_buku` varchar(20) NOT NULL,
  `jumlah` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_pengembalian`
--

CREATE TABLE `transaksi_pengembalian` (
  `id_transaksi` varchar(20) NOT NULL,
  `id_distributor` varchar(20) NOT NULL,
  `id_buku` varchar(20) NOT NULL,
  `jumlah` varchar(10) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure for view `laporan_data_buku`
--
DROP TABLE IF EXISTS `laporan_data_buku`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_data_buku`  AS  select `distributor`.`id_buku` AS `id_buku`,`distributor`.`nama` AS `nama`,`buku`.`stok` AS `stok` from (`buku` join `distributor` on((`buku`.`id_buku` = `distributor`.`id_buku`))) ;

-- --------------------------------------------------------

--
-- Structure for view `laporan_data_buku1`
--
DROP TABLE IF EXISTS `laporan_data_buku1`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `laporan_data_buku1`  AS  select `penerbit`.`id_buku` AS `id_buku`,`penerbit`.`nama` AS `nama`,`buku`.`stok` AS `stok` from (`buku` join `penerbit` on((`buku`.`id_buku` = `penerbit`.`id_buku`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`id_distributor`),
  ADD KEY `distributor_ibfk_1` (`id_buku`);

--
-- Indexes for table `penerbit`
--
ALTER TABLE `penerbit`
  ADD PRIMARY KEY (`id_penerbit`),
  ADD KEY `penerbit_ibfk_1` (`id_buku`);

--
-- Indexes for table `transaksi_penerimaan`
--
ALTER TABLE `transaksi_penerimaan`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `transaksi_penerimaan_ibfk_1` (`id_distributor`),
  ADD KEY `transaksi_penerimaan_ibfk_2` (`id_buku`);

--
-- Indexes for table `transaksi_pengembalian`
--
ALTER TABLE `transaksi_pengembalian`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `transaksi_pengembalian_ibfk_1` (`id_buku`),
  ADD KEY `transaksi_pengembalian_ibfk_2` (`id_distributor`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `distributor`
--
ALTER TABLE `distributor`
  ADD CONSTRAINT `distributor_ibfk_1` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`);

--
-- Constraints for table `penerbit`
--
ALTER TABLE `penerbit`
  ADD CONSTRAINT `penerbit_ibfk_1` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`);

--
-- Constraints for table `transaksi_penerimaan`
--
ALTER TABLE `transaksi_penerimaan`
  ADD CONSTRAINT `transaksi_penerimaan_ibfk_1` FOREIGN KEY (`id_distributor`) REFERENCES `buku` (`id_buku`),
  ADD CONSTRAINT `transaksi_penerimaan_ibfk_2` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`);

--
-- Constraints for table `transaksi_pengembalian`
--
ALTER TABLE `transaksi_pengembalian`
  ADD CONSTRAINT `transaksi_pengembalian_ibfk_1` FOREIGN KEY (`id_buku`) REFERENCES `buku` (`id_buku`),
  ADD CONSTRAINT `transaksi_pengembalian_ibfk_2` FOREIGN KEY (`id_distributor`) REFERENCES `distributor` (`id_distributor`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
