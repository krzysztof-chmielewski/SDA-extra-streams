package com.kchmielewski.sda.extra.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DefaultEmployeeDatabase implements EmployeeDatabase {
    private final List<Employee> employees;

    public DefaultEmployeeDatabase(String path) throws IOException {
        employees = Files.lines(Paths.get(path)).skip(1).map(Employee::fromLine).collect(Collectors.toList());
    }

    @Override
    public Map<Employee.Gender, List<Employee>> groupByGender() {
        return employees.stream().collect(Collectors.groupingBy(Employee::getGender));
    }

    @Override
    public Map<String, List<Employee>> groupByRole() {
        return employees.stream().collect(Collectors.groupingBy(Employee::getRole));
    }

    @Override
    public Employee min(Comparator<Employee> comparator) {
        return employees.stream().min(comparator).orElseThrow(IllegalStateException::new);
    }

    @Override
    public Employee max(Comparator<Employee> comparator) {
        return employees.stream().max(comparator).orElseThrow(IllegalStateException::new);
    }

    @Override
    public Double averageSalaryFor(Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.averagingDouble(Employee::getSalary));
    }

    @Override
    public <T> Map<T, List<Employee>> groupBy(Function<Employee, T> groupingFunction) {
        return employees.stream().collect(Collectors.groupingBy(groupingFunction));
    }

    @Override
    public <T> Map<T, Double> averageSalaryGroupedBy(Function<Employee, T> groupingFunction) {
        return employees.stream().collect(Collectors.groupingBy(groupingFunction, Collectors.averagingDouble(Employee::getSalary)));
    }
}
