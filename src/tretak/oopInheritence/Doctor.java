package tretak.oopInheritence;

public class Doctor {
    int salary;
    String name;

    public Doctor(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    void diagnose() {
        System.out.println("Figuring out whats going on...");
        salary += 1000;
    }

    public int getSalary() {
        return salary;
    }
}
