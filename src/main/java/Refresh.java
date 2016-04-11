// 导入必需的 java 库

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// 扩展 HttpServlet 类
public class Refresh extends HttpServlet {

    // 处理 GET 方法请求的方法
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置刷新自动加载时间为 1 秒
        response.setIntHeader("Refresh", 1);

        // 设置响应内容类型
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Get current time
        Calendar calendar = new GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String CT = (hour < 10 ? "0" + hour : hour) + ":" +
                    (minute < 10 ? "0" + minute : minute) + ":" +
                    (second < 10 ? "0" + second : second);

        PrintWriter out = response.getWriter();
        String title = "自动刷新 Header 设置";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p align=\"center\">当前时间是：" + CT + "</p>\n");
    }

    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
