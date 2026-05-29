package metody_exercises;

import java.util.Scanner;

public class ex7 {

    public static String hosts(String ip){
        int prefix = Integer.parseInt(ip.substring(ip.length()-2));
        double numHosts = Math.pow(2, 32-prefix);
        numHosts -= 1;

        String idk = ip.substring(0, ip.lastIndexOf('.')+1)+"0-"+numHosts;
        return idk.substring(0, idk.length()-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("zadej ip: ");
        String ip = sc.nextLine();
        System.out.println(hosts(ip));
    }
}
