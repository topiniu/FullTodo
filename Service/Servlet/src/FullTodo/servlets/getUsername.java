package FullTodo.servlets;

import FullTodo.IOTools;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 获取已注册的用户名列表
// 可以获取的值：
// 数组，例如：["Frank","name1","name2"]
public class getUsername extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--- getUsername ---");
        response.setContentType("text/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String names = IOTools.getUsername();
//        String jsonData = "callback("+names+")";
        PrintWriter writer = response.getWriter();
        writer.print(names);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
