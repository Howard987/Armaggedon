-- Reconstruction de la base de données Timesheet
DROP DATABASE IF EXISTS timesheet;
CREATE DATABASE timesheet;
USE timesheet;


--SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
--SET AUTOCOMMIT = 0;
--START TRANSACTION;
--SET time_zone = "+00:00";


-- Structure de la table `employee`

CREATE TABLE IF NOT EXISTS `employee` (
  `e_id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `e_name` varchar(30) NOT NULL,
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO employee ( e_id, e_name ) VALUES ( 1, 'Jean Pierre' );

SELECT * FROM employee;


-- Structure de la table `project`

CREATE TABLE IF NOT EXISTS `project` (
  `p_id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `p_name` varchar(30) NOT NULL,
  `p_start_date` date NOT NULL,
  `p_end_date` date NOT NULL,
  `p_cost` int(6) NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO project (p_id, p_name, p_start_date, p_end_date, p_cost) VALUES ( 1, 'Project Armagedon', '2020-06-14', '2020-06-15', 100 );

SELECT * FROM project;


-- Structure de la table `activity`

CREATE TABLE IF NOT EXISTS `activity` (
  `a_id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `a_e_fk` int(4) UNSIGNED NOT NULL,
  `a_p_fk` int(4) UNSIGNED NOT NULL,
  `a_description` varchar(50) NOT NULL,
  `a_cost` int(6) NULL,
  PRIMARY KEY (`a_id`),
  KEY `a_e_fk` (`a_e_fk`),
  KEY `a_p_fk` (`a_p_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO activity (a_id, a_e_fk, a_p_fk, a_description, a_cost) VALUES ( 1, 1, 1, 'Windows installation', 100 );

SELECT * FROM activity;

-- Structure de la table `time`

CREATE TABLE IF NOT EXISTS `time` (
  `t_id` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_a_fk` int(4) UNSIGNED NOT NULL,
  `t_hour` int(4) UNSIGNED NOT NULL,
  `t_cost` int(6) NOT NULL,
  PRIMARY KEY (`t_id`),
  KEY `t_a_fk` (`t_a_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO time (t_id, t_a_fk, t_hour, t_cost ) VALUES ( 1, 1, 2, 50 );

SELECT * FROM time;

-- Contraintes pour les tables déchargées


-- Contraintes pour la table `activity`

ALTER TABLE `activity`
  ADD CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`a_e_fk`) REFERENCES `employee` (`e_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `activity_ibfk_2` FOREIGN KEY (`a_p_fk`) REFERENCES `project` (`p_id`) ON DELETE CASCADE;


-- Contraintes pour la table `time`

ALTER TABLE `time`
  ADD CONSTRAINT `time_ibfk_1` FOREIGN KEY (`t_a_fk`) REFERENCES `activity` (`a_id`) ON DELETE CASCADE;
COMMIT;

