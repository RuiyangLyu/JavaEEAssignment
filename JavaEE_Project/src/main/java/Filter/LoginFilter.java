package Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "LoginFilter", urlPatterns = { "/*" })
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //将request和response转格式，不转有些方法没法调用
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        //获取session
        HttpSession session = req.getSession(true);

        //设置返回类型为页面，以便给用户显示警告信息
        resp.setContentType("text/html;");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        // 获取用户请求资源的路径
        String request_uri = req.getRequestURI();
        String ctxPath = req.getContextPath();
        String uri = request_uri.substring(ctxPath.length());

        // 如果路径目标是login，不做拦截，否则需要检查session以确定该用户是否已经合法登录
        if(uri.contains("login.jsp") || uri.contains("LoginServlet") || uri.contains("commons")){
            chain.doFilter(request, response);
        }else{
            // 如果session中有user，即走过正常登录的流程
            if (null != session.getAttribute("user")) {
                //不做拦截，直接跳过
                chain.doFilter(request, response);
            } else {
                //显示报错信息，并在3秒后跳回login.jsp
                out.println("您需要先登录才能访问其他资源。");
                resp.setHeader("refresh", "3;url=" + ctxPath + "/login.jsp");
                return;
            }
        }
    }
}
