# Write your MySQL query statement below
select p.product_id,round(
        coalesce(sum(p.price*s.units)/sum(s.units),0
    ),2
) average_price
from prices p
left join unitsSold s
on p.product_id=s.product_id
and s.purchase_date between p.start_date and p.end_date
group by p.product_id;