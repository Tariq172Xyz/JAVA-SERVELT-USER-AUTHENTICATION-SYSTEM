package Web_project_UserAuth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email=req.getParameter("email");
        String password=req.getParameter("password");
        UserDAO user=new UserDAO();
        User validate=user.validateUser(email,password);

        if (validate!=null){
            HttpSession session = req.getSession();
            session.setAttribute("user",validate);

            resp.sendRedirect("home");
        }else{
            req.setAttribute("Error","Username or password is incorrect");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req,resp);

        }

    }
}
