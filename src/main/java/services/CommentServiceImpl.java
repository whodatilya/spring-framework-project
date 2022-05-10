package services;

import forms.CommentForm;
import models.Comment;
import repositories.CommentsRepository;

public class CommentServiceImpl implements CommentService{
    private final CommentsRepository commentsRepository;

    public CommentServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public Comment createNew(CommentForm commentForm) {
        Comment comment = new Comment();
        comment.setText(commentForm.getText());

        return commentsRepository.save(comment);
    }
}
