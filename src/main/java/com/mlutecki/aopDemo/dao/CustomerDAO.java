package com.mlutecki.aopDemo.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {
    private String acc;
    public void addAccount(Integer ac) {
        acc = ac.toString();
        System.out.println(getClass() + ": Jestem w innej klasie");
    }
}