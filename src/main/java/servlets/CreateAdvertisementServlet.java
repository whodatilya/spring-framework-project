package servlets;

import forms.PostForm;
import repositories.PostsRepository;
import repositories.PostsRepositoryImpl;
import services.PostService;
import services.PostServiceImpl;

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

@WebServlet("/createNew")
public class CreateAdvertisementServlet extends HttpServlet {
     private PostService postService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/createNew.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        PostForm postForm = new PostForm();
        postForm.setArticle(req.getParameter("article"));
        postForm.setDescription(req.getParameter("desc"));
        postForm.setPhoneNumber(req.getParameter("phone"));

        postService.createNew(postForm);

        req.getRequestDispatcher("jsp/createNew.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        try {
            //Подгружаем драйвер, оно автоматически регистрирует JDBC
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/siteDB", "postgres", "29102002");

            PostsRepository postsRepository = new PostsRepositoryImpl(connection);
            postService = new PostServiceImpl(postsRepository);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Unavailable");
            throw new UnavailableException("Site unavailable.");
        }
    }
}
