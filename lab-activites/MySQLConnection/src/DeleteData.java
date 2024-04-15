import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            PreparedStatement statement = c.prepareStatement("DELETE FROM user WHERE id=?")){

            String name = "Russel Palms";
            String email = "palms@cit.edu";
            int idToDelete = 1;


            statement.setInt(1, idToDelete);

//            String createTableQuery = "CREATE TABLE IF NOT EXISTS user (" +
//                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
//                    "NAME VARCHAR(50) NOT NULL, " +
//                    "email VARCHAR(50) NOT NULL )";

//            statement.execute(createTableQuery);

            int rowsDeleted  = statement.executeUpdate();

            if(rowsDeleted > 0){
                System.out.println("Data Deleted Successfully!");
            }

//            System.out.println("Table created successfully!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
