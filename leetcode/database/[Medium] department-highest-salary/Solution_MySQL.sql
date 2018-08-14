select Department.Name Department, Employee.Name Employee, Employee.Salary from Employee, Department
where Employee.DepartmentId = Department.Id
and (Employee.Salary, Employee.DepartmentId) in (select MAX(Salary) Salary, DepartmentId from Employee group by DepartmentId)

