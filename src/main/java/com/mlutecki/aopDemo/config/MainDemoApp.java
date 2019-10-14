package com.mlutecki.aopDemo.config;

import com.mlutecki.aopDemo.dao.AccountDAO;
import com.mlutecki.aopDemo.dao.CustomerDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        String myString= accountDAO.addAccount(100000L);
        System.out.println("to jest moj string zmodyfikowany: " + myString);
        System.out.println("------------------------------------------------------------");
        CustomerDAO customerDAO = context.getBean("customerDAO", CustomerDAO.class);
        customerDAO.addAccount(153);

        context.close();
    }
}
