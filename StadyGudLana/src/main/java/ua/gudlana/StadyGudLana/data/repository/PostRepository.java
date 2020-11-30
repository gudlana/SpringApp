package ua.gudlana.StadyGudLana.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.gudlana.StadyGudLana.data.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
