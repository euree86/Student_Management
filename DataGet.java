package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataGet {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/csitthird", "root", "#1Eurika2");
            String retrieveQuery="SELECT * from student WHERE id=2";
            PreparedStatement statement= connection.prepareStatement(retrieveQuery);
            ResultSet resultSet= statement.executeQuery();
            while(resultSet.next()){
                System.out.println("ID:"+resultSet.getInt("id")
                +"Name:"+resultSet.getString("name")
                        +"Age:"+resultSet.getInt("age"));
            }
            System.out.println("DATA Retrieved SUCCESSFULLY");
            statement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("DATA RETRIVE FAILED");
        }
    }
}