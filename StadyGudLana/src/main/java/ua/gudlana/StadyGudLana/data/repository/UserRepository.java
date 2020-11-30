package ua.gudlana.StadyGudLana.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.gudlana.StadyGudLana.data.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
