package com.joseph.MemberDatabse;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.InputMismatchException;

/**
 * Project: Member Database with Hibernate
 * Developed by: Yousef Emadi
 * Date: APR 2021
 * Supported by: Java, Spring, H2
 */

@SpringBootApplication
public class MemberDB_Application implements ApplicationContextAware {

    public static ApplicationContext ctx;
    @Override
    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }


    public static void main(String[] args) {
        SpringApplication.run(MemberDB_Application.class, args);

        UserPanel userPanel = new UserPanel();
        Database list = new HibernateDatabase();
        IdGenerator idGen = new IdGenerator();
        Controller controller = new Controller();

        controller.Configure(userPanel, list, idGen);


        while (true) {

            controller.mainController();

        }

    }


}
