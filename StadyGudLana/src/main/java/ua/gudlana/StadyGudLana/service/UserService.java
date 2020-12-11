package ua.gudlana.StadyGudLana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.data.repository.RoleRepository;
import ua.gudlana.StadyGudLana.data.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> findByUsername(String username) {
        return userRepository.findByUsernameRegex(username);
    }

    public List<User> findAll() {
       return userRepository.findAll();
    }
}
