package ua.gudlana.StadyGudLana.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.gudlana.StadyGudLana.data.domain.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

   Role findByRole(String role);

}
