package tretak.oopCollectingg;

import java.util.LinkedList;
import java.util.Queue;

class Character {
    String name;
    int health;
    int attack;
    int armor;

    public Character(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * Postava se pokusi zautocit na jinou
     * @param opponent postava, na kterou je utoceno
     */
    public void attack(Character opponent) {
        System.out.println(name + " attacks " + opponent.name + " for " + attack + " damage!");
        if (attack - opponent.armor <= 0){
            opponent.health -= attack-(attack/2);
        } else {
            opponent.health -= attack- opponent.armor;
        }

    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name + " (HP: " + health + ", Attack: " + attack + ")";
    }
}

public class RPGQueue {
    public static void main(String[] args) {
        Queue<Character> team1 = new LinkedList<>();
        Queue<Character> team2 = new LinkedList<>();

        //Naplnit obe fronty postavami

       team1.add(new Character("Warrior", 50, 10, 5));
       team1.add(new Character("Mage", 30, 15, 8));
       team1.add(new Character("Rogue", 40, 12, 12));
       team2.add(new Character("Goofy Bear", 55, 8, 3));
       team2.add(new Character("Spider", 15, 14, 7));
       team2.add(new Character("AnotherSpider", 15, 14, 9));
       team2.add(new Character("Wolf", 45, 10, 4));
               //klasicka implementace by mela zvladnout vypis toString defaultne
       System.out.println("Starting Battle!");
       System.out.println("Team 1: " + team1);
       System.out.println("Team 2: " + team2);


        // TODO: 20.11.2024 Zajistit combat dvou teamu

        //RULES: turn based combat, bojuji vzdy ti na vrcholu fronty
        //combat se opakuje, dokud neni jeden team porazen tak, ze ve fronte nic neni

        //vzdy zacne nekdo z teamu 1 utocit na neco z teamu 2
        //pote neco z teamu 2 na nekoho v temau 1
        //Pokud je clen tymu na vrchu fronty porazen, je vyndan z fronty
        //to, kdo je porazen, za kolik utoci vyuzijte metody v Character

        while (!team1.isEmpty() && !team2.isEmpty()){
            Character character1 = team1.peek();
            Character character2 = team2.peek();
            character1.attack(character2);
            if (character2.isAlive()){
                character2.attack(character1);
                if (!character1.isAlive()){
                    System.out.println(character1.name+" is defeated");
                    team1.poll();
                }
            } else {
                System.out.println(character2.name+" is defeated");
                team2.poll();
            }
            System.out.println("Team 1: " + team1);
            System.out.println("Team 2: " + team2);
        }


        // TODO: 20.11.2024 Vypsat viteze
        if (team1.isEmpty()){
            System.out.println("winner: "+team2);
        } else {
            System.out.println("winner "+team1);
        }
    }
}
