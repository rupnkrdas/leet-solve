# Write your MySQL query statement below
select name, bonus
from employee as emp left join bonus
  on emp.empid = bonus.empid
where (bonus < 1000) or (bonus is null)