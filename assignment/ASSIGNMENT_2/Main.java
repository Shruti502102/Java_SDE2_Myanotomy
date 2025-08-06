import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataLoader.loadEmployees("employees.csv");
        EmployeeService service = new EmployeeService(employees);

        System.out.println("🔍 Engineers in Delhi:");
        service.findByRoleAndCity("Software Engineer", "Delhi")
               .forEach(System.out::println);

        System.out.println("\n📊 Avg Performance in Sales:");
        System.out.println(service.averagePerformanceByDepartment("Sales"));

        System.out.println("\n👩‍🦰 Female Employees:");
        System.out.println(service.genderCount("F"));
    }
}
