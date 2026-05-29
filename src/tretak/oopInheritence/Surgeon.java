package tretak.oopInheritence;

public class Surgeon extends Doctor{
    int SURGEON_BONUS = 20000;

    public Surgeon(int salary, String name) {
        super(salary, name);
        this.salary += SURGEON_BONUS;
    }

    void surgery() {
        System.out.println("Cutting open...");
        salary += 5000;
    }

    
}
