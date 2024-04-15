import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement("UPDATE user SET name=?, email=? WHERE id=?")){

            String name = "Russel Palms";
            String email = "palms@cit.edu";
            int idToUpdate = 1;

            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, idToUpdate);

//            String createTableQuery = "CREATE TABLE IF NOT EXISTS user (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
//                    "NAME VARCHAR(50) NOT NULL, " +
//                    "email VARCHAR(50) NOT NULL )";

//            statement.execute(createTableQuery);

            int rowsUpdated  = statement.executeUpdate();

            if(rowsUpdated > 0){
                System.out.println("Data Inserted Successfully!");
            }

//            System.out.println("Table created successfully!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
