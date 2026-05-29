package tretak.oopInheritence;

public class CardioSurgeon extends Surgeon{
    int CARDIAC_SURGEON_BONUS = 35000;

    public CardioSurgeon(int salary, String name) {
        super(salary, name);
        this.salary += CARDIAC_SURGEON_BONUS;
    }

    void cardiacSurgery() {
        System.out.println("Cut through the heart and I'm to blame...");
        salary += 15000;
    }
}
