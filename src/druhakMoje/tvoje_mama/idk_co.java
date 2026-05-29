package tvoje_mama;

public class idk_co {
    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
