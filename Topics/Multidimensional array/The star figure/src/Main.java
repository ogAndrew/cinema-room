
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        String[][] matrix = new String[n][n];

        int mid = (int) Math.floor(n / 2);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col == mid || row == mid || row == col || col == n - row - 1) {
                    matrix[row][col] = "*";
                } else {
                    matrix[row][col] = ".";
                }
            }
        }

        for (String[] strings : matrix) {
            System.out.println(String.join(" ", strings));
        }
    }
}