package ss.entity;
import java.util.Date;
public class User {
    private String uid;
    private String uname;
    private String upassword;


    public User(String uid, String uname, String upassword) {
        super();
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {return upassword;}

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    @Override
    public String toString() {
        return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + "]";
    }
}