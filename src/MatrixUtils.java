import java.util.Arrays;
import java.util.Scanner;

public class MatrixUtils {
    public static byte[][] multiplyByConstant(byte[][] matrix, int constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        byte[][] result = new byte[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (byte) (matrix[i][j] * constant);
            }
        }
        return result;
    }

    public static int sumOfMaxElementsInEvenRows(byte[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i += 2) {
            int maxInRow = findMax(matrix[i]);
            sum += maxInRow;
        }
        return sum;
    }

    public static int sumOfMinElementsInOddRows(byte[][] matrix) {
        int sum = 0;
        for (int i = 1; i < matrix.length; i += 2) {
            int minInRow = findMin(matrix[i]);
            sum += minInRow;
        }
        return sum;
    }

    private static byte findMax(byte[] arr) {
        byte max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static byte findMin(byte[] arr) {
        byte min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static byte[][] readMatrix(Scanner scanner) {
        int rows = Main.validateInput(scanner, "Input number of rows: ", true, Integer.class);
        int cols = Main.validateInput(scanner, "Input number of columns: ", true, Integer.class);

        byte[][] matrix = new byte[rows][cols];

        System.out.println("Input matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Main.validateInput(scanner, "\t Element [" + i + "][" + j + "]: ", false, Byte.class);
            }
        }
        return matrix;
    }
}
