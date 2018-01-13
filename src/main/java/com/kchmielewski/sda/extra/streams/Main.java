package com.kchmielewski.sda.extra.streams;

import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        EmployeeDatabase database = new DefaultEmployeeDatabase("src/main/resources/employees.csv");

        System.out.println(database.groupByGender());
        System.out.println(database.groupBy(Employee::getGender));
        System.out.println(database.groupByRole());
        System.out.println(database.groupBy(Employee::getProject));
        System.out.println(database.averageSalaryGroupedBy(Employee::getRole));
        System.out.println(database.averageSalaryFor(e -> e.getCitizenship().equals("American")));
        System.out.println(database.max(Comparator.comparing(Employee::getSalary)));
        System.out.println(database.min(Comparator.comparing(Employee::getSalary)));
        System.out.println(database.max(Comparator.comparing(Employee::getDateOfBirth)));
        System.out.println(database.min(Comparator.comparing(Employee::getDateOfBirth)));
    }
}
