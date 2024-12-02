import java.io.IOException;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateData")
public class UpdateDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String director = request.getParameter("director");
        String scriptwriter = request.getParameter("scriptwriter");
        String dub = request.getParameter("dub");
        String music = request.getParameter("music");
        String time = request.getParameter("time");
        String episode = request.getParameter("episode");
        response.setContentType("text/html;charset=UTF-8");

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/animation";
        String USER = "root";
        String PASS = "823181698";

        String sql = "UPDATE dm SET  director=?, scriptwriter=?,dub=?, music=?, time=?, episode=? WHERE name=?";// 省略其他字段

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, director);
            pstmt.setString(2, scriptwriter);
            pstmt.setString(3, dub);
            pstmt.setString(4, music);
            pstmt.setString(5, time);
            pstmt.setString(6, episode);
            pstmt.setString(7, name);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                response.sendRedirect("dm/index.jsp");
            } else {
                // 如果没有更新任何行，将错误信息发送到JSP页面
                request.setAttribute("error", "No rows were updated.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("dm/error.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 考虑使用日志记录框架来记录错误
            request.setAttribute("error", e.getMessage()); // 确保属性名与error.jsp中使用的一致
            RequestDispatcher dispatcher = request.getRequestDispatcher("dm/error.jsp");
            dispatcher.forward(request, response);
        }
    }}