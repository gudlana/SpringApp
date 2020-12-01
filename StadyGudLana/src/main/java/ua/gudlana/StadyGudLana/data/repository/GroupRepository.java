package ua.gudlana.StadyGudLana.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.gudlana.StadyGudLana.data.domain.Group;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {
    void delete(String id);
}
