package com.joseph.MemberDatabse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemberDB_Application {

    public static void main(String[] args) {
        SpringApplication.run(MemberDB_Application.class, args);

        UserPanel userPanel = new UserPanel();
        Database list = new MemberList();
        IdGenerator idGen = new IdGenerator();
        Controller controller = new Controller();

        controller.Configure(userPanel, list, idGen);


        while (true) {
            controller.mainController();
        }

    }
}
