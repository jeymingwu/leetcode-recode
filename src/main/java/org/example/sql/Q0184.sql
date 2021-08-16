# 184. 部门工资最高的员工
# SQL架构
# Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
#
# +----+-------+--------+--------------+
# | Id | Name  | Salary | DepartmentId |
# +----+-------+--------+--------------+
# | 1  | Joe   | 70000  | 1            |
# | 2  | Jim   | 90000  | 1            |
# | 3  | Henry | 80000  | 2            |
# | 4  | Sam   | 60000  | 2            |
# | 5  | Max   | 90000  | 1            |
# +----+-------+--------+--------------+
# Department 表包含公司所有部门的信息。
#
# +----+----------+
# | Id | Name     |
# +----+----------+
# | 1  | IT       |
# | 2  | Sales    |
# +----+----------+
# 编写一个 SQL 查询，找出每个部门工资最高的员工。对于上述表，您的 SQL 查询应返回以下行（行的顺序无关紧要）。
#
# +------------+----------+--------+
# | Department | Employee | Salary |
# +------------+----------+--------+
# | IT         | Max      | 90000  |
# | IT         | Jim      | 90000  |
# | Sales      | Henry    | 80000  |
# +------------+----------+--------+
# 解释：
#
# Max 和 Jim 在 IT 部门的工资都是最高的，Henry 在销售部的工资最高。
#
# https://leetcode-cn.com/problems/department-highest-salary/

SELECT d.Name AS Department, e.Name AS Employee, e.Salary AS Salary
FROM Employee e,
     (
         SELECT max(Salary) AS maxSalary, DepartmentId AS DepartmentId
         FROM Employee
         GROUP BY DepartmentId
     ) AS tmp, Department d
WHERE e.Salary = tmp.maxSalary AND e.DepartmentId = d.Id AND tmp.DepartmentId = e.DepartmentId;

# 另一种写法

SELECT d.Name AS Department, e.Name AS Employee, e.Salary AS Salary
FROM Employee e JOIN Department d ON e.DepartmentId = d.Id
WHERE (e.DepartmentId, e.Salary) IN (SELECT DepartmentId, MAX(Salary) FROM Employee GROUP BY DepartmentId);