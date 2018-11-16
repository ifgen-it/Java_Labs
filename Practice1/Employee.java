package Practice1;

public class Employee {

    private int IDnumber;
    private String name;
    private String position;
    private int salary;

    private static int CounterID = 1;

    public static void PrintMaxSalary(Employee[] Emp) {
        //max search
        int Max = 0;
        for (Employee e : Emp) {
            if (e.salary > Max) {
                Max = e.salary;
            }
        }

        //print all matched with max
        System.out.println("\nPositions with max salary:");

        for (Employee e : Emp) {
            if (e.salary == Max) {
                System.out.println(e.position);
            }
        }
    }

    public static int SumSalary(Employee[] Emp) {
        int Sum = 0;
        for (Employee e : Emp) {
            Sum += e.salary;
        }
        return Sum;
    }

    public static void PrintArr(Employee[] Emp) {
        for (int i = 0; i < Emp.length; i++) {
            Emp[i].Print();
        }
    }

    public void Print() {
        System.out.println(IDnumber + " " + name + " " + position + " " + salary);
    }

    public Employee(String name) {

        this(name, "worker", 5000);

    }

    public Employee(String name, String position) {
        this(name, position,
                position.equals("worker") ? 5000 : 6000);
    }

    public Employee(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        IDnumber = CounterID++;
    }

}
