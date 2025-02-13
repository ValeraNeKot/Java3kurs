package com.jaxb.test;

import com.jaxb.model.Department;
import com.jaxb.model.Employee;
import com.jaxb.model.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {

        List<Employee> list1 = new ArrayList<Employee>();
        list1.add(new Employee("E01", "Tom", null));
        list1.add(new Employee("E02", "Mary", "E01"));
        list1.add(new Employee("E03", "John", null));

        List<Employee> list2 = new ArrayList<Employee>();
        list2.add(new Employee("A01", "Ben", null));
        list2.add(new Employee("A02", "Wen", null));
        list2.add(new Employee("A03", "Ken", "A01"));

        List<Employee> list3 = new ArrayList<Employee>();
        list3.add(new Employee("B01", "Bin", null));
        list3.add(new Employee("B02", "Win", null));
        list3.add(new Employee("B03", "Kin", "B01"));

        List<Department> list = new ArrayList<Department>();
        list.add(new Department("E", "ACCOUNTING", "NEW YORK", list1));
        list.add(new Department("A", "BEBE", "Balivia", list2));
        list.add(new Department("B", "BABA", "Minsk", list3));
        Organization org = new Organization(list);

        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Organization.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(org, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(org, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.

            Organization deptFromFile1 = (Organization) um.unmarshal(new FileReader(
                    XML_FILE));
            List<Department> emps = deptFromFile1.getDepartments();
            for (Department emp : emps) {
                System.out.println("\n Department: "+ emp.getDeptName());
                for (Employee e : emp.getEmployees()) {
                    System.out.println("Employee: " + e.getEmpName());
            }}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
