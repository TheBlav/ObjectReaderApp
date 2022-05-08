package Data;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    double salary;

    public Employee(String firstName, String lastName, double salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return (super.toString() + " wypłata: " + salary + " pln");
    }
}
