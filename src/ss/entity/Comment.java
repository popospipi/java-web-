package ss.entity;
import java.util.Date;
public class Comment{
    private String aname;
    private String username;
    private String acomment;


    public Comment(String aname,String username ,String acomment) {
        super();
        this.aname = aname;
        this.username = username;
        this.acomment = acomment;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAcomment() {
        return acomment;
    }

    public void setAcomment(String acomment) {
        this.aname = acomment;
    }


    @Override
    public String toString() {
        return "Comment [ aname=" + aname + ", username=" + username + ",acomment=" + acomment + "]";
    }
}