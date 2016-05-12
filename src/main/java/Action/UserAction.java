package Action;

import modle.User;
import util.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/5/12.
 */
@WebServlet(urlPatterns = "/User")
public class UserAction extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")) {
            login(req,resp);
        }
        if (action.equals("register")) {
            register(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement =null;

        String sql = "INSERT INTO exercise.user VALUES (NULL ,?,?,DEFAULT )";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.executeUpdate();
            resp.sendRedirect("/index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(null,preparedStatement,connection);
        }

    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        String sql = "select * from exercise.user WHERE username=?AND password=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();

            if (resultSet.next()){
                User user = new User(resultSet.getInt("id"),resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("role"));
                req.getSession().setAttribute("user",user);

                if (user.getRole().equals("teacher")) {
                    resp.sendRedirect("/teacher.jsp");
                }
                if (user.getRole().equals("student")) {
                    resp.sendRedirect("/student.jsp");
                }
                if (user.getRole().equals("jiaowu")) {
                    resp.sendRedirect("/jiaowu.jsp");
                }
            } else {
                req.setAttribute("message", "用户名或密码错误");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.close(resultSet,preparedStatement,connection);

        }
    }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
