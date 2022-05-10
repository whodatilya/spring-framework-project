package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {
}
