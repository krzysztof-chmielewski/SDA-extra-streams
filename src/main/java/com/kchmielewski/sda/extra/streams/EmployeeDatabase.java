package com.kchmielewski.sda.extra.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDatabase {
    private final List<Employee> employees;

    public EmployeeDatabase(String path) throws IOException {
        employees = Files.lines(Paths.get(path)).skip(1).map(Employee::fromLine).collect(Collectors.toList());
    }
}
