package servlets;

import forms.CommentForm;
import models.Comment;
import repositories.CommentRepositoryImpl;
import repositories.CommentsRepository;
import services.CommentService;
import services.CommentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/advertisement")
public class AdvertisementServlet extends HttpServlet {
    CommentService commentService;
    CommentsRepository commentsRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String query = req.getParameter("query");
        if (query != null) {
            System.out.println(query);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/advertisement.jsp");
        requestDispatcher.forward(req, resp);
        List<Comment> comments = commentsRepository.findAll();
        System.out.println(comments);
        try {
            req.setAttribute("comments", comments);
            req.getRequestDispatcher("/jsp/advertisement.jsp").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        CommentForm commentForm = new CommentForm();
        commentForm.setText(req.getParameter("text"));

        commentService.createNew(commentForm);

        req.getRequestDispatcher("jsp/advertisement.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siteDB", "postgres", "29102002");

            CommentsRepository commentsRepository = new CommentRepositoryImpl(connection);
            commentService = new CommentServiceImpl(commentsRepository);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Site unavailable.");
        }
    }
}
