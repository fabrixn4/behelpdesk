package com.fabrizio.helpdesk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fabrizio.helpdesk.api.entity.User;
import com.fabrizio.helpdesk.api.enums.ProfileEnum;
import com.fabrizio.helpdesk.api.repository.UserRepository;

@SpringBootApplication
public class BehelpdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BehelpdeskApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoding) {
		return args -> {
			initUsers(userRepository, passwordEncoding);
		};
	}
	
	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoding) {
		User admin = new User();
		admin.setEmail("fabrixn4@gmail.com");
		admin.setPassword(passwordEncoding.encode("1234"));
		admin.setProfile(ProfileEnum.ROLE_ADMIN);
		User find = userRepository.findByEmail("fabrixn4@gmail.com");
		if (find == null) {
			userRepository.save(admin);
		}
	}	
}
