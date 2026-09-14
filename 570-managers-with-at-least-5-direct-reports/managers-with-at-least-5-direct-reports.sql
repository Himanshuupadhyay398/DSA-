# Write your MySQL query statement below
-- select name from employee where id =(select managerId from employee group by managerId having count(*)>=5)
select e1.name as name from employee e1 
join employee e2
on e1.id=e2.managerId
group by e1.name,e1.id
having count(e1.id)>=5;