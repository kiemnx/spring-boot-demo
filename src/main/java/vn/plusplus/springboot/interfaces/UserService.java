package vn.plusplus.springboot.interfaces;

public interface UserService extends AccountInterface{
    boolean checkUserExistedByPhone(String phone);
    boolean insertUser(String phone, String email, String pass);
}
