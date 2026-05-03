package com.vinibf.cursospring.config;

import com.vinibf.cursospring.entities.Category;
import com.vinibf.cursospring.entities.Order;
import com.vinibf.cursospring.entities.User;
import com.vinibf.cursospring.entities.enums.OrderStatus;
import com.vinibf.cursospring.repositories.CategoryRepository;
import com.vinibf.cursospring.repositories.OrderRepository;
import com.vinibf.cursospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "User1", "User1@gmail.com", "11111111", "senha1");
        User user2 = new User(null, "User2", "User2@gmail.com", "22222222", "senha2");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, user1);

        Category c1 = new Category(null, "Roupas");
        Category c2 = new Category(null, "Eletrodomésticos");
        Category c3 = new Category(null, "Alimentos");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
