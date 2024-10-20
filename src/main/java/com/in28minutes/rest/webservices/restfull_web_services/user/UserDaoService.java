package com.in28minutes.rest.webservices.restfull_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    private static int usersCount = 0 ;

    static {
        users.add(new User(++usersCount, "Johan", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Text", LocalDate.now().minusYears(10)));
        users.add(new User(++usersCount, "OneRa", LocalDate.now().minusYears(40)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public boolean deleteById(int id) {
        Predicate<User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
        return false;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
}