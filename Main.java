import java.util.Random;

/**
 * Основний клас для виконання операцій з матрицями.
 */
public class Main {
    /**
     * Головний метод для запуску програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        //Мій варіант
        int my_var = 2108; // Номер варіанту
        System.out.println("C5=" + my_var % 5);  // Остача від ділення на 5
        System.out.println("C7=" + my_var % 7);  // Остача від ділення на 7
        System.out.println("C11=" + my_var % 11); // Остача від ділення на 11

        //Розмірність матриці
        byte N = 3;
        byte[][] MatrixA = new byte[N][N]; // Перша матриця
        byte[][] MatrixB = new byte[N][N]; // Друга матриця
        byte[][] MatrixC = new byte[N][N]; // Результат XOR операції

        //заповнення матриць випадковими значеннями
        CreateMatrix(MatrixA);
        CreateMatrix(MatrixB);

        //виконання XOR операції над матрицями
        xorMatrix(MatrixA, MatrixB, MatrixC);

        //Виведення результатів
        System.out.println("MatrixA:");
        printMatrix(MatrixA);

        System.out.println("MatrixB:");
        printMatrix(MatrixB);

        System.out.println("MatrixC:");
        printMatrix(MatrixC);

        //обчислення суми за заданою функцією
        System.out.println("Сума: " + customFunctionToMatrix(MatrixC));
    }

    /**
     * Заповнює передану матрицю випадковими значеннями типу byte.
     *
     * @param matrix матриця для заповнення
     */
    public static void CreateMatrix(byte[][] matrix) {
        Random random = new Random();
        for (byte[] bytes : matrix) {
            random.nextBytes(bytes);
        }
    }

    /**
     * Виконує XOR операцію між двома матрицями і зберігає результат у третій матриці.
     *
     * @param matrixA перша матриця
     * @param matrixB друга матриця
     * @param matrixC матриця для збереження результату
     */
    public static void xorMatrix(byte[][] matrixA, byte[][] matrixB, byte[][] matrixC) {
        int N = matrixA.length; //розмірність матриць
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrixC[i][j] = (byte) (matrixA[i][j] ^ matrixB[i][j]);
            }
        }
    }

    /**
     * Обчислює суму елементів матриці за заданою функцією.
     * <p>
     * Для кожного стовпця:
     * - якщо номер стовпця парний (0, 2, ...), до суми додається максимальне значення у цьому стовпці;
     * - якщо номер стовпця непарний (1, 3, ...), до суми додається мінімальне значення у цьому стовпці.
     *
     * @param matrix вхідна матриця
     * @return обчислена сума
     */
    public static int customFunctionToMatrix(byte[][] matrix) {
        int sum = 0;
        int N = matrix.length;

        for (int j = 0; j < N; j++) {
            if (j % 2 == 0) { // парний номер стовпця
                int max = Integer.MIN_VALUE;
                for (byte[] bytes : matrix) {
                    if (bytes[j] > max) {
                        max = bytes[j];
                    }
                }
                sum += max;
            } else { //епарний номер стовпця
                int min = Integer.MAX_VALUE;
                for (byte[] bytes : matrix) {
                    if (bytes[j] < min) {
                        min = bytes[j];
                    }
                }
                sum += min;
            }
        }

        return sum;
    }

    /**
     * Виводить матрицю у консоль.
     *
     * @param matrix матриця для виведення
     */
    public static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            for (byte value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
