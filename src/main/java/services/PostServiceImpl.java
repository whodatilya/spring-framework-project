package services;

import forms.PostForm;
import models.Post;
import repositories.PostsRepository;

public class PostServiceImpl implements PostService{

    private final PostsRepository postsRepository;

    public PostServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public Post createNew(PostForm postForm) {

        Post post = new Post();
        post.setArticle(postForm.getArticle());

        post.setDescription(postForm.getDescription());
        post.setPhoneNumber(postForm.getPhoneNumber());
        return postsRepository.save(post);
    }
}
