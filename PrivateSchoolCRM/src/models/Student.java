
package models;

import java.time.LocalDate;


public class Student {
    
     private String name;
    private String lastName;
    private int fees;
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(String name, String lastname, int fees, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastname;
        this.fees = fees;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastName;
    }

    public int getFees() {
        return fees;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    
}
