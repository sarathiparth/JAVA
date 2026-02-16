package scenario;
import java.util.ArrayList;
import java.util.List;

class Employee {
    private String employeeId;
    private String name;
    private String role;
    private double baseSalary;
    private double calculatedSalary;

    public Employee(String employeeId, String name, String role, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void calculateSalary() {
        switch (role.toLowerCase()) {
            case "manager":
                calculatedSalary = baseSalary + (0.20 * baseSalary);
                break;
            case "developer":
                calculatedSalary = baseSalary + (0.10 * baseSalary);
                break;
            case "designer":
                calculatedSalary = baseSalary + (0.05 * baseSalary);
                break;
            case "intern":
                calculatedSalary = 1000;
                break;
            default:
                calculatedSalary = baseSalary;
        }
    }

    public void applyDeduction(double amount) {
        calculatedSalary -= amount;
    }

    public void displayEmployeeDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Role: " + role);
        System.out.println("Salary: " + calculatedSalary);
        System.out.println("----------------------");
    }
}

class Payroll {
    private List<Employee> employees;

    public Payroll() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee findEmployeeById(String employeeId) {
        for (Employee e : employees) {
            if (e.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return e;
            }
        }
        return null;
    }

    public void calculateAllSalaries() {
        for (Employee e : employees) {
            e.calculateSalary();
        }
    }

    public void displayAllEmployees() {
        for (Employee e : employees) {
            e.displayEmployeeDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();

        Employee e1 = new Employee("E101", "Amit", "Manager", 50000);
        Employee e2 = new Employee("E102", "Neha", "Developer", 40000);
        Employee e3 = new Employee("E103", "Ravi", "Intern", 0);

        payroll.addEmployee(e1);
        payroll.addEmployee(e2);
        payroll.addEmployee(e3);

        payroll.calculateAllSalaries();

        Employee emp = payroll.findEmployeeById("E102");
        if (emp != null) {
            emp.applyDeduction(2000);
        }

        payroll.displayAllEmployees();
    }
}
