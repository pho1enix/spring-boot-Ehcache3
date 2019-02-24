package com.phoenix.training.cache.dao;

import com.phoenix.training.cache.entity.User;
import com.phoenix.training.cache.repos.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@Component
public class UserDao {
    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);
    @Autowired
    UserRepo userRepo;

    @Cacheable(value = "Users")
    public Map<String, List<User>> findAllUser() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        LOG.info("I am still being used!");
        return userRepo.findAll()
                .stream()
                .collect(Collectors.groupingBy(User::getFname, Collectors.toList()));
    }
}
