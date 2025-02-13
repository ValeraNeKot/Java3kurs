package com.spring.controller;

import com.spring.service.StringService;

import java.util.List;

public class StringController {
    private StringService stringService;

    // Сеттер для инъекции зависимости
    public void setStringService(StringService stringService) {
        this.stringService = stringService;
    }

    // Метод для сортировки строк
    public List<String> sortStrings(List<String> strings) {
        return stringService.sortStrings(strings);
    }
}
