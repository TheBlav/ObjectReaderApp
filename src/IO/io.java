package IO;

import Data.Employee;
import Interface.Printer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class io implements Printer {
   Scanner scanner =  new Scanner(System.in);

    public Employee createNewEmployee(){
        boolean correctData = false;
        String firstName = null, lastName = null;
        double salary = 0;
        do {
            try {
                print("Podaj imię pracownika: ");
                firstName = scanner.nextLine();
                print("Podaj nazwisko pracownika: ");
                lastName = scanner.nextLine();
                print("podaj wysokość wypłaty pracownia: ");
                salary = scanner.nextDouble();
                scanner.nextLine();
                correctData = true;
            } catch (InputMismatchException e) {
                correctData = false;
                System.err.println("Podano błędne dane, spróbuj ponownie.");
                scanner.nextLine();
            }
        } while (!correctData);
        return new Employee(firstName, lastName, salary);
    }

    public void printEmployees(Employee[] employees){
        StringBuilder employeePrinter = new StringBuilder();
        for (Employee employee : employees) {
            employeePrinter.append(employee + "\n");
        }
        print(employeePrinter.toString());
    }
}
