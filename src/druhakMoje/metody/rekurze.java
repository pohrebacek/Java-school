package metody;

public class rekurze {

    static void countDown(int n){
        System.out.println(n);
        n--;
        if (n > 0){
            countDown(n);
        }

    }

    static void nonrecursivecountdown(int n){
        for (int i = n; i > 0; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        countDown(n);
    }
}
