package motedyTest;

public class ex1 {
    public static String checkPulse(int[] pulses){
        String check = "";
        for (int i = 0; i < pulses.length; i++) {
            if (i != 0 && pulses[i] - pulses[i-1] > 30){
                check = "danger";
                break;
            } else if (pulses[i] == 0) {
                check = "dead";
                break;
            } else {
                check = "ok";
                break;
            }
        }
        return check;
    }
    public static void main(String[] args) {
        int[] array = {0, 50, 25, 18, 22};
        System.out.println(checkPulse(array));
    }
}
