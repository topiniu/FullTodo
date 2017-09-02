package FullTodo.servlets;

import FullTodo.IOTools;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 获取待办事项，json格式
// 可以获取的值：
// 根据传过来的name获取待办事项数据
public class getTodoList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--- getTodoList ---");
        response.setContentType("text/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        String name = request.getParameter("name");
        System.out.println(name);
        String todolist = IOTools.getTodoList(name);
        System.out.println(todolist);
//        String jsonData = "callback("+todolist+")";
        PrintWriter writer = response.getWriter();
        writer.print(todolist);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
