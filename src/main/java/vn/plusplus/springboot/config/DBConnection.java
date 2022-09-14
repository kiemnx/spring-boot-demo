package vn.plusplus.springboot.config;

import vn.plusplus.springboot.controller.HomeController;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection(){
//        HomeController home = new HomeController();
        if(connection == null){
            connection = connectMySql();
        }
        return connection;
    }


    private static Connection connectMySql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info","root","1234");
            System.out.println("Connected MSYQL");
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
