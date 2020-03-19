
package playingwithemployers;

public class Receptionist extends Employee implements Driving {
    
    public Receptionist(String name, double salary) {
        super(name, salary);
    }
      public void greed(){
        System.out.println(getName() + " Receiption is greet");
        
    }

    @Override
    public void drive() {
        System.out.println(getName() + " Receptionist is driving");
    }

    @Override
    public void work() {
        greed();
    }
}
