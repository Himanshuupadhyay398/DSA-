# Write your MySQL query statement below

select w2.id from weather w1
join weather w2
where datediff(w2.recorddate,w1.recorddate)=1
and w1.temperature<w2.temperature;