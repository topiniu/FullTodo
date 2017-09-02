package FullTodo.servlets;

import FullTodo.IOTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

// 添加/修改/覆盖某用户的待办事项
// 参数：
// username:根据username来添加/修改/覆盖相应的待办事项。
public class addTodoList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--- addTodoList ---");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
//        System.out.println("Host: " + request.getHeader("Host"));
//        System.out.println("Referer : " + request.getHeader("Referer"));
        String username = request.getParameter("names");
        String todoList = request.getParameter("todoList");
        System.out.println(username+"\n"+todoList);
        IOTools.addTodoList(username,todoList);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
