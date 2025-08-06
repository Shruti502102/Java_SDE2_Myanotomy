import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataLoader {
    public static List<Employee> loadEmployees(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee e = new Employee(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3],
                    data[4],
                    data[5],
                    data[6],
                    Double.parseDouble(data[7])
                );
                employees.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
