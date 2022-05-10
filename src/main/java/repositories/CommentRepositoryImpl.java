package repositories;

import models.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentRepositoryImpl implements CommentsRepository{
    private final Connection connection;

    //language=sql
    private final String SQL_INSERT_COMMENT = "INSERT INTO comments(text) VALUES (?)";
    private final String SQL_FIND_COMMENT_BY_TEXT = "SELECT * FROM comments WHERE text=?;";

    public CommentRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery("select * from comments");
            while (set.next()) {
                int id = set.getInt("id");
                String text = set.getString("text");

                Comment comment = Comment.builder()
                        .id(id)
                        .text(text)
                        .build();

                comments.add(comment);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return comments;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Comment save(Comment comment) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_COMMENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, comment.getText());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                comment.setId((int) resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public void deleteById(Long id) {

    }
}
