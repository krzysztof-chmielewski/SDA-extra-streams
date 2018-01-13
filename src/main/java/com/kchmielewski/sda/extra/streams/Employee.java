package com.kchmielewski.sda.extra.streams;

import java.time.LocalDate;

public class Employee {
    private final String name;
    private final String surname;
    private final Gender gender;
    private final LocalDate dateOfBirth;
    private final String citizenship;
    private final String role;
    private final int salary;
    private final String project;
    private final String favouriteColour;

    private Employee(String name, String surname, Gender gender, LocalDate dateOfBirth, String citizenship, String role, int salary, String project, String favouriteColour) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.citizenship = citizenship;
        this.role = role;
        this.salary = salary;
        this.project = project;
        this.favouriteColour = favouriteColour;
    }

    public static Employee fromLine(String line) {
        String[] data = line.split(",");

        return new Employee(data[0], data[1], Gender.valueOf(data[2]), LocalDate.parse(data[3]), data[4], data[5], Integer.valueOf(data[6]), data[7], data[8]);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getRole() {
        return role;
    }

    public int getSalary() {
        return salary;
    }

    public String getProject() {
        return project;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", citizenship='" + citizenship + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", project='" + project + '\'' +
                ", favouriteColour='" + favouriteColour + '\'' +
                '}';
    }

    public enum Gender {
        F("Female"),
        M("Male");

        private final String name;

        Gender(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
