import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            byte[][] matrix = MatrixUtils.readMatrix(scanner);

            int constant = validateInput(scanner, "Input constant: ", false, Integer.class);

            System.out.println("Initial matrix: ");
            MatrixUtils.printMatrix(matrix);

            byte[][] resultMatrix = MatrixUtils.multiplyByConstant(matrix, constant);
            System.out.println("Resulting matrix after multiplication: ");
            MatrixUtils.printMatrix(resultMatrix);

            int sumEvenRows = MatrixUtils.sumOfMaxElementsInEvenRows(resultMatrix);
            System.out.println("Sum of the largest elements in even rows: " + sumEvenRows);

            int sumOddRows = MatrixUtils.sumOfMinElementsInOddRows(resultMatrix);
            System.out.println("Sum of the smallest elements in odd rows: " + sumOddRows);

        } catch (Exception e) {
            System.out.println("An unknown error occurred: " + e.getMessage());
        }
    }

    public static <T> T validateInput(Scanner scanner, String prompt, boolean isSizeNumber, Class<T> type) {
        T input = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                switch (type.getSimpleName()) {
                    case "Integer":
                        int intValue = scanner.nextInt();
                        if (intValue <= 0 && isSizeNumber) {
                            System.out.println("Invalid input. Number must be greater than zero.");
                        } else {
                            input = type.cast(intValue);
                            validInput = true;
                        }
                        break;

                    case "Byte":
                        byte byteValue = scanner.nextByte();
                        input = type.cast(byteValue);
                        validInput = true;
                        break;

                    default:
                        System.out.println("Unsupported type for numerical input.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a value in the correct format.");
                scanner.next();
            }
        }
        return input;
    }
}