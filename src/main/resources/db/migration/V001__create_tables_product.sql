CREATE TABLE `calculatorOutput` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `uuid` varchar(255) NOT NULL,
                           `name` varchar(100) NOT NULL,
                           `calculatedValue` float(13) NOT NULL,
                           `status` int(1) NOT NULL,
                           `created_by` bigint(20) DEFAULT NULL,
                           `last_update_by` bigint(20) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;