package Servlet;
import Entity.WaterGate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetGatesServlet", value = "/GetGatesServlet")
public class GetGatesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<WaterGate> List = (ArrayList<WaterGate>) request.getServletContext().getAttribute("waterGateList");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

//        ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(response.getWriter(), List);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
