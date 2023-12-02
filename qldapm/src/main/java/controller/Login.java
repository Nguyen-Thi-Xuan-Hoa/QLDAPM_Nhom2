package controller;

import bean.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        System.out.println(email+pass);
        User user = UserService.getInstance().login(email, pass);
        System.out.println(user);

        HttpSession session = request.getSession();

        if (user != null) {
            session.setAttribute("auth", user);
            response.sendRedirect("playnow.jsp");

        } else {
            request.setAttribute("error", "Sai thông tin đăng nhập");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


}