package domain;

public class Employee {
    private int employeeId;
    private String employeeName;
    // constructor
    public Employee(int employeeId,String employeeName){
        setEmployeeId(employeeId);
        setEmployeeName(employeeName);
    }

    //getters y setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getEmployeeName(){
        return employeeName;
    }
    public void setEmployeeName(String employeeName){
        this.employeeName=employeeName;
    }
}
