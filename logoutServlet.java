package Web_project_UserAuth;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/logout")
public class logoutServlet  extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                                        //donot create a new session
        HttpSession session=req.getSession(false);

        //checks if session exits then destroy it.
        if (session!=null){
            session.invalidate();

        }
        //sends back to login page with new request
        resp.sendRedirect("login");
    }
}
