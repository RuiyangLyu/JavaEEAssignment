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

@WebServlet(name = "AddGateServlet", value = "/AddGateServlet")
public class AddGateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取全局变量课程名单
        ArrayList<WaterGate> wgList = (ArrayList<WaterGate>)request.getServletContext().getAttribute("waterGateList");

        //从前端页面获取新的课程信息
        int ID = Integer.parseInt(request.getParameter("id"));

        for (WaterGate waterGate : wgList) {
            //id重复了
            if (ID == waterGate.getID()) {
                request.setAttribute("error msg", "编号重复，请重新输入！");
                request.getRequestDispatcher("addGate.jsp").forward(request, response);
            }
        }

        String gateName = request.getParameter("gatename");
        String buildTime = request.getParameter("buildtime");
        String manager =request.getParameter("manger");
        double lat = Double.parseDouble(request.getParameter("lat"));
        double lng = Double.parseDouble(request.getParameter("lng"));
        String description =request.getParameter("description");


        //创建记录
        WaterGate wg = new WaterGate(ID, gateName, buildTime, manager, lng, lat, description);


        //增加记录
        wgList.add(wg);

        //这句会直接用新列表替换掉旧的列表
        request.getServletContext().setAttribute("waterGateList", wgList);

        //设置返回类型为页面，以便给用户显示警告信息
        response.setContentType("text/html;");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //显示报错信息，并在3秒后跳回login.jsp
        out.println("新增成功，即将跳转回main页面。");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
