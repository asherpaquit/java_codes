import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement("INSERT INTO USER (name, email) VALUES (?, ?)")){

            String name = "Asher Pax";
            String email = "pax@cit.edu";

            statement.setString(1, name);
            statement.setString(2, email);

//            String createTableQuery = "CREATE TABLE IF NOT EXISTS user (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
//                    "NAME VARCHAR(50) NOT NULL, " +
//                    "email VARCHAR(50) NOT NULL )";

//            statement.execute(createTableQuery);

            int rowsInserted  = statement.executeUpdate();

            if(rowsInserted > 0){
                System.out.println("Data Inserted Successfully!");
            }

//            System.out.println("Table created successfully!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
