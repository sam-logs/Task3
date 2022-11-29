package com.bhavna.services;

import com.bhavna.bean.Employee;

import java.util.*;
import java.util.stream.Collectors;


public class EmployeeService {
    Employee employee = new Employee("Saurav",28000,"Hyderabad");
    Employee employee1 = new Employee("Ekjot",29000,"Noida");
    Employee employee2 = new Employee("Arpit",29000,"Noida");
    Employee employee3 = new Employee("Saumya",29000,"Noida");
    Employee employee4 = new Employee("Anish",680000,"Hyderabad");
    Employee employee5 = new Employee("Anish",680000,"Noida");

    List<Employee> list = new ArrayList<>();

    public void employeeOperation(){
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        //System.out.println(list.toString());

        Long search = list.stream().filter(item -> item.getName().startsWith("S")).count();
        System.out.println("Count Of Employee Starting With S: "+search);

        List<Employee> filter = list.parallelStream().filter(location -> location.getLocation().equals("Hyderabad"))
                .collect(Collectors.toList());
        System.out.println("Employees In Hyderabad Using Parallel Stream: "+filter);

        Map<String,List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getLocation));
        System.out.println("Based on Location: "+map);

          List salary =  list.stream().filter(sal -> sal.getSalary()>100000)
                .collect(Collectors.toList());
        System.out.println("Salary Of Employee Having Salary Greater than 100000: "+salary);

        List<Employee> maps = list.stream()
                .sorted(Comparator.comparing(Employee::getName).thenComparing(Comparator.comparing(Employee::getLocation)))
                .collect(Collectors.toList());
        System.out.println("Sorted According to names and after location: "+maps);
    }


}
