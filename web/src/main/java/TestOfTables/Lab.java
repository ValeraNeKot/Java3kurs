package TestOfTables;
import java.sql.*;
import val.web.Connection.JDBC;

public class Lab {
	  public static void main(String[] args) {
	        Statement stmt = null;
	        try{

	            JDBC.connect();

	            stmt = JDBC.connection.createStatement();
	            //1
	            String queryAuthor = "SELECT * FROM authors ORDER BY firstName, lastName";

	            System.out.println("Show all authors");

	            ResultSet rs1 = stmt.executeQuery(queryAuthor);
	            while (rs1.next()) {
	            	int id = rs1.getInt("authorID");
	           	 	String firstName = rs1.getString("firstName");
	           	 	String lastName = rs1.getString("lastName");
	           	 	System.out.println(id + "\t" + firstName + "\t" + lastName);
	            }
	            //2
	            String publisherName = "PIPI";
	            String sql = "INSERT INTO publishers (publisherName) VALUES (?)";
	            PreparedStatement preparedStatement = JDBC.connection.prepareStatement(sql);
	            preparedStatement.setString(1, publisherName);
	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Publisher added successfully!");
	            } else {
	                System.out.println("Failed to add publisher.");
	            }
	            //3
	            String queryPublisher = "SELECT * FROM publishers";

	            System.out.println("Show all publishers");

	            ResultSet rs2 = stmt.executeQuery(queryPublisher);
	            while (rs2.next()) {
	            	int id = rs2.getInt("PublisherID");
	           	 	String publName = rs2.getString("publisherName");
	           	 	System.out.println(id + "\t" + publName);
	            }
	            String sql2 = "UPDATE publishers SET publisherName = ? WHERE publisherID = ?";
	            
	            PreparedStatement preparedStatement2 = JDBC.connection.prepareStatement(sql2);
	            preparedStatement2.setString(1, "PUPU");
	            preparedStatement2.setInt(2, 12);
	            preparedStatement2.executeUpdate();
	            //4
	            int publisherId = 5;
	            String sql3 = "SELECT * FROM Titles WHERE publisherID = " + publisherId+ " ORDER BY title ASC"; // Сортируем по заголовку
	            
	            PreparedStatement preparedStatement3 = JDBC.connection.prepareStatement(sql3);
	            //preparedStatement3.setInt(1, publisherId); // Устанавливаем publisherID в запрос
	            
	            ResultSet resultSet = preparedStatement3.executeQuery(sql3);
	                while (resultSet.next()) {
	                	 String isbn = resultSet.getString("isbn");
	                	 String title = resultSet.getString("title");
	                	 int editionNumber = resultSet.getInt("editionNumber");
	                	 String year = resultSet.getString("year"); 
	                	 int publisherID = resultSet.getInt("publisherID"); 
	                	 double price = resultSet.getDouble("price");
	                	 System.out.println(isbn + "\t" + title + "\t" + editionNumber +"\t"+ year + "\t"+ publisherID +"\t"+  price );
	                	 }
	            //5
	                String firstName = "Valera";
	           	 	String lastName = "Semenova";
		            String sql4 = "INSERT INTO authors (firstName, lastName) VALUES (?, ?)";
		            PreparedStatement preparedStatement4 = JDBC.connection.prepareStatement(sql4);
		            preparedStatement4.setString(1, firstName);
		            preparedStatement4.setString(2, lastName);
		            int rowsAffected4 = preparedStatement4.executeUpdate();

		            if (rowsAffected4 > 0) {
		                System.out.println("Author added successfully!");
		            } else {
		                System.out.println("Failed to add author.");
		            }    
	            //6
		            String sql5 = "UPDATE authors SET firstName = ? WHERE authorID = ?";
		            
		            PreparedStatement preparedStatement5 = JDBC.connection.prepareStatement(sql5);
		            preparedStatement5.setString(1, "Muhamed");
		            preparedStatement5.setInt(2, 3);
		            preparedStatement5.executeUpdate();
		            //4
		        //7
		            String publisherName1 = "Popa";
		            String sql6 = "INSERT INTO publishers (publisherName) VALUES (?)";
		            PreparedStatement preparedStatement6 = JDBC.connection.prepareStatement(sql6);
		            preparedStatement6.setString(1, publisherName1);
		            preparedStatement6.executeUpdate();

		            String isbn = "1111139512";
		        	String title = "LalaOkeke";
		        	int editionNumber = 7;
		        	String year = "2024";  
		        	double price = 12.12;
		            String sql7 = "INSERT INTO Titles (isbn, title, editionNumber, year, publisherID, price) VALUES (?, ?, ?, ?, (SELECT publisherID FROM Publishers WHERE publisherName = ? ), ?)";
		            PreparedStatement preparedStatement7 = JDBC.connection.prepareStatement(sql7);
		            preparedStatement7.setString(1, isbn);
		            preparedStatement7.setString(2, title);
		            preparedStatement7.setInt(3, editionNumber);
		            preparedStatement7.setString(4, year);
		            preparedStatement7.setString(5, publisherName1);
		            preparedStatement7.setDouble(6, price);
		            preparedStatement7.executeUpdate();
		            
		            String sql8 = "INSERT INTO AuthorISBN (authorID, isbn) VALUES ((SELECT authorID FROM Authors WHERE firstName = ? AND lastName = ?), ?)";
		            PreparedStatement preparedStatement8 = JDBC.connection.prepareStatement(sql8);
		            preparedStatement8.setString(1, firstName);
		            preparedStatement8.setString(2, lastName);
		            preparedStatement8.setString(3, isbn);
		            preparedStatement8.executeUpdate();

	        } catch(SQLException se) {
	            //Handle errors for JDBC
	            se.printStackTrace();
	        } finally {
	            //finally block used to close resources
	            JDBC.close();
	        }
	    }
	}