-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 08, 2023 lúc 06:06 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shoe`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admins`
--

CREATE TABLE `admins` (
  `admin_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `level` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `admins`
--

INSERT INTO `admins` (`admin_id`, `email`, `level`, `name`, `password`) VALUES
(1, 'admin12@gmail.com', 1, 'Ling', '12345');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brands`
--

CREATE TABLE `brands` (
  `brand_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `brands`
--

INSERT INTO `brands` (`brand_id`, `name`) VALUES
(1, 'Nike'),
(2, 'Adidas'),
(3, 'Ananas'),
(4, 'Anta');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `colordetail`
--

CREATE TABLE `colordetail` (
  `product_id` bigint(20) NOT NULL,
  `color_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `colordetail`
--

INSERT INTO `colordetail` (`product_id`, `color_id`) VALUES
(1, 3),
(1, 1),
(1, 2),
(2, 1),
(2, 2),
(2, 3),
(3, 2),
(3, 1),
(3, 3),
(4, 2),
(4, 3),
(4, 1),
(5, 1),
(5, 3),
(5, 2),
(6, 2),
(6, 1),
(6, 3),
(7, 2),
(7, 3),
(7, 1),
(8, 1),
(8, 2),
(8, 3),
(9, 1),
(9, 2),
(9, 3),
(10, 2),
(10, 3),
(10, 1),
(11, 1),
(11, 2),
(11, 3),
(12, 3),
(12, 2),
(12, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `colors`
--

CREATE TABLE `colors` (
  `color_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `colors`
--

INSERT INTO `colors` (`color_id`, `name`) VALUES
(1, 'White'),
(2, 'Black'),
(3, 'Red'),
(4, 'Blue'),
(5, 'Green'),
(6, 'Pink');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customers`
--

CREATE TABLE `customers` (
  `customer_id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customers`
--

INSERT INTO `customers` (`customer_id`, `address`, `email`, `name`, `password`, `phone`) VALUES
(1, 'Vietnam', 'ling@gmail.com', 'Linh Huynh', '12345', '0865452355');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `genres`
--

CREATE TABLE `genres` (
  `genre_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `genres`
--

INSERT INTO `genres` (`genre_id`, `name`) VALUES
(1, 'Giày Da'),
(2, 'sneaker'),
(3, 'Sandal'),
(4, 'Boot');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetails`
--

CREATE TABLE `orderdetails` (
  `id` bigint(20) NOT NULL,
  `number` int(11) NOT NULL,
  `price` double NOT NULL,
  `color_id` bigint(20) DEFAULT NULL,
  `order_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `size_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orderdetails`
--

INSERT INTO `orderdetails` (`id`, `number`, `price`, `color_id`, `order_id`, `product_id`, `size_id`) VALUES
(1, 1, 980, 2, 1, 3, 2),
(2, 1, 980, 1, 1, 6, 4),
(3, 2, 1960, 2, 2, 2, 4),
(4, 1, 760, 1, 2, 8, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL,
  `date` datetime DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `customer_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`order_id`, `date`, `total_price`, `address`, `status`, `customer_id`) VALUES
(1, '2023-04-08 22:52:38', 1960, 'Vietnam', 1, 1),
(2, '2023-04-08 22:56:41', 2720, 'Vietnam Trái đất ', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `product_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `urlimage` varchar(255) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `genre_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`product_id`, `description`, `name`, `price`, `urlimage`, `brand_id`, `genre_id`) VALUES
(1, 'new Nike 2024', 'Giày Nike Wmns Air Zoom Vomero 16 DA7698-004 Nữ', 1111, '/images/giay-chay-bo-nu-nike-wmns-air-zoom-vomero-16-da7698-004-thumb-600x600.jpg', 1, 2),
(2, 'new Nike 2024', 'Giày chạy bộ nam nike air zoom ', 980, '/images/giay-chay-bo-nam-nike-air-zoom-pegasus-39-dh4071-102-081222-032916-600x600.jpg', 1, 2),
(3, 'new Nike 2024', 'Giày chạy bộ nam ', 980, '/images/giay-chay-bo-nam-nike-air-zoom-pegasus-39-dh4071-302-thumb-4-600x600.jpg', 2, 1),
(4, 'new Nike 2024', 'Giày chạy bộ nam ', 980, '/images/giay-chay-bo-nam-nike-air-zoom-vomero-16-da7245-008-thumb-600x600.jpg', 3, 3),
(5, 'new Nike 2024', 'Giày chạy bộ nam ', 980, '/images/giay-chay-bo-nam-nike-react-miler-3-dd0490-001-thumb-1-600x600.jpg', 4, 4),
(6, 'new Nike 2024', 'Giày chạy bộ nữ react miler 3', 980, '/images/giay-chay-bo-nam-nike-react-miler-3-dd0490-100-thumb-1-600x600.jpg', 4, 4),
(7, 'new Nike 2024', 'Giày chạy nike wmns air zoom vomero', 980, '/images/giay-chay-bo-nu-nike-wmns-air-zoom-vomero-16-da7698-004-thumb-600x600.jpg', 1, 1),
(8, 'new Nike 2024', 'Giày chạy nike wmns air zoom pegasus', 760, '/images/giay-chay-bo-nu-wmns-nike-air-zoom-pegasus-39-dh4072-800-thumb-600x600.jpg', 2, 2),
(9, 'new Nike 2024', 'Giày lifestyle nam air max 90', 760, '/images/giay-lifestyle-nam-nike-air-max-90-dm0029-004-thumb-600x600.jpg', 2, 2),
(10, 'new Nike 2024', 'Giày lifestyle nam air max 97', 760, '/images/giay-lifestyle-nam-nike-air-max-97-dm0027-001-thumb-600x600.jpg', 3, 3),
(11, 'new Nike 2024', 'Giày lifestyle nam air max dawn', 760, '/images/giay-lifestyle-nam-nike-air-max-dawn-dj3624-001-thumb-1-600x600.jpg', 4, 4),
(12, 'new Nike 2024', 'Giày lifestyle nam nike blazer mid pro', 760, '/images/giay-lifestyle-nam-nike-blazer-mid-pro-club-dq7673-001-thumb-600x600.jpg', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `size`
--

CREATE TABLE `size` (
  `size_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `size`
--

INSERT INTO `size` (`size_id`, `name`) VALUES
(1, '36'),
(2, '37'),
(3, '38'),
(4, '39'),
(5, '40'),
(6, '41'),
(7, '42');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sizedetail`
--

CREATE TABLE `sizedetail` (
  `product_id` bigint(20) NOT NULL,
  `size_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `sizedetail`
--

INSERT INTO `sizedetail` (`product_id`, `size_id`) VALUES
(1, 1),
(1, 6),
(1, 5),
(1, 4),
(1, 2),
(1, 3),
(2, 4),
(2, 1),
(2, 2),
(2, 5),
(2, 3),
(2, 6),
(3, 2),
(3, 4),
(3, 5),
(3, 6),
(3, 3),
(3, 1),
(4, 2),
(4, 3),
(4, 4),
(4, 5),
(4, 1),
(4, 6),
(5, 4),
(5, 5),
(5, 1),
(5, 2),
(5, 6),
(5, 3),
(6, 4),
(6, 1),
(6, 6),
(6, 5),
(6, 2),
(6, 3),
(7, 5),
(7, 6),
(7, 4),
(7, 1),
(7, 2),
(7, 3),
(8, 1),
(8, 4),
(8, 5),
(8, 3),
(8, 6),
(8, 2),
(9, 3),
(9, 4),
(9, 5),
(9, 1),
(9, 2),
(9, 6),
(10, 2),
(10, 5),
(10, 3),
(10, 4),
(10, 1),
(10, 6),
(11, 1),
(11, 5),
(11, 4),
(11, 6),
(11, 2),
(11, 3),
(12, 3),
(12, 5),
(12, 4),
(12, 1),
(12, 2),
(12, 6);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`admin_id`);

--
-- Chỉ mục cho bảng `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`brand_id`);

--
-- Chỉ mục cho bảng `colordetail`
--
ALTER TABLE `colordetail`
  ADD KEY `FK85yduw9r7l8aj0tmx1mn2k6t3` (`color_id`),
  ADD KEY `FK6iq92sujgh118483wix7f7dei` (`product_id`);

--
-- Chỉ mục cho bảng `colors`
--
ALTER TABLE `colors`
  ADD PRIMARY KEY (`color_id`);

--
-- Chỉ mục cho bảng `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Chỉ mục cho bảng `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`genre_id`);

--
-- Chỉ mục cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKr72lbajurt82gbs9v4cxkvat3` (`color_id`),
  ADD KEY `FKhnsosbuy7bhpqpnt3bjr7sh8x` (`order_id`),
  ADD KEY `FK92im1bt9gndrexccag7x5oq92` (`product_id`),
  ADD KEY `FKnysi6pd93okj1e6fifd7o044c` (`size_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FKpxtb8awmi0dk6smoh2vp1litg` (`customer_id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `FKa3a4mpsfdf4d2y6r8ra3sc8mv` (`brand_id`),
  ADD KEY `FK1w6wsbg6w189oop2bl38v0hjk` (`genre_id`);

--
-- Chỉ mục cho bảng `size`
--
ALTER TABLE `size`
  ADD PRIMARY KEY (`size_id`);

--
-- Chỉ mục cho bảng `sizedetail`
--
ALTER TABLE `sizedetail`
  ADD KEY `FKjer45bv8qwf9l6t46twrh5b3q` (`size_id`),
  ADD KEY `FKj75v7ypycjfjgy02n2qfvjm87` (`product_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admins`
--
ALTER TABLE `admins`
  MODIFY `admin_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `brands`
--
ALTER TABLE `brands`
  MODIFY `brand_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `colors`
--
ALTER TABLE `colors`
  MODIFY `color_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `genres`
--
ALTER TABLE `genres`
  MODIFY `genre_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `product_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `size`
--
ALTER TABLE `size`
  MODIFY `size_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `colordetail`
--
ALTER TABLE `colordetail`
  ADD CONSTRAINT `FK6iq92sujgh118483wix7f7dei` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `FK85yduw9r7l8aj0tmx1mn2k6t3` FOREIGN KEY (`color_id`) REFERENCES `colors` (`color_id`);

--
-- Các ràng buộc cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `FK92im1bt9gndrexccag7x5oq92` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `FKhnsosbuy7bhpqpnt3bjr7sh8x` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  ADD CONSTRAINT `FKnysi6pd93okj1e6fifd7o044c` FOREIGN KEY (`size_id`) REFERENCES `size` (`size_id`),
  ADD CONSTRAINT `FKr72lbajurt82gbs9v4cxkvat3` FOREIGN KEY (`color_id`) REFERENCES `colors` (`color_id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKpxtb8awmi0dk6smoh2vp1litg` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK1w6wsbg6w189oop2bl38v0hjk` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`genre_id`),
  ADD CONSTRAINT `FKa3a4mpsfdf4d2y6r8ra3sc8mv` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`brand_id`);

--
-- Các ràng buộc cho bảng `sizedetail`
--
ALTER TABLE `sizedetail`
  ADD CONSTRAINT `FKj75v7ypycjfjgy02n2qfvjm87` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`),
  ADD CONSTRAINT `FKjer45bv8qwf9l6t46twrh5b3q` FOREIGN KEY (`size_id`) REFERENCES `size` (`size_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
