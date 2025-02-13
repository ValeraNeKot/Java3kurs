package com.spring.service;

import java.util.List;
import java.util.stream.Collectors;

public class StringService {
    // Метод для сортировки строк
    public List<String> sortStrings(List<String> strings) {
        return strings.stream()
                      .sorted()
                      .collect(Collectors.toList());
    }
}
