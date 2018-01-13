package com.kchmielewski.sda.extra.streams;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EmployeeDatabase database = new EmployeeDatabase("src/main/resources/employees.csv");
    }
}
