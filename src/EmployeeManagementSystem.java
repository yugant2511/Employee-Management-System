import java.util.*;

public class EmployeeManagementSystem {

    private ArrayList<Employee> employees;
    private HashMap<String, Employee> employeeMap;
    private Scanner scanner;

    public EmployeeManagementSystem() {
        scanner = new Scanner(System.in);
        employees = EmployeeFileHandler.loadEmployees();
        employeeMap = new HashMap<>();

        for (Employee e : employees) {
            employeeMap.put(e.getId(), e);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.menu();
    }

    private void menu() {
        int choice;
        do {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Salary Report");
            System.out.println("5. Save & Exit");
            System.out.print("Enter choice: ");

            choice = getValidInt(1, 5);
            scanner.nextLine();

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewEmployees();
                case 3 -> searchEmployee();
                case 4 -> EmployeeReportGenerator.generateSalaryReport(employees);
                case 5 -> EmployeeFileHandler.saveEmployees(employees);
            }
        } while (choice != 5);
    }

    private void addEmployee() {
        System.out.print("ID: ");
        String id = scanner.nextLine();

        if (employeeMap.containsKey(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Department: ");
        String dept = scanner.nextLine();
        System.out.print("Position: ");
        String pos = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        Employee e = new Employee(id, name, dept, pos, salary);
        employees.add(e);
        employeeMap.put(id, e);

        System.out.println(" Employee added.");
    }

    private void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        employees.forEach(System.out::println);
    }

    private void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = scanner.nextLine();

        Employee e = employeeMap.get(id);
        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private int getValidInt(int min, int max) {
        while (true) {
            try {
                int value = scanner.nextInt();
                if (value >= min && value <= max) return value;
            } catch (InputMismatchException e) {
                scanner.next();
            }
            System.out.print("Enter valid option: ");
        }
    }
}
