package ss.dao;
import ss.entity.Comment;

import java.util.List;

public interface CommentDao {
    int insertOne(Comment comment);
    List<Comment> selectAll();
    Comment findOne(String aname, String username,String acomment);
    int deleteOne(String aname,String username);
    Comment selectOne(String comment,String username);
    int updateOne(Comment  comment);
    boolean findOne(String aname);
}
