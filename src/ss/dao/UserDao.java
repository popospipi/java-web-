package ss.dao;
import ss.entity.User;

import java.util.List;

public interface UserDao {
    int insertOne(User user);
    List<User> selectAll();
    User findOne(String uid, String pwd);
    int deleteOne(String uid);
    User selectOne(String uid);
    int updateOne(User user);
    boolean findOne(String uid);
}