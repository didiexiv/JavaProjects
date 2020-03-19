
package playingwithemployers;


public class Teacher extends Employee implements Advisable{
    
    public Teacher(String name, double salary) {
        super(name, salary);
    }
    
    public void teach(){
        System.out.println(getName() + " Teacher is teaching");
        
    }

    @Override
    public void giveAdvise() {
         System.out.println(getName() + " Teacher is giving advise");
    }

    @Override
    public void work() {
        teach();
    }
    
    
}
