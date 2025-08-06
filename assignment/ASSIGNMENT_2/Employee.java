public class Employee {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String city;
    private String department;
    private String role;
    private double performanceRating;

    // Constructor
    public Employee(int id, String name, int age, String gender, String city,
                    String department, String role, double performanceRating) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.department = department;
        this.role = role;
        this.performanceRating = performanceRating;
    }

    // Getters (add setters if needed)
    public String getCity() { return city; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }
    public double getPerformanceRating() { return performanceRating; }
    public String getGender() { return gender; }

    @Override
    public String toString() {
        return name + " (" + role + ", " + city + ")";
    }
}
