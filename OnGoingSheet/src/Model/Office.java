package Model;

import java.util.LinkedList;

public class Office<T extends Employee> extends Division{
    private LinkedList<T> employees;

    public Office(String name, boolean openDoor) {
        super(name, openDoor);
    }

    public LinkedList<T> getEmployees() {
        return employees;
    }

    public void addEmployee(T employee) {
        if (employee == null || employees.contains(employee)) {
            return;
        }

        employees.add(employee);

        employee.setOffice(this);

    }

    public void removeEmployee(T employee) {
        if (employee == null || !employees.contains(employee)) {
            return;
        }

        employees.remove(employee);

        employee.removeOffice();
    }
}
