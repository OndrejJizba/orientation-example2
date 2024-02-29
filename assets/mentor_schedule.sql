SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of classes
-- ----------------------------
BEGIN;
INSERT INTO `classes` VALUES (1, 'Radial');
INSERT INTO `classes` VALUES (4, 'Reader');
INSERT INTO `classes` VALUES (2, 'Report');
INSERT INTO `classes` VALUES (5, 'Sector');
INSERT INTO `classes` VALUES (3, 'Sleepy');
COMMIT;

-- ----------------------------
-- Table structure for mentors
-- ----------------------------
DROP TABLE IF EXISTS `mentors`;
CREATE TABLE `mentors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `mentors_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES `classes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of mentors
-- ----------------------------
BEGIN;
INSERT INTO `mentors` VALUES (1, 'Viktor', 1);
INSERT INTO `mentors` VALUES (2, 'Kond', 3);
INSERT INTO `mentors` VALUES (3, 'Zoli', 5);
INSERT INTO `mentors` VALUES (4, 'Edina', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
