-- Sakila Database
-- Write a SQL statement for each of the following. 

-- 1. Get 10 cities in descending alphabetical order.

SELECT * FROM city ORDER BY city DESC LIMIT 10;

-- 2. Get all films with "airplane" in the title.

SELECT * FROM film WHERE title LIKE '%airplane%';

-- 3. Get the highest payment amount.

SELECT MAX(amount) AS highest_payment FROM payment;

-- 4. Get the number of records in the customer table for store id #1.

SELECT COUNT(store_id) FROM customer WHERE store_id=1;

-- 5. Get all payment records for customer with email address "NANCY.THOMAS@sakilacustomer.org"

SELECT * FROM payment INNER JOIN customer ON payment.customer_id=customer.customer_id WHERE email='NANCY.THOMAS@sakilacustomer.org';

-- 6. Use a View to get the film info for actor Bob Fawcett.

SELECT film_info FROM actor_info WHERE first_name='Bob'AND last_name='Fawcett';

-- 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 

SET @alien_center_film_id = (SELECT film_id from film WHERE title='ALIEN CENTER');
CALL `sakila`.`film_in_stock`(@alien_center_film_id, 2, @inventory_id);

-- 8. Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! Pay attention to constraints and the order that you are inserting data.)

START TRANSACTION;
		INSERT INTO staff(first_name, last_name,address_id,store_id,username) VALUES('Richie','Rich',5,2,'RR');
        SET @new_staff_id = (SELECT MAX(staff_id) FROM staff);
		INSERT INTO store(manager_staff_id, address_id) VALUES (@new_staff_id,5); 

-- 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 

SET @new_store_id = (SELECT MAX(store_id) FROM store);
UPDATE store SET last_update = CURRENT_TIMESTAMP WHERE store_id = @new_store_id;

-- 10. Delete the new store. 

ROLLBACK;
