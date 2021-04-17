package com.joseph.MemberDatabse;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MemberDB_Application {

    public static void main(String[] args) {
//        SpringApplication.run(MultiEcouteApplication.class, args);

        UserPanel userPanel = new UserPanel();
        Database list = new MemberList();
        Controller controller = new Controller();

        controller.Configure(userPanel, list);


        while (true) {
            controller.mainController();
        }

    }
}
