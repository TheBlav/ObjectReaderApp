package IO;

import Data.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EmployeeImport {

    public Employee[] employeeImport(String fileName){
        int employeesNumber = 999;
        Employee[] employees = new Employee[employeesNumber];
        try(
                var fis = new FileInputStream(fileName);
                var ois = new ObjectInputStream(fis);
                ){
            employees = (Employee[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Błąd wczytywania danych");
        }
        return  employees;
    }
}
