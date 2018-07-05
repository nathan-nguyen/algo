select Department.Name Department, Employee.Name Employee, Employee.Salary from Employee, Department,
(select MAX(Salary) Salary, DepartmentId from Employee group by DepartmentId) SalaryTable
where Employee.DepartmentId = Department.Id and Employee.DepartmentId = SalaryTable.DepartmentId
and Employee.Salary = SalaryTable.Salary

