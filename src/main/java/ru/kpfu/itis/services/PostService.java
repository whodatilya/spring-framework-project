package ru.kpfu.itis.services;

import ru.kpfu.itis.dtos.PostDto;
import ru.kpfu.itis.models.Post;

import java.util.List;


public interface PostService {
    Post createNew(PostDto postDto);
    List<Post> findAllPosts();
}
