package playingwithemployers;

import java.util.ArrayList;
import java.util.List;

public class PlayingWithEmployers {

    public static void main(String[] args) {
        Employee teacher1 = new Teacher("Nick", 1000);
        Employee teacher2 = new Teacher("Mary", 1000);
        Employee receptionist = new Receptionist("Peter", 1200);
        Employee director1 = new Director("Andy", 2000);
        Employee director2 = new Director("Jonathan", 2500);

        List<Employee> employees = new ArrayList();
        employees.add(teacher1);
        employees.add(teacher2);
        employees.add(receptionist);
        employees.add(director1);
        employees.add(director2);
        
        List<Employee> advisers = new ArrayList();
        List<Employee> drivers = new ArrayList();
        
        advisers.add(teacher1);
        
        for (Employee employee : employees) {
            employee.work();
            boolean isAdvisable = employee instanceof Advisable;
            boolean isDriving = employee instanceof Driving;
            
            if (isAdvisable == true ) {
                advisers.add(employee);
                System.out.println("Employee " + employee.getName() + " can give advices");
            }
            if (isDriving == true){
                drivers.add(employee);
            System.out.println("Employee " + employee.getName() + " can drive");
            }
        }
        
       
        
        
        
        // how many advisers and drivers do we have?
        

        
    }

}
