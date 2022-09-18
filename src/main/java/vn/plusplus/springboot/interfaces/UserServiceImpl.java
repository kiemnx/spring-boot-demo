package vn.plusplus.springboot.interfaces;

import org.springframework.stereotype.Service;
import vn.plusplus.springboot.config.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServiceImpl implements UserService{

    private final DBConnection dbConnection;
    private final Connection connection;

    public UserServiceImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
        this.connection = dbConnection.getConnection();
    }


    @Override
    public boolean checkUserExistedByPhone(String phone) {
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM account WHERE phone='" + phone +"'";
            System.out.println("QUERY: " + query);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insertUser(String phone, String email, String pass) {
        boolean check = checkUserExistedByPhone(phone);
        if(!check) {
            try {
                Statement statement = connection.createStatement();
                String query = "INSERT into account( `phone`, `email`, `password`) VALUES ('" + phone + "','" + email + "','" + pass + "');";
                System.out.println("QUERY: " + query);
                statement.execute(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return check;
    }

    @Override
    public String checkUserName(String username) {
        return null;
    }
}
