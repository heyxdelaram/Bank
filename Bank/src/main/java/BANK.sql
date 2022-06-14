DROP DATABASE IF EXISTS `bank`;
CREATE DATABASE `bank`;
USE `bank`;

SET NAMES 'utf8';
SET character_set_client = utf8mb4;

-- CUSTOMERS --
CREATE TABLE `customers` (
	`customer_id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `father_name` VARCHAR(20),
    `national_code` VARCHAR(13) NOT NULL,
    `password` VARCHAR(15) NOT NULL
    `cell_phone` VARCHAR(50) NOT NULL,
	`address` VARCHAR(100) NOT NULL,  
    `city` varchar(50) NOT NULL,
    `birth_date` date NOT NULL,
    PRIMARY KEY (`customer_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `customers` VALUES(1, 'Tom', 'Rollen', 'Ben', '044-647-3290', 'CUSTOMER1234' '+989120983472', '5 Spohn Circle', 'Tehran', '1964-08-30'); 
INSERT INTO `customers` VALUES(2, 'Riley', 'Ryans', 'Will', '034-942-9372', 'CUSTOMER3456', '+989198368408', '50 Lillian Crossing', 'Tabriz', '1974-03-21');

-- STAFF --
CREATE TABLE `staff` (
	`staff_id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
	`father_name` VARCHAR(20),
    `national_code` VARCHAR(13) NOT NULL,
    `cell_phone` VARCHAR(50) NOT NULL,
	`address` VARCHAR(100) NOT NULL,  
    `city` varchar(50) NOT NULL,
    `birth_date` date NOT NULL,
    `position` VARCHAR(50) NOT NULL,
    `salary` DECIMAL(12,2) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`staff_id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `staff` VALUES (1, 'Freddi', 'MacCaffrey', 'Athony', '098-239-8732', '+989196753902',
							'251 Springs Junction', 'Tehran', '1985-02-07', 'Accountant', '20000.00', 'freddi_maccaffrey', 'frey732');
INSERT INTO `staff` VALUES (2, 'Andy', 'Georgian', NULL, '023-798-3076', '+989199473920',
							'7 Manley Drive', 'Esfahan', '1964-08-30', 'Accountant', '25000.00', 'andy_georgian', 'anan830');
INSERT INTO `staff` VALUES (3, 'Johnny', 'Depp', 'Andrew', '198-332-9687', '+989123874302',
							'538 Mosinee Center', 'Tehran', '1969-10-13', 'Human Resources', '45000.00', 'johnny_depp', 'jopp296');
INSERT INTO `staff` VALUES (4, 'Michelle', 'Streep', 'Steve', '144-578-80943', '+989128741831',
							'68 Lawn Avenue', 'Tehran', '1974-04-14', 'Manager', '90000.00', 'michelle_streep', 'miep943');
                            

-- LOANS --
CREATE TABLE `loans`(
	`loan_id` INT NOT NULL AUTO_INCREMENT,
    `customer_id` INT NOT NULL,
    `amount` DECIMAL(12,2) DEFAULT '0',
    `on_loan` TINYINT(1) NOT NULL,
    PRIMARY KEY (`loan_id`),
    KEY `fk_customer_idx` (`customer_id`),
    CONSTRAINT `customer_idx` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `loans` VALUES (1, 2, 28.89,1);
INSERT INTO `loans` VALUES (2, 1, 437.5,1);

-- ACCOUNT --
CREATE TABLE `accounts`(
	`account_id` INT NOT NULL AUTO_INCREMENT,
    `account_number` VARCHAR(10) NOT NULL,
    `customer_id` INT NOT NULL,
    `account_type` VARCHAR(25) NOT NULL,
    `balance` DECIMAL(12,2) DEFAULT '0',
    `loan_status` INT,
    PRIMARY KEY (`account_id`),
    KEY `fk_customer_idx` (`customer_id`),
    KEY `fk_loan_statusx` (`loan_status`),
    CONSTRAINT `fk_customer_idx` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT `fk_loan_statusx` FOREIGN KEY (`loan_status`) REFERENCES `loans` (`loan_id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `accounts` VALUES (1, '1293427420', 1, 'Checkings', 234.98, 2);
INSERT INTO `accounts` VALUES (2, '0590439283', 2, 'Savings', 400, 1);


-- CARDS --
CREATE TABLE `cards` (
	`cards_id` INT NOT NULL AUTO_INCREMENT,
    `customer_id` INT,
    `card_number` VARCHAR(16),
    `issuance_date` date,
    `expiry_date` date,
    `cvv2` INT(3),
    PRIMARY KEY (`cards_id`),
    KEY `fx_customer_idx` (`customer_id`),
    CONSTRAINT `fx_customer_idx` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `cards` VALUES (1, 2, '1293427420498273','2002-09-09', '2022-07-09', 134);
INSERT INTO `cards` VALUES (2, 1, '0590439283372950','2003-06-11', '2022-10-30', 635);
-- CHECKS --
CREATE TABLE `checks` (
	`check_id` INT NOT NULL AUTO_INCREMENT,
	`payee_id` INT,
    `amount_in_numbers` DECIMAL(12,2) DEFAULT '0' NOT NULL,
    `amount_in_words` VARCHAR(100) NOT NULL,
    `for_id` INT NOT NULL,
    `account_number` INT NOT NULL,
    `current_date` date NOT NULL,
	PRIMARY KEY (`check_id`),
	KEY `fx_payee_idx` (`payee_id`),
    KEY `fx_for_idx` (`for_id`),
    KEY `fx_account_numberx` (`account_number`),
    CONSTRAINT `fx_payee_idx` FOREIGN KEY (`payee_id`) REFERENCES `customers` (`customer_id`),
    CONSTRAINT `fx_for_idx` FOREIGN KEY (`for_id`) REFERENCES `customers` (`customer_id`),
    CONSTRAINT `fx_account_numberx` FOREIGN KEY (`account_number`) REFERENCES `accounts` (`account_id`) -- ????
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `checks` VALUES (1, 2, 55.9, 'fifty five dollars and 90 cents', 1, 2, '2022-03-25');

-- TRANSACTIONS --
CREATE TABLE `transactions`(
	`transaction_id` INT NOT NULL AUTO_INCREMENT,
    `from_id` INT,
    `to_id` INT,
    `amount` DECIMAL(12,2) DEFAULT '0',
    `loan_id` INT DEFAULT NULL,
    `check_id` INT DEFAULT NULL,
    `time` time,
    `date` date,
    PRIMARY KEY (`transaction_id`),
    KEY `fx_from_idx` (`from_id`),
    KEY `fx_to_idx`(`to_id`),
    KEY `fx_loan_idx`(`loan_id`),
    KEY `fx_check_idx` (`check_id`),
    CONSTRAINT `fx_from_idx` FOREIGN KEY (`from_id`) REFERENCES `accounts` (`account_id`),
    CONSTRAINT `fx_to_idx` FOREIGN KEY (`to_id`) REFERENCES `accounts` (`account_id`),
    CONSTRAINT `fx_loan_idx`FOREIGN KEY (`loan_id`) REFERENCES `loans` (`loan_id`),
    CONSTRAINT `fx_check_idx` FOREIGN KEY (`check_id`) REFERENCES `checks` (`check_id`)
    
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO `transactions` VALUES (1, 2, 1, 55.9, 1, 1, '19:43:19', '2022-03-13');

CREATE TABLE `central bank` (
	`id` TINYINT(1) NOT NULL,
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;



