// 导入必需的 java 库

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// 扩展 HttpServlet 类
public class HelloWorld extends HttpServlet {

    private String message;

    public void init() {
        // 执行必要的初始化
        message = "Hello, Servlet";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型，编码
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // 实际的逻辑实在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy() {

    }
}
