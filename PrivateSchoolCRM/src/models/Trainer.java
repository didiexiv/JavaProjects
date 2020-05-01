
package models;


public class Trainer {
    private String name;
    private String lastname;
    private String subject;

    public Trainer() {
    }

    public Trainer(String name, String lastname, String subject) {
        this.name = name;
        this.lastname = lastname;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSubject() {
        return subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

  
}
