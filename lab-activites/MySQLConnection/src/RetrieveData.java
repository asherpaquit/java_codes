import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveData {
    public static void main(String[] args) {
        try(Connection c = MySQLConnection.getConnection();
            Statement statement = c.createStatement()){

            String selectQuery = "SELECT * FROM user";
            ResultSet result = statement.executeQuery(selectQuery);

            while(result.next()){
                 int id = result.getInt("id");
                 String name = result.getString("name");
                 String email = result.getString("email");
                 System.out.println("ID: " + id + "\nName: " + name + "\nemail: " + email);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
