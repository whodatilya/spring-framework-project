package services;

import forms.CommentForm;
import models.Comment;

public interface CommentService {
    Comment createNew(CommentForm commentForm);
}
