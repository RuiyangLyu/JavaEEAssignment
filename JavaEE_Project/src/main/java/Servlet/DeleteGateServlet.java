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

        String ID = request.getParameter("id");


        ArrayList<WaterGate> wgList = (ArrayList<WaterGate>)request.getServletContext().getAttribute("waterGateList");


        for(WaterGate wg : wgList) {
            if(wg.getID() == Integer.parseInt(ID)) {
                //删除掉列表中原有的记录
                wgList.remove(wg);
                //将更新过的列表放回全局变量容器
                request.getServletContext().setAttribute("waterGateList", wgList);
                break;
            }
        }

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
