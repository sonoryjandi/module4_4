package amalysheva.crud.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println(PageGenerator.instance().getPage("page.html"));
//
//        resp.setContentType("text/html;charset=utf-8");
//        resp.setStatus(HttpServletResponse.SC_OK);
//        super.doGet(req, resp);

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("get sign in");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("post sign in");

//        Map<String, Object> pageVariables = createPageVariablesMap(request);
//
//        String message = request.getParameter("message");
//
//        response.setContentType("text/html;charset=utf-8");
//
//        if (message == null || message.isEmpty()) {
//            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        } else {
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
//        pageVariables.put("message", message == null ? "" : message);
//
//        response.getWriter().println(PageGenerator.instance().getPage("page.html", pageVariables));
    }

    // doGet

    //doPost
}
