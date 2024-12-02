package ss.serviceimpl;
import ss.dao.CommentDao;
import ss.daoimpl.CommentDaoImpl;
import ss.entity.Comment;
import ss.service.CommentService;

import java.util.ArrayList;
import java.util.List;

public class CommentServiceImpl implements CommentService{
    private CommentDao cd = new CommentDaoImpl();
    private CommentServiceImpl commentDao;

    @Override
    public List<Comment> queryCommentsByUname(String aname) {
        List<Comment> comment = new ArrayList<>();
        return comment;
    }

    @Override
    public int addComment(Comment comment) {

        return cd.insertOne(comment);
    }
    @Override
    public List<Comment> queryAllComment() {

        return cd.selectAll();
    }
    @Override
    public int removeComment(String aname,String username) {

        return cd.deleteOne(aname,username);
    }
    @Override
    public Comment queryOneComment(String aname, String username) {

        return cd.selectOne(aname,username);
    }
    @Override
    public int updateComment(Comment comment) {

        return cd.updateOne(comment);
    }

    @Override
    public List<Comment> queryAllsComment() {
        return List.of();
    }

    public void setCommentsDao(CommentDao commentDao) {
        this.commentDao = (CommentServiceImpl) commentDao;
    }
}