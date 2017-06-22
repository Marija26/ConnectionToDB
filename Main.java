package db_package;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Admin on 21.06.2017.
 */
public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "werter";

    public static void main(String[] args) {
        Connection connection;


        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("Connection is established");
            }
           connection.close();
            if(connection.isClosed()){
                System.out.println("Connection to DB is closed");
            }

        } catch (SQLException e) {
            System.err.println("Connection to library is failed");;
        }
    }
}
