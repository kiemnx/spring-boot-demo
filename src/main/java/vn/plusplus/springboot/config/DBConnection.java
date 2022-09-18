package vn.plusplus.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class DBConnection {

    private  Connection connection = null;

    @Value("${database.url}")
    private String dbUrl;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    public  Connection getConnection(){
//        HomeController home = new HomeController();
        if(connection == null){
            connection = connectMySql();
        }
        return connection;
    }


    private  Connection connectMySql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Connected MSYQL");
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
