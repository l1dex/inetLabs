package servlet;

import db.DAO.UsersDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignServlet", urlPatterns = {"/signServlet"})
public class SignServlet extends HttpServlet {
    private UsersDAO usersDAO;
    public SignServlet(){
        this.usersDAO = new UsersDAO();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(usersDAO.getUserByLogin(req.getParameter("login")).getPassword().compareTo(req.getParameter("password")) == 0){
            req.getSession().setAttribute("login",req.getParameter("login"));
            req.getRequestDispatcher("content.jsp").forward(req,resp);
        }else {
            req.getSession().setAttribute("message","wrong password");
            req.getRequestDispatcher("signPage.jsp").forward(req,resp);
        }

    }

}
