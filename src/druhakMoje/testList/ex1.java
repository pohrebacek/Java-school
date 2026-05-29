package testList;

public class ex1 {
    public static void main(String[] args) {
        int[][] grades = {
                {30, 50, 15, 21},
                {22, 25, 74, 56},
                {11, 2, 5, 7}
        };
        int count = 0;
        int count2 = 0;

        for (int i = 0; i < grades.length; i++) {
            for (int j = 0; j < 4; j++) {
                count += grades[i][j];
            }
            if (count >= 100){
                count2 += 1;
            }
            count = 0;
        }

        System.out.println(count2);
        
    }
}
