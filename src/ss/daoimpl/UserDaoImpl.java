package ss.daoimpl;

import ss.dao.UserDao;
import ss.entity.User;
import ss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao{
    @Override
    public int insertOne(User user) {
        String sql = "insert into t_user values (?,?,?)";
        Object[] objs = {user.getUid(), user.getUname(), user.getUpassword()};
        int n = DBUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public User findOne(String uid, String pwd) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_user where uid=? and upassword=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        User user = null;
        try {
            ps.setString(1, uid);
            ps.setString(2, pwd);

            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User(rs.getString("uid"), rs.getString("uname"),
                        rs.getString("upassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(rs, ps, conn);
        }

        return user;
    }
    @Override
    public List<User> selectAll() {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_user";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();
        try {
            rs = ps.executeQuery();
            while(rs.next()) {
                User user = new User(rs.getString("uid"),
                        rs.getString("uname"), rs.getString("upassword"));

                list.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return list;
    }

    @Override
    public int deleteOne(String uid) {
        String sql = "delete from t_user where uid=?";
        Object[] objs = {uid};
        int n = DBUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public User selectOne(String uid) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_user where uid=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        try {
            ps.setString(1, uid);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        User user = null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                user = new User(rs.getString("uid"),
                        rs.getString("uname"), rs.getString("upassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return user;
    }

    @Override
    public int updateOne(User user) {
        String sql = "update t_user set uid=?,uname=?,upassword=? where uid=?";
        Object[] objs = {user.getUid(), user.getUname(), user.getUpassword(),user.getUid()};
        int n = DBUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public boolean findOne(String uid) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_user where uid=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        try {
            ps.setString(1, uid);

            rs = ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(rs, ps, conn);
        }
        return false;
    }
}