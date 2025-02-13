package com.spring;

import com.spring.controller.StringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("string.xml");

        StringController controller = (StringController) context.getBean("stringController");

        List<String> sortedStrings = controller.sortStrings(Arrays.asList("banana", "apple", "cherry"));
        System.out.println("Sorted Strings: " + sortedStrings);
    }
}
