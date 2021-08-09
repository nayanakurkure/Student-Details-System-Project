Create database Student;
show databases;
use Student;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `admintbl` (
  `id` int(11) NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `admintbl` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `Name` text NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` text NOT NULL,
  `DOB_DAY` int(11) NOT NULL,
  `DOB_MONTH` text NOT NULL,
  `DOB_YEAR` int(11) NOT NULL,
  `Gender` text NOT NULL,
  `Address` text NOT NULL,
  `Nationality` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `Name`, `Email`, `Password`, `DOB_DAY`, `DOB_MONTH`, `DOB_YEAR`, `Gender`, `Address`, `Nationality`) VALUES
(24, 'Mangala Kurkure', 'mangala@gmail.com', 'mangala', 26, 'sup', 1995, 'female', '16,Dena nagar,Bhusawal', ''),
(25, 'abcde', 'abcde.com', 'abcde', 4, 'Apr', 1997, 'female', 'shahu nagar,bhusawal.', 'INDIAN'),
(28, 'Nayana', 'nayana@gmail.com', 'nayana', 19, 'Mar', 1998, 'female', 'Shanti nagar,Bhusawal', 'INDIAN');
select * from user;
--
-- Indexes for dumped tables
--

--
-- Indexes for table `admintbl`
--
ALTER TABLE `admintbl`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

-- AUTO_INCREMENT for table `admintbl`
--
ALTER TABLE `admintbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
