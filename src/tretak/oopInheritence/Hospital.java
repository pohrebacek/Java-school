package tretak.oopInheritence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hospital {
    public static void main(String[] args) {
        Doctor carl = new Doctor(50000, "Carl");
        System.out.println(carl.getSalary());
        carl.diagnose();
        System.out.println(carl.getSalary());

        Surgeon joseph = new Surgeon(50000, "Joseph");
        System.out.println(joseph.getSalary());
        joseph.surgery();
        joseph.diagnose();
        System.out.println(joseph.getSalary());

        CardioSurgeon frenchie = new CardioSurgeon(50000, "Frenchie");
        System.out.println(frenchie.getSalary());
        frenchie.diagnose();
        frenchie.surgery();
        frenchie.cardiacSurgery();
        System.out.println(frenchie.getSalary());

        Doctor jarmil = new Surgeon(50000, "Jarmil");
        System.out.println(jarmil.getSalary());

        //pretypovat a hodit do variable
        //Surgeon temp = (Surgeon) jarmil;

        //rovnou volant na preytpovanou variable
        ((Surgeon) jarmil).surgery();

        Doctor[] doctors = {carl, joseph, frenchie, jarmil};
        for(Doctor doctor : doctors) {
            //pokus o opreraci
            System.out.println(doctor.name+" attempting surgery...");
            if (doctor instanceof Surgeon){
                ((Surgeon)doctor).surgery();
            } else {
                System.out.println(doctor.name+" not qualified");
            }

        }
    }
}
