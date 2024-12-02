package com.study.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/getImage")
public class ImageServlet extends HttpServlet {
    private static final String DOWNLOAD_DIRECTORY = "D:/work";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        File file = new File(DOWNLOAD_DIRECTORY+"/" + filename);
        if (file.exists()) {
            // 设置响应类型为图片类型
            response.setContentType(getServletContext().getMimeType(filename));
            // 将图片写入输出流
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
            fis.close();
            os.flush();
            os.close();
        } else {
            // 文件不存在时的处理
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
