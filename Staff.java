
class Staff {
	int employeeId;
    String employeeName;
    double salary;

    Staff(int employeeId, String employeeName, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + employeeName + ", Salary: " + salary;
    }

}
