-- 182. 查找重复的电子邮箱
-- SQL架构
-- 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
--
-- 示例：
--
-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- 根据以上输入，你的查询应返回以下结果：
--
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+
-- 说明：所有电子邮箱都是小写字母。
-- https://leetcode-cn.com/problems/duplicate-emails/

-- 方法一：先 GROUP BY 分组，再用聚合函数 COUNT() 统计列数，最后再判断
SELECT Email
FROM Person
GROUP BY Email
HAVING count(email) > 1

-- 亦可创建临时辅助表
SELECT Email
FROM (
     SELECT Email, count(1) nums
    FROM Person
    GROUP BY email
         ) AS temp_person
WHERE nums > 1

-- 方法二：自联结
SELECT DISTINCT a.Email
FROM Person a, Person b
WHERE a.id != b.id AND a.Email = b.Email

-- 【拓展：统计出现 n 次的数据】
SELECT 列名
FROM 表名
GROUP BY 列名
HAVING count(列名) > n