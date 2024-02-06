package com.alvonellos.interview.Interviews.gs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static class Employee {
        enum Location {
            NY,
            CA
        }
        String id;
        String name;
        Integer salary;
        Location location;

        public Employee(String id, String name, Integer salary, Location location) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", location=" + location +
                    '}';
        }
    }

    public static final List<Employee> employees = new ArrayList<>();

    public static void main(String... args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            cls();
            menu();
            System.out.print("> ");
            String input = in.nextLine();
            switch(input) {
                case "0":
                    return;
                case "1":
                    addEmployee();
                    break;
                case "2":
                    updateEmployee();
                    break;
                case "3":
                    deleteEmployee();
                    break;
                case "4":
                    getEmployee();
                    break;
                case "5":
                    getAllEmployees();
                    break;
                case "6":
                    sortEmployees();
                    break;
                case "7":
                    sortEmployeesBySalary();
                    break;
                case "8":
                    sortEmployeesBySalaryDescending();
                    break;
                case "9":
                    sortEmployeesBySalaryAscending();
                    break;
                case "10":
                    sortEmployeesBySalaryDescending();
                    break;
                case "11":
                    sortEmployeesBySalaryDescending();
                    break;
                case "12":
                    sortEmployeesBySalaryDescending();
                    break;
                case "13":
                    sortEmployeesBySalaryDescending();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
    }

    public static void menu() {
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee");
        System.out.println("3. Delete Employee");
        System.out.println("4. Get Employee");
        System.out.println("5. Get All Employees");
        System.out.println("6. Sort Employees");
        System.out.println("7. Sort Employees By Salary");
        System.out.println("8. Sort Employees By Salary Descending");
        System.out.println("9. Sort Employees By Salary Ascending");
        System.out.println("10. Sort Employees By Salary Descending");
        System.out.println("11. Sort Employees By Salary Descending");
        System.out.println("12. Sort Employees By Salary Descending");
    }

    public static void addEmployee() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Employee ID: ");
        String id = in.nextLine();
        System.out.println("Enter Employee Name: ");
        String name = in.nextLine();
        System.out.println("Enter Employee Salary: ");
        Integer salary = Integer.parseInt(in.nextLine());
        System.out.println("Enter Employee Location: ");
        String location = in.nextLine();
        Employee employee = new Employee();
        employee.id = id;
        employee.name = name;
        employee.salary = salary;
        employee.location = Employee.Location.valueOf(location);
        employees.add(employee);
    }
}
