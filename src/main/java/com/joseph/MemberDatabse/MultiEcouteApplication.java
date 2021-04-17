package com.joseph.MemberDatabse;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MultiEcouteApplication {

    public static void main(String[] args) {
//        SpringApplication.run(MultiEcouteApplication.class, args);

        UserPanel userPanel = new UserPanel();
        Controller controller = new Controller();
        ClientsList clientsList = new ClientsList();


        while (true) {
            controller.mainController();
        }

    }
}
