--1、MySQL 关于数据主键、外键的设置和级联操作  https://blog.csdn.net/phpdadao/article/details/22935401
--  . cascade方式：在父表上update/delete记录时，同步update/delete掉子表的匹配记录
--
--    . set null方式
-- 在父表上update/delete记录时，将子表上匹配记录的列设为null
-- 要注意子表的外键列不能为not null
--
--    . No action方式
-- 如果子表中有匹配的记录,则不允许对父表对应候选键进行update/delete操作
--
--    . Restrict方式
-- 同no action, 都是立即检查外键约束
--
--    . Set default方式
-- 父表有变更时,子表将外键列设置成一个默认的值 但Innodb不能识别


-- 2、关于时间类型以及相关操作：查询或者排序
-- https://blog.csdn.net/csdnluolei/article/details/86488461