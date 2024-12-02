package ss.daoimpl;

import ss.dao.CommentDao;
import ss.entity.Comment;
import ss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CommentDaoImpl implements CommentDao{
    @Override
    public int insertOne(Comment comment) {
        String sql = "insert into t_comment values (?,?,?)";
        Object[] objs = {comment.getAname(),comment.getUsername(),comment.getAcomment()};
        int n = DBUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public Comment findOne(String aname, String username,String acomment) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_comment where aname=? and username=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        Comment comment = null;
        try {
            ps.setString(1, aname);
            ps.setString(2, username);

            rs = ps.executeQuery();
            if(rs.next()) {
                comment = new Comment( rs.getString("aname"), rs.getString("username"),rs.getString("acomment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeAll(rs, ps, conn);
        }

        return comment;
    }
    @Override
    public List<Comment> selectAll() {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_comment";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        List<Comment> list = new ArrayList<Comment>();
        try {
            rs = ps.executeQuery();
            while(rs.next()) {
                Comment comment = new Comment(rs.getString("aname"), rs.getString("username"),rs.getString("acomment"));

                list.add(comment);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return list;
    }

    @Override
    public int deleteOne(String aname,String username) {
        String sql = "delete from t_comment where aname=? and username=? ";
        Object[] objs = {aname,username};
        int n = DBUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public Comment selectOne(String aname,String username) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_comment where aname=? and username=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        try {
            ps.setString(1, aname);
            ps.setString(2,username);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        ResultSet rs = null;
        Comment comment = null;
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                comment = new Comment(rs.getString("aname"),rs.getString("username"), rs.getString("acomment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(rs, ps, conn);
        }
        return comment;
    }

    @Override
    public int updateOne(Comment comment) {
        String sql = "update t_comment set acomment=? where aname=? and username=? ";
        Object[] objs = {comment.getAcomment(),comment.getAname(),comment.getUsername()};
        int n = DBUtil.excuteDML(sql, objs);
        return n;
    }

    @Override
    public boolean findOne(String aname) {
        Connection conn = DBUtil.getConnection();
        String sql = "select * from t_comment where aname=?";
        PreparedStatement ps = DBUtil.getPreparedStatement(conn, sql);
        ResultSet rs = null;
        try {
            ps.setString(1, aname);

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