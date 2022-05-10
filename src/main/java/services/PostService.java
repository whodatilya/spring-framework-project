package services;

import dtos.PostDto;
import models.Post;


public interface PostService {
    Post createNew(PostDto postDto);
}
