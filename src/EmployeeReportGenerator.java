import java.util.ArrayList;

public class EmployeeReportGenerator {

    public static void generateSalaryReport(ArrayList<Employee> employees) {
        double totalSalary = 0;

        for (Employee e : employees) {
            totalSalary += e.getSalary();
        }

        System.out.println("\n SALARY REPORT");
        System.out.println("Total Employees: " + employees.size());
        System.out.println("Total Salary Expense: ₹" + totalSalary);

        if (!employees.isEmpty()) {
            System.out.println("Average Salary: ₹" + (totalSalary / employees.size()));
        }
    }

    public static void departmentReport(ArrayList<Employee> employees, String department) {
        System.out.println("\n Department: " + department);

        boolean found = false;
        for (Employee e : employees) {
            if (e.getDepartment().equalsIgnoreCase(department)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in this department.");
        }
    }
}
