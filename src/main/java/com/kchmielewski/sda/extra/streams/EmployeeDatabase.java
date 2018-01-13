package com.kchmielewski.sda.extra.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public interface EmployeeDatabase {
    Map<Employee.Gender, List<Employee>> groupByGender();

    Map<String, List<Employee>> groupByRole();

    Employee min(Comparator<Employee> comparator);

    Employee max(Comparator<Employee> comparator);

    Double averageSalaryFor(Predicate<Employee> predicate);

    <T> Map<T, List<Employee>> groupBy(Function<Employee, T> groupingFunction);

    <T> Map<T, Double> averageSalaryGroupedBy(Function<Employee, T> groupingFunction);
}
