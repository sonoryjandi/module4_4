package amalysheva.crud.servlets;

import amalysheva.crud.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(urlPatterns = {"/signin/*"})
public class SignInServlet extends HttpServlet {
    private final static File signInPage = new File("C:\\Users\\real_\\IdeaProjects\\module4_4\\src\\main\\resources\\signIn.html");
    private int idUser;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("get sign in");
        resp.getWriter().println(readPage(signInPage));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("post sign up");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User newUser = new User(login, password);
        resp.getWriter().println("New user: " + getIdUser() + newUser);

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

    public String readPage(File pageForReading) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pageForReading)));
            String content;
            StringBuilder answer = new StringBuilder();
            while ((content = reader.readLine()) != null) {
                answer.append(content);
                System.out.println(content);
            }
            return answer.toString();
        }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
