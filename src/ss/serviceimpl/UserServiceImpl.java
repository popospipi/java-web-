package ss.serviceimpl;
import ss.dao.UserDao;
import ss.daoimpl.UserDaoImpl;
import ss.entity.User;
import ss.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao ud = new UserDaoImpl();
    private UserServiceImpl userDao;
    @Override
    public int register(User user) {
        if(ud.findOne(user.getUid())){
            return -1;
        }
        return ud.insertOne(user);
    }
    @Override
    public int addUser(User user) {

        return ud.insertOne(user);
    }
    @Override
    public User login(String uid, String pwd) {

        return ud.findOne(uid, pwd);
    }
    @Override
    public List<User> queryAllUser() {

        return ud.selectAll();
    }
    @Override
    public int removeUser(String uid) {

        return ud.deleteOne(uid);
    }
    @Override
    public User queryOneUser(String uid) {

        return ud.selectOne(uid);
    }
    @Override
    public int updateUser(User user) {

        return ud.updateOne(user);
    }

    @Override
    public List<User> queryAllsUser() {
        return List.of();
    }

    public void setUsersDao(UserDao userDao) {
            this.userDao = (UserServiceImpl) userDao;
    }
}