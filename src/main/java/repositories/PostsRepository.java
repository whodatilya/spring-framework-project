package repositories;

import models.Post;

public interface PostsRepository extends CrudRepository<Post> {
    Post findByArticle(String article);
}
