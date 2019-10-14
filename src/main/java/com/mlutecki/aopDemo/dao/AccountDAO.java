package com.mlutecki.aopDemo.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private Long Id;
    public String addAccount(Long id) {
        this.Id = id;
        System.out.println(getClass() + ": Robie z klasa AccountDAO");
        return "\n JJJJJJJJJJAAAAAAAAAAAAAA";
    }
}