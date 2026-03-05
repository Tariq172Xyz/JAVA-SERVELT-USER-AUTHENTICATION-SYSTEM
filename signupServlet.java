package Web_project_UserAuth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signup")
public class signupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("signup.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        UserDAO user=new UserDAO();
        boolean newUser=user.saveUser(name,email,password);

        if (newUser){
            HttpSession session= req.getSession();
            session.setAttribute("user",new User(name,email,password));
            resp.sendRedirect("home");
        }else {
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("signup.jsp");
            requestDispatcher.forward(req,resp);
        }

    }
}
