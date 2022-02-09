package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	public static void main(String[] args) {
		String databaseURL = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "1qaz!QAZ";
		Connection con = null;
		try {
			con = DriverManager.getConnection(databaseURL, user, password);
			if (con != null) {
				System.out.println("Connected to the database");
				Statement stmt = con.createStatement();

				String sql;

				// 1. Get 10 cities in descending alphabetical order.
				sql = "SELECT * FROM city ORDER BY city DESC LIMIT 10";
				getSQLResults(sql, stmt);

				// 2. Get all films with "airplane" in the title.
				sql = "SELECT * FROM film WHERE title LIKE '%airplane%'";
				getSQLResults(sql, stmt);

				// 3. Get the highest payment amount.
				sql = "SELECT MAX(amount) AS highest_payment FROM payment";
				getSQLResults(sql, stmt);

				// 4. Get the number of records in the customer table for store id #1.
				sql = "SELECT COUNT(store_id) FROM customer WHERE store_id=1";
				getSQLResults(sql, stmt);

				// 5. Get all payment records for customer with email address
				// "NANCY.THOMAS@sakilacustomer.org"
				sql = "SELECT * FROM payment " + "INNER JOIN customer ON payment.customer_id=customer.customer_id"
						+ " WHERE email='NANCY.THOMAS@sakilacustomer.org'";
				getSQLResults(sql, stmt);

				// 6. Use a View to get the film info for actor Bob Fawcett.
				sql = "SELECT film_info FROM actor_info WHERE first_name=? AND last_name=?";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, "Bob");
				preparedStatement.setString(2, "Fawcett");
				getSQLResults(preparedStatement);
				
				// 7. Use a Stored Procedure to get the 4 inventory ids for the film "Alien Center" at Store #2. 
				String alienCenterFilms = "SET @alien_center_film_id = (SELECT film_id from film WHERE title=?)";
				preparedStatement = con.prepareStatement(alienCenterFilms);
				preparedStatement.setString(1, "ALIEN CENTER");
				preparedStatement.execute();
				
				String inventoryIds = "CALL sakila.film_in_stock(@alien_center_film_id, ?, @inventory_id)";
				preparedStatement = con.prepareStatement(inventoryIds);
				preparedStatement.setInt(1, 2);
				getSQLResults(preparedStatement);
				
				// 8. Insert a new store. Ensure that you use TRANSACTION. (This one is possible but it's tough! Pay attention to constraints and the order that you are inserting data.)
				 con.setAutoCommit(false);
				 sql = "START TRANSACTION";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();
				 
				 sql = "INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username)"
						+ " VALUES (?,?,?,?,?,?,?)";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.setString(1, "John");
				 preparedStatement.setString(2, "Doe");
				 preparedStatement.setString(3, "18");
				 preparedStatement.setString(4, "rando@gmail.com");
				 preparedStatement.setString(5, "2");
				 preparedStatement.setString(6, "1");
				 preparedStatement.setString(7, "newJohn");
				 preparedStatement.execute();
				 
				 sql = "SET @staffId = LAST_INSERT_ID()";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "INSERT INTO address (address, district, city_id, phone, location)"
						 + " VALUES (?, ?, ?, ?, ST_GeomFromText(?))";
				 
				 long value = 7137778888L;
		
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.setString(1, "110 Main");
				 preparedStatement.setString(2, "Dime Box");
				 preparedStatement.setInt(3, 300);
				 preparedStatement.setLong(4, value);
				 preparedStatement.setString(5, "POINT(1 1)");
				 preparedStatement.execute();

				 sql = "SET @addressId = LAST_INSERT_ID()";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "INSERT INTO store (manager_staff_id, address_id)"
				 		+ " VALUES (@staffId, @addressId);";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "SET @storeId = LAST_INSERT_ID()";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "UPDATE staff SET store_id = @storeId WHERE staff_id = @staffId";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.executeUpdate();
				 
				 sql = "SELECT * FROM store";
				 preparedStatement = con.prepareStatement(sql);
				 getSQLResults(preparedStatement);
				 
				 sql = "ROLLBACK";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();
				 
				 sql = "SELECT * FROM store";
				 preparedStatement = con.prepareStatement(sql);
				 getSQLResults(preparedStatement);
				 
				 // 9. Update the timestamp to the current date/time for the new store you entered in the previous question. 
				 sql = "START TRANSACTION";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "SET SQL_SAFE_UPDATES = 0";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "UPDATE store AS s"
						 +  " INNER JOIN address AS a ON a.address_id = s.address_id"
						 +  " SET s.last_update = CURDATE()"
						 +  " WHERE a.address = '110 Main'";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();
				
				 sql = "SET SQL_SAFE_UPDATES = 1";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();
				 
				 sql = "ROLLBACK";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();
				 
				 // 10. Delete the new store. 
				 sql = "START TRANSACTION";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "SET SQL_SAFE_UPDATES = 0";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "DELETE s.* "
				 		+ " FROM store AS s"
				 		+ " INNER JOIN address AS a ON a.address_id = s.address_id"
				 		+ " WHERE a.address = '110 Main'";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.executeUpdate();
				 
				 sql = "SET SQL_SAFE_UPDATES = 1";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();

				 sql = "ROLLBACK";
				 preparedStatement = con.prepareStatement(sql);
				 preparedStatement.execute();
				
			}
		} catch (SQLException ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static void getSQLResults(String sqlQuery, Statement stmt) {
		try {

			ResultSet rs = stmt.executeQuery(sqlQuery);
			DBTablePrinter.printResultSet(rs);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void getSQLResults(PreparedStatement preparedStatement) {
		try {

			ResultSet rs = preparedStatement.executeQuery();
			DBTablePrinter.printResultSet(rs);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}