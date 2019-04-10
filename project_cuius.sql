-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 07, 2019 at 11:31 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_cuius`
--
CREATE DATABASE IF NOT EXISTS `project_cuius` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `project_cuius`;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--
-- Creation: Jan 17, 2019 at 07:04 PM
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(100) NOT NULL,
  `cat_desc` varchar(2000) NOT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `category`:
--

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `cat_name`, `cat_desc`) VALUES
(1, 'computers', 'All computer related products, including desktops, laptops and pcs'),
(2, 'mobile', 'mobile phone products, including, but not limited to mobile phones, tablets, ipads, smart watches, etc'),
(3, 'Tech Accessories', 'Including Good wireless headphones, earbuds, Bluetooth speaker, portable smartphone charger, streaming stick, decent camera, GoPro'),
(4, 'Home And Kitchen', 'All Home Appliances, Kitchen Utensils, Home property'),
(5, 'Clothing', 'All Clothing Items'),
(6, 'Ware House', 'All Items that can be found in a warehouse, including building and contruction material');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--
-- Creation: Jan 26, 2019 at 12:54 PM
--

DROP TABLE IF EXISTS `country`;
CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL,
  `iso_code` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `printable_name` varchar(50) NOT NULL,
  `iso3` varchar(10) NOT NULL,
  `numcode` varchar(10) NOT NULL,
  `version` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `country`:
--

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `iso_code`, `name`, `printable_name`, `iso3`, `numcode`, `version`) VALUES
(1000, 'AF', 'AFGHANISTAN', 'Afghanistan', 'AFG', '004', 1),
(1001, 'AL', 'ALBANIA', 'Albania', 'ALB', '008', 1),
(1002, 'DZ', 'ALGERIA', 'Algeria', 'DZA', '012', 1),
(1003, 'AS', 'AMERICAN SAMOA', 'American Samoa', 'ASM', '016', 1),
(1004, 'AD', 'ANDORRA', 'Andorra', 'AND', '020', 1),
(1005, 'AO', 'ANGOLA', 'Angola', 'AGO', '024', 1),
(1006, 'AI', 'ANGUILLA', 'Anguilla', 'AIA', '660', 1),
(1008, 'AG', 'ANTIGUA AND BARBUDA', 'Antigua and Barbuda', 'ATG', '028', 1),
(1009, 'AR', 'ARGENTINA', 'Argentina', 'ARG', '032', 1),
(1010, 'AM', 'ARMENIA', 'Armenia', 'ARM', '051', 1),
(1011, 'AW', 'ARUBA', 'Aruba', 'ABW', '533', 1),
(1012, 'AU', 'AUSTRALIA', 'Australia', 'AUS', '036', 1),
(1013, 'AT', 'AUSTRIA', 'Austria', 'AUT', '040', 1),
(1014, 'AZ', 'AZERBAIJAN', 'Azerbaijan', 'AZE', '031', 1),
(1015, 'BS', 'BAHAMAS', 'Bahamas', 'BHS', '044', 1),
(1016, 'BH', 'BAHRAIN', 'Bahrain', 'BHR', '048', 1),
(1017, 'BD', 'BANGLADESH', 'Bangladesh', 'BGD', '050', 1),
(1018, 'BB', 'BARBADOS', 'Barbados', 'BRB', '052', 1),
(1019, 'BY', 'BELARUS', 'Belarus', 'BLR', '112', 1),
(1020, 'BE', 'BELGIUM', 'Belgium', 'BEL', '056', 1),
(1021, 'BZ', 'BELIZE', 'Belize', 'BLZ', '084', 1),
(1022, 'BJ', 'BENIN', 'Benin', 'BEN', '204', 1),
(1023, 'BM', 'BERMUDA', 'Bermuda', 'BMU', '060', 1),
(1024, 'BT', 'BHUTAN', 'Bhutan', 'BTN', '064', 1),
(1025, 'BO', 'BOLIVIA', 'Bolivia', 'BOL', '068', 1),
(1026, 'BA', 'BOSNIA AND HERZEGOVINA', 'Bosnia and Herzegovina', 'BIH', '070', 1),
(1027, 'BW', 'BOTSWANA', 'Botswana', 'BWA', '072', 1),
(1029, 'BR', 'BRAZIL', 'Brazil', 'BRA', '076', 1),
(1031, 'BN', 'BRUNEI DARUSSALAM', 'Brunei Darussalam', 'BRN', '096', 1),
(1032, 'BG', 'BULGARIA', 'Bulgaria', 'BGR', '100', 1),
(1033, 'BF', 'BURKINA FASO', 'Burkina Faso', 'BFA', '854', 1),
(1034, 'BI', 'BURUNDI', 'Burundi', 'BDI', '108', 1),
(1035, 'KH', 'CAMBODIA', 'Cambodia', 'KHM', '116', 1),
(1036, 'CM', 'CAMEROON', 'Cameroon', 'CMR', '120', 1),
(1037, 'CA', 'CANADA', 'Canada', 'CAN', '124', 1),
(1038, 'CV', 'CAPE VERDE', 'Cape Verde', 'CPV', '132', 1),
(1039, 'KY', 'CAYMAN ISLANDS', 'Cayman Islands', 'CYM', '136', 1),
(1040, 'CF', 'CENTRAL AFRICAN REPUBLIC', 'Central African Republic', 'CAF', '140', 1),
(1041, 'TD', 'CHAD', 'Chad', 'TCD', '148', 1),
(1042, 'CL', 'CHILE', 'Chile', 'CHL', '152', 1),
(1043, 'CN', 'CHINA', 'China', 'CHN', '156', 1),
(1046, 'CO', 'COLOMBIA', 'Colombia', 'COL', '170', 1),
(1047, 'KM', 'COMOROS', 'Comoros', 'COM', '174', 1),
(1048, 'CG', 'CONGO', 'Congo', 'COG', '178', 1),
(1049, 'CD', 'CONGO, THE DEMOCRATIC REPUBLIC OF THE', 'Congo, the Democratic Republic of the', 'COD', '180', 1),
(1050, 'CK', 'COOK ISLANDS', 'Cook Islands', 'COK', '184', 1),
(1051, 'CR', 'COSTA RICA', 'Costa Rica', 'CRI', '188', 1),
(1052, 'CI', 'COTE D IVOIRE', 'Cote d Ivoire', 'CIV', '384', 1),
(1053, 'HR', 'CROATIA', 'Croatia', 'HRV', '191', 1),
(1054, 'CU', 'CUBA', 'Cuba', 'CUB', '192', 1),
(1055, 'CY', 'CYPRUS', 'Cyprus', 'CYP', '196', 1),
(1056, 'CZ', 'CZECH REPUBLIC', 'Czech Republic', 'CZE', '203', 1),
(1057, 'DK', 'DENMARK', 'Denmark', 'DNK', '208', 1),
(1058, 'DJ', 'DJIBOUTI', 'Djibouti', 'DJI', '262', 1),
(1059, 'DM', 'DOMINICA', 'Dominica', 'DMA', '212', 1),
(1060, 'DO', 'DOMINICAN REPUBLIC', 'Dominican Republic', 'DOM', '214', 1),
(1061, 'EC', 'ECUADOR', 'Ecuador', 'ECU', '218', 1),
(1062, 'EG', 'EGYPT', 'Egypt', 'EGY', '818', 1),
(1063, 'SV', 'EL SALVADOR', 'El Salvador', 'SLV', '222', 1),
(1064, 'GQ', 'EQUATORIAL GUINEA', 'Equatorial Guinea', 'GNQ', '226', 1),
(1065, 'ER', 'ERITREA', 'Eritrea', 'ERI', '232', 1),
(1066, 'EE', 'ESTONIA', 'Estonia', 'EST', '233', 1),
(1067, 'ET', 'ETHIOPIA', 'Ethiopia', 'ETH', '231', 1),
(1068, 'FK', 'FALKLAND ISLANDS (MALVINAS)', 'Falkland Islands (Malvinas)', 'FLK', '238', 1),
(1069, 'FO', 'FAROE ISLANDS', 'Faroe Islands', 'FRO', '234', 1),
(1070, 'FJ', 'FIJI', 'Fiji', 'FJI', '242', 1),
(1071, 'FI', 'FINLAND', 'Finland', 'FIN', '246', 1),
(1072, 'FR', 'FRANCE', 'France', 'FRA', '250', 1),
(1073, 'GF', 'FRENCH GUIANA', 'French Guiana', 'GUF', '254', 1),
(1074, 'PF', 'FRENCH POLYNESIA', 'French Polynesia', 'PYF', '258', 1),
(1076, 'GA', 'GABON', 'Gabon', 'GAB', '266', 1),
(1077, 'GM', 'GAMBIA', 'Gambia', 'GMB', '270', 1),
(1078, 'GE', 'GEORGIA', 'Georgia', 'GEO', '268', 1),
(1079, 'DE', 'GERMANY', 'Germany', 'DEU', '276', 1),
(1080, 'GH', 'GHANA', 'Ghana', 'GHA', '288', 1),
(1081, 'GI', 'GIBRALTAR', 'Gibraltar', 'GIB', '292', 1),
(1082, 'GR', 'GREECE', 'Greece', 'GRC', '300', 1),
(1083, 'GL', 'GREENLAND', 'Greenland', 'GRL', '304', 1),
(1084, 'GD', 'GRENADA', 'Grenada', 'GRD', '308', 1),
(1085, 'GP', 'GUADELOUPE', 'Guadeloupe', 'GLP', '312', 1),
(1086, 'GU', 'GUAM', 'Guam', 'GUM', '316', 1),
(1087, 'GT', 'GUATEMALA', 'Guatemala', 'GTM', '320', 1),
(1088, 'GN', 'GUINEA', 'Guinea', 'GIN', '324', 1),
(1089, 'GW', 'GUINEA-BISSAU', 'Guinea-Bissau', 'GNB', '624', 1),
(1090, 'GY', 'GUYANA', 'Guyana', 'GUY', '328', 1),
(1091, 'HT', 'HAITI', 'Haiti', 'HTI', '332', 1),
(1093, 'VA', 'HOLY SEE (VATICAN CITY STATE)', 'Holy See (Vatican City State)', 'VAT', '336', 1),
(1094, 'HN', 'HONDURAS', 'Honduras', 'HND', '340', 1),
(1095, 'HK', 'HONG KONG', 'Hong Kong', 'HKG', '344', 1),
(1096, 'HU', 'HUNGARY', 'Hungary', 'HUN', '348', 1),
(1097, 'IS', 'ICELAND', 'Iceland', 'ISL', '352', 1),
(1098, 'IN', 'INDIA', 'India', 'IND', '356', 1),
(1099, 'ID', 'INDONESIA', 'Indonesia', 'IDN', '360', 1),
(1100, 'IR', 'IRAN, ISLAMIC REPUBLIC OF', 'Iran, Islamic Republic of', 'IRN', '364', 1),
(1101, 'IQ', 'IRAQ', 'Iraq', 'IRQ', '368', 1),
(1102, 'IE', 'IRELAND', 'Ireland', 'IRL', '372', 1),
(1103, 'IL', 'ISRAEL', 'Israel', 'ISR', '376', 1),
(1104, 'IT', 'ITALY', 'Italy', 'ITA', '380', 1),
(1105, 'JM', 'JAMAICA', 'Jamaica', 'JAM', '388', 1),
(1106, 'JP', 'JAPAN', 'Japan', 'JPN', '392', 1),
(1107, 'JO', 'JORDAN', 'Jordan', 'JOR', '400', 1),
(1108, 'KZ', 'KAZAKHSTAN', 'Kazakhstan', 'KAZ', '398', 1),
(1109, 'KE', 'KENYA', 'Kenya', 'KEN', '404', 1),
(1110, 'KI', 'KIRIBATI', 'Kiribati', 'KIR', '296', 1),
(1111, 'KP', 'KOREA, DEMOCRATIC PEOPLE S REPUBLIC OF', 'Korea, Democratic People s Republic of', 'PRK', '408', 1),
(1112, 'KR', 'KOREA, REPUBLIC OF', 'Korea, Republic of', 'KOR', '410', 1),
(1113, 'KW', 'KUWAIT', 'Kuwait', 'KWT', '414', 1),
(1114, 'KG', 'KYRGYZSTAN', 'Kyrgyzstan', 'KGZ', '417', 1),
(1115, 'LA', 'LAO PEOPLE S DEMOCRATIC REPUBLIC', 'Lao People s Democratic Republic', 'LAO', '418', 1),
(1116, 'LV', 'LATVIA', 'Latvia', 'LVA', '428', 1),
(1117, 'LB', 'LEBANON', 'Lebanon', 'LBN', '422', 1),
(1118, 'LS', 'LESOTHO', 'Lesotho', 'LSO', '426', 1),
(1119, 'LR', 'LIBERIA', 'Liberia', 'LBR', '430', 1),
(1120, 'LY', 'LIBYAN ARAB JAMAHIRIYA', 'Libyan Arab Jamahiriya', 'LBY', '434', 1),
(1121, 'LI', 'LIECHTENSTEIN', 'Liechtenstein', 'LIE', '438', 1),
(1122, 'LT', 'LITHUANIA', 'Lithuania', 'LTU', '440', 1),
(1123, 'LU', 'LUXEMBOURG', 'Luxembourg', 'LUX', '442', 1),
(1124, 'MO', 'MACAO', 'Macao', 'MAC', '446', 1),
(1125, 'MK', 'MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF', 'Macedonia, the Former Yugoslav Republic of', 'MKD', '807', 1),
(1126, 'MG', 'MADAGASCAR', 'Madagascar', 'MDG', '450', 1),
(1127, 'MW', 'MALAWI', 'Malawi', 'MWI', '454', 1),
(1128, 'MY', 'MALAYSIA', 'Malaysia', 'MYS', '458', 1),
(1129, 'MV', 'MALDIVES', 'Maldives', 'MDV', '462', 1),
(1130, 'ML', 'MALI', 'Mali', 'MLI', '466', 1),
(1131, 'MT', 'MALTA', 'Malta', 'MLT', '470', 1),
(1132, 'MH', 'MARSHALL ISLANDS', 'Marshall Islands', 'MHL', '584', 1),
(1133, 'MQ', 'MARTINIQUE', 'Martinique', 'MTQ', '474', 1),
(1134, 'MR', 'MAURITANIA', 'Mauritania', 'MRT', '478', 1),
(1135, 'MU', 'MAURITIUS', 'Mauritius', 'MUS', '480', 1),
(1137, 'MX', 'MEXICO', 'Mexico', 'MEX', '484', 1),
(1138, 'FM', 'MICRONESIA, FEDERATED STATES OF', 'Micronesia, Federated States of', 'FSM', '583', 1),
(1139, 'MD', 'MOLDOVA, REPUBLIC OF', 'Moldova, Republic of', 'MDA', '498', 1),
(1140, 'MC', 'MONACO', 'Monaco', 'MCO', '492', 1),
(1141, 'MN', 'MONGOLIA', 'Mongolia', 'MNG', '496', 1),
(1142, 'MS', 'MONTSERRAT', 'Montserrat', 'MSR', '500', 1),
(1143, 'MA', 'MOROCCO', 'Morocco', 'MAR', '504', 1),
(1144, 'MZ', 'MOZAMBIQUE', 'Mozambique', 'MOZ', '508', 1),
(1145, 'MM', 'MYANMAR', 'Myanmar', 'MMR', '104', 1),
(1146, 'NA', 'NAMIBIA', 'Namibia', 'NAM', '516', 1),
(1147, 'NR', 'NAURU', 'Nauru', 'NRU', '520', 1),
(1148, 'NP', 'NEPAL', 'Nepal', 'NPL', '524', 1),
(1149, 'NL', 'NETHERLANDS', 'Netherlands', 'NLD', '528', 1),
(1150, 'AN', 'NETHERLANDS ANTILLES', 'Netherlands Antilles', 'ANT', '530', 1),
(1151, 'NC', 'NEW CALEDONIA', 'New Caledonia', 'NCL', '540', 1),
(1152, 'NZ', 'NEW ZEALAND', 'New Zealand', 'NZL', '554', 1),
(1153, 'NI', 'NICARAGUA', 'Nicaragua', 'NIC', '558', 1),
(1154, 'NE', 'NIGER', 'Niger', 'NER', '562', 1),
(1155, 'NG', 'NIGERIA', 'Nigeria', 'NGA', '566', 1),
(1156, 'NU', 'NIUE', 'Niue', 'NIU', '570', 1),
(1157, 'NF', 'NORFOLK ISLAND', 'Norfolk Island', 'NFK', '574', 1),
(1158, 'MP', 'NORTHERN MARIANA ISLANDS', 'Northern Mariana Islands', 'MNP', '580', 1),
(1159, 'NO', 'NORWAY', 'Norway', 'NOR', '578', 1),
(1160, 'OM', 'OMAN', 'Oman', 'OMN', '512', 1),
(1161, 'PK', 'PAKISTAN', 'Pakistan', 'PAK', '586', 1),
(1162, 'PW', 'PALAU', 'Palau', 'PLW', '585', 1),
(1164, 'PA', 'PANAMA', 'Panama', 'PAN', '591', 1),
(1165, 'PG', 'PAPUA NEW GUINEA', 'Papua New Guinea', 'PNG', '598', 1),
(1166, 'PY', 'PARAGUAY', 'Paraguay', 'PRY', '600', 1),
(1167, 'PE', 'PERU', 'Peru', 'PER', '604', 1),
(1168, 'PH', 'PHILIPPINES', 'Philippines', 'PHL', '608', 1),
(1169, 'PN', 'PITCAIRN', 'Pitcairn', 'PCN', '612', 1),
(1170, 'PL', 'POLAND', 'Poland', 'POL', '616', 1),
(1171, 'PT', 'PORTUGAL', 'Portugal', 'PRT', '620', 1),
(1172, 'PR', 'PUERTO RICO', 'Puerto Rico', 'PRI', '630', 1),
(1173, 'QA', 'QATAR', 'Qatar', 'QAT', '634', 1),
(1174, 'RE', 'REUNION', 'Reunion', 'REU', '638', 1),
(1175, 'RO', 'ROMANIA', 'Romania', 'ROM', '642', 1),
(1176, 'RU', 'RUSSIAN FEDERATION', 'Russian Federation', 'RUS', '643', 1),
(1177, 'RW', 'RWANDA', 'Rwanda', 'RWA', '646', 1),
(1178, 'SH', 'SAINT HELENA', 'Saint Helena', 'SHN', '654', 1),
(1179, 'KN', 'SAINT KITTS AND NEVIS', 'Saint Kitts and Nevis', 'KNA', '659', 1),
(1180, 'LC', 'SAINT LUCIA', 'Saint Lucia', 'LCA', '662', 1),
(1181, 'PM', 'SAINT PIERRE AND MIQUELON', 'Saint Pierre and Miquelon', 'SPM', '666', 1),
(1182, 'VC', 'SAINT VINCENT AND THE GRENADINES', 'Saint Vincent and the Grenadines', 'VCT', '670', 1),
(1183, 'WS', 'SAMOA', 'Samoa', 'WSM', '882', 1),
(1184, 'SM', 'SAN MARINO', 'San Marino', 'SMR', '674', 1),
(1185, 'ST', 'SAO TOME AND PRINCIPE', 'Sao Tome and Principe', 'STP', '678', 1),
(1186, 'SA', 'SAUDI ARABIA', 'Saudi Arabia', 'SAU', '682', 1),
(1187, 'SN', 'SENEGAL', 'Senegal', 'SEN', '686', 1),
(1189, 'SC', 'SEYCHELLES', 'Seychelles', 'SYC', '690', 1),
(1190, 'SL', 'SIERRA LEONE', 'Sierra Leone', 'SLE', '694', 1),
(1191, 'SG', 'SINGAPORE', 'Singapore', 'SGP', '702', 1),
(1192, 'SK', 'SLOVAKIA', 'Slovakia', 'SVK', '703', 1),
(1193, 'SI', 'SLOVENIA', 'Slovenia', 'SVN', '705', 1),
(1194, 'SB', 'SOLOMON ISLANDS', 'Solomon Islands', 'SLB', '090', 1),
(1195, 'SO', 'SOMALIA', 'Somalia', 'SOM', '706', 1),
(1196, 'ZA', 'SOUTH AFRICA', 'South Africa', 'ZAF', '710', 1),
(1198, 'ES', 'SPAIN', 'Spain', 'ESP', '724', 1),
(1199, 'LK', 'SRI LANKA', 'Sri Lanka', 'LKA', '144', 1),
(1200, 'SD', 'SUDAN', 'Sudan', 'SDN', '736', 1),
(1201, 'SR', 'SURINAME', 'Suriname', 'SUR', '740', 1),
(1202, 'SJ', 'SVALBARD AND JAN MAYEN', 'Svalbard and Jan Mayen', 'SJM', '744', 1),
(1203, 'SZ', 'SWAZILAND', 'Swaziland', 'SWZ', '748', 1),
(1204, 'SE', 'SWEDEN', 'Sweden', 'SWE', '752', 1),
(1205, 'CH', 'SWITZERLAND', 'Switzerland', 'CHE', '756', 1),
(1206, 'SY', 'SYRIAN ARAB REPUBLIC', 'Syrian Arab Republic', 'SYR', '760', 1),
(1207, 'TW', 'TAIWAN, PROVINCE OF CHINA', 'Taiwan, Province of China', 'TWN', '158', 1),
(1208, 'TJ', 'TAJIKISTAN', 'Tajikistan', 'TJK', '762', 1),
(1209, 'TZ', 'TANZANIA, UNITED REPUBLIC OF', 'Tanzania, United Republic of', 'TZA', '834', 1),
(1210, 'TH', 'THAILAND', 'Thailand', 'THA', '764', 1),
(1212, 'TG', 'TOGO', 'Togo', 'TGO', '768', 1),
(1213, 'TK', 'TOKELAU', 'Tokelau', 'TKL', '772', 1),
(1214, 'TO', 'TONGA', 'Tonga', 'TON', '776', 1),
(1215, 'TT', 'TRINIDAD AND TOBAGO', 'Trinidad and Tobago', 'TTO', '780', 1),
(1216, 'TN', 'TUNISIA', 'Tunisia', 'TUN', '788', 1),
(1217, 'TR', 'TURKEY', 'Turkey', 'TUR', '792', 1),
(1218, 'TM', 'TURKMENISTAN', 'Turkmenistan', 'TKM', '795', 1),
(1219, 'TC', 'TURKS AND CAICOS ISLANDS', 'Turks and Caicos Islands', 'TCA', '796', 1),
(1220, 'TV', 'TUVALU', 'Tuvalu', 'TUV', '798', 1),
(1221, 'UG', 'UGANDA', 'Uganda', 'UGA', '800', 1),
(1222, 'UA', 'UKRAINE', 'Ukraine', 'UKR', '804', 1),
(1223, 'AE', 'UNITED ARAB EMIRATES', 'United Arab Emirates', 'ARE', '784', 1),
(1224, 'GB', 'UNITED KINGDOM', 'United Kingdom', 'GBR', '826', 1),
(1225, 'US', 'UNITED STATES', 'United States', 'USA', '840', 1),
(1227, 'UY', 'URUGUAY', 'Uruguay', 'URY', '858', 1),
(1228, 'UZ', 'UZBEKISTAN', 'Uzbekistan', 'UZB', '860', 1),
(1229, 'VU', 'VANUATU', 'Vanuatu', 'VUT', '548', 1),
(1230, 'VE', 'VENEZUELA', 'Venezuela', 'VEN', '862', 1),
(1231, 'VN', 'VIET NAM', 'Viet Nam', 'VNM', '704', 1),
(1232, 'VG', 'VIRGIN ISLANDS, BRITISH', 'Virgin Islands, British', 'VGB', '092', 1),
(1233, 'VI', 'VIRGIN ISLANDS, U.S.', 'Virgin Islands, U.s.', 'VIR', '850', 1),
(1234, 'WF', 'WALLIS AND FUTUNA', 'Wallis and Futuna', 'WLF', '876', 1),
(1235, 'EH', 'WESTERN SAHARA', 'Western Sahara', 'ESH', '732', 1),
(1236, 'YE', 'YEMEN', 'Yemen', 'YEM', '887', 1),
(1237, 'ZM', 'ZAMBIA', 'Zambia', 'ZMB', '894', 1),
(1238, 'ZW', 'ZIMBABWE', 'Zimbabwe', 'ZWE', '716', 1);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--
-- Creation: Jan 17, 2019 at 07:05 PM
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `billing_address` varchar(1000) NOT NULL,
  `shipping_address` varchar(1000) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `customers`:
--

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--
-- Creation: Jan 29, 2019 at 02:12 PM
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `contact` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `items` varchar(1000) NOT NULL,
  `discount` double DEFAULT NULL,
  `shipping` double DEFAULT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `invoice`:
--

-- --------------------------------------------------------

--
-- Table structure for table `merchant`
--
-- Creation: Jan 17, 2019 at 07:06 PM
--

DROP TABLE IF EXISTS `merchant`;
CREATE TABLE IF NOT EXISTS `merchant` (
  `merchant_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(1000) NOT NULL,
  `contact_name` varchar(1000) NOT NULL,
  `company_address` varchar(1000) NOT NULL,
  `company_phone` varchar(1000) NOT NULL,
  `company_email` varchar(1000) NOT NULL,
  `company_logo` varchar(100) NOT NULL,
  PRIMARY KEY (`merchant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `merchant`:
--

--
-- Dumping data for table `merchant`
--

INSERT INTO `merchant` (`merchant_id`, `company_name`, `contact_name`, `company_address`, `company_phone`, `company_email`, `company_logo`) VALUES
(1, 'TelOne', 'Jon Doe', 'Runhare House\r\nHarare\r\nZimbabwe', '+2661234567', 'sales@telone.co.zw', 'The-new-TelOne-Logo.jpg'),
(2, 'Fate Enterprises', 'Inino', '123\r\nHwange\r\nZimbabwe', '+2371234568', 'inino@fate.co.zw', 'Clothing Company');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--
-- Creation: Jan 20, 2019 at 09:08 AM
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_cat_id` int(11) NOT NULL,
  `merchant_id` int(11) NOT NULL,
  `pro_name` varchar(245) NOT NULL,
  `pro_price` double NOT NULL,
  `pro_qty` int(11) NOT NULL,
  `pro_desc` varchar(2000) NOT NULL,
  `pro_pic1` varchar(100) NOT NULL,
  `pro_pic2` varchar(100) DEFAULT NULL,
  `pro_pic3` varchar(100) DEFAULT NULL,
  `pro_pic4` varchar(100) DEFAULT NULL,
  `pro_pic5` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `FK_product_sub_cat_id` (`sub_cat_id`),
  KEY `FK_product_merchant_id` (`merchant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `product`:
--   `merchant_id`
--       `merchant` -> `merchant_id`
--   `sub_cat_id`
--       `sub_category` -> `sub_cat_id`
--

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pro_id`, `sub_cat_id`, `merchant_id`, `pro_name`, `pro_price`, `pro_qty`, `pro_desc`, `pro_pic1`, `pro_pic2`, `pro_pic3`, `pro_pic4`, `pro_pic5`) VALUES
(1, 2, 1, 'Mac Book Pro', 765, 10, 'ram 8gb , 1 terrabyte memory, duard core processor. capable of gpu support. x52 internet wifi modules ', '19.jpg', NULL, NULL, NULL, NULL),
(2, 19, 1, 'AMD Athlon™ X4 Processor', 444, 12, 'The Athlon X4 860K 3.7 GHz Quad-Core FM2+ Processor from AMD has a base clock speed of 3.7 GHz and a maximum turbo frequency of 4.3 GHz. It features four cores in an FM2+ socket, 4MB of cache memory, 28nm lithography, and supports both 32 and 64-bit processing. Having four cores allows this processor\'s to run multiple programs simultaneously without slowing down the system. Included with the Athlon X4 860K is a 95W Quiet Cooler thermal solution.', '04.jpg', NULL, NULL, NULL, NULL),
(3, 19, 1, 'ASUS X555LA-DB51 - 15.6\" - Core i5 4210U - 8 GB RAM - 1 TB HDD', 1055, 6, 'PROCESSOR / CHIPSET\r\nCPU Intel Core i5 (4th Gen) 4210U / 1.7 GHz\r\nMax Turbo Speed 2.7 GHz\r\nNumber of Cores Dual-Core\r\nCache 3 MB\r\n64-bit Computing Features Intel Turbo Boost Technology 2.0\r\nCACHE MEMORY\r\nInstalled Size 3 MB\r\nMEMORY\r\nRAM 8 GB (1 x 4 GB + 4 GB (soldered))\r\nMax Supported Size 8 GB\r\nTechnology DDR3L SDRAM\r\nSpeed 1600 MHz\r\nSTORAGE\r\nOptical Drive DVD±RW (±R DL)\r\nRAM\r\nMemory Speed 1600 MHz', '05.jpg', NULL, NULL, NULL, NULL),
(4, 11, 1, 'Headphones SHL3060BK/00 | Philips', 70, 7, 'Sound. closed. Frequency response. 10 - 22,000 Hz. Impedance. 24 Ohm. Magnet type. Neodymium. Maximum power input. 1000 mW. Sensitivity. 106 dB. Speaker diameter. ...\r\nDesign. Black.\r\nPackaging dimensions. 4.5 cm. Depth. 1.8 inch. EAN. 69 23410 73239 9. Gross weight. 0.227 kg. Gross weight. 0.500 lb. Height. 22.2 cm. Height.', '06.jpg', NULL, NULL, NULL, NULL),
(5, 11, 1, 'Sound Microphone', 170, 3, ' 130 dB SPL microphone is. A self-noise spec of 25 dBA is good, 20 dBA is very good, and 15 dBA or less is excellent', '08.jpg', NULL, NULL, NULL, NULL),
(6, 12, 1, 'Oculus Rift', 770, 6, 'TBA, 1.3 x 14.7 x 7 inches for Dk2 dev kit	201.9 x 116.4 x 92.6 mm\r\nWeight	<380 grams	310 grams', '09.jpg', NULL, NULL, NULL, NULL),
(7, 12, 1, 'Wireless Gamepad F710', 50, 16, 'Phone Wireless Bluetooth GamePad Controller For iPhone IOS Android TV Box Tablet. ... Bluetooth Wireless Controller Game pad For Android iPhone Amazon Fire TV Stick. ... Wireless Bluetooth Gamepad Controller for Dualshock4 PS4 Sony PlayStation 4.', '11.jpg', NULL, NULL, NULL, NULL),
(8, 16, 2, 'Jeans', 65, 44, 'LEVIS 511 Jeans Slim Fit Stretch Black Below Waist Slim Hip to Ankle Many Sizes. Wrangler Mens Jeans Five Star Regular Fit Many Sizes Many Colors New With Tags. NWT MEN LEVI’S 501 -2442 ORIGINAL BUTTON FLY STRAIGHT STRETCH JEANS PANT ', '55.jpg', NULL, NULL, NULL, NULL),
(9, 16, 2, 'Watches', 265, 22, 'Omega Constellation 18k White Gold Black Diamond Dial Watch Omega De Ville Hour Vision Automatic ', '56.jpg', NULL, NULL, NULL, NULL),
(10, 20, 2, 'Royal Watch ', 450, 15, 'Awesome Watches', '62.jpg', NULL, NULL, NULL, NULL),
(11, 16, 2, 'Winter Jacket', 89, 35, 'Women\'s winter jackets\r\nShell: 100% Nylon; Lining: 100% Nylon; Fill: 100% Polyester\r\nImported\r\nMachine Wash\r\nContoured seams bring a fitted shape to this water-resistant lightweight quilted coat\r\nZip pockets, hood, elasticized cuffs\r\nPacks neatly into included carrying bag with drawstring closure\r\nOutfit the entire family with comfortable, quality clothing from Amazon Family\r\nWinter made better: we listen to customer feedback and fine-tune every detail to ensure quality, fit, and comfort', '61.jpeg', NULL, NULL, NULL, NULL),
(12, 2, 2, 'Iphone 6s', 680, 12, '6.5-inch Super Retina display (OLED) with HDR\r\nIP68 dust and water resistant (maximum depth of 2 meters up to 30 minutes)\r\n12MP dual cameras with dual OIS and 7MP True Depth front camera—Portrait mode, Portrait Lighting, Depth Control, and Smart HDR\r\nFace ID for secure authentication and Apple Pay\r\nA12 Bionic with next-generation Neural Engine\r\nWireless charging—works with Qi chargers\r\niOS 12 with Emoji, Screen Time, Siri Shortcuts, and Group FaceTime', '59.jpg', NULL, NULL, NULL, NULL),
(13, 6, 2, 'Laptops', 800, 33, 'Stunning 13.3-inch Retina display\r\nTouch ID and the latest Apple-designed keyboard\r\nDual-core 8th-generation Intel Core i5 processor with Intel UHD Graphics 617\r\nFast SSD storage and 8GB memory\r\nStereo speakers with wider stereo sound\r\nTwo Thunderbolt 3 (USB-C) ports\r\nUp to 12 hours of battery life', '60.jpg', NULL, NULL, NULL, NULL),
(14, 2, 2, 'Iphon Xs', 900, 8, 'GSM Unlocked Phones are ONLY compatible with GSM carriers like AT&T and T-Mobile as well as other GSM networks around the world. They WILL NOT WORK with CDMA carriers like Sprint and Verizon (Search for \"Fully Unlocked iPhones\" for CDMA compatible iPhones\r\nHeadphones, SIM Card and SIM ejector tool are not included.An all-new 5.8-inch SuperRetina screen with all-screen OLED Multi-Touch display12MP wide-angle and telephoto cameras with Dual optical image stabilizationWireless Qi chargingSplash, water, and dust resistant\r\nHeadphones, SIM Card and SIM ejector tool are not included.\r\nAn all-new 5.8-inch SuperRetina screen with all-screen OLED Multi-Touch display', '63.jpg', NULL, NULL, NULL, NULL),
(15, 16, 2, 'Reading glasses', 900, 55, '4 pairs of men and Women reading glasses at 1 low price with colors available: black tortoise.\r\nLightweight plastic frames and plastic lenses with flexible spring hinge temples ensure a comfortable fit without uncomfortable pinching.\r\nClassic rectangular shape fashion frame reading glasses Suitable for any occasions. Universal size fits most face shapes.\r\nConvenient set allows you to keep a pair of glasses for reading in different places so you always have a pair handy.\r\nYour Glasses come with our 90 Day Money Back Guarantee and 1-Year Manufacturer’s Warranty.', '64.jpeg', NULL, NULL, NULL, NULL),
(16, 12, 1, 'Zenit Camera Lens', 475, 4, 'Camera Lens 200 mega pixels for gaming virtual reality and Photo shoots, video making, movie creation', '77.jpg', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product_order`
--
-- Creation: Jan 20, 2019 at 05:32 AM
--

DROP TABLE IF EXISTS `product_order`;
CREATE TABLE IF NOT EXISTS `product_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `merchant_id` int(11) NOT NULL,
  `delivery_id` int(11) NOT NULL,
  `order_date` date NOT NULL,
  `order_qty` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `order_status` varchar(45) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_product_order_pro_id` (`pro_id`),
  KEY `FK_product_order_customer_id` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `product_order`:
--   `customer_id`
--       `customers` -> `customer_id`
--   `pro_id`
--       `product` -> `pro_id`
--

-- --------------------------------------------------------

--
-- Table structure for table `product_order_details`
--
-- Creation: Jan 20, 2019 at 05:35 AM
--

DROP TABLE IF EXISTS `product_order_details`;
CREATE TABLE IF NOT EXISTS `product_order_details` (
  `order_det_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `pro_qty` int(11) NOT NULL,
  PRIMARY KEY (`order_det_id`),
  KEY `FK_product_order_details_pro_id` (`pro_id`),
  KEY `FK_product_order_details_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `product_order_details`:
--   `order_id`
--       `product_order` -> `order_id`
--   `pro_id`
--       `product` -> `pro_id`
--

-- --------------------------------------------------------

--
-- Table structure for table `sub_category`
--
-- Creation: Jan 20, 2019 at 05:25 AM
--

DROP TABLE IF EXISTS `sub_category`;
CREATE TABLE IF NOT EXISTS `sub_category` (
  `sub_cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_id` int(11) NOT NULL,
  `sub_cat_name` varchar(250) NOT NULL,
  `sub_cat_desc` varchar(2000) NOT NULL,
  PRIMARY KEY (`sub_cat_id`),
  KEY `FK_sub_category_cat_id` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `sub_category`:
--   `cat_id`
--       `category` -> `cat_id`
--

--
-- Dumping data for table `sub_category`
--

INSERT INTO `sub_category` (`sub_cat_id`, `cat_id`, `sub_cat_name`, `sub_cat_desc`) VALUES
(2, 1, 'Apple', 'All Apple computer products including Mac books and apple'),
(3, 2, 'Apple', 'All Apple Iphone and Ipad mobile products'),
(4, 1, 'Acer', 'Acer Computers'),
(5, 1, 'HP', 'Hulet Parkard computer Products'),
(6, 1, 'Samsung', 'Samsung Computers'),
(7, 2, 'Samsung', 'Samsung Phones'),
(8, 2, 'Huawei', 'Huawei Phones'),
(9, 2, 'Sony', 'Sony Phones'),
(10, 2, 'HTC', 'HTC Phones'),
(11, 3, 'Music', 'Head phones, ear plugs, ipods, walkman '),
(12, 3, 'Gaming', 'Consoles, game pads, VR gear'),
(13, 4, 'Kitchen', 'All utensils '),
(14, 4, 'Furniture', 'Beds, Stoves, fridges, Sofas'),
(15, 5, 'Formal', 'Suits, Shirts'),
(16, 5, 'Casual', 'Jeans, Shorts, sneakers'),
(17, 6, 'Gardening', 'Lawn moor, Hedge cutter, Shovels'),
(18, 6, 'Building', 'Building material'),
(19, 3, 'Processors', 'CPU and GPU'),
(20, 5, 'Jewelry', 'Watches, Braces, Necklaces, Rings and a bunch of other man made ornaments for fashion');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_log`
--
-- Creation: Jan 17, 2019 at 07:08 PM
--

DROP TABLE IF EXISTS `transaction_log`;
CREATE TABLE IF NOT EXISTS `transaction_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `full_name_on_cc` varchar(50) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `address_line1` varchar(100) NOT NULL,
  `address_line2` varchar(100) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `PAN` varchar(100) NOT NULL,
  `expiration_date` varchar(4) NOT NULL,
  `transation_amount` varchar(16) NOT NULL,
  `transaction_date_and_time` varchar(50) NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `transaction_log`:
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--
-- Creation: Jan 23, 2019 at 12:08 PM
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `reg_date` date NOT NULL,
  `contact_no` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `users`:
--

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `role_id`, `user_name`, `first_name`, `last_name`, `email`, `password`, `reg_date`, `contact_no`) VALUES
(2, 1, 'takunda', 'Terrence', 'Munyunguma', 'terrence@cuius.com', 'XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=', '2019-01-24', '+263713994446'),
(3, 1, 'taku', 'Terrence', 'Munyunguma', 'terrence@cuius.co.zw', 'XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=', '2019-03-05', '+263713994446');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--
-- Creation: Jan 17, 2019 at 07:08 PM
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- RELATIONSHIPS FOR TABLE `user_role`:
--

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`role_id`, `role_name`) VALUES
(1, 'user'),
(2, 'admin');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_product_merchant_id` FOREIGN KEY (`merchant_id`) REFERENCES `merchant` (`merchant_id`),
  ADD CONSTRAINT `FK_product_sub_cat_id` FOREIGN KEY (`sub_cat_id`) REFERENCES `sub_category` (`sub_cat_id`);

--
-- Constraints for table `product_order`
--
ALTER TABLE `product_order`
  ADD CONSTRAINT `FK_product_order_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  ADD CONSTRAINT `FK_product_order_pro_id` FOREIGN KEY (`pro_id`) REFERENCES `product` (`pro_id`);

--
-- Constraints for table `product_order_details`
--
ALTER TABLE `product_order_details`
  ADD CONSTRAINT `FK_product_order_details_order_id` FOREIGN KEY (`order_id`) REFERENCES `product_order` (`order_id`),
  ADD CONSTRAINT `FK_product_order_details_pro_id` FOREIGN KEY (`pro_id`) REFERENCES `product` (`pro_id`);

--
-- Constraints for table `sub_category`
--
ALTER TABLE `sub_category`
  ADD CONSTRAINT `FK_sub_category_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`);


--
-- Metadata
--
USE `phpmyadmin`;

--
-- Metadata for table category
--

--
-- Metadata for table country
--

--
-- Metadata for table customers
--

--
-- Metadata for table invoice
--

--
-- Metadata for table merchant
--

--
-- Metadata for table product
--

--
-- Metadata for table product_order
--

--
-- Metadata for table product_order_details
--

--
-- Metadata for table sub_category
--

--
-- Metadata for table transaction_log
--

--
-- Metadata for table users
--

--
-- Metadata for table user_role
--

--
-- Metadata for database project_cuius
--
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
