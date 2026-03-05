package Web_project_UserAuth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/home")
public class homeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        if (session==null || session.getAttribute("user")==null){
            resp.sendRedirect("login");
            return;
        }

        RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
        requestDispatcher.forward(req,resp);
    }
}
