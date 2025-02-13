package com.Gson.core;

import com.Gson.domain.Staff;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.reflect.TypeToken;

public class GsonExample2 {
    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("json/student.json")) {

            Type employeeListType = new TypeToken<List<Staff>>(){}.getType();
            // Десериализация JSON файла в список сотрудников
            List<Staff> staff = gson.fromJson(reader, employeeListType);
            for (Staff employee : staff) {
                employee.print();
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

