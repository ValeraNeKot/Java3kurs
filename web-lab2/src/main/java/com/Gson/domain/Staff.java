package com.Gson.domain;

import com.Gson.core.EF;
import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Staff {
    private String name;
    private int age;
    //@EF
    private String[] position;
    private List<String> skills;
    private Map<String, BigDecimal> salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String[] position) {
        this.position = position;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(Map<String, BigDecimal> salary) {
        this.salary = salary;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void print()
    {
        System.out.println(name);
        System.out.println(age);
        for (int i = 0; i < position.length; i++) System.out.println(position[i]);
        System.out.println(skills);
        System.out.println(salary);
    }
}
