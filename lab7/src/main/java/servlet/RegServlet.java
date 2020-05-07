package servlet;

import db.DAO.UsersDAO;
import db.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegServlet", urlPatterns = {"/regServlet"})
public class RegServlet extends HttpServlet {
    private UsersDAO usersDAO;
    public RegServlet(){
        this.usersDAO = new UsersDAO();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(usersDAO.getUserByLogin(req.getParameter("login")) == null){
            usersDAO.create(new Users(1,req.getParameter("login"),req.getParameter("password")));
            req.getRequestDispatcher("http://127.0.0.1:8080/signPage.jsp").forward(req,resp);
        }else {
            resp.getWriter().println("User with this login already exist");
        }
    }

}
