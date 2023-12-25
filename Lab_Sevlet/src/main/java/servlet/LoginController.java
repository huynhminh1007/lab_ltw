package servlet;

import bean.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginController extends HttpServlet {

    private final String URL_LOGIN = "/index.jsp";
    private final String URL_ERROR = "/login.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = UserService.getInstance().checkLogin(email, password);

        if(user != null) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher(URL_LOGIN).forward(request, response);
        }
        else {
            request.setAttribute("error_login", "Tài khoản Không hợp lệ");
            response.sendRedirect(request.getContextPath() + URL_ERROR);
        }
    }
}
