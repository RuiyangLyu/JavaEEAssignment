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

@WebServlet(name = "ModifyGateServlet", value = "/ModifyGateServlet")
public class ModifyGateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //从前端页面获取新的课程信息
        int ID = Integer.parseInt(request.getParameter("id"));
        String gateName = request.getParameter("gatename");
        String buildTime = request.getParameter("buildtime");
        String manager =request.getParameter("manger");
        double lat = Double.parseDouble(request.getParameter("lat"));
        double lng = Double.parseDouble(request.getParameter("lng"));
        String description =request.getParameter("description");



        //创建更新好的课程记录
        WaterGate editedWg = new WaterGate(ID, gateName, buildTime, manager, lng, lat, description);

        //获取全局变量课程名单
        ArrayList<WaterGate> wgList = (ArrayList<WaterGate>)request.getServletContext().getAttribute("waterGateList");


        //遍历课程列表，找到对应id的课程
        for(WaterGate wg : wgList) {
            if(wg.getID() == ID) {
                //删除掉列表中原有的记录
                wgList.remove(wg);
                //放入更新过的记录
                wgList.add(editedWg);
                request.getServletContext().setAttribute("waterGateList", wgList);
                break;
            }
        }

        //设置返回类型为页面，以便给用户显示警告信息
        response.setContentType("text/html;");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //显示报错信息，并在3秒后跳回login.jsp
        out.println("修改成功，即将跳转回main页面。");
        response.setHeader("refresh", "1;url=" + request.getContextPath() + "/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
