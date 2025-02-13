package com.Gson.core;

import com.Gson.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GsonExample1 {

    public static void main(String[] args) {

        // pretty print
        //Gson gson = new GsonBuilder().setExclusionStrategies(new CES(List.class)).create();
        Gson gson= new Gson();

        Staff staff = createStaffObject();
        Staff staff2 = createStaffObject_2();

        // Java objects to String
        String json = gson.toJson(staff);
        try (FileWriter writer = new FileWriter("json/student.json")) {
            writer.write("[\n");
            gson.toJson(staff, writer);
            writer.write(",\n");
            gson.toJson(staff2, writer);
            writer.write("\n]");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private static Staff createStaffObject() {

        Staff staff = new Staff();

        staff.setName("valera");
        staff.setAge(35);
        staff.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2020", new BigDecimal(10000));
            put("2024", new BigDecimal(12000));
            put("2025", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "c#", "kotlin"));

        return staff;

    }

    private static Staff createStaffObject_2() {

        Staff staff = new Staff();

        staff.setName("oleg");
        staff.setAge(35);
        staff.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2018", new BigDecimal(12000));
            put("2024", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "c++", "kotlin"));

        return staff;

    }


}