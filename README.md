XYZShop
=======

XYZ's Custom Shop plugin

SQL Structure
=====

Do this to the database
CREATE TABLE `items` (
  `item` int(11) NOT NULL COMMENT 'Item ID',
  `datavalue` smallint(6) NOT NULL COMMENT 'Data Value',
  `buyprice` bigint(20) NOT NULL COMMENT 'Buy Price',
  `sellprice` bigint(20) NOT NULL COMMENT 'Sell Price',
  `quantity` int(11) NOT NULL COMMENT 'Number of items this represents'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
