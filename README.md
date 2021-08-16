# comvivaAssignment

1.Implement a cache that will help the application return responses faster. The cache is a fixed size cache and when the cache size is full, the criterion to add new elements to the cache it that
·         Entry that got accessed the first time the previous day

·         If there was no hit  on the cache the prev day, then the criteria for removal should be the one that got accessed the day before the before the previous day
---
Using LinkedHashmap, save date and value to maintain the data with its insertion time. declared a cacheMap and a variable capacity and set their values using the constructor.
Whilw inserting data in cache boolean return type function get () that returns false if the key is not present in the cache.function get_Value in which if get(key)==false, then put(key).
To put key with timestamp given a check for previous day with findPrevDay function , if cache is full and findPrevDay returns date then remove it and add to map.
Similarly for day before prev day findDayPrevDay fun is used with static value to count prev day is used and  If there was no hit  on the cache the prev day, then the criteria for removal should be the one that got accessed the day before the before the previous day is achieved.


-------------------------------------------------
2.A barbershop consists of a waiting room with n chairs, and a barber chair for giving haircuts. If there are no customers to be served, the barber goes to sleep. If a customer enters the barbershop and all chairs are occupied, then the customer leaves the shop. If the barber is busy, but chairs are available, then the customer sits in one of the free chairs. If the barber is asleep, the customer wakes up the barber. Write a program to coordinate the interaction between the barber and the customers.
----

To implement barber sustomer interaction in shop, created barber,shop,customer, thread to cretae customers and main thread.
Barber is initially sleeping, customers are initialized by custutility thread and added to customers list, if customers list has customers in waiting room barber is notified using notify(),
barber picksup the customer and gives haircut hence the thread is removed from the list.
new chairs are available for new customers while barber is serving for old customers with 1000 time interval for each customer.
