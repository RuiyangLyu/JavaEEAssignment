package Servlet;

import Entity.WaterGate;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowModifyGateServlet", value = "/ShowModifyGateServlet")
public class ShowModifyGateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ID = request.getParameter("id");
        System.out.println(ID);

        ArrayList<WaterGate> wgList = (ArrayList<WaterGate>)request.getServletContext().getAttribute("waterGateList");


        WaterGate waterGate = null;


        for(WaterGate wg : wgList) {
            if(wg.getID() == Integer.parseInt(ID)) {
                waterGate = wg;
            }
        }


        if(waterGate != null) {
            request.setAttribute("id", waterGate.getID());
            request.setAttribute("gatename", waterGate.getGateName());
            request.setAttribute("buildtime", waterGate.getBuildTime());
            request.setAttribute("manager", waterGate.getManager());
            request.setAttribute("latitude", waterGate.getLat());
            request.setAttribute("longitude", waterGate.getLng());
            request.setAttribute("description", waterGate.getDescription());
        }


        RequestDispatcher dis = request.getRequestDispatcher("modifyGate.jsp");
        dis.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
