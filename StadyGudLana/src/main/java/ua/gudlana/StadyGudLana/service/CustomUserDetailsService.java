package ua.gudlana.StadyGudLana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.gudlana.StadyGudLana.data.domain.Role;
import ua.gudlana.StadyGudLana.data.domain.User;
import ua.gudlana.StadyGudLana.data.repository.RoleRepository;
import ua.gudlana.StadyGudLana.data.repository.UserRepository;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public User findUserByEmail(String email){
        return  userRepository.findByEmail(email);
    }

    public void saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      //  Role userRole = roleRepository.findByRole("ADMIN");
      //  user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);

        if(user != null){
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return  buildUserForAuthentication(user, authorities);
        } else {
            throw new UsernameNotFoundException("username not found");
        }
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles){
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach(role -> {
            roles.add(new SimpleGrantedAuthority(role.role));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }


}
