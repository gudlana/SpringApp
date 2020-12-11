package ua.gudlana.StadyGudLana.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ua.gudlana.StadyGudLana.data.domain.User;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

    @Query(value = "{'username' : {$regex : ?0, $options: 'i'}}")
    List<User> findByUsernameRegex(String username);
}
