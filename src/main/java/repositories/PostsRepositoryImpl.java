package repositories;

import models.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostsRepositoryImpl implements PostsRepository {
    private final Connection connection;
    //language=sql
    private final String SQL_INSERT_POST = "INSERT INTO posts(article, description, phoneNumber) VALUES (?, ?, ?)";
    private final String SQL_FIND_POST_BY_ARTICLE = "SELECT * FROM posts WHERE article=?;";

    public PostsRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select * from posts");
            while (set.next()) {
                int id = set.getInt("id");
                String article = set.getString("article");
                String description = set.getString("description");
                String phoneNumber = set.getString("phonenumber");

                Post post = Post.builder()
                        .id((long) id)
                        .article(article)
                        .description(description)
                        .phoneNumber(phoneNumber)
                        .build();

                posts.add(post);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Post save(Post post) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_POST, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, post.getArticle());
            preparedStatement.setString(2, post.getDescription());
            preparedStatement.setString(3, post.getPhoneNumber());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                post.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Post findByArticle(String article) {
        return null;
    }


}
