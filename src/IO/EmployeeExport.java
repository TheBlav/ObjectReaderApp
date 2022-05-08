package IO;

import App.Company;
import Data.Employee;
import Interface.Printer;

import java.io.*;

public class EmployeeExport implements Printer {

    public void EmployeeExport(String fileName, Employee[] employeesArray){
        Employee[] employees = employeesArray;
        File file = new File(fileName);
        boolean fileExists = file.exists();

        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.err.println("Nie udało się stworzyć pliku");
            }
        }
        if (fileExists){
            try(
                    var fos = new FileOutputStream(fileName);
                    var oos = new ObjectOutputStream(fos);
                    ){
                oos.writeObject(employees);
                print("Plik z danymi został utworzony / zapisany");
            } catch (IOException e) {
                System.err.println("Nie uddało się zapisać pliku");
            }


        }
    }
}
