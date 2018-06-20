/* Write your T-SQL query statement below */
select Department.Name "Department", e1.Name "Employee", e1.Salary
from Employee e1, Department where
e1.DepartmentId = Department.Id and
(select count(distinct e2.Salary) from Employee e2 where e1.DepartmentId = e2.DepartmentId and e1.Salary < e2.Salary) < 3
order by Department.Name, e1.Salary desc, e1.Name

