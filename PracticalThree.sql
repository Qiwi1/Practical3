-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Окт 12 2022 г., 16:46
-- Версия сервера: 5.6.51
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `PracticalThree`
--

-- --------------------------------------------------------

--
-- Структура таблицы `beauty`
--

CREATE TABLE `beauty` (
  `id` bigint(20) NOT NULL,
  `sostav` varchar(255) DEFAULT NULL,
  `kolwo` varchar(255) DEFAULT NULL,
  `nazvanie` varchar(255) DEFAULT NULL,
  `views` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `beauty`
--

INSERT INTO `beauty` (`id`, `sostav`, `kolwo`, `nazvanie`, `views`) VALUES
(22, 'Мазь офигительная', '11 штук', 'Мазь Достоевского', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `building`
--

CREATE TABLE `building` (
  `id` bigint(20) NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `floor_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `building`
--

INSERT INTO `building` (`id`, `adress`, `type`, `floor_id`) VALUES
(20, 'Ул. Пушкина', 'Дом', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `clothes`
--

CREATE TABLE `clothes` (
  `id` bigint(20) NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `tkan` varchar(255) DEFAULT NULL,
  `type_clothes` varchar(255) DEFAULT NULL,
  `ves` varchar(255) DEFAULT NULL,
  `nazvanie` varchar(255) DEFAULT NULL,
  `views` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `clothes`
--

INSERT INTO `clothes` (`id`, `size`, `tkan`, `type_clothes`, `ves`, `nazvanie`, `views`) VALUES
(26, 'XXL', 'Кожа', 'Полузакрытая', '1кг', 'Куртка', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `computer`
--

CREATE TABLE `computer` (
  `id` bigint(20) NOT NULL,
  `chipset` varchar(255) DEFAULT NULL,
  `cpu` varchar(255) DEFAULT NULL,
  `gpu` varchar(255) DEFAULT NULL,
  `ram_mb` int(11) NOT NULL,
  `rom_gb` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `documents`
--

CREATE TABLE `documents` (
  `id` bigint(20) NOT NULL,
  `inn` varchar(255) DEFAULT NULL,
  `snils` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `documents`
--

INSERT INTO `documents` (`id`, `inn`, `snils`) VALUES
(1, '123456789', '9876543212345'),
(2, '3214565241127', '127299746892732');

-- --------------------------------------------------------

--
-- Структура таблицы `floor`
--

CREATE TABLE `floor` (
  `id` bigint(20) NOT NULL,
  `floors` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `floor`
--

INSERT INTO `floor` (`id`, `floors`, `info`) VALUES
(1, 'Двадцать пятый', 'Квартира сбоку'),
(2, 'Третий', 'Квартира слева');

-- --------------------------------------------------------

--
-- Структура таблицы `fruit`
--

CREATE TABLE `fruit` (
  `id` bigint(20) NOT NULL,
  `forma` varchar(255) DEFAULT NULL,
  `kolwo` varchar(255) DEFAULT NULL,
  `nazvanie` varchar(255) DEFAULT NULL,
  `strana` varchar(255) DEFAULT NULL,
  `ves` varchar(255) DEFAULT NULL,
  `views` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `fruit`
--

INSERT INTO `fruit` (`id`, `forma`, `kolwo`, `nazvanie`, `strana`, `ves`, `views`) VALUES
(7, 'Овал1', '20', 'Манго', 'Россия1', '121', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(29);

-- --------------------------------------------------------

--
-- Структура таблицы `job_post`
--

CREATE TABLE `job_post` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `partpost` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `job_post`
--

INSERT INTO `job_post` (`id`, `name`, `partpost`) VALUES
(1, 'Менеджер по уборке прилегающих территорий', 'Уборка района'),
(2, 'Директор', 'Распределение документов');

-- --------------------------------------------------------

--
-- Структура таблицы `keyboard`
--

CREATE TABLE `keyboard` (
  `id` bigint(20) NOT NULL,
  `form_per` int(11) NOT NULL,
  `key_nums` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `switches` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `mobile`
--

CREATE TABLE `mobile` (
  `id` bigint(20) NOT NULL,
  `memory` varchar(255) DEFAULT NULL,
  `memorygb` varchar(255) DEFAULT NULL,
  `models_tel` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `views` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `mobile`
--

INSERT INTO `mobile` (`id`, `memory`, `memorygb`, `models_tel`, `number`, `operator`, `views`) VALUES
(28, '6000000', '70000', 'Sumsung', '83821932', 'Beeline', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `documents_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `person`
--

INSERT INTO `person` (`id`, `first_name`, `last_name`, `documents_id`) VALUES
(19, 'Oleg', 'Olegov', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `post`
--

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `anons` varchar(255) DEFAULT NULL,
  `full_text` varchar(255) DEFAULT NULL,
  `title` varchar(150) DEFAULT NULL,
  `views` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `username`) VALUES
(8, b'1', '', ''),
(9, b'1', 'kjh', '123'),
(10, b'1', '1234', 'Иван'),
(11, b'1', '123321', 'бдд'),
(12, b'1', '123321', 'qwe'),
(13, b'1', '123321456', 'qwerty'),
(14, b'1', '12qw12', 'qaws'),
(15, b'1', '$2a$08$KN9tnX6NT0pd812Nfqt7Ae.v2c63jdifB5qG/FxNOEowpVxcJIO5m', 'qw12'),
(16, b'1', '$2a$08$CS72tE7wOoSC69v5m5.goeTKRSPTOc3CJ4yYyaV5VSsWeVr8uP6hG', '12qw'),
(17, b'1', '$2a$08$2hXTDtarrCiPkOTjHDgJDe87yQRJy4ihgAt7gYJF3qE0gHmJ0kkpi', '11'),
(18, b'1', '$2a$08$MMIXseKjDMbRMpdOYnUtiOGejCgpLo6UCGrnNhbUuKgpMQSCKbiCO', '112'),
(24, b'1', '$2a$08$9V8JLlVp1QFL0.qYk2.LpOyZYSrxJTNJ7pJdCVvNuccQQFnbPn/by', 'Пользователь'),
(25, b'1', '$2a$08$iUQZxRkwJBdaMHVeK6g7BODkGkfCK8w8J6qa3XZfHf4en.ekSm.f2', 'Admin'),
(27, b'1', '$2a$08$hF.rL1WelivbWFablUsFfOTnHMEB9pTSQcYg7AsxIFNKlX6.jZkQG', '098');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(8, 'USER'),
(10, 'USER'),
(11, 'USER'),
(11, 'ADMIN'),
(12, 'USER'),
(13, 'USER'),
(14, 'USER'),
(15, 'USER'),
(15, 'ADMIN'),
(17, 'USER'),
(17, 'ADMIN'),
(18, 'USER'),
(18, 'ADMIN'),
(16, 'ADMIN'),
(9, 'USER'),
(24, 'USER'),
(25, 'ADMIN'),
(27, 'USER'),
(27, 'ADMIN');

-- --------------------------------------------------------

--
-- Структура таблицы `worker`
--

CREATE TABLE `worker` (
  `id` bigint(20) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `worker`
--

INSERT INTO `worker` (`id`, `last_name`, `firstname`) VALUES
(1, 'Минин', 'Артём'),
(2, 'Алексеев', 'Семён'),
(3, 'Зенков', 'Станислав'),
(4, 'Таршин', 'Тимофей'),
(5, 'Иванова', 'Александра'),
(6, 'Журавлев', 'Даниил');

-- --------------------------------------------------------

--
-- Структура таблицы `worker_jobpost`
--

CREATE TABLE `worker_jobpost` (
  `worker_id` bigint(20) NOT NULL,
  `jobpost_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `worker_jobpost`
--

INSERT INTO `worker_jobpost` (`worker_id`, `jobpost_id`) VALUES
(1, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `beauty`
--
ALTER TABLE `beauty`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `building`
--
ALTER TABLE `building`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKt31uwppoor9tc8hyn9c0gsqis` (`floor_id`);

--
-- Индексы таблицы `clothes`
--
ALTER TABLE `clothes`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `computer`
--
ALTER TABLE `computer`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `floor`
--
ALTER TABLE `floor`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `fruit`
--
ALTER TABLE `fruit`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `job_post`
--
ALTER TABLE `job_post`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `keyboard`
--
ALTER TABLE `keyboard`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `mobile`
--
ALTER TABLE `mobile`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKfiev27ekr5cnuedubbc7x46ee` (`documents_id`);

--
-- Индексы таблицы `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- Индексы таблицы `worker`
--
ALTER TABLE `worker`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `worker_jobpost`
--
ALTER TABLE `worker_jobpost`
  ADD KEY `FK90me6keoiiqn59k05nn5nvqkw` (`jobpost_id`),
  ADD KEY `FKd43ma3sk8cfxsishf4gmlxiuc` (`worker_id`);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `building`
--
ALTER TABLE `building`
  ADD CONSTRAINT `FKt31uwppoor9tc8hyn9c0gsqis` FOREIGN KEY (`floor_id`) REFERENCES `floor` (`id`);

--
-- Ограничения внешнего ключа таблицы `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FKfiev27ekr5cnuedubbc7x46ee` FOREIGN KEY (`documents_id`) REFERENCES `documents` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `worker_jobpost`
--
ALTER TABLE `worker_jobpost`
  ADD CONSTRAINT `FK90me6keoiiqn59k05nn5nvqkw` FOREIGN KEY (`jobpost_id`) REFERENCES `job_post` (`id`),
  ADD CONSTRAINT `FKd43ma3sk8cfxsishf4gmlxiuc` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
