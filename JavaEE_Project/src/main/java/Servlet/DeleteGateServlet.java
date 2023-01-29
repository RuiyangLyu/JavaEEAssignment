package Servlet;
import Entity.WaterGate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "DeleteGateServlet", value = "/DeleteGateServlet")
public class DeleteGateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要修改的课程id
        String ID = request.getParameter("id");

        //获取全局变量课程名单
        ArrayList<WaterGate> wgList = (ArrayList<WaterGate>)request.getServletContext().getAttribute("waterGateList");

        //遍历课程列表，找到对应id的课程
        for(WaterGate wg : wgList) {
            if(wg.getID() == Integer.parseInt(ID)) {
                //删除掉列表中原有的记录
                wgList.remove(wg);
                //将更新过的列表放回全局变量容器
                request.getServletContext().setAttribute("waterGateList", wgList);
                break;
            }
        }

        //设置返回类型为页面，以便给用户显示警告信息
        response.setContentType("text/html;");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //显示报错信息，并在3秒后跳回login.jsp
        out.println("删除成功，即将跳转回main页面。");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
