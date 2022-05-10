package services;

import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dtos.PostDto;
import repositories.PostsRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public Post createNew(PostDto postDto) {
        Post post = Post.builder()
                .article(postDto.getTitle())
                .description(postDto.getDescription())
                .phoneNumber(postDto.getPhone_number())
                .build();
        return this.postsRepository.save(post);
    }
}
