package tvoje_mama;

public class convert {
    public static void main(String[] args) {
        int[] binaryArray = {1,0,1,1,1,1,0,1};
        //int[] binaryArray = {1,0,0,0,1,0,0,0,0,0,1};
        int result = 0;

        for (int i = 0; i < binaryArray.length; i++) {
            int idk = binaryArray.length-i;
            result += binaryArray[i] * (int) (Math.pow(2,idk));
        }

        System.out.println(result/2);
    }
}
