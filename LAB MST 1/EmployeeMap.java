// Q2) HashMap
import java.util.HashMap;
import java.util.Map;

class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

public class EmployeeMap {
    private Map<Integer, String> employeeMap = new HashMap<>();


    public void addEmployee(int id, String name) {
        employeeMap.put(id, name);
    }

    
    public String getEmployee(int id) throws EmployeeNotFoundException {
        if (employeeMap.containsKey(id)) {
            return employeeMap.get(id);
        } else {
            throw new EmployeeNotFoundException("Error:Employee ID not found!");
        }
    }

    
    public void displayEmployees() {
        System.out.println("Employee Map: " + employeeMap);
    }

    public static void main(String[] args) {
        EmployeeMap empMap = new EmployeeMap();

        System.out.println("Adding employees...");
        empMap.addEmployee(101, "John");
        empMap.addEmployee(102, "Jane");
        empMap.addEmployee(103, "Mike");

        empMap.displayEmployees();

        try {
            System.out.println("Name for ID 102: " + empMap.getEmployee(102));
            System.out.println("Name for ID 999: " + empMap.getEmployee(999)); 
        } catch (EmployeeNotFoundException e) {
            System.out.println("Name for ID 999: " + e.getMessage());
        }
    }
}
