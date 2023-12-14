package controller;

import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Signup", value = "/Signup")
public class Signup extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            System.out.println("msdnkfjadjfkjdsb");
            System.out.println(name );
            System.out.println("msdnkfjadjfkjdsb");
            String email = request.getParameter("email");
            System.out.println(email );
            String pass = request.getParameter("password");
            System.out.println(pass);
            System.out.println("msdnkfjadjfkjdsb");
            boolean exist = UserService.getInstance().checkAccountExist(email);
//            if (name == null && pass == null && email== null) {
//                request.setAttribute("errorName", "*Xin hãy nhập đầy đủ thông tin");
//                request.getRequestDispatcher("signup.jsp").forward(request, response);
//            }
            if (exist) {
                request.setAttribute("errorAcc", "* Email này đã được sử dụng");
                request.getRequestDispatcher("signup.jsp").forward(request, response);

            } else {
                UserService.getInstance().addUser(name, email, pass);
                response.sendRedirect("/Login");
                System.out.println(exist);


            }


        }
    }
