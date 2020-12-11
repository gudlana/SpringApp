package ua.gudlana.StadyGudLana;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ua.gudlana.StadyGudLana.data.domain.Role;
import ua.gudlana.StadyGudLana.data.repository.RoleRepository;

@SpringBootApplication
public class StadyGudLanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StadyGudLanaApplication.class, args);
	}

//
//	@Bean
//	CommandLineRunner init(RoleRepository roleRepository) {
//
//		return args -> {
//
//			Role adminRole = roleRepository.findByRole("ADMIN");
//			if (adminRole == null) {
//				Role newAdminRole = new Role();
//				newAdminRole.setRole("ADMIN");
//				roleRepository.save(newAdminRole);
//			}
//
//			Role userRole = roleRepository.findByRole("USER");
//			if (userRole == null) {
//				Role newUserRole = new Role();
//				newUserRole.setRole("USER");
//				roleRepository.save(newUserRole);
//			}
//		};
//	}
}


