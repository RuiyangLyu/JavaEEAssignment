package Servlet;
import Entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        //从前端页面获取用户名

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        ServletContext application = request.getServletContext();

        ArrayList<User> userList = (ArrayList<User>) application.getAttribute("userList");




        //设置检查登录合法标记位
        boolean flag = false;

        for (User user : userList) {

            String tempName = user.getUsername();
            String tempPassword = user.getPassword();
            boolean status = user.getStatus();

//            if (userName.equals(tempName) && password.equals(tempPassword) && status) {
//                flag = true;
//                request.getSession().setAttribute("user", user);
//                break;
//            }
            if ( userName.equals(tempName) && password.equals(tempPassword) ) {
                flag = true;
                request.getSession().setAttribute("user", user);
                break;
            }
        }

        if (flag){
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }else {

            request.setAttribute("msg","登录失败，请重试");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
