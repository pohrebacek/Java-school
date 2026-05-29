package ctvrtak.gui;

import javax.swing.*;

public class FirstWindow  extends JFrame {  //classa musí dědit od JFrame, aby měl přístup k tý knihovně

    public FirstWindow() {  //konstruktor slouží k nastavování toho okna, vytváření labelů toho okna atd
        this.setSize(400, 450);
        this.setTitle("Kkokot");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);   //je potřeba nastavit aby se po zavření okna vypl program, defaultně totiž po vypnutí program běžel dál
        this.setLocationRelativeTo(null);   //hodí okno doprostřed
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new FirstWindow().setVisible(true); //logicky zobrazuje okno, dá se to udělat i tak že udělam objekt a přes ten zavolam tu metodu ale proč zeo
    }
}
