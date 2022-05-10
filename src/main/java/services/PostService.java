package services;

import forms.PostForm;
import models.Post;


public interface PostService {
    Post createNew(PostForm postForm);
}
