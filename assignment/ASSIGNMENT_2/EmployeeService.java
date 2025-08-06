import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> findByRoleAndCity(String role, String city) {
        return employees.stream()
                .filter(e -> e.getRole().equalsIgnoreCase(role))
                .filter(e -> e.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public double averagePerformanceByDepartment(String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .mapToDouble(Employee::getPerformanceRating)
                .average()
                .orElse(0.0);
    }

    public long genderCount(String gender) {
        return employees.stream()
                .filter(e -> e.getGender().equalsIgnoreCase(gender))
                .count();
    }

    // Add more querying methods here...
}
