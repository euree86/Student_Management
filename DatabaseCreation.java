package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseCreation {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "#1Eurika2");
            String dataBaseCreationQuery= "CREATE DATABASE csitThird";
            PreparedStatement statement= connection.prepareStatement(dataBaseCreationQuery);
            statement.execute();
            System.out.println("DATABASE CREATED SUCCESSFULLY");
            statement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("DATABASE CREATION FAILED");
        }
    }
}
