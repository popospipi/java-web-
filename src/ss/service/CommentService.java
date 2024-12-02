package ss.service;
import ss.entity.Comment;

import java.util.List;

public interface CommentService {
    int addComment(Comment comment);
    List<Comment> queryAllComment();
    int removeComment(String aname,String usename);
    Comment queryOneComment(String aname, String username);
    int updateComment(Comment comment);
    List<Comment> queryAllsComment();
    List<Comment> queryCommentsByUname(String aname);
}