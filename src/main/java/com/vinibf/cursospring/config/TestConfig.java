package com.vinibf.cursospring.config;

import com.vinibf.cursospring.entities.User;
import com.vinibf.cursospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "User1", "User1@gmail.com", "11111111", "senha1");
        User user2 = new User(null, "User2", "User2@gmail.com", "22222222", "senha2");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
