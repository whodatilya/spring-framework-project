package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import models.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNickname(String nickname);

    boolean existsByNickname(String nickname);

    @Query(value = "select count(u.id) from User u where u.lastName = ?1")
    int countUserByLastName(String lastName);

}
