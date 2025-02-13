package com.jaxb.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "organization")
public class Organization {
    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departmentsList;

    public Organization() { }

    public Organization(List<Department> departments) {
        this.departmentsList = departments;
    }

    // Геттеры и сеттеры
    public List<Department> getDepartments() { return departmentsList; }
    public void setDepartments(List<Department> departments) { this.departmentsList = departments; }
}