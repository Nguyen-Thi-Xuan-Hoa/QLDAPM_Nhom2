package controller;

import bean.User;
import service.UserService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="Playnow", value = "/Playnow")
public class Playnow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listuser=UserService.getInstance().getListUser();
        request.setAttribute("listuser", listuser);
        request.getRequestDispatcher("playnow.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
