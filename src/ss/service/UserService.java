package ss.service;
import ss.entity.User;

import java.util.List;

public interface UserService {
    int register(User user);
    User login(String uid, String pwd);
    int addUser(User user);
    List<User> queryAllUser();
    int removeUser(String uid);
    int updateUser(User user);
    List<User> queryAllsUser();
    User queryOneUser(String uid);
}