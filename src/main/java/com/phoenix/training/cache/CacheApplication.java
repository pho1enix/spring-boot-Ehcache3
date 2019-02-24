package com.phoenix.training.cache;

import com.phoenix.training.cache.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class CacheApplication {
    private static final Logger LOG = LoggerFactory.getLogger(CacheApplication.class);
    @Autowired
    UserDao userDao;
    int count = 1;

    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

    @Scheduled(fixedDelay = 5000)
    public void doNotStop() throws InterruptedException {

        if ((count++ % 2) == 0) {
            TimeUnit.SECONDS.sleep(11);
        }
        LOG.info(userDao.findAllUser().get("Ganesh2").toString());

    }


}


