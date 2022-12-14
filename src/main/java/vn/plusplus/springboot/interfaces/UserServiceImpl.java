package vn.plusplus.springboot.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.plusplus.springboot.config.DBConnection;
import vn.plusplus.springboot.repository.AccountJPArepo;
import vn.plusplus.springboot.repository.AccountJpa;
import vn.plusplus.springboot.utils.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class UserServiceImpl implements UserService{

    private final DBConnection dbConnection;
    private final Connection connection;

    @Autowired
    AccountJPArepo accountJPArepo;

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
                Account account = new Account();
                account.setUsername(resultSet.getString("username"));
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

    @Transactional
    public void transferMoney(String accountFrom, String accountTo, Integer money){
        //Tru tien trong accountFrom
        AccountJpa accFrom = accountJPArepo.findByActivePhone(accountFrom);
        accFrom.setBalance(accFrom.getBalance() - money);
        accountJPArepo.save(accFrom);
        //Cong tien vao accountTo
        AccountJpa accTo = accountJPArepo.findByActivePhone(accountTo);
        accTo.setBalance(accTo.getBalance() + money);
        accountJPArepo.save(accTo);
    }
}
