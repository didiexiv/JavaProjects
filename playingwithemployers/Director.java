
package playingwithemployers;

public class Director extends Employee implements Driving, Advisable{
    
    public Director(String name, double salary) {
        super(name, salary);
    }
      public void guide(){
        System.out.println(getName() + " DIrector is guidding");
        
    }

    @Override
    public void drive() {
       System.out.println(getName() + " Director is driving"); 
    }

    @Override
    public void giveAdvise() {
        System.out.println(getName() + " Director is advising");
    }

    @Override
    public void work() {
        guide();
    }
}
