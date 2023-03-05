package Listener;

import Entity.User;
import Entity.WaterGate;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.ArrayList;


@WebListener
public class ServerInitListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public ServerInitListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        //用户列表
        ArrayList<User> userList = new ArrayList<User>();
        //添加5个初始化用户
        User user1 = new User("User001",1,"123456",1,true);
        User user2 = new User("User002",2,"123456",1,true);
        User user3 = new User("User003",3,"123456",1,false);
        User user4 = new User("User004",4,"123456",0,false);
        User user5 = new User("User005",5,"123456",0,true);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);

        //水闸列表
        ArrayList<WaterGate> waterGateList = new ArrayList<WaterGate>();
        //添加初始化10个水闸
        WaterGate waterGate1 = new WaterGate(1,"1号站","2022年2月15日","User01",30.21,40.71,"这是一段简介");
        WaterGate waterGate2 = new WaterGate(2,"2号站","2022年2月15日","User02",30.21,40.71,"这是一段简介");
        WaterGate waterGate3 = new WaterGate(3,"3号站","2022年2月15日","User03",30.21,40.71,"这是一段简介");
        WaterGate waterGate4 = new WaterGate(4,"4号站","2022年2月15日","User04",30.21,40.71,"这是一段简介");
        WaterGate waterGate5 = new WaterGate(5,"5号站","2022年2月15日","User05",30.21,40.71,"这是一段简介");
        WaterGate waterGate6 = new WaterGate(6,"6号站","2022年2月15日","User06",30.21,40.71,"这是一段简介");
        WaterGate waterGate7 = new WaterGate(7,"7号站","2022年2月15日","User07",30.21,40.71,"这是一段简介");
        WaterGate waterGate8 = new WaterGate(8,"8号站","2022年2月15日","User08",30.21,40.71,"这是一段简介");
        WaterGate waterGate9 = new WaterGate(9,"9号站","2022年2月15日","User09",30.21,40.71,"这是一段简介");
        WaterGate waterGate10 = new WaterGate(10,"10号站","2022年2月15日","User10",30.21,40.71,"这是一段简介");
        waterGateList.add(waterGate1);
        waterGateList.add(waterGate2);
        waterGateList.add(waterGate3);
        waterGateList.add(waterGate4);
        waterGateList.add(waterGate5);
        waterGateList.add(waterGate6);
        waterGateList.add(waterGate7);
        waterGateList.add(waterGate8);
        waterGateList.add(waterGate9);
        waterGateList.add(waterGate10);

        //将两个列表放在application这个容器中
        sce.getServletContext().setAttribute("userList",userList);
        sce.getServletContext().setAttribute("waterGateList",waterGateList);

        System.out.println("初始化成功——");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
