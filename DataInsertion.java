package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataInsertion {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/csitthird", "root", "#1Eurika2");
            String insertionQuery=
                    "INSERT INTO student( id,name,age) VALUES(2,'Eureeka',20)";
            PreparedStatement statement= connection.prepareStatement(insertionQuery);
            statement.execute();
            System.out.println("DATA CREATED SUCCESSFULLY");
            statement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("DATA CREATION FAILED");
        }
    }
}