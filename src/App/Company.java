package App;

import Data.Employee;
import IO.EmployeeExport;
import IO.EmployeeImport;
import IO.io;
import Interface.Printer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Company implements Printer {
    private final int MAX_EMPLOYEES = 3;
    private final int ADD = 1;
    private final int SAVE = 2;
    private final int LOAD = 3;
    private final int PRINT = 4;
    private final int EXIT = 9;
    Employee[] employees = new Employee[MAX_EMPLOYEES];


    public void Company() {
        int userChoice;
        io inOut = new io();
        Scanner scanner = new Scanner(System.in);
        String fileName = "C:\\Users\\guzje\\OneDrive\\Dokumenty\\java\\Employees.obj";
        userChoice = 0;
         try {

             do {
                print("Witam w programie obsługi pracowników.");
                print("Aby dodać pracowników, wybierz: 1");
                print("Aby zapisać pracowników, wybierz: 2");
                print("Aby wczytać pracowników, wybierz: 3");
                print("Aby wyświetlić zapisanych pracowników, wybierz: 4");
                print("Koniec programu, wybierz: 9");
                userChoice = scanner.nextInt();

                switch (userChoice) {

                    case ADD: {
                        for (int i = 0; i < MAX_EMPLOYEES; i++) {
                            employees[i] = inOut.createNewEmployee();
                        }
                        break;
                    }
                    case SAVE: {
                        EmployeeExport saveEmployees = new EmployeeExport();
                        saveEmployees.EmployeeExport(fileName, employees);
                        break;
                    }

                    case LOAD: {
                        EmployeeImport employeeImport = new EmployeeImport();
                        employees = employeeImport.employeeImport(fileName);
                        break;
                    }

                    case PRINT:{
                        boolean isArrayEmpty = true;
                        for (Employee employee : employees) {
                            isArrayEmpty = employee == null;
                        }
                        if (isArrayEmpty){
                            print("Baza danych pracowników jest pusta.");
                        }
                        else {
                            inOut.printEmployees(employees);
                        }
                        break;
                    }

                    case EXIT: {
                        break;
                    }
                    default:
                        print("nie wybrano żadnego z powyższych");
                }
                } while (userChoice != EXIT);

            } catch (InputMismatchException e) {
                System.err.println("Podano błędną daną, podaj liczbę całkowitą z poprawnego zakresu");
                scanner.nextLine();
            }







    }
    }

