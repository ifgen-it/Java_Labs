package Practice1;

import java.util.Scanner;

public class Task3 {

  public static void Decision(){
   
   System.out.println("Task3\n");
   
   Employee[] Emp = new Employee[6];
   
   Emp[0] = new Employee("Evgen");
   
   Emp[1] = new Employee("Max", "worker");
   Emp[3] = new Employee("King", "admin");
   Emp[2] = new Employee("Kate", "salor", 8000);
   Emp[4] = new Employee("Grant", "admin", 8000);
   Emp[5] = new Employee("Zlotkey", "it", 6600);
   
   Employee.PrintArr(Emp);
   
   System.out.println("\nSum salary of all employees: "+ Employee.SumSalary(Emp) );
   
   Employee.PrintMaxSalary(Emp);
   
  }
}